package com.lxp.ssh2.service;

import java.util.List;

import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.vo.PageBean;
import com.lxp.ssh2.vo.PageRequest;

/**
 * @Package com.lxp.ssh2.service
 * @Class com.lxp.ssh2.service.BookService
 * @Description: TODO
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public interface BookService {
	public List<Catalog> findAll();
	public PageBean<Book> findPage(int index, int size, int catalogId);
}
