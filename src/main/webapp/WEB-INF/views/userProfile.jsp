<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class="userProfileImage"><img src="${ userModel.profileImageUrl }"></div>
<div class ="userProfileInfo" >
<h1>My profile </h1>
<h3>My username: ${ userModel.login }</h3>
<h3>My email: ${ userModel.email }</h3>
<h3>My role is ${ userModel.role.myRole }</h3>
<br>
<a href="/user/${ userModel.id }/image">Upload profile image</a>

</div>
</body>
</html>