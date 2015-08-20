package com.lxp.ssh2.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Package com.lxp.ssh2.po
 * @Class com.lxp.ssh2.po.Book
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Entity
@Table(name="books")
public class Book extends BaseEntity{
	
	@Column(name="name", nullable=false, length=50)
	private String name;
	@Column(name="author", nullable=true, length=50)
	private String author;
	@Column(name="publisher", nullable=true, length=50)
	private String publisher; 
	@Column(name="publish_date")
	private Date publishDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="catalog_id")
	private Catalog catalog;
	
	@Column(name="price", nullable=true)
	private Double price;
	@Column(name="pic", nullable=true, length=50)
	private String pic;
	
	@Column(name="status", nullable=true)
	private Integer status;

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
