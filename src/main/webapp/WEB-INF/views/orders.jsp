<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>하루를 신선하게</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    

    
</head>
<%
	String result = (String)request.getAttribute("list");
%>
<script>
function checkResult(event) {
    var sendResult = '<%=result %>';
    
    if (sendResult === 'false'){
    	alert("주문에 실패했습니다.");
    	event.preventDefault(); 
    }else {
    	alert("주문이 완료되었습니다.");
    }
}
</script>

<body>   
    <%@ include file="header.jsp"%>

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Orders</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Orders</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
  <div class="container">
    <% String login = (String) session.getAttribute("ID"); %>
    <div class="row">
        <div class="col-lg-12">
        
            <form id="checkoutForm" action="insertorders.do" method="post" onsubmit="submitForm()">
                <input type="hidden" name="userid" value="<%= login %>">
             
                      <div class="text-center">
                        <h4>주문 정보</h4>
                  	  </div>
                    
                <div class="row"> 
                <table>
                
                    <tr>
                        <td colspan="3">
                            <div class="product-info">
                                <p>수령인 : ${uInfo.name}</p>
                                <p>수령인 전화번호 : ${uInfo.telno}</p>
                             	<p>배송지 : <input type="text" name="address" value="${uInfo.address}"></p>
                                <p>이메일 : ${uInfo.email}</p>
                            </div>
                        </td>
                    </tr>
                </table>
                </div>
                
                <div class="shoping__cart__table">
                <table class="table1">
                    <thead>
                        <tr>
                            <th>상품사진</th>
                            <th>상품명</th>
                            <th></th>
                            <th>수량</th>
                            <th>가격</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                    
                        <c:set var="totalPrice" value="0" />
                        <c:forEach items="${cartOrders}" var="dto" varStatus="status">
                            <tr>
                                <td><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                                <td><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
                                <td><input type="hidden" name="pcode" value="${dto.pcode}"></td>
                                <td><input type="hidden" name="count" value="${dto.count}">${dto.count}</td>
                                <td>${dto.count * dto.price}&#8361;</td>
                            </tr>
                            <c:set var="totalPrice" value="${totalPrice + (dto.count * dto.price)}" />
                        </c:forEach>
                    </tbody>
                </table>
              </div>
                <input type="hidden" name="pcodeList" value="[]">
				<input type="hidden" name="countList" value="[]">
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="shoping__cart__btns">
                <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='main.do'">메인페이지</a>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="shoping__checkout">
                <h5>상품가격</h5>
                <ul>
                    <li>총주문가격 : <fmt:formatNumber value="${totalPrice}" type="number" pattern="#,##0" />원</li>
                </ul>
                <a href="#" class="primary-btn" onclick="submitForm(); checkResult(event)">결제하기</a>
            </div>
        </div>
    </div>
   </div>
</section>

<script>
    function submitForm() {
        var form = document.getElementById('checkoutForm');
        var userid = '<%= login %>';
        var address = document.querySelector('input[name="address"]').value;
        
        // 정보를 폼에 추가합니다.
        form.elements['userid'].value = userid;
        form.elements['address'].value = address;
        
        // pcode와 count 정보를 가져와서 배열로 저장합니다.
        var pcodes = document.getElementsByName('pcode');
        var counts = document.getElementsByName('count');
        var pcodeList = [];
        var countList = [];
        
        for (var i = 0; i < pcodes.length; i++) {
            pcodeList.push(pcodes[i].value);
            countList.push(counts[i].value);
        }
        
        // userid와 address를 pcode와 count 개수에 맞게 복제합니다.
        var useridList = Array(pcodes.length).fill(userid);
        var addressList = Array(pcodes.length).fill(address);
        
        // 배열을 폼에 추가합니다.
        form.elements['userid'].value = useridList.join(',');
        form.elements['address'].value = addressList.join(',');
        form.elements['pcodeList'].value = pcodeList.join(',');
        form.elements['countList'].value = countList.join(',');
        
        form.submit();
    }
</script>




    <!-- Shoping Cart Section End -->


    <!-- Footer Section Begin -->
    
  	<%@ include file="footer.jsp"%>
   
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>


</body>

</html>