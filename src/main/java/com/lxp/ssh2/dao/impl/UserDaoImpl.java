package com.lxp.ssh2.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxp.ssh2.dao.BaseDao;
import com.lxp.ssh2.dao.UserDao;
import com.lxp.ssh2.po.User;

/**
 * @Package com.lxp.ssh2.dao.impl
 * @Class com.lxp.ssh2.dao.impl.UserDaoImpl
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void add() {
		User user = new User();
		user.setAccount("123");
		user.setName("123");
		user.setPassword("123");
		this.getHibernateTemplate().save(user);
	}

	@Override
	public List<User> findAll() {
		String hql = "from User";
		return super.getHibernateTemplate().find(hql);
	}

}
