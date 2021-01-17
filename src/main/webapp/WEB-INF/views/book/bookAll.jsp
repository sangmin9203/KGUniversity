<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value ="${pageContext.request.contextPath}"/>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 판매 목록</title>
</head>
<body>
	<c:forEach items = "${supPaging}" var = "List" >
		<img src ="<spring:url value='/resources/img/${List.book_picture}'/>"><br>
		<a href="${path}/book/getBookInfo.do${pageMaker.makeQuery(pageMaker.supPaging.page)}&book_name=${List.book_name}">${List.book_name}</a><br>
		${List.book_writer}<br>		
		${List.book_price}<br>
	</c:forEach>
	
	<br><br>
	
	<c:if test="${pageMaker.prev}">
		<li><a href="${path}/book/bookAll.do?page=${pageMaker.startPage-1}">이전</a></li>
     </c:if>
	 <c:forEach begin="${pageMaker.startPage}" end ="${pageMaker.endPage}" var ="idx">
		<li <c:out value ="${pageMaker.supPaging.page == idx ? '' : ''}"/>>
		<a href="${path}/book/bookAll.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.next && pageMaker.endPage >0}">
		<li><a href ="${path}/book/bookAll.do?page=${pageMaker.endPage+1}">다음</a></li>
	</c:if>
</body>
</html>
 