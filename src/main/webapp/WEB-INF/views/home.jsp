<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

	<h1>You are in the site FC Liverpool</h1>
<sec:authorize access="isAuthenticated()">


</sec:authorize>
<sec:authorize access="!isAuthenticated()">


</sec:authorize>


