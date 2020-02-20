 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #555;
}

.topnav a {
  float: left;
  color: #f2f2a2;
  text-align: center;
  padding: 16px 16px;
  text-decoration: none;
  font-size: 17px;
   display: inline-block;
   vertical-align: middle;
  content: "";
  background:;
  background-size: 100% 100%;
   align-items: center;
}

.topnav a:hover {
  background-color: #blue;
  color: red;
  
}

.topnav a.active {
  background:url('assets/images/login.png');
  color: white;
  padding: 5px 15px,5px;
  border-radius:20px;
}

.topnav a.right{
float:right;
}
.orange{
  color: #ed6c0d;
  cursor: pointer !important;
}
.white{
  color:#ffffff;
  cursor: pointer !important;
}
.rgiht{
float:left;
}

</style>
</head>
 <%
  Integer sellerId=(Integer)session.getAttribute("login_seller_id");
  %>
<body>
<div class="topnav">
  <a class="active" href="">BuYSeLL</a>
   <% if(sellerId==null) {%>
  <a href="login.jsp" class="right">Login</a>
 
  <a href="register.jsp" class="right">Register</a>
 <%} %>
 <%if(sellerId!=null){ %>
 
 <a href="LogoutServlet" class="right">Logout</a>
  <a class="right"><span class="white">User Id:</span><Span class="orange"><%=sellerId %></Span></a>
 <a href="addCar.jsp" class="right">AddCars</a>
 <a href= "viewCar" class="right">ViewMyCars</a>
 <a href="WhoOrderedMyCarSevlet"class="right">MyOrderedCar</a>
 <a href="ViewAllCar.jsp" class="left">HOME</a>
 <a href="viewOrderedCarServlet" class="right">orderedCars</a>
 <a href="SearchByPrice.jsp" class="left">SearchBy price</a>
 <a href="SearchByBrand.jsp" class="left">Search By Brand</a>
 
 <%} %>
</div>

<div style="padding-left:16px">
  <h2></h2>
  <p></p>
</div>

</body>
</html>
