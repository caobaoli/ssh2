package com.lxp.ssh2.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @Package com.lxp.ssh2.po
 * @Class com.lxp.ssh2.po.User
 * @Description: user实体类
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "account"))
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private Integer id;
	
	@Column(name="account", nullable=false, unique=true, length=50)
	private String account;
	
	@Column(name="password_digist",nullable=false, length=50)
	private String password;
	
	@Column(name="salt", nullable=false, length=50)
	private String salt;
	
	@Column(name="last_login_time", nullable=true)
	private Date lastlogin;
	
	@Column(name="create_at", nullable=true)
	private Date createAt;
	
	@Column(name="update_at", nullable=true)
	private Date updateAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password="
				+ password + ", salt=" + salt + ", lastlogin=" + lastlogin
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
}
