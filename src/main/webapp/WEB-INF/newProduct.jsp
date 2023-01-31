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
<title>New Product</title>
</head>
<body>
	<h3>new product</h3>
	
	<form:form action="/products/create" method="POST" modelAttribute="product">
		<div>
	        <form:label path="name">Name: </form:label>
	        <form:input path="name"/>
	        <form:errors path="name"/>
    	</div>
    	<div class="form-group">
			<form:label path="description">Description: </form:label>
			<form:input class="form-control" path="description"/>
			<form:errors path="description"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="price">Price: </form:label>
			<form:input class="form-control" path="price"/>
			<form:errors path="price"></form:errors>
		</div>
		<input type="submit" value="Submit" />
	</form:form>
	

</body>
</html>