<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

<div class="panel-body">
	<table class="table table-striped table-bordered ">
		<thead style="text-align: center;">
			<tr >
				<th >№</th>
				<th >Team</th>
				<th>Games</th>
				<th>Win</th>
				<th>Draw</th>
				<th>Lost</th>
				<th>Goals</th>
				<th>Point</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${sortedTeam }" var="team" varStatus="i">

				<tr>

					<td>${ i.index+1 }</td>
					<td style="text-align: left;"><img src="${ team.team.myGerb }" height="20px" width="18px"><span style="margin-left: 10px">${ team.team.name }</span></td>
					<td>${ team.game }</td>
					<td>${ team.gameWin }</td>
					<td>${ team.gameDraw }</td>
					<td>${ team.gameLose }</td>
					<td>${ team.goalScore }-${ team.goalMiss }</td>
					<td>${ team.point}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>