package com.lxp.ssh2.web.action.users;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.stereotype.Controller;

import com.lxp.ssh2.po.User;
import com.lxp.ssh2.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.users
 * @Class com.lxp.ssh2.web.action.users.UserAction
 * @Description: 用户登录注册验证
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@SuppressWarnings("serial")
@Controller
@ParentPackage(value="ssh2-default")
@Namespace(value="/")
public class UserAction extends ActionSupport {
	
	@Resource(name="userService")
	private UserService userService;
	private String account;
	private String password;
	private String passwordConfirm;
	private String kaptcha;

	
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}
	
	@Action(value="login", results={
			@Result(name=SUCCESS, location="home/login.jsp")
		})
	public String login() {
		return SUCCESS;
	}
	
	@Action(value="regist", results={
				@Result(name=SUCCESS, location="home/regist.jsp")
			})
	public String regist() {
		return SUCCESS;
	}
	
	/**
	 * 注册验证
	 */
	@Action(value="auth", results={
			@Result(name=SUCCESS, type="redirect", location="login"),
			@Result(name=ERROR, location="home/regist.jsp")
	})
	public String auth() {
		@SuppressWarnings("unchecked")
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if("".equals(account)) {
			request.put("account", "用户名不能为空");
			return ERROR;
		}
		if("".equals(password)){
			request.put("password", "密码不能为空");
			return ERROR;
		}
		if("".equals(passwordConfirm)){
			request.put("passwordConfirm", "重复密码不能为空");
			return ERROR;
		}
		if(!password.trim().equals(passwordConfirm.trim())) {
			request.put("password", "两次密码不一致");
			request.put("passwordConfirm", "两次密码不一致");
			return ERROR;
		}
		if("".equals(kaptcha)){
			request.put("kaptcha", "验证码不能为空");
			return ERROR;
		}
		//获取动态生成的验证码放入到session中的值
		String kaptchaExpected = (String)ActionContext.getContext().getSession()  
				.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!kaptcha.equals(kaptchaExpected)) {
			request.put("kaptcha", "验证码错误");
			return ERROR;
		}
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		userService.save(user);
		return SUCCESS;
	}
	
	
	/**
	 * 登录验证
	 */
	@SuppressWarnings("unchecked")
	@Action(value="dologin", results={
			@Result(name=SUCCESS, type="redirect", location="/index"),
			@Result(name=ERROR, location="home/login.jsp")
	})
	public String dologin() {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		if("".equals(account)) {
			request.put("account", "用户名不能为空");
			return ERROR;
		}
		if("".equals(password)){
			request.put("password", "密码不能为空");
			return ERROR;
		}
		if("".equals(kaptcha)){
			request.put("kaptcha", "验证码不能为空");
			return ERROR;
		}
		//获取动态生成的验证码放入到session中的值
		String kaptchaExpected = (String)ActionContext.getContext().getSession()  
				.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!kaptcha.equals(kaptchaExpected)) {
			request.put("kaptcha", "验证码错误");
			return ERROR;
		}
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		if(userService.validateUser(user)==null) {
			request.put("isEmpty", "用户名或密码错误");
			return ERROR;
		}
		ActionContext.getContext().getSession().put("current_user", user);
		return SUCCESS;
	}
	
	/**
	 * 退出操作
	 */
	@Action(value="logoff", results={
			@Result(name=SUCCESS, type="redirect", location="/index")
	})
	public String logoff() {
		SessionMap<String, Object> session = (SessionMap<String, Object>) ActionContext
				.getContext().getSession();
		session.invalidate();
		return SUCCESS;
	}
}
