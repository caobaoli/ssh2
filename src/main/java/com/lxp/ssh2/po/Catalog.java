package com.lxp.ssh2.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Package com.lxp.ssh2.po
 * @Class com.lxp.ssh2.po.Catalog
 * @Description: Catalog实体类
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Entity
@Table(name="catalogs", uniqueConstraints=@UniqueConstraint(columnNames={"catalog_name"}))
public class Catalog implements Serializable {
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	private Integer id;
	
	@Column(name="catalog_name", nullable=false, unique=true, length=50)
	private String catalogname;
	
	@Column(name="catalog_status", nullable=true )
	private Integer catalogstatus;
	
	@Column(name="update_at", nullable=true)
	private Date updateat;
	
	@Column(name="create_at", nullable=true)
	private Date createat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatalogname() {
		return catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Integer getCatalogstatus() {
		return catalogstatus;
	}

	public void setCatalogstatus(Integer catalogstatus) {
		this.catalogstatus = catalogstatus;
	}

	public Date getUpdateat() {
		return updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}
	
	
}
