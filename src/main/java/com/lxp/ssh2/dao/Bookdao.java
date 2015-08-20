package com.lxp.ssh2.dao;

import java.util.List;

import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.vo.PageBean;
import com.lxp.ssh2.vo.PageRequest;

/**
 * @Package com.lxp.ssh2.dao
 * @Class com.lxp.ssh2.dao.Bookdao
 * @Description: books相关操作接口
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public interface Bookdao {
	public List<Catalog> findAll();
	public PageBean<Book> findByPageRequest(PageRequest pageRequest);
}
