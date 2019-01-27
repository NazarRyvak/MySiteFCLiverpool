<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

<div id="app">
	<sec:authorize access="hasRole('ADMIN')">
		<div class="row" style="margin: 0 auto;">
			Full Name:<input type="text" v-model="player.fullName"><br>
			Position: <select v-model="player.position">
				<option value="Goalkeeper">Goalkeeper</option>
				<option value="Defender">Defender</option>
				<option value="Midfielder">Midfielder</option>
				<option value="Forward">Forward</option>
			</select> <br> Number: <input type="text" v-model="player.number"><br>
			Country: <input type="text" v-model="player.country"><br>
			Descriprion: <input type="text" v-model="player.description"><br>
			<button @click="savePlayer()" class="button ">Save player</button>
		</div>

	</sec:authorize>



	<br>
	<div class="row">
		<div class="col-md-12">
		
			<div v-for="player in players" class="col-md-4">
				<div class="myContainerForPlayer">
					<span class="label-info"> <img class="playerIMG"
						:src=player.imageUrl alt="" height="150px">
					</span>
					<div class="playerNumber">
						<h3 style="margin: auto auto;">{{player.number}}</h3>
					</div>
					<div class=infoPlayer>

						<h1 style="color: black;">{{player.fullName}}</h1>
						<h3 style="color: black;">{{player.position}}</h3>

					</div>



					
				</div>
				<div class="update">
						<sec:authorize access="hasRole('ADMIN')">
							<div class="row text-center">

								<div class="col-md-12">
									<button @click="getPlayer(player.id)" class="btn btn-info">Edit</button>
									<button @click="deletePlayer(player.id)" class="btn btn-danger">Delete</button>
								</div>

							</div>
							<div class="row text-center">
								<div class="col-md-12">
									<input type="file" @change="selectFile($event)">
									<button @click="uploadFile(player.id)" class="btn btn-info">Upload
										image</button>
									<br>
								</div>
							</div>
						</sec:authorize>
					</div>

			</div>
			
		</div>
		
	</div>
</div>
<script src="/resources/js/axios.min.js"></script>
<script src="/resources/js/vue.min.js"></script>
<script src="/resources/js/main.js"></script>