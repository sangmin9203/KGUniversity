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
${bvo.book_writer}<br>
${bvo.book_price}<br>
<pre><c:out value="${bvo.book_info}"/></pre><br>
<pre><c:out value="${bvo.book_mokcha}"/></pre><br>

<form action = "${path}/book/bookAll.do" method = "GET">
	<input  type = "hidden" name = "book_name" value ="${bvo.book_name}">
	<input  type = "hidden" name = "page" value ="${supPaging.page}">
	<input  type = "hidden" name = "perPageNum" value ="${supPaging.perPageNum}">
	<button type = "submit">목록</button>
</form>
<form action ="${path}/book/updateBook.do" method = "GET">
	<input  type = "hidden" name = "book_name" value ="${bvo.book_name}">
	<input  type = "hidden" name = "page" value ="${supPaging.page}">
	<input  type = "hidden" name = "perPageNum" value ="${supPaging.perPageNum}">
	<button type = "submit">수정</button>
</form>
<form action ="${path}/book/deleteBook.do" method = "POST">
	<input  type = "hidden" name = "book_name" value ="${bvo.book_name}"> 
	<input  type = "hidden" name = "page" value ="${supPaging.page}">
	<input  type = "hidden" name = "perPageNum" value ="${supPaging.perPageNum}">
	<button type = "submit">삭제</button>
</form>

</body>
</html>