package com.lxp.ssh2.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @Package com.lxp.ssh2.dao
 * @Class com.lxp.ssh2.dao.BaseDao
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public class BaseDao extends HibernateDaoSupport{
	@Resource(name="sessionFactory")
	public void setHibernateSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
