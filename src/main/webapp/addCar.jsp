<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<style>
.lable
{
color: black;
  padding: 8px;
}
.orange{
  color: #ed6c0d;
  cursor: pointer !important;
}
</style>
<body>

<% 
int sellerId=(Integer)session.getAttribute("login_seller_id");

%>
<script>
function myFunction() {
	if(sellerId!=null)
		{
  alert("added success");
		}
	else
		{
		alert("Failed");
		}
}
		</script>
	<script src="js/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	console.log("Jquery working");
});
function validateCarNo(regNo)
{
	//alert(phNo)
	
	var url = "CarRegNoValidateServlet?regNo=" + regNo;
	$.get(url, function(data){
		console.log(data);
		  var result = parseInt(data);
		
		//  alert("Data:" + data.length);
		  if(result ==1)
			  {
			 // alert("Your Already Registered");
			  var c = confirm("car is already registered");
			
			  }
	});
	
	}
	
	function setYear(){
		$("#regYear").attr("min", 1947);
		$("#regYear").attr("max", new Date().getFullYear());
		
	}
	function validateYear(year)
	{
		/* 
		console.log(year);
		var currentYear=new Date().getFullYear();
		if(year>1947 && year>currentYear==false)
			{
			
			}
		else
			{
			alert("enter the valid year");
			}
	 */	
	}
	

</script>
	
<Form action="AddCarServlet" method="post" autocomplete="off">
<table>
<tbody>
<tr><td>Car Name</td><td>: <input type="text" name="carName" id="carName" placeholder="Ex:figo" required/></td></tr>
<tr><td>Car Brand</td><td>: <input type="text" name="carBrand" id="carBrand" placeholder="ford" required/></td></tr>
<tr><td>Transmission Type</td><td>: <input type="radio" name="tr" value="manual" required>manual<input type="radio" name="tr" value="auto">auto</td></tr>
<tr><td>Fuel Type</td><td>: <input type="radio" name="fuel" value="petrol" required>Petrol<input type="radio" name="fuel" value="diesel">Diesel</td></tr>
<tr><td>Registration State</td><td>: <input type="text" name="regState" id="regState" placeholder="Ex:Tamilnadu"required/></td></tr>
<tr><td>Car Available City </td><td>: <input type="text" name="carAvailableCity" id="carAvailableCity" placeholder="Ex:chennai" required/></td></tr>
<tr><td>Registered Year</td><td>: <input type="number" name="regYear" id="regYear" placeholder="Ex:2000"  required onblur="validateYear(this.value)"/></td></tr>
<tr><td>Driven Kilometer</td><td>: <input type="number" name="drKm" id="drKm" maxlength="10" pattern="^[0-9]" title="Enter Km correctly" min="1" placeholder="Ex:DrivenKm"required/></td></tr>
<tr><td>Registration Number</td><td>: <input type="text" name="regNo" id="regNo"required placeholder="Ex:TN00NH3433" pattern="[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}" title="Enter correct Format"onblur="validateCarNo(this.value)"/></td><td><Label for="regNo" class="lable"><span class="orange">Ex:TN00NH3433</span></Label></td></tr>
<tr><td>Vehicle Identification Number</td><td>: <input type="text" name="vid" maxLength="17" pattern="[0-9]{1}[A-Z]{4}[0-9]{2}[A-Z]{4}[0-9]{6}" title="need 17 character" id="vid"required placeholder="Ex:1NNNN11NNNN111111"/></td><td><Label for="vid"><span class="orange">Ex:1NNNN11NNNN111111</span></Label></td></tr>
<tr><td>Price</td><td>: <input type="number" name="price" id="price"placeholder="Ex:100000"  min=300000 pattern="^[0-9]" title="Give valid price"required/></td></tr>
<tr><td>Are You owner</td><td><input type="radio" name="isowner" value=1 required>Yes<input type="radio" name="isowner"value=0>No<br></td></tr>
<tr><td>Car Image Source</td><td>: <input type="text" name="image" placeholder="image.jpg"/></td></tr> 
<tr><td></td><td align="right"><button type="submit" onclick="myfunction()" class="btn btn-default login-buton btn-disabled">add</button></td></tr>
</tbody>
</table>
</Form>
<script>
setYear();

</script>
</body>
</html>