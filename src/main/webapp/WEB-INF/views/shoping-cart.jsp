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

<body>
    <%@ include file="header.jsp"%>

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                
                    <form id="deleteForm" action="cartdelete" method="post">
                        <div class="shoping__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>상품사진</th>
                                        <th>상품명</th>
                                        <th>수량</th>
                                        <th>가격</th>
                                        <th>총가격</th>
                                    </tr>
                                </thead>
                                <tbody>
                                        <c:forEach var="dto" items="${cart}">
                                            <input type="hidden" name="userid" value="${dto.userid}">
                                            <input type="hidden" name="seq" value="${dto.seq}">
                                            <input type="hidden" name="pcode" value="${dto.pcode}">
                                            <input type="hidden" id="count" name="count" value="${dto.count}">
                                            <tr>
                                                <td class="center-align" style="text-align: center;">
                                                    <input type="checkbox" name="pcode" value="${dto.pcode}" data-count="${dto.count}" data-price="${dto.price}" data-seq="${dto.seq}" onchange="calculateTotalPrice()">
                                                </td>
                                                <td><input type="hidden" name="photo"><img src="${dto.photo}" alt="Product"></td>
                                                <td><input type="hidden" name="name" value="${dto.name}">${dto.name}</td>
                                                <td><input type="hidden" name="count" value="${dto.count}">${dto.count}</td>
                                                <td><input type="hidden" name="price" value="${dto.price}">₩${dto.price}</td>
                                                <td><input type="hidden" name="totalPrice" value="${dto.count * dto.price}"><span class="itemTotalPrice">₩${dto.count * dto.price}</span></td>
                                                <td class="shoping__cart__item__close"> 
                                                    <span class="icon_close" onclick="cartdelete(${dto.seq})"></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                              
                                </tbody>
                            </table>
                        </div>
                    </form> 
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="#" class="primary-btn cart-btn cart-btn-right" onclick="window.location.href='main.do'">메인페이지</a>
                    </div>
                    <div class="shoping__checkout">
                        <h5>총 상품가격</h5>
                        <ul>
                            <li>합계 <span id="totalPriceDisplay">₩0</span></li>
                        </ul>    
                        <a href="#" class="primary-btn" onclick="submitForm('orders'); return false;">결제페이지로</a>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <script>
    function calculateTotalPrice() {
    	  var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    	  var totalPrice = 0;

    	  checkboxes.forEach(function (checkbox) {
    	    var count = parseInt(checkbox.dataset.count, 10);
    	    var price = parseFloat(checkbox.dataset.price);
    	    var itemTotalPrice = count * price;

    	    var row = checkbox.parentNode.parentNode;
    	    var totalCell = row.querySelector('.itemTotalPrice');
    	    totalCell.textContent =  '₩' + itemTotalPrice.toLocaleString('en-US',{ useGrouping: false });

    	    totalPrice += itemTotalPrice;
    	  });

    	  var totalPriceDisplay = document.getElementById('totalPriceDisplay');
    	  totalPriceDisplay.innerHTML =  '₩' + totalPrice.toLocaleString('en-US',{ useGrouping: false });
    	}



    function cartdelete(seq) {
        if (confirm("해당 상품을 장바구니에서 삭제하시겠습니까?")) {
            var deleteForm = document.getElementById('deleteForm');
            deleteForm.action = 'cartdelete?seq=' + seq;
            deleteForm.submit();
        }
    }

    function submitForm(action) {
        var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
        var data = [];

        checkboxes.forEach(function(checkbox) {
            var pcode = checkbox.value;
            var count = checkbox.dataset.count;
            var price = checkbox.dataset.price;
            var seq = checkbox.dataset.seq;
            var item = {
                pcode: pcode,
                count: count,
                price: price,
                seq: seq
            };

            data.push(item);
        });

        var queryString = '';
        data.forEach(function(item, index) {
            var prefix = (index === 0) ? '?' : '&';
            queryString += prefix + 'pcode=' + encodeURIComponent(item.pcode);
            queryString += '&count=' + encodeURIComponent(item.count);
            queryString += '&price=' + encodeURIComponent(item.price);
            queryString += '&seq=' + encodeURIComponent(item.seq);
        });

        window.location.href = action + queryString;
    }

    calculateTotalPrice();
    </script>

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
