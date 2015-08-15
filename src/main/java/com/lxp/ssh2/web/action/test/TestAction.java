package com.lxp.ssh2.web.action.test;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.lxp.ssh2.service.HelloService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.test
 * @Class com.lxp.ssh2.web.action.test.TestAction
 * @Description: 测试convention
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
	/**
	 * 请求url:http://localhost:8080/test/testcon
	 */
	@Resource(name="helloService")
	private HelloService helloService;
	
	@Action(value="testcon")
	public String t1() {
		helloService.sayHello();
		return SUCCESS;
	}
}
