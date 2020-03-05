<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@page import="java.util.List" %>
     <%@page import="com.chainsys.carsaleapp.model.CarDetail" %>
     <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuySell</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>

.orange{
  color: #ed6c0d;
  
  cursor: pointer !important;
}
modal-title{
                    font-size: 20px;
                    color: #463364;
                    margin-bottom: 48px;
                    font-weight: 500;
                    line-height: 1.3;
                    max-width: 194px;
                }
.left{
float:left;
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: px;
}
.right{
float:right;
}
</style>
</head>
<%List<CarDetail> cd=(List<CarDetail>)request.getAttribute("availableCar"); %>
<body>
<form action="SearchByBrandServlet" method="get">
<div>
<input list="carBrand"  name="carBrand" placeholder="CarBrand">
<datalist id="carBrand">
<option value="audi">
<option value="honda">
<option value="ford">
<option value="tata">
<option value="hundai">
<option value="maruti">
<option value="suzuki">
</datalist>
<button name="submit">Search</button>
</div>
<%if((cd!=null)&&!cd.isEmpty()){%>
<%for(CarDetail cdl:cd)
	{%>
<div class="left">
<div class ="card-desk" class="left">
<div class="card" style="width: 18rem; height: 20rem">
  <img src="assets/images/<%=cdl.getImageSrc()%>" class="card-img-top" alt="image">
  <div class="card-body">
    <h5 class="card-title"><%=cdl.getCarBrand() %> <%=cdl.getCarName() %> </h5>
    <h6 class="card-text">Registration year:<%=cdl.getRegYear()%></h6>
    <h6>DrivenKm:<%=cdl.getDrivenKm()%></h6>
    <h6>price:<%=cdl.getPrice() %></h6>
    <a href="SearchCarServlet?carId=<%=cdl.getCarId()%>" class="right" class="madal-title"><span class="orange">view Detail></span></a>
  </div>
</div>
</div>
</div>
<%}%>
<%}%>
</form>
</body>
</html>