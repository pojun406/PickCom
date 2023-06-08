<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>PickCom:대한민국 1등 PC 쇼핑몰</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <link rel="stylesheet" href="../css/common.css">
  <link rel="stylesheet" href="../css/product.css">
</head>
<body>
<div id="wrapper">
  <header>
    <div class="top">
      <div>
        <!-- 로그인 상태에 따라 버튼 표시 -->
        <c:choose>
          <!-- 로그인하지 않은 상태 -->
          <c:when test="${not loggedIn}">
            <a href="<c:url value="/loginForm.do"/>">로그인</a>
            <a href="">회원가입</a>
          </c:when>
          <!-- 로그인한 상태 -->
          <c:otherwise>
            <a href="<c:url value="/logout.do"/>">로그아웃</a>
            <a href="">마이페이지</a>
          </c:otherwise>
        </c:choose>
        <a href="">
          <i class="fa fa-shopping-cart" aria-hidden="true"></i>
          장바구니
        </a>
      </div>
    </div>
    <div class="logo">
      <div>
        <a href="<c:url value="/shop/bestProductList.do"/>">
          <img src="../img/header_logo.png" alt="헤더로고">
        </a>
        <form action="#">
          <input type="text" name="keyword">
          <button>
            <i class="fa fa-search" aria-hidden="true"></i>
          </button>
        </form>
      </div>
    </div>
    <div class="menu">
      <div>
        <ul>
          <li><a href="<c:url value="/shop/hitProductList.do"/>">히트상품</a></li>
          <li><a href="<c:url value="/shop/recommendedProductList.do"/>">추천상품</a></li>
          <li><a href="<c:url value="/shop/newProductList.do"/>">최신상품</a></li>
          <li><a href="<c:url value="/shop/bestProductList.do"/>">인기상품</a></li>
          <li><a href="<c:url value="/shop/saleProductList.do"/>">할인상품</a></li>
        </ul>
        <ul>
          <li><a href="#">쿠폰존</a></li>
          <li><a href="#">사용후기</a></li>
          <li><a href="#">개인결제</a></li>
          <li><a href="#">고객센터</a></li>
          <li><a href="#">FAQ</a></li>
        </ul>
      </div>
    </div>
  </header>
</div>>
</body>

</html>