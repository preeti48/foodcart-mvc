<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
<table border="1" cellpadding="10%" cellspacing="5" align="center" bordercolor="green">
<h1 align="center"> Menu</h1>
	<tr>
	<th>Id</th>
	<th>Items</th>
	<th>Price</th>
	</tr>

	<c:forEach var="item" items="${foodItems}">
	<tr>
		<td>${item.id}</td>
		<td>${item.item}</td>
		<td>${item.price}</td>
	<tr>
	</c:forEach>
</tr>
</table>

<form action="./Food" method="post">
	<input type="submit" value="submit"></input>
	<input type="text" name="id"></input>
	<input type="text" name="item"></input>
	<input type="text" name="price"></input>
</form>	
</body>
</html>