package com.lxp.ssh2.vo;

import java.util.Map;

/**
 * @Package com.lxp.ssh2.vo
 * @Class com.lxp.ssh2.vo.PageRequest
 * @Description: 封装请求参数
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public class PageRequest {

	private Integer size;
	private Integer index;
	private Integer catalogId;
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	public PageRequest() {
	}
	public PageRequest(Integer size, Integer index, Integer catalogId) {
		super();
		this.size = size;
		this.index = index;
		this.catalogId = catalogId;
	}
	/**
	 * 主要用于hibernate分页查询时的setFirstResult方法
	 */
	public Integer getFirstRequest() {
		return (index-1)*size;
	}

}
