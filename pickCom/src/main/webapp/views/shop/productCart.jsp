<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../tiles/default_layout.jsp" %>
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
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/product.css">
    <style>
        #product > .cart > form {
        }

        #product > .cart > form > table {
            width: 100%;
            border-bottom: 1px solid #d3d3d3;
            border-collapse: collapse;
            border-spacing: 0;
        }

        #product > .cart > form > table tr {
            border-bottom: 1px solid #d3d3d3;
        }

        #product > .cart > form > table th:first-child {
            width: 60px;
        }

        #product > .cart > form > table th {
            padding: 12px 0;
            border-top: 2px solid #000;
            border-bottom: 1px solid #d3d3d3;
            background: #fff;
            color: #383838;
            font-size: 0.95em;
            text-align: center;
            letter-spacing: -0.1em;
        }

        #product > .cart > form > table .empty {
            display: none;
        }

        #product > .cart > form > table td {
            text-align: center;
        }

        #product > .cart > form > table td:last-child {
            color: #ff006c;
            font-weight: bold;
        }

        #product > .cart > form > table th > input {
        }


        #product > .cart > form > table tr > td > input {
        }

        #product > .cart > form > table td > article {
            padding: 6px;
            overflow: hidden;
        }

        #product > .cart > form > table td > article > a {
            float: left;
            display: inline-block;
        }

        #product > .cart > form > table td > article > a > img {
            width: 80px;
        }

        #product > .cart > form > table td > article > div {
            float: left;
            margin-left: 10px;
        }

        #product > .cart > form > table td > article > div > h2 {
            text-align: left;
        }

        #product > .cart > form > table td > article > div > p {
            text-align: left;
            color: #777;
            margin-top: 4px;
        }

        #product > .cart > form > input[name=del] {
            border-color: #bdbdbd;
            border-bottom-color: #828282;
            background: #fafafa;
            color: #4d4d4d;
            padding: 6px 11px;
            border-width: 1px;
            margin-top: 6px;
        }

        #product > .cart > form > .total {
            float: right;
            width: 360px;
            height: 412px;
            padding: 20px;
            margin-top: 12px;
            background: #fff;
            border: 1px solid #d3d3d3;
            box-sizing: border-box;
        }

        #product > .cart > form > .total > h2 {
            width: 100%;
            font-weight: bold;
            font-size: 16px;
            border-bottom: 1px solid #111;
            margin-bottom: 10px;
            padding-bottom: 10px;
            box-sizing: border-box;
            color: #1e1e1e;
        }

        #product > .cart > form > .total > table {
            width: 100%;
        }

        #product > .cart > form > .total > table tr:nth-last-child(1) td {
            font-size: 20px;
        }

        #product > .cart > form > .total > table tr:nth-last-child(1) td:last-child {
            color: #ff006c;
            font-size: 20px;
            font-weight: bold;
        }

        #product > .cart > form > .total > table td {
            padding: 10px 0;
            font-size: 14px;
            color: #555;
        }

        #product > .cart > form > .total > table td:last-child {
            text-align: right;
        }

        #product > .cart > form > .total > input[type=submit] {
            width: 100%;
            height: 56px;
            font-size: 26px;
            border-width: 1px;
            border-color: #d81818;
            border-bottom-color: #9e1212;
            background: #ed2f2f;
            background-image: -webkit-linear-gradient(#ed2f2f, #dd0e0e);
            color: #fff;
            box-sizing: border-box;
            margin-top: 10px;
        }
    </style>
