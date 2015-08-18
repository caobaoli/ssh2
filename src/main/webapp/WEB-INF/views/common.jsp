<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<link rel="stylesheet" type="text/css" href="<%=path %>/assets/app/smoothness/jquery-ui.css">
<link href="<%=path %>/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/assets/app/application.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="<%=path %>/assets/js/html5shiv.js"></script>
<![endif]-->
<script language="javascript" src="<%=path%>/assets/js/jquery-1.11.3.js"></script>
<script language="javascript" src="<%=path %>/assets/bootstrap/js/bootstrap.js"></script>
<script language="javascript" src="<%=path %>/assets/js/jquery-ui.js"></script>
<script language="javascript" src="<%=path %>/assets/js/application.js"></script>