<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<form action="/getOrders" modelAttribute="orderCmd">
	<h1 style="color:red;text-align:center">Order History Details</h1>
	Name on Card : <input type="text" name="nameOnCard"><br>
	Cvv Number : <input type="text" name="cvvNum"><br>
	Exp Date : <input type="text" name="expDate"><br>
	Start Date : <input type="text" name="startDate"><br>
	End Date : <input type="text" name="endDate"><br>
	Price : <input type="text" name="price"><br>
	Type Of Order : <input type="text" name="typeOfOrder"><br>
	<input type="submit" value="Submit"/>
</form>