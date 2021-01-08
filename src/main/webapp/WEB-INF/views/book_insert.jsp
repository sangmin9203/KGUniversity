<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta  name="viewport" content="width-device-width" initial-scale="1">
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<script src="./js/jquery-3.1.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>책 등록 페이지</title>
</head>
<body>

	<div class = container style="margin : auto; width:700px; align : center">
		<form action ="bookInsertForm.do" method = "post" enctype="multipart/form-data">
			<div class="form-group">
  				<label for="picture1">책 사진 첨부</label>
   					<input type="file" class="form-control" id="picture1" name="book_file">
 	</div>
 	<div class="form-group">
            <label for="name1">책 제목:</label>
                 <input type="text" class="form-control" id="name1" name="book_name">
              </div>
	<div class="form-group">
    	<label for="writer">저자:</label>
        	<input type="text" class="form-control" id="writer1" name="book_writer">
    </div>             
	<div class="form-group">
    	<label for="price1">가격:</label>
        	<input type="text" class="form-control" id="price1" name="book_price ">
    </div>       
    <div class="form-group">
		<label for="info1">책 소개:</label><br><br>
			<textarea rows="5" cols="50" id="info1" name=book_info></textarea>
	</div> 
	<div class="form-group">
		<label for="mokcha1">목차:</label><br><br>
			<textarea rows="5" cols="50" id="mok1" name=book_mokcha></textarea>
	</div>  
	<div class="form-group"  style = "width : 50px">
		<label for="inventory1">재고:</label><br><br>
			<input type="text" class="form-control" id="inventory1" name="book_inventory">
	</div>  
   
	
	<input style = "margin:8px" class="btn btn-success" type = "submit" value = "등록" onclick="return confirm('등록하시겠습니까?')">
	<input style = "margin:8px" class="btn btn-warning" type = "reset" value = "취소">
	</form>
</div>
</body>
</html>