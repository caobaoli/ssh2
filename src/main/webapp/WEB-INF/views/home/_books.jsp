<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="span1">
</div>
<div class="span8">
	<c:forEach var="book" items="${requestScope.pb.data}">
	<div class="row-fluid">
		<div class="span2">
			<br /> <img src="assets/app/bookpic/${book.pic}" width="160" height="160" />
		</div>
		<div class="span8">
			<h5>${book.name }</h5>
			<ul class="unstyled">
				<li>作 者:${book.author}</li>
				<li>出 版社:${book.publisher}</li>
				<li>出版时间:<fmt:formatDate value="${book.publishDate}" pattern="yyyy年MM月"/></li>
				<li>价 格:<span class="price_red">￥<fmt:formatNumber value="${book.price}" pattern="0.00" /></span></li>
			</ul>
			<h3>
				<a href="cart.do?m=add&id=${book.id}" class="btn btn-warning"><i
					class="icon-shopping-cart icon-white"></i>加入购物车</a>
			</h3>
		</div>
	</div>
	<hr />
	</c:forEach>
	<div class="pagination pull-right">
		<ul>
		<c:if test="${pb.index<=1}">
			<li><a>上一页</a></li>
		</c:if>
		<c:if test="${pb.index>1}">
			<li><a href="home.do?c_id=${c_id}&i=${pb.index-1}&s=${pb.size}">上一页</a></li>
		</c:if>
		<c:forEach var="i" begin="1" end="${pb.totalPage}" step="1">
			<li><a href="home.do?c_id=${c_id}&i=${i}&s=${pb.size}">${i}</a></li>
		</c:forEach>
		<c:if test="${pb.index<=pb.totalPage}">
			<li><a href="home.do?c_id=${c_id}&i=${pb.index+1}&s=${pb.size}">下一页</a></li>
		</c:if>
		<c:if test="${pb.index>pb.totalPage}">
			<li><a>下一页</a></li>
		</c:if>	
		</ul>
	</div>
</div>