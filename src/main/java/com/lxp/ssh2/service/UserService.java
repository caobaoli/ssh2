package com.lxp.ssh2.service;

import java.util.List;

import com.lxp.ssh2.po.User;

/**
 * @Package com.lxp.ssh2.service
 * @Class com.lxp.ssh2.service.UserService
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public interface UserService {
	public List<User> findAll();
}
