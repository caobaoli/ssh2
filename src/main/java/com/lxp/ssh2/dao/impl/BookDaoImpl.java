package com.lxp.ssh2.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lxp.ssh2.dao.BaseDao;
import com.lxp.ssh2.dao.Bookdao;
import com.lxp.ssh2.po.Book;
import com.lxp.ssh2.po.Catalog;
import com.lxp.ssh2.vo.PageBean;
import com.lxp.ssh2.vo.PageRequest;
import com.opensymphony.module.sitemesh.Page;

/**
 * @Package com.lxp.ssh2.dao.impl
 * @Class com.lxp.ssh2.dao.impl.BookDaoImpl
 * @Description: 实现类
 * @Author LiXiaoPeng Copyright Corporation 2015
 */
@Repository(value = "bookDao")
public class BookDaoImpl extends BaseDao implements Bookdao {

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Catalog> findAll() {
		String hql = "from Catalog c";
		List<Catalog> list = super.getHibernateTemplate().find(hql);
		return list;
	}

	@Transactional
	@Override
	public PageBean<Book> findByPageRequest(final PageRequest pageRequest) {
		HibernateTemplate template = super.getHibernateTemplate();
		final StringBuilder sb = new StringBuilder();
		sb.append(" and b.catalog.id = " + pageRequest.getCatalogId() + " and b.status = 1");
		@SuppressWarnings("unchecked")
		List<Book> list = template.executeFind(new HibernateCallback<List<Book>>() {
					@Override
					public List<Book> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder hql=new StringBuilder("from Book b where 1=1"+sb.toString()+" order by b.publishDate desc");
						Query query = session.createQuery(hql.toString());
						query.setFirstResult(pageRequest.getFirstRequest());
						query.setMaxResults(pageRequest.getSize());
						return query.list();
					}
				});

		PageBean<Book> page = new PageBean<Book>();
		page.setData(list);
		page.setIndex(pageRequest.getIndex());
		page.setSize(pageRequest.getSize());
		StringBuilder hql=new StringBuilder("select count(b) from Book b where 1=1"+sb.toString());
		Long total = (Long) template.find(hql.toString()).iterator().next();
		page.setTotal(total);
		return page;

	}

}
