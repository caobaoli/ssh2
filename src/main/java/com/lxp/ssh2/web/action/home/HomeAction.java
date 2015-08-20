package com.lxp.ssh2.web.action.home;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.service.BookService;
import com.lxp.ssh2.vo.PageBean;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Package com.lxp.ssh2.web.action.home
 * @Class com.lxp.ssh2.web.action.home.HomeAction
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@SuppressWarnings("serial")
@Controller
@ParentPackage(value="ssh2-default")
@Namespace(value="/")
public class HomeAction extends ActionSupport {
	
	@Resource(name="bookService")
	private BookService bookService;
	private List<Catalog> catalogList;
	private PageBean<Book> pb;
	/**
	 * 分页请求
	 */
	private Integer c_id = 1;
	private Integer index = 1;
	private Integer size = 3;
	
	
	public PageBean<Book> getPb() {
		return pb;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	

	public Integer getC_id() {
		return c_id;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<Catalog> getCatalogList() {
		return catalogList;
	}

	@Action(value="index", results={
			@Result(name=SUCCESS, location="home/index.jsp")
	})
	public String index() {
		catalogList = bookService.findAll();
		pb = bookService.findPage(index, size, c_id);
		return SUCCESS;
	}
}
