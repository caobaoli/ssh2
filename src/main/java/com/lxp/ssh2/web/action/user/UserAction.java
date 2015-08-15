package com.lxp.ssh2.web.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.lxp.ssh2.po.User;
import com.lxp.ssh2.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.user
 * @Class com.lxp.ssh2.web.action.user.UserAction
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Controller
@ParentPackage(value = "ssh2-default")
public class UserAction extends ActionSupport {
	
	@Resource(name="userService")
	private UserService userService;
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}
	
	@Action(value="list")
	public String list() {
		users = userService.findAll();
		return SUCCESS;
	}
}
