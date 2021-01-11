<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 판매 목록</title>
</head>
<body>
	<c:forEach var = "List" items = "${alist}">
		${List.book_name}<br>
		${List.book_price}<br>
		${List.book_picture}<br>
		<img src ="<spring:url value='/resources/img/book_123124123.jpg'/>">
		<img src ="<spring:url value='/resources/img/${List.book_picture}'/>">
</c:forEach>
</body>
</html> 