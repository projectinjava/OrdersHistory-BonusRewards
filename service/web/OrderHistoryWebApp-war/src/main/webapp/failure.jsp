<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h3 align="center" >failure response</h3>
<body style="background-color: aqua;">
<table align="center" style="background-color: orange;">
<tr>
<th>ErrorCode</th>
<th>ErrorMsg</th>
</tr>
<tr>
<td>${webRespStatus.respCode}</td>
<td>${webRespStatus.respMsg}</td>
</tr>
</table>
</body>
</html> 