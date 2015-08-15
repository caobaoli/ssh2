package com.lxp.ssh2.dao;

import java.util.List;

import com.lxp.ssh2.po.User;

/**
 * @Package com.lxp.ssh2.dao
 * @Class com.lxp.ssh2.dao.UserDao
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public interface UserDao {
	public void add();
	public List<User> findAll();
}
