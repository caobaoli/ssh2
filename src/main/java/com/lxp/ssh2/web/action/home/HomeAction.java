package com.lxp.ssh2.web.action.home;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.home
 * @Class com.lxp.ssh2.web.action.home.HomeAction
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Controller
@ParentPackage(value="ssh2-default")
public class HomeAction extends ActionSupport {
	
	@Action(value="index")
	public String index() {
		return SUCCESS;
	}
}
