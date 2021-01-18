<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path" value ="${pageContext.request.contextPath}"/>
<%@ page session="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세내용</title>
</head>
<body>
<img src ="<spring:url value='/resources/img/${bvo.book_picture}'/>"><br>
${bvo.book_name}<br>
${purchase.book_amount}<br>
</body>
</html>