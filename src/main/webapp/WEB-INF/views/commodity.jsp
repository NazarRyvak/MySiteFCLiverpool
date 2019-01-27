<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>






<div class="containerForCommodity">
<div class="filterCommodity">
<div class="container containerForFilter">
	<div class="row">
		<div class="col-lg-3 col-md-6 col-md-offset-3 col-lg-offset-0">
      <div class="well">
      <h3 align="center">Search Filter</h3>
      
        <form:form class="form-horizontal" modelAttribute="filter" action="/shop/search" method="GET">
        
          <div class="form-group">
            <label for="type" class="control-label">Type</label><br>
       T-SHIRT:<form:checkbox path="type" value="T-SHIRTS" id="type"/><br>
SHORTS:<form:checkbox path="type" value="SHORTS" id="type"/><br>
SOCKS:<form:checkbox path="type" value="SOCKS" id="type"/><br>
SOUVENIRS:<form:checkbox path="type" value="SOUVENIRS" id="type"/><br>
          </div>
          <div class="form-group">
            <label for="pricefrom" class="control-label">Min Price</label>
            <div class="input-group">
              <div class="input-group-addon" id="basic-addon1">£</div>
              <form:input path="searchFromMinPrice" type="text" class="form-control" id="pricefrom" aria-describedby="basic-addon1"/>
            </div>
          </div>
          <div class="form-group">
            <label for="priceto" class="control-label">Max Price</label>
            <div class="input-group">
              <div class="input-group-addon" id="basic-addon2">£</div>
              <form:input path="searchToMaxPrice" type="text" class="form-control" id="priceto" aria-describedby="basic-addon1"/>
            </div>
          </div>
          <button class="btn btn-danger" type="submit">Search</button>
          
        </form:form>
      </div>
    </div>
	</div>
</div>





<%-- Min price<br>
Max price:<form:input /><br>
 --%>



</div>
<div class="commodityShow">
	<sec:authorize access="hasRole('ADMIN')">
	<div style="width: 100%;"><a href="/shop/add-commodity">ADD NEW COMMODITY</a></div>
	</sec:authorize>
<c:forEach items="${ commodities }"  var="commodity">
<div class="commodity col-md-4">
<div class= "commodityImage"><img src="${ commodity.imageUrl } " width="200px"></div>
<div class="commodityInfo">
<span> ${ commodity.name } </span><br>
<span> £${ commodity.price } </span>

</div>


</div>
</c:forEach>
</div>

</div>