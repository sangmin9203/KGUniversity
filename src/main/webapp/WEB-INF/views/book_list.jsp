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
		<img src ="<spring:url value='/resources/img/${List.book_picture}'/>"><br>
		<a href="getBookInfo.do?book_name=${List.book_name}">${List.book_name}</a><br>
		<%-- <a href="list.jsp?name=<%= URLEncoder.encode(name, "UTF-8")%>">list로 이동</a> --%>
		${List.book_price}<br>
	</c:forEach>
</body>
</html> 