</head>
<body onload="fn_allPrice()"><!-- 주문페이지 로딩시 주문금액,포인트 등 계산 -->
<div id="wrapper">
    <main id="product">
        <section class="cart">
            <nav>
                <h1>장바구니</h1>
                <p>
                    HOME >
                    <span>컴퓨터·브랜드PC·조립PC</span>
                    >
                    <strong>장바구니</strong>
                </p>
            </nav>
            <form action="#">
                <form name="basket" method="post" action="/../shop/cartAllOrderWrite.do">
                    <input type="hidden" name="list" value="${list}">
                </form>

                <table border="0">
                    <tr>
                        <th><input type="checkbox" name="allchk" id="allchk" onclick="fn_allchk()"></th>
                        <th>상품명</th>
                        <th>총수량</th>
                        <th>상품가</th>
                        <th>할인</th>
                        <th>판매가</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                    <c:choose>
                        <c:when test="${fn:length(list) > 0}">
                            <c:forEach var="item" items="${list}" varStatus="status">
                                <tr>
                                    <td><input type="checkbox" name="chk" id="chk"></td>
                                    <td>
                                        <article>
                                            <a href="#">
                                                <img src="${item.PRODUCT_IMG}" alt="1">
                                            </a>
                                            <div>
                                                <h2><a href="#">${item.PRODUCT_NAME}</a></h2>
                                                <p>${item.PRODUCT_DESCRIPTION}</p>
                                            </div>
                                        </article>
                                    </td>
                                    <td><input type="text" name="cart_product_amount" value="${item.CART_QUANTITY}" style="border:none;"></td>
                                    <td><input type="text" name="product_original_price" value="${item.PRODUCT_ORIGINALPRICE}" style="border:none;"></td>
                                    <td><input type="text" name="product_discount_amount" value="${item.DISCOUNT_AMOUNT}" style="border:none;"></td>
                                    <td><input type="text" name="product_sale_price" value="${item.PRODUCT_SALEPRICE}" style="border:none;"></td>
                                    <td><input type="text" name="order_fee" value="${item.PRODUCT_SHIPPINGFEE}" style="border:none;"></td>
                                    <td><input type="text" name="product_price" value="${item.CART_QUANTITY * item.PRODUCT_SALEPRICE}" style="border:none;"></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr class="empty">
                                <td colspan="7">장바구니에 상품이 없습니다.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </table>
                <input type="button" name="cart_delete" value="선택삭제" onclick="fn_delete(${status.index})">
                <div class="total">
                    <h2>전체합계</h2>
                    <c:choose>
                        <c:when test="${fn:length(list) > 0}">
                            <table>
                                <tr>
                                    <td>상품수</td>
                                    <td><input type="text" id="all_order_amount" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>상품금액</td>
                                    <td><input type="text" id="all_price" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>할인금액</td>
                                    <td><input type="text" id="discount_amount" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td><input type="text" id="all_order_fee" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>전체주문금액</td>
                                    <td><input type="text" id="all_order_price" style="border:none;"></td>
                                </tr>
                            </table>
                            <input type="submit" value="주문하기">
                        </c:when>
                    </c:choose>
                </div>
            </form>
        </section>
    </main>
    <button type="button" id="top">상단이동</button>
</div>
</body>
</html>

