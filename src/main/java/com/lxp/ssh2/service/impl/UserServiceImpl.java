package com.lxp.ssh2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.Crypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	/**
	 * 保存用户
	 */
	@Transactional
	@Override
	public void save(User user) {
		user.setCreateAt(new Date());
		String salt = this.generateSalt();
		user.setSalt(salt);
		String password = Crypt.crypt(user.getPassword(), salt);
		user.setPassword(password);
		userDao.add(user);
	}
	
	/**
	 * 产生盐值
	 */
	public String generateSalt() {
		String str = "abcdefghigklmnopqrstuvwxyz123456789";
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<16; i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		return sb.toString();
	}

	/**
	 * 验证用户
	 */
	@Override
	public User validateUser(User user) {
		User tempuser = userDao.findByAccount(user.getAccount());
		if(tempuser!=null) {
			String password = Crypt.crypt(user.getPassword(), tempuser.getSalt());
			if(password.equals(tempuser.getPassword())) {
				return tempuser;
			}
		}
		return null;
	}

	
	

}
