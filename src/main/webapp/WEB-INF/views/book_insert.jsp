<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = container>
	<form action ="bookInsertForm.do" method = "post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>책 사진첨부</td>
				<td><input type = "file" name = "book_file"></td>
			</tr>		
			<tr>
				<td>책 제목</td>
				<td><input type = "text" name = "book_name" ></td>
			</tr>		
			<tr>
				<td>저자</td>
				<td><input type = "text" name = "book_writer"></td>
			</tr>		
			<tr>
				<td>가격</td>
				<td><input type = "text" name = "book_price"></td>
			</tr>		
			<tr>
				<td>책 소개</td>
				<td><textarea name = "book_info"></textarea></td>
			</tr>		
			<tr>
				<td>목차</td>
				<td><textarea name = "book_mokcha"></textarea></td>
			</tr>		
			<tr>
				<td>책 재고</td>
				<td><input type = "text" name = "book_inventory" ></td>
			</tr>		
		</table>
		<input type="submit" value = "등록" onclick="return confirm('등록하시겠습니까?')">
		<input type = "reset" value = "취소">
	</form>
</div>
</body>
</html>