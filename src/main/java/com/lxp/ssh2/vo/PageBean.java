package com.lxp.ssh2.vo;

import java.util.List;
import java.util.Map;

/**
 * @Package com.lxp.ssh2.vo
 * @Class com.lxp.ssh2.vo.PageBean
 * @Description: 分页辅助类
 * @Author LiXiaoPeng
 * Copyright  Corporation 2015
 */
public class PageBean<T> {
	private List<T> data;//总数据
	private Integer size;//每页大小
	private Long total;//总条数
	private Integer index;//当前页
	
	public Map<String, Object> parameters;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * 是否包含数据
	 */
	public boolean hashData() {
		return data==null?false:(data.size()>0);
	}
	
	/**
	 * 总页数
	 */
	public Integer getTotalPage() {
		int t = total.intValue();
		return t%size==0?t/size:(t/size+1);
	}
	
	/**
	 * 是否有下一页
	 */
	public boolean hashNext() {
		return index<getTotalPage();
	}
	
	/**
	 * 是否有上一页
	 */
	public boolean hashPrevious() {
		return index>1;
	}
	
	/**
	 * 是否是第一页
	 */
	public boolean isFirst() {
		return index==1;
	}
	
	/**
	 * 是否有最后一页
	 */
	public boolean isLast() {
		return index==getTotalPage();
	}

}
