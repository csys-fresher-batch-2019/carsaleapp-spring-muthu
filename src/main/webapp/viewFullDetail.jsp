<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@page import="java.util.List" %>
     <%@page import="com.chainsys.carsaleapp.model.CarDetail" %>
     <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuySell</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>

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
<style>
body
{
background-image:url('assets/images/car2.jpg');
background-repeat: no-repeat;
background-attachment: fixed;
background-size: 100% 100%;
}
</style>
<body>
<%List<CarDetail> cd=(List<CarDetail>)request.getAttribute("carDetail"); %>

<form>
<div>
<%if(cd!=null)
{%>

<%	for(CarDetail cd1:cd)
		{%>
	
	<center>
<div class="cent">
<div class ="card-desk" class="left">
<div class="card" style="width: 20rem; height: 40rem">
  <img src="assets/images/<%=cd1.getImageSrc() %>" class="card-img-top" alt="image">
  <div class="card-body">
    <h5 class="card-title"><%=cd1.getCarBrand() %> <%=cd1.getCarName() %> </h5>
    <h6 class="card-text">Registered Year:<%=cd1.getRegYear()%></h6>
    <h6 class="card-text">DrivenKm:<%=cd1.getDrivenKm()%></h6>&nbsp;<h6 class="card-text">price:<%=cd1.getPrice() %></h6>
     <h6 class="card-text">Transmission Type:<%=cd1.getTrType()%></h6>&nbsp;<h6 class="card-text">Registration Number:<%=cd1.getRegistrationNo()%></h6>
     <h6 class="card-text">Registered State:<%=cd1.getRegState() %></h6>&nbsp;<h6 class="card-text">Seller Name:<%=cd1.getCarOwner().getOwnerName()%></h6>
        <h6 class="card-text">Seller Contact Number:<%=cd1.getCarOwner().getContactNo() %></h6>
         <a href="OrderCarServlet?carId=<%=cd1.getCarId()%>" class="right" class="madal-title"><span class="orange">Order</span></a></a>
         
         </div>
</div>
</div>
</div>
</center>
<%}%>
<%} %>
</div>
</form>
</body>
</html>