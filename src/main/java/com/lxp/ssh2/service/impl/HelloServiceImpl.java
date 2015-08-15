package com.lxp.ssh2.service.impl;

import org.springframework.stereotype.Service;

import com.lxp.ssh2.service.HelloService;

/**
 * @Package com.lxp.ssh2.service.impl
 * @Class com.lxp.ssh2.service.impl.HelloServiceImpl
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Service(value="helloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello() {
		System.out.println("你好");
	}

}
