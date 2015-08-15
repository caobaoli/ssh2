package com.lxp.ssh2.web.action.test;

import org.apache.struts2.convention.annotation.Action;

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

	@Action(value="testcon")
	public String t1() {
		return SUCCESS;
	}
}
