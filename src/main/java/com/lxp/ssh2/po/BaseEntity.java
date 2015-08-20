package com.lxp.ssh2.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Package com.lxp.ssh2.po
 * @Class com.lxp.ssh2.po.BaseEntity
 * @Description:  抽象实体基类，提供统一的ID，和相关的基本功能方法
 *  			 注意这是所有实体类的基类，必须添加 @MappedSuperclass
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@MappedSuperclass
public class BaseEntity {
		/**
		 * 主键
		 */
		@Id
		@GeneratedValue
		@Column(name = "id", unique = true, nullable = false)	
		private Long id;
		
		/**
		 * 创建时间
		 */
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "createdAt",columnDefinition="timestamp default CURRENT_TIMESTAMP")
	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date createdAt;
	    
	    /**
		 * 更新时间
		 */
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updatedAt")
	    private Date updatedAt;
	    
	    

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

}
