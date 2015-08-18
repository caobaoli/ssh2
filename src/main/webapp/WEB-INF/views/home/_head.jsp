<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container bg">
	<h1 id="title">网上书城</h1>
	<div class="header_search">
		<input type="text" name="search" class="search" />
	</div>
	<div class="header_button">
		<button id="search_button">搜索</button>
	</div>
	<ul class="breadcrumb pull-right" style="margin-bottom: 0px">
		<li><a href="regist">[免费注册]</a> <span class="divider">|</span></li>
		<c:if test="${sessionScope.current_user==null}">
			<li><a href="login">[登录]</a> <span class="divider">|</span></li>
		</c:if>
		<c:if test="${sessionScope.current_user!=null}">
			<li>您好,${sessionScope.current_user.account}<a href="#"> </a><a
				href="logoff">[退出]</a> <span class="divider">|</span></li>
		</c:if>
		<li><a href="#">我的订单</a> <span class="divider">|</span></li>
		<li><a href="cart.do?m=showCart"><i
				class="icon-shopping-cart"></i> 购物车<span class="numberic_red">(${sessionScope.cart.itemCount+0})</span></a><span
			class="divider">|</span></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown">客户服务</a><b class="caret"></b><span
			class="divider">|</span>
			<ul class="dropdown-menu">
				<li><a tabindex="-1" href="#">帮助中心</a></li>
				<li><a tabindex="-1" href="#">售后服务</a></li>
				<li><a tabindex="-1" href="#">在线客服</a></li>
				<li class="divider"></li>
				<li><a tabindex="-1" href="#">投诉中心</a></li>
				<li><a tabindex="-1" href="#">客服邮箱</a></li>
			</ul></li>
	</ul>
</div>

<div class="container">
	<div class="navbar">
		<div class="navbar-inner nav_bg">
			<a class="brand" href="#">全部商品分类</a>
			<ul class="nav">
				<li><a href="home.do">首页</a></li>
				<li><a href="#">图书城</a></li>
				<li><a href="#">阅览区</a></li>
				<li><a href="#">团购</a></li>
				<li><a href="#">服务</a></li>
				<li><a href="#">闪购</a></li>
				<li><a href="#">社区</a></li>
			</ul>
		</div>
	</div>
</div>