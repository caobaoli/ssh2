package com.lxp.ssh2.web.action.home;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.home
 * @Class com.lxp.ssh2.web.action.home.HomeAction
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@SuppressWarnings("serial")
@Controller
@ParentPackage(value="ssh2-default")
@Namespace(value="/")
public class HomeAction extends ActionSupport {
	
	@Action(value="index", results={
			@Result(name=SUCCESS, location="home/index.jsp")
	})
	public String index() {
		return SUCCESS;
	}
}
