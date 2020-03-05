<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <%@page import="com.chainsys.carsaleapp.dao.impl.CarOrderImp" %>
    <%@page import="com.chainsys.carsaleapp.model.CarOrder" %>
    <%@page import="java.util.List" %>
    <jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Buy</title>
</head>
<body>
<%
	Integer sellerId=(Integer)session.getAttribute("login_seller_id"); 
CarOrderImp odi=new CarOrderImp();
List<CarOrder> car=(List<CarOrder>)request.getAttribute("orderedlist");
String msg="no records";
%>
<% if(car!=null &&  !car.isEmpty()){ %>
	<table class="table table-bordered">
	<thead>
	<tr>
	<th>BuyerName</th>
	<th>OrderId</th>
	<th>CarId</th>
	<th>BuyerId</th>
	 <th>address1</th>
     <th>address2</th>
      <th>city</th>
      <th>pincode</th>
      <th>State</th>
      <th>Test Drive</th>
      <th>status</th>
      <th>orderedDate</th>
	<th>DeliveryDate</th>
 	</tr>
	</thead>
<% for(CarOrder co:car){%>

	<tr>
	<td><%=co.getBuyerName() %></td>
	<td><%=co.getOrderId() %></td>
	<td><%=co.getCarId()%></td>
	<td><%=co.getUserId() %></td>
	<td><%=co.getAddress1()%></td>
    <td><%=co.getAddress2()%></td>
    <td><%=co.getCity()%></td>
    <td><%=co.getPincode()%></td>
    <td><%=co.getBuyerState()%></td>
    <td><%=co.getDeliveredDate() %></td>
	<td><%=co.getStatus()%></td>
	<td><%=co.getOrderedDate()%></td>
	<td><%=co.getDeliveredDate()%></td>
	
		</tr>
	
	<%}%>
	</table>
	<%}
else {%>
		<h1>NO RECORDS</h1>

<% }%>
</body>
</html>