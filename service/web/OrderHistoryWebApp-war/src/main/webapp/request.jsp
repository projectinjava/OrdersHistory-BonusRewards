<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<spring:form action="getorders.form" method="post" commandName="webReq">
<H1 align="center" style="background-color:silver;" >ORDER HISTORY SERVICES AND BONUS REWARD</H1>
<body style="background-color:aqua; ">
<div align="center">
<table style="background-color:orange;" >
<tr>
<td>CardNumber</td><td><spring:input path="cardNumber"/>
</tr>
<tr>
<td>NameOnCard</td><td><spring:input path="nameOnCard"/>
</tr>
<tr>
<td>CvvNum</td><td><spring:input path="cvvNum"/></tr>
<tr>
<td>ExpDate</td><td><spring:input path="expDate"/></tr>
<tr>
<td>StartDate</td><td><spring:input path="startDate"/></tr>
<tr>
<td>EndDate</td><td><spring:input path="endDate"/></tr>
<tr>
<td>TypeOfOrder</td><td><spring:input path="typeOfOrder"/></tr>
<tr>
<td>Price</td><td><spring:input path="price"/></tr>
</table>

</br>

<input type=submit  value="submit">
</div>
</body>
</spring:form>
