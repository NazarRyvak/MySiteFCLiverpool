<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>

<form:form class="formCommodity" action="/shop/save-commodity" method="POST"  modelAttribute="commodityModel"  enctype="multipart/form-data">
Type:<form:select path="type">
<form:option value="T-SHIRTS">T-SHIRTS</form:option>
<form:option value="SHORTS">SHORTS</form:option>
<form:option value="SOCKS">SOCKS</form:option>
<form:option value="SOUVENIRS">SOUVENIRS</form:option>
</form:select><br>
Name:<form:input path="name"/><br>
Price:<form:input path="price"/><br>
Image:<input type="file" name="commodityImage"><br>

Descriprion:<form:textarea path="description"/>

<button type="submit">SAVE</button>

</form:form>