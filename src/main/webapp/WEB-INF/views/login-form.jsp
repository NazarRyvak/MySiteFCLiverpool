<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

	<div class="loginForm">
		<div class="textForLogin">
			<p>Login</p>
		</div>
		<form:form action="/user/login" method="post">
			<p>Your login:</p>
			<input type="text" name="login">
			<p>Your password:</p>
			<input type="password" name="password">
			<br>
			<br>
			<button type="submit" class="btn btn-primary btn-md">login</button>
			<br>
			<br>
			<p>
				New Member? <a href="/user/register" class="">Sign up</a>
			</p>
			<p>
				<a>Forgot password?</a>
			</p>
		</form:form>
	</div>
