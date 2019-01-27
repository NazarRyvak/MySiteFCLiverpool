<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="hasRole('ADMIN')">
		<p>
			<a href="/admin/update/result/${ selectedTour }">Update</a>
		</p>
	</sec:authorize>
	<c:forEach items="${ listMatches }" var="match">
		<c:if
			test="${ match.homeTeamObject.name !=null && match.guestTeamObject.name!=null}">
			<div class="containerForResult">
				<div class="resultTeam">
					<div class="resultTeamText">${ match.homeTeamObject.name }</div>
				</div>

				<div class="resultGerb">
					<img src="${ match.homeTeamObject.myGerb }" height="100%">
				</div>

				<div class="resultScore">${ match.goalHome}</div>

				<div>-</div>

				<div class="resultScore">${ match.goalGuest }</div>
				<div class="resultGerb">
					<img src="${ match.guestTeamObject.myGerb }" height="100%">
				</div>
				<div class="resultTeam">
					<div class="resultTeamText">${ match.guestTeamObject.name }</div>
				</div>
			</div>
			<br>
		</c:if>
	</c:forEach>


	<form:form action="/set" method="post">
		<select name="settedTour">
			<c:forEach items="${ tourList }" var="tour">
				<c:choose>
					<c:when test="${ tour==selectedTour }">
						<option selected value="${ tour }">${ tour }</option>
					</c:when>
					<c:otherwise>
						<option value="${ tour }">${ tour }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<button type="submit">SET</button>
	</form:form>

</body>
</html>