package com.lxp.ssh2.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.service.BookService;
import com.lxp.ssh2.vo.PageBean;

/**
 * @Package com.lxp.ssh2.test.dao
 * @Class com.lxp.ssh2.test.dao.BookDaoTest
 * @Description: 测试BookDao的方法
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BookDaoTest {

	@Resource(name="bookService")
	private BookService bookService;
	
	@Test
	public void findAllTest() {
		List<Catalog> list = bookService.findAll();
		System.out.println(list.get(0));
	}
	
	@Test
	public void findPage() {
		int size = 3;
		int index = 1;
		int catalogId = 1;
		PageBean<Book> page = bookService.findPage(index, size, catalogId);
		Assert.assertEquals(Long.valueOf(5), page.getTotal());
		Assert.assertEquals(Integer.valueOf(2), page.getTotalPage());
		Assert.assertEquals(true, page.isFirst());
		Assert.assertEquals(false, page.isLast());
		Assert.assertEquals(true, page.hashData());
		Assert.assertEquals(true, page.hashNext());
		Assert.assertEquals(false, page.hashPrevious());
		Assert.assertEquals(Long.valueOf(20), page.getData().get(0).getId());
	}

}
