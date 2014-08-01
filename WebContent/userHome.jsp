<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="content">
		<p id="error">
			<c:if test="${not empty requestScope.errors }">
				<c:out value="${errors }"></c:out>
			</c:if>
		</p>
		<div id="productList">
			<c:if test="${not empty productList }">
				<form method="post" action="UserSelectedProducts">
					<table>
						<tr>
							<th>Select</th>
							<th>Item Category</th>
							<th>Item Name</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
						<c:forEach var="item" items="${productList}">
							<tr>
								<td><input type="checkbox" name="items"
									value="${item.itemId}"/></td>
								<td><c:out value="${item.category}" /></td>
								<td><c:out value="${item.name}" /></td>
								<td><c:out value="${item.price}" /></td>
								<td><input type="text" name="${item.itemId}" value="1" />
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" style="float: right;">
								<div id="cost">
									<input type="submit" name="submit" value="Checkout">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>