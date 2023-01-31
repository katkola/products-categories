<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
	<div id="main">
		<h3><c:out value="${category.name}"/></h3>
		<a href="/">Home</a>
		<div>
			<h4>Categories</h4>
			<ul>
				<c:forEach var="product" items="${category.products}">
					<li><c:out value="${product.name}" /></li>
				</c:forEach>
			</ul>
		</div>
		
		
		<form action="/categories/update/${category.id}" method="post">
				<div class="form-group">
					<label for="productId">Add Product:</label>
            		<select name="productId">
            			<c:forEach var="product" items="${allProducts}">
            				<option value="${product.id}"> ${product.name}</option>
            			</c:forEach>
            		</select>
				</div>
				<input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>