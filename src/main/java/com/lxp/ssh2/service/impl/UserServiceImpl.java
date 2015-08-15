package com.lxp.ssh2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxp.ssh2.dao.UserDao;
import com.lxp.ssh2.po.User;
import com.lxp.ssh2.service.UserService;

/**
 * @Package com.lxp.ssh2.service.impl
 * @Class com.lxp.ssh2.service.impl.UserServiceImpl
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
