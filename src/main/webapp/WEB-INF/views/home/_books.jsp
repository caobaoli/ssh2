<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="span1"></div>
<div class="span8">
	<c:forEach var="book" items="${pb.data}">
		<div class="row-fluid">
			<div class="span2">
				<br /> <img src="assets/app/bookpic/${book.pic}" width="160"
					height="160" />
			</div>
			<div class="span8">
				<h5>${book.name }</h5>
				<ul class="unstyled">
					<li>作 者:${book.author}</li>
					<li>出 版社:${book.publisher}</li>
					<li>出版时间:<fmt:formatDate value="${book.publishDate}"
							pattern="yyyy年MM月dd日" /></li>
					<li>价 格:<span class="price_red">￥<fmt:formatNumber
								value="${book.price}" pattern="0.00" /></span></li>
				</ul>
				<h3>
					<a href="cart.do?m=add&id=${book.id}" class="btn btn-warning"><i
						class="icon-shopping-cart icon-white"></i>加入购物车</a>
				</h3>
			</div>
		</div>
		<hr />
	</c:forEach>
	
	<div class="pagination">
		<s:if test="pb.totalPage>1">
			<ul class="pagination">
				<s:if test="!pb.first">
					<li class="${pb.first?'disabled':''}"><s:a namespace="/"
							action="index">
							<i >&laquo;</i>
							<s:param name="index" value="pb.index-1"></s:param>
							<s:param name="size" value="pb.size"></s:param>
						</s:a></li>
				</s:if>
				<s:iterator var="i" begin="1" end="%{pb.totalPage}">

					<li class="${pb.index==i?'active':''}"><s:a namespace="/"
							action="index">
							<s:param name="c_id" value="c_id"></s:param>
							<s:param name="index" value="#i"></s:param>
							<s:param name="size" value="pb.size"></s:param>
						${i}</s:a></li>
				</s:iterator>
				<s:if test="!pb.last">
					<li class="${pb.last?'disabled':''}"><s:a namespace="/"
							action="index">
							<i >&raquo;</i>
							<s:param name="index" value="pb.index+1"></s:param>
							<s:param name="size" value="pb.size"></s:param>
						</s:a></li>
				</s:if>

			</ul>
		</s:if>
		<span class="summary">共有<span class="badge badge-info">${pb.total}</span>条结果
		</span>
	</div>


</div>