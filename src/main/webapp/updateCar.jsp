<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@page import="com.chainsys.carsale.dao.impl.CarOwnerImp" %>
    <%@page import="com.chainsys.carsale.model.CarOwner" %>
    <%@page import="java.util.List" %>
    <jsp:include page="header.jsp"></jsp:include>
  
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyCars</title>
</head>
<script>

</script>
<body>
<form>


<%
	Integer sellerId=(Integer)session.getAttribute("login_seller_id"); 
CarOwnerImp odi=new CarOwnerImp();
List<CarOwner> car=(List<CarOwner>)request.getAttribute("totalCar");
String msg="no records";
%>
<% if(car!=null&& !car.isEmpty()){%>
	<div class="container">
	<table  class="table table-striped">
	<thead>
	<tr>
	<th>SellerName</th>
	<th>SellerId</th>
	<th>CarAvailableCity</th>
	<th>CarBrand</th>
	<th>CarName</th>
	<th>DrivenKm</th>
	<th>Price</th>
	<th>Registration Year</th>
	<th>Registration Number</th>
	<th>Vehicle Identification Number</th>
	</tr>
	</thead>
<% for(CarOwner co:car){%>

	<tr>
	<td><%=co.getOwnerName() %></td>
	<td><%=co.getOwnerId() %></td>
	<td><%=co.getCarDetail().getCarAvailableCity()%></td>
	<td><%=co.getCarDetail().getCarBrand() %></td>
	<td><%=co.getCarDetail().getCarName() %></td>
	<td><%=co.getCarDetail().getDrivenKm() %></td>
	<td><%=co.getCarDetail().getPrice() %></td>
	<td><%=co.getCarDetail().getRegYear() %></td>
	<td><%=co.getCarDetail().getRegistrationNo() %></td>
	<td><%=co.getCarDetail().getVehicleIdNo() %></td>
	</tr>
	
	<%}%>
	</table>
	</div>
	<%}
else {%>
		<h1>NO RECORDS</h1>

<% }%>

</form>
</body>
</html>