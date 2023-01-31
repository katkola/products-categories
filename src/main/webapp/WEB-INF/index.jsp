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
<title>Home Page</title>
</head>
<body>
	<h3>Home Page</h3>
	
	<a href="/products/new">New Product</a>
	<a href="/categories/new">New Category</a>
	
	<div class="card">
		<div class="card-body">
			<h4>Products</h4>
			<ul>
				<c:forEach var="product" items="${allProducts}">
					<li><a href="products/${product.id}"><c:out value="${product.name}" /></a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="card-body">
			<h4>Categories</h4>
			<ul>
				<c:forEach var="category" items="${allCategories}">
					<li><a href="categories/${category.id}"><c:out value="${category.name}" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>