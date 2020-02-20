<%@page import="java.awt.Window"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>REGISTRATION</title>
 <style>
  .right{
float:right;
}
.center
{
float:center;
}
.cent{
float:
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: 60px;
}
 </style>
<script src="js/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	console.log("Jquery working");
});
function validateContactNo(phNo)
{
	//alert(phNo)
	if(phNo.length!=10 || phNo.length>10)
		{
		alert("check phone No")
		}
	var url = "CarOwnerValidateServlet?phoneNo=" + phNo;
	$.get(url, function(data){
		console.log(data);
		  var result = parseInt(data);
		
		//  alert("Data:" + data.length);
		  if(result ==1)
			  {
			 // alert("Your Already Registered");
			  var c = confirm("You are already registered. Do you want to login ?");
			  if ( c){
				  window.location.href="login.jsp";
			  }
			  }
	});
	
	}
	

</script>
</head>
<body>
<script type="text/javascript">
function check(input) {
if (input.value != document.getElementById('npass').value) {
input.setCustomValidity('Password Must be Matching.');
} else {
// input is valid -- reset the error message
input.setCustomValidity('');
}
}     
function  register()
{
if(test="${param.success eq 1}")
{
alert("register successFully");
var c=confirm("Registered successFully.Do you want to jogin?");
if(c)
	{
	window.location.href("login.jsp");
	}
}
}
</script>

<form action="RegisterServlet" method="post">



<div class="card-desk">
<div class="card" style="width: 25rem; height:32rem">
<h6 class="modal-title"><Span class="orange"> REGISTRATION</Span></h6>
<div class="card-body">
<table>
<tr><td><label for="ContactNo">Contact No:</label></td>
<td><input type="number" name="contactNo" id="ContactNo" maxLength="10" pattern="[0-9]{10}" title="10 digit mobile no" required onblur="validateContactNo(this.value)"/></td>
<tr><td><label for="sname">Your Name:</label></td>
<td><input type="text" name="sname" id="sname" required/></td></tr>
<tr><td><label for="sname">Address1:</label></td>
<td><input type="text" name="address1" id="address" required/></td></tr>
<tr><td><label for="sname">Address2:</label></td>
<td><input type="text" name="doorno" id="sname"/></td></tr>
<tr><td><label for="scity">City:</label></td>
<td><input type="text" name="city" id="scity" required/></td></tr>
<tr><td><label for="sname">State :</label></td>
<td><input type="text" name="state" id="sstate" required/></td></tr>
<tr><td><label for="sname">Pincode :</label></td>
<td><input type="text" name="pincode" id="spincode" pattern=[0-9]{6} maxlength="6" title="EX:600000" required/></td></tr>
<tr><td><label for="npass">Password</label></td>
<td><input type="password" name="npass" id="npass" required/></td></tr>
<tr><td><label for="npass">Re-Enter Password</label></td>
<td><input type="password" name="npass" id="npass" required oninput="check(this)"/></td></tr>
<tr><td></td><td><button type="submit"   class="btn btn-default login-buton btn-disabled right">Sign up</button></td></tr>
</table>
</div>
</div>
</div>
</form>

<%
String errorMessage = request.getParameter("errorMessage");

%>
</body>
</html>