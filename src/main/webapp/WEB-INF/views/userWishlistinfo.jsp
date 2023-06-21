<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>위시리스트</title>

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
    <script src="js/login.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="userSidebar.jsp" %>
	<!-- Shoping Cart Section Begin -->
	<!-- <section class="shoping-cart spad">
	    <div class="container">
	        <div class="row"> -->
	            <div class="col-lg-10 col-md-11">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr class="">
                                    <th><p>상품사진</p></th>
                                    <th><p>상품명</p></th>
                                    <th><p>가격</p></th>
                                    <th><p>상품정보</p></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${USERWISHLIST}" var="dto">
	                                <input type="hidden" name="userid" value="${sessionScope.ID}">
                                    <input type="hidden" name="pcode" value="${dto.pcode}">
                                    <input type="hidden" name="photo">
                                    <input type="hidden" name="name" value="${dto.name}">
                                    <input type="hidden" name="price" value="${dto.price}">
                                    <tr>
                                        <td><a href="productInformSend?pcode=${dto.pcode}"><img src="${dto.photo}" alt="Product" width="50%"></a></td>
                                        <td>${dto.name}</td>
                                        <td>${dto.price}&#8361;</td>
                                        <td>
                                        <a href="productInformSend?pcode=${dto.pcode}" class="btn btn-primary btn-user btn-block">제품<br/>페이지</a>
                                        </td>
                                        <td class="shoping__cart__item__close">
                                           	<span class="icon_close" onclick="wishdeleteFn(${dto.pcode})"></span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
	            </div>
	        </div>
		</div>
	</section>
	
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