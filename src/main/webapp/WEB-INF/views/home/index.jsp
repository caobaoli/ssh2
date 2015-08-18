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
<c:import url="../common.jsp"></c:import>
</head>
<body>
<c:import url="_head.jsp"></c:import>
<div class="container">
  <div class="row">
  	<c:import url="_catalog.jsp"></c:import>
  	<c:import url="_books.jsp"></c:import>
  </div>
</div>
<c:import url="_footer.jsp"></c:import>
</body>
</html>
