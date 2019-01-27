<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

<table class="myTable">
	<thead>
		<tr class="tableTR">
			<th class="tableTH">Home Team</th>
			<th class="tableTH">Score</th>
			<th class="tableTH">Guest Team</th>
			<th class="tableTH">Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ listMatches }" var="match">
			<tr class="tableTR">
				<td class="tableTH">${match.homeTeam }</td>
				<td class="tableTH">${ match.goalHome }-${ match.goalGuest }</td>
				<td class="tableTH">${ match.guestTeam }</td>
				<td class="tableTH"><a href="/admin/update/match/${ match.id }"><button>UPDATE</button></a><a href="/admin/clear/match/${ match.id }"><button>CLEAR</button></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<form:form action="/admin/set" method="post">
	<select name="settedTour">
			<c:forEach items="${ tourList }" var="tour">
			<c:choose>
			<c:when test="${ tour==selectedTour }">
			<option selected value="${ tour }">${ tour }</option>
			</c:when>
			<c:otherwise>
			<option  value="${ tour }">${ tour }</option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</select>
				<button type="submit">SET</button>
	</form:form>