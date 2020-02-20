<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@page import="java.util.List" %>
    <%@page import="com.chainsys.carsale.dao.impl.CarDetailImp"%>
     <%@page import="com.chainsys.carsale.model.CarDetail"%>
      <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ALL CARS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<style>

.left{
float:left;
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: px;
}
.cent{
float:
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: 60px;
}
.right{
float:right;
}
</style>
<body>
<% CarDetailImp co=new CarDetailImp(); %>
<%List<CarDetail> list=co.viewAllCar(); %>

<form action="">
<div>
<%if(list!=null)
{%>

<%	for(CarDetail cd:list)
		{%>
<div class="left">
<div class ="card-desk" class="left">
<div class="card" style="width: 25rem; height: 31rem">
  <img src="assets/images/<%=cd.getImageSrc() %>" class="card-img-top" alt="image">
  <div class="card-body">
    <h5 class="card-title"><%=cd.getCarBrand() %> <%=cd.getCarName() %> </h5>
    <h6 class="card-text">Registered Year:<%=cd.getRegYear()%></h6>
    <h6 class="card-text">DrivenKm:<%=cd.getDrivenKm()%></h6>
    <h6 class="card-text">price:<%=cd.getPrice() %></h6>
     <h6 class="card-text">Registered State:<%=cd.getRegState() %></h6>
      <a href="SearchCarServlet?carId=<%=cd.getCarId()%>" class="right" class="madal-title"><span class="orange">View Detail></span></a></div>
</div>
</div>
</div>
<%}%>
<%} %>
</div>
</form>
</body>
</html>