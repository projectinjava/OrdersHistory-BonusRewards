<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h3 align="center">success response</h3>
<body style="background-color: aqua;">

<div align="center">
		<table align="center" border="3">
			<tr>
				<!-- <th><a href="sortcardnum">Sort By CardNumber</a></th> -->
				<th><a href="sortprice.form">Sort By Price</a></th>
				<th><a href="sortstatus.form">Sort By Status</a></th>
				<th><a href="typeoforder.form">Sort By Type</a></th>
				<th><a href="sortbyDate.form">Sort By Date</a></th>

			</tr>
			</table>
			</br>
	<table align="center" style="background-color: orange;">
	
		
		<tr>
			<th>orderId</th>
			<th>orderName</th>
			<th>description</th>
			<th>orderDate</th>
			<th>status</th>
			<th>type</th>
			<th>price</th>
		</tr>
		<c:forEach items="${listOrder}" var="orders">
			<tr>
				<td>${orders.oid}</td>
				<td>${orders.name}</td>
				<td>${orders.desc}</td>
				<td>${orders.date}</td>
				<td>${orders.status}</td>
				<td>${orders.type}</td>
				<td>${orders.price}</td>

			</tr>
		</c:forEach>
	</table>
	</br>
<!-- <form action="download.form?view=pdf">
	<select value="multiple">
	
	<option value="pdf">Download PDF <br> </option>
	<option value="download.form?view=excel">Download Excel </option>
	
	</select>
	<input type="submit" value="download"/>
</form> -->
	
	<div align="center" id="download" >
		<a href="download.form?view=pdf">Download PDF Document</a><br> <a
			href="download.form?view=excel">Download Excel Document</a>
	</div>
	

</body>
</html>
