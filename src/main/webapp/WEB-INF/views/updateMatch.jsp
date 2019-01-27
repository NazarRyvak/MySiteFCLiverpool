<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<form:form action="/admin/save" method="POST"
	modelAttribute="modelMatch">

	<input type="hidden" name="id" value="${ modelMatch.id }">
Enter home team: <form:select path="homeTeam">
		<c:forEach items="${ teams }" var="team">
		<c:choose>
		<c:when test="${ teamHome==team }">
		<option  selected="${ team }" value="${ team }">${ team }</option>
		</c:when>
		<c:otherwise>
		<option value="${ team }">${ team }</option>
		</c:otherwise>
		</c:choose>
		</c:forEach>
	</form:select>
	<br>
Enter goal`s home team<form:input path="goalHome" />
	<br>
Enter home team: <form:select path="guestTeam">
		<c:forEach items="${ teams }" var="team">
					<c:choose>
		<c:when test="${ teamGuest==team }">
		<option  selected="${ team }" value="${ team }">${ team }</option>
		</c:when>
		<c:otherwise>
		<option value="${ team }">${ team }</option>
		</c:otherwise>
		</c:choose>
		</c:forEach>
	</form:select>
	<br>
Enter goal` guest Team<form:input path="goalGuest" />
	<br>
	<button type="submit">SAVE</button>
</form:form>