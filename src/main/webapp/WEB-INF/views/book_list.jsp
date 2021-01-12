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
<form action="searchBoard.bo" method="post">
		<input type="hidden" name="boardClass" value="${boardClass}">
		<select name="category">
			<option value="글제목">글제목</option>
			<option value="글내용">글내용</option>
			<option value="작성자">작성자</option>
		</select>
        <input type="text" style = "height : 30px" name="keyword" placeholder="검색글을 입력하세요">
        <input type="submit" value="검색">
        <!-- <button type="button" name ="search">검색</button> -->
</form>
	<c:forEach var = "List" items = "${alist}">
		<img src ="<spring:url value='/resources/img/${List.book_picture}'/>"><br>
		<a href="getBookInfo.do?book_name=${List.book_name}">${List.book_name}</a><br>
		<%-- <a href="list.jsp?name=<%= URLEncoder.encode(name, "UTF-8")%>">list로 이동</a> --%>
		${List.book_price}<br>
	</c:forEach>
</body>
</html> 