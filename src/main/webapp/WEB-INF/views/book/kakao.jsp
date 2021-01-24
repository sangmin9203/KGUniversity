<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path" value ="${pageContext.request.contextPath}"/>
<%-- <%@ page session="false" %> --%> 
<%
	String user_id = (String) request.getParameter("user_id");
	int book_num = (int) Integer.parseInt(request.getParameter("book_num"));
	String book_picture = (String) request.getParameter("book_picture");
	String book_name = (String) request.getParameter("book_name");
	int book_inventory = (int) Integer.parseInt(request.getParameter("book_inventory"));
	int purchase_amount = (int) Integer.parseInt(request.getParameter("purchase_amount"));
	int book_price = (int) Integer.parseInt(request.getParameter("book_price"));
	int total_price = book_price*purchase_amount;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세내용</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
 	<script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp99338921'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakao',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '${book_name}',
            amount : <%=total_price%>,
            buyer_email : 'aaa@gmail.com',
            buyer_name : '${user_id}',
            buyer_tel : '010-1234-5678',
            buyer_addr : '강남구 세곡동',
            buyer_postcode : '123-456',
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
                location.href="<%=request.getContextPath()%>/book/purchase.do?user_id=<%=user_id%>&book_num=<%=book_num%>&book_picture=<%=book_picture%>&book_name=<%=book_name%>&book_inventory=<%=book_inventory%>&purchase_amount=<%=purchase_amount%>";
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/book/bookAll.do";
                alert(msg);
            }
        });
        
    });
    </script>
    
    <%-- <%=user_id%> : ${user_id}<br>
    <%=book_num%> : ${book_num} <br>
    <%=book_picture%> : ${book_picture}<br>
    <%=book_name%> : ${book_name}<br>
    <%=book_inventory%> : ${book_inventory}<br>
    <%=purchase_amount%> : ${purchase_amount}<br> --%>
    
</body>
</html>