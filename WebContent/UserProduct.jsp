<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<table>
				<tr>
					<th>S. No.</th>
					<th>Item Category</th>
					<th>Item Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Discounted Price</th>
				</tr>
				<c:if test="${not empty requestScope.dto }">
					<c:set var="count" value="0" scope="page" />
					<c:set var="initialCost" value="0" scope="page" />
					<c:forEach var="product"
						items="${requestScope.dto.userProductList}">
						<c:set var="initialCost"
							value="${(product.price *  dto.itemQuantity[count])+ initialCost}" />
						<tr>
							<td><c:out value="${count+1 }"></c:out></td>
							<td><c:out value="${product.category }"></c:out></td>
							<td><c:out value="${product.name }"></c:out></td>
							<td><c:out value="${dto.itemQuantity[count]}"></c:out></td>
							<td><c:out value="${product.price }"></c:out></td>
							<td><c:out value="${dto.finalPriceList[count] }"></c:out></td>
						</tr>
						<c:set var="count" value="${count+1 }" />
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="6"><div id="cost">
							<p>
								<span id="cost_title">Initial Cost -</span>
								<c:out value="${initialCost}"></c:out>
							</p>
							<p>
								<span id="cost_title">Final Cost -</span>
								<c:out value="${requestScope.dto.finalCost}"></c:out>
							</p>
						</div></td>
				</tr>
			</table>

		</div>
	</div>

</body>
</html>