<script type="text/javascript">
    //상품선택
    function fn_allchk() {

        var chk = document.getElementById("allchk").checked; //값: true,false
        var arraychk = document.getElementsByName("chk"); //cart_no
        var len = arraychk.length;
        for (var i = 0; i < len; i++) {
            arraychk[i].checked = chk; //chk가 true면 arraychk도 true
        }
    }

    function fn_amount(index) { //장바구니 상품수량 변경
        var array8 = document.getElementsByName("product_att_amount"); //재고수량
        var array1 = document.getElementsByName("cart_product_amount"); //수량
        var array4 = document.getElementsByName("chk");

        var att = Number(array8[index].value);
        var amount = Number(array1[index].value);
        var cart_no = array4[index].value;
        var result = (amount <= att);

        if (amount = !null && amount > 0) {
            if (result == true) {
                var comSubmit = new ComSubmit();
                comSubmit.setUrl("<c:url value='/cart/cartModify.do' />");
                comSubmit.addParam("CART_PRODUCT_AMOUNT", array1[index].value);
                comSubmit.addParam("CART_NO", cart_no);
                comSubmit.submit();
            } else {
                alert("재고가 부족합니다.");
                return false;
            }
        } else {
            alert("유효한 숫자가 아닙니다.");
            return false;
        }
    }

    //상품 삭제
    function fn_delete(index) {
        var array4 = document.getElementsByName("chk");
        var cart_no = array4[index].value;

        if (confirm("삭제하시겠습니까?")) {
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/cart/cartDelete.do' />");
            comSubmit.addParam("CART_NO", cart_no);
            comSubmit.submit();
        }
        return false;
    }

    //전체삭제
    function fn_allDelete() {
        var array9 = document.getElementsByName("member_no");
        var member_no = array9[0].value;

        if (confirm("삭제하시겠습니까?")) {
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/cart/cartAllDelete.do' />");
            comSubmit.addParam("MEMBER_NO", member_no);
            comSubmit.submit();
        }
        return false;
    }

    function fn_allPrice() { //전체주문금액구하기
        var arrayAmount = document.getElementsByName("cart_product_amount"); // 장바구니 수량
        var arrayOrigianl = document.getElementsByName("cart_original_price"); // 상품가격
        var arrayDiscount = document.getElementsByName("product_discount_amount"); // 할인가
        var arrayAllPrice = document.getElementsByName("order_price"); // 주문 가격
        var arrayFee = document.getElementsByName("order_fee"); // 배송비
        var len = array2.length;
        var amount = 0;
        var original = 0;
        var discount = 0;
        var allPrice = 0;
        var fee = 0;
        for (var i = 0; i < len; i++) {
            amount += Number(arrayAmount[i].value);
            original += Number(arrayOrigianl[i].value);
            allPrice += Number(arrayAllPrice[i].value);
            fee += Number(arrayFee[i].value);
            discount += Number(arrayDiscount[i].value);
        }
        document.getElementById("all_order_amount").value = amount;
        document.getElementById("all_price").value = original;
        document.getElementById("discount_amount").value = discount;
        document.getElementById("all_order_fee").value = fee;
        document.getElementById("all_order_price").value = allPrice;

        /*var array7 = document.getElementsByName("member_grade");
        var grade = array7[0].value;
        var val = 0;
        if ("nomal" == grade) {
            val = 0.03;
        } else if ("gold" == grade) {
            val = 0.05;
        } else {
            val = 0.1;
        }
        var point = Number(hap) * Number(val); //등급별 적립율
        document.getElementById("point").value = point;*/
    }

    //선택상품 찜하기
    function fn_like() {

        if (${sessionId ne null}) {
            var arraycode = document.getElementsByName("chk");
            var len = arraycode.length;
            var val = 0;
            for (var i = 0; i < len; i++) {
                if (arraycode[i].checked == true) {
                    val++;
                    var no = document.getElementsByName("product_no");
                    var attno = document.getElementsByName("product_att_no");
                    var comSubmit = new ComSubmit();
                    comSubmit.setUrl("<c:url value='/cart/like.do' />");
                    comSubmit.addParam("PRODUCT_NO", no[i].value);
                    comSubmit.addParam("PRODUCT_ATT_NO", attno[i].value);
                    comSubmit.submit();
                }
            }
            if (val == 0) {
                alert("상품을 선택해 주세요.");
            } else {
                alert("찜하기에 넣었습니다.");
            }
        } else {
            alert("로그인 후 이용해주세요.");
            location.href = "/stu/loginForm.do";
        }


    }

    function fn_all_order() { //장바구니 전제주문
        document.cart.submit();
    }

    function fn_select_order() { //선택상품 주문
        var obj = $("[name=chk]");
        var SELECT_CART_NO = new Array(); // 배열 선언

        // 체크된 체크박스의 value 값을 가지고 온다.
        $('input:checkbox[name=chk]:checked').each(function () { // 체크된 체크박스의 value 값을 가지고 온다.
            SELECT_CART_NO.push(this.value);
        });
        if (SELECT_CART_NO[0] != null) {
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/order/cartSelectOrder.do' />");
            comSubmit.addParam("SELECT_CART_NO", SELECT_CART_NO);
            comSubmit.submit();
        } else {
            alert("구매할 상품을 선택해 주세요.");
        }
    }
</script>