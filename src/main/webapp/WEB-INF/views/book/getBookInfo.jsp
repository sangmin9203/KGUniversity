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
<form action = "purchaseList.do" method = "POST">
<select>
	<c:forEach var = "book_amount" begin="1" end = "${bvo.book_inventory}" step = "1" varStatus="a" >
		<option name = "book_amount">${book_amount}</option>
	</c:forEach>
</select>
(재고 : ${bvo.book_inventory})<br>
</form>
<pre><c:out value="${bvo.book_info}"/></pre><br>
<pre><c:out value="${bvo.book_mokcha}"/></pre><br>


<% int admin = 0;
	if (admin == 1){ %>
	<button type = "button" onclick = "history.go(-1)">목록</button>
<% } else if (admin == 0) { %>
	<!-- 관리자 로그인시 보여야할 버튼 -->
	<button type = "button" onclick = "history.go(-1)">목록</button>
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
		<button type = "submit" onclick="return confirm('삭제하시겠습니까?')">삭제</button>
	</form>
<% } %>
<!-- ----------------------------------------------------------------------  -->

</body>
</html>