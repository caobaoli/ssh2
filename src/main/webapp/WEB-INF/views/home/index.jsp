<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网上书城</title>
<link href="<%=path %>/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/assets/app/application.css" rel="stylesheet" type="text/css">

<!--[if lt IE 9]>
<script src="<%=path %>/assets/js/html5shiv.js"></script>
<![endif]-->
</head>
<body>
<%@include file="_head.jsp" %>
<div class="container">
  <div class="row">
    <%@include file="_catalog.jsp" %>
    <%@include file="_books.jsp" %>  
  </div>
</div>
<%@include file="_footer.jsp" %>
<script language="javascript" src="<%=path %>/assets/js/jquery-1.11.3.js"></script> 
<script language="javascript" src="<%=path %>/assets/bootstrap/js/bootstrap.js"></script>
<script language="javascript" src="<%=path %>/assets/js/jquery-ui.js"></script>
<script language="javascript" src="<%=path %>/assets/js/application.js"></script>
</body>
</html>
