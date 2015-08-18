<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span3">
      <div class="well sidebar-nav">
        <ul class="nav nav-list">
        <c:forEach var="catalog" items="${requestScope.catalogList}">
          <li class="${requestScope.c_id==catalog.id?'active':''}">
          <a href="home.do?c_id=${catalog.id}">${catalog.catalogName}</a>
          </li>
         </c:forEach>
        </ul>
      </div>
    </div>