package com.lxp.ssh2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxp.ssh2.dao.Bookdao;
import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.service.BookService;
import com.lxp.ssh2.vo.PageBean;
import com.lxp.ssh2.vo.PageRequest;

/**
 * @Package com.lxp.ssh2.service.impl
 * @Class com.lxp.ssh2.service.impl.BookServiceImpl
 * @Description: service层实现类
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@Service(value="bookService")
public class BookServiceImpl implements BookService {

	@Resource(name="bookDao")
	private Bookdao bookDao;
	
	@Transactional
	@Override
	public List<Catalog> findAll() {
		return bookDao.findAll();
	}

	@Transactional
	@Override
	public PageBean<Book> findPage(int index, int size, int catalogId) {
		PageRequest pageRequest = new PageRequest(size, index, catalogId);
		return bookDao.findByPageRequest(pageRequest);
	}

}
