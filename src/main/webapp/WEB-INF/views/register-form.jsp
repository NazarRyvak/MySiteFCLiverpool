<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.errors{
color:red;'
}
</style>
</head>
<body>
<div class="registryForm">
<div class="textForRegistry"><p>Registry</p></div>
<form:form action="/user/register" method="post" modelAttribute="registerModel">
<form:errors path="*" cssClass="errors"></form:errors>
<p>Your login:</p><form:input path="login"/>
<p>Your email:</p><form:input type="email" path="email"/>
<p>Your password:</p><form:input type="password" path="password"/>
<p>Confirm your password:</p><form:input type="password" path="confirmPassword"/><br><br>
<button type="submit" class="btn btn-primary btn-md">Registry</button><br><br>
</form:form>
</div>
</body>
</html>