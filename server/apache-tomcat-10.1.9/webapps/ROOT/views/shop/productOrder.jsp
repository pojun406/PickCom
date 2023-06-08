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
        #product > .order > form {
        }

        #product > .order > form > table {
            width: 100%;
            border-top: 2px solid #000;
            border-collapse: collapse;
            border-spacing: 0;
        }

        #product > .order > form > table tr {
            border-bottom: 1px solid #d3d3d3;
        }

        #product > .order > form > table th {
            padding: 12px 0;
            background: #fff;
            color: #383838;
            font-size: 0.95em;
            text-align: center;
            letter-spacing: -0.1em;
        }

        #product > .order > form > table .empty {
            display: none;
        }

        #product > .order > form > table td {
            text-align: center;
        }

        #product > .order > form > table td:last-child {
            color: #ff006c;
            font-weight: bold;
        }

        #product > .order > form > table tr > td > input {
        }

        #product > .order > form > table td > article {
            padding: 6px;
            overflow: hidden;
        }

        #product > .order > form > table td > article > a {
            float: left;
            display: inline-block;
        }

        #product > .order > form > table td > article > a > img {
            width: 80px;
        }

        #product > .order > form > table td > article > div {
            float: left;
            margin-left: 10px;
        }

        #product > .order > form > table td > article > div > h2 {
            text-align: left;
        }

        #product > .order > form > table td > article > div > p {
            text-align: left;
            color: #777;
            margin-top: 4px;
        }

        #product > .order > form > article {
            width: 560px;
            height: auto;
            margin-top: 16px;
        }

        #product > .order > form > .delivery {
        }

        #product > .order > form > .final {
            float: right;
            width: 360px;
            height: 412px;
            padding: 20px;
            margin-top: 12px;
            background: #fff;
            border: 1px solid #d3d3d3;
            box-sizing: border-box;
        }

        #product > .order > form > .final > h2 {
            width: 100%;
            font-weight: bold;
            font-size: 16px;
            border-bottom: 1px solid #111;
            margin-bottom: 10px;
            padding-bottom: 10px;
            box-sizing: border-box;
            color: #1e1e1e;
        }

        #product > .order > form > .final > table {
            width: 100%;
        }

        #product > .order > form > .final > table tr:nth-last-child(1) td {
            font-size: 20px;
        }

        #product > .order > form > .final > table tr:nth-last-child(1) td:last-child {
            color: #ff006c;
            font-size: 20px;
            font-weight: bold;
        }

        #product > .order > form > .final > table td {
            padding: 10px 0;
            font-size: 14px;
            color: #555;
        }

        #product > .order > form > .final > table td:last-child {
            text-align: right;
        }

        #product > .order > form > .final > input[type=submit] {
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

        #product > .order > form > article > h1 {
            font-weight: bold;
            font-size: 14px;
            padding: 6px 0;
            margin-bottom: 12px;
            border-bottom: 1px solid #111;
        }

        #product > .order > form > article > div {
            padding: 6px;
            box-sizing: border-box;
        }

        #product > .order > form > .delivery > table {
            margin-top: 10px;
        }

        #product > .order > form > .delivery > table tr > td:nth-child(1) {
            padding: 6px;
        }

        #product > .order > form > .delivery > table input[type=button] {
            padding: 4px 6px;
            border: 1px solid #ccc;
            background-color: #f0f4f9;
            border-color: #acc0e0;
            color: #3371c9;
            outline: none;
        }

        #product > .order > form input {
            color: #555;
            padding: 2px 0;
            border: 1px solid #999;
            box-sizing: border-box;
        }

        #product > .order > form > .delivery > table input[name=addr1] {
            width: 400px;
        }

        #product > .order > form > .delivery > table input[name=addr2] {
            width: 400px;
        }

        #product > .order > form > .discount > div {
            overflow: hidden;
        }

        #product > .order > form > .discount > div > p {
            float: left;
        }

        #product > .order > form > .discount > div > label {
            float: right;
        }

        #product > .order > form > .discount > div > label > input[type=text] {
            display: inline-block;
            outline: none;
        }

        #product > .order > form > .discount > div > span {
            display: block;
            margin-top: 20px;
            color: #888;
        }

        #product > .order > form > .discount > div > label > input[type=button] {
            padding: 4px 6px;
            border: 1px solid #ccc;
            background-color: #f0f4f9;
            border-color: #acc0e0;
            color: #3371c9;
            outline: none;
        }

        #product > .order > form > .payment > div {
            margin-bottom: 10px;
        }

        #product > .order > form > .payment > div > span {
            display: inline-block;
            color: #3a85c8;
            margin: 6px 0;
        }

        #product > .order > form > .payment > div label {
            margin-right: 16px;
        }

        #product > .order > form > .payment > div input {
            vertical-align: bottom;
            margin-right: 4px;
        }

        #product > .order > form > .alert {
            width: 560px;
            background-color: #f7f7f7;
            padding: 6px;
            padding-left: 20px;
            color: #999;
            box-sizing: border-box;
        }

        #product > .order > form > .alert > ul {
            list-style: inherit;
        }

        #product > .order > form > .alert > ul > li {
            line-height: 20px;
        }

        #product > .order > form > .alert > ul > li > span {
            position: relative;
            left: -6px;
        }
    </style>
</head>
<body onload="fn_allPrice()">
<div id="wrapper">
    <main id="product">
        <section class="order">
            <nav>
                <h1>주문결제</h1>
                <p>
                    HOME >
                    <span>장바구니</span>
                    >
                    <strong>주문결제</strong>
                </p>
            </nav>

            <!-- tables -->
            <form id="commonForm" name="commonForm"></form>
            <form name="orderWrite" id="orderWrite" method="post" action="/../shop/orderPay.do">
                <table border="0">
                    <tr>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>상품가</th>
                        <th>할인가</th>
                        <th>판매가</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                    <c:choose>
                        <c:when test="${fn:length(list) > 0}">
                            <c:forEach var="item" items="${list}" varStatus="status">
                                <input type="hidden" name="product_num" value="${item.PRODUCT_NUM}">
                                <input type="hidden" name="product_discount" value="${item.DISCOUNT_AMOUNT}">
                                <tr>
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
                                    <td><input type="text" name=product_amount" value="${item.cart_quantity}" style="border:none;">
                                    </td>
                                    <td><input type="text" name=product_origianl_price" value="${item.PRODUCT_ORIGINALPRICE}" style="border:none;">
                                    </td>
                                    <td><input type="text" name=product_discount" value="${item.DISCOUNT_AMOUNT}" style="border:none;">
                                    </td>
                                    <td><input type="text" name="product_sale_price" value="${item.PRODUCT_SALEPRICE}"
                                               style="border:none;"></td>
                                    <td><input type="text" name="product_fee" value="${item.PRODUCT_SHIPPINGFEE}"
                                               style="border:none;"></td>
                                    <td><input type="text" name="product_amount_price"
                                               value="${item.CART_QUANTITY * item.PRODUCT_SALEPRICE}"
                                               style="border:none;"></td>
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
                <div class="final">
                    <h2>최종결제 정보</h2>
                    <c:choose>
                        <c:when test="${fn:length(list) > 0}">
                            <table>
                                <tr>
                                    <td>총계</td>
                                    <td><input type="text" name="order_all_amount" id="order_all_amount" value="" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>상품금액</td>
                                    <td><input type="text" name="order_price" id="order_price" value="" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>할인금액</td>
                                    <td><input type="text" name="order_discount" id="order_discount" value="" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td><input type="text" name="order_fee" id="order_fee" value="" style="border:none;"></td>
                                </tr>
                                <tr>
                                    <td>전체주문금액</td>
                                    <td><input type="text" name="order_all_price" id="order_all_price" value="" style="border:none;"></td>
                                </tr>
                            </table>
                            <input type="submit" value="결제하기">
                        </c:when>
                    </c:choose>
                </div>
                <!-- 배송정보 -->
                <article class="delivery">
                    <h1>배송정보</h1>
                    <table>
                        <tr>
                            <td>주문자</td>
                            <td><input type="text" name="orderer"></td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td>
                                <input type="text" name="hp">
                                <span>- 포함 입력</span>
                            </td>
                        </tr>
                        <tr>
                            <td>기본주소</td>
                            <td>
                                <input type="text" name="addr1">
                            </td>
                        </tr>
                        <tr>
                            <td>상세주소</td>
                            <td><input type="text" name="addr2"></td>
                        </tr>
                    </table>
                </article>
                <%--<!-- 할인정보 -->
                <article class="discount">
                    <h1>할인정보</h1>
                    <div>
                        <p>
                            현재 포인트 :
                            <span>7200</span>점
                        </p>

                        <label>
                            <input type="text" name="point">점
                            <input type="button" value="적용">
                        </label>
                        <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
                    </div>
                </article>--%>
                <!-- 결제방법 -->
                <article class="payment">
                    <h1>결제방법</h1>
                    <div>
                        <span>신용카드</span>
                        <p>
                            <label>
                                <input type="radio" name="payment" value="type1">신용카드 결제
                            </label>
                            <label>
                                <input type="radio" name="payment" value="type2">체크카드 결제
                            </label>
                        </p>
                    </div>
                    <div>
                        <span>계좌이체</span>
                        <p>
                            <label>
                                <input type="radio" name="payment" value="type3">실시간 계좌이체
                            </label>
                            <label>
                                <input type="radio" name="payment" value="type4">무통장 입금
                            </label>
                        </p>
                    </div>
                    <div>
                        <span>기타</span>
                        <p>
                            <label>
                                <input type="radio" name="payment" value="type4">휴대폰 결제
                            </label>
                            <label>
                                <input type="radio" name="payment" value="type5">카카오페이
                                <img src="../../img/ico_kakaopay.gif" alt="카카오페이">
                            </label>
                        </p>
                    </div>
                </article>
                <!-- 경고 -->
                <article class="alert">
                    <ul>
                        <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.
                            </span></li>
                        <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.
                            </span></li>
                        <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.
                            </span></li>
                    </ul>
                </article>
            </form>
        </section>
    </main>
    <button type="button" id="top">상단이동</button>
</div>
</body>
</html>

<script type="text/javascript">

    //기본 주문금액 계산
    function fn_allPrice() {

        var arrayAmount = document.getElementsByName("product_amount"); // 장바구니 수량
        var arrayOrigianl = document.getElementsByName("product_original_price"); // 상품가격
        var arrayDiscount = document.getElementsByName("product_discount_amount"); // 할인가
        var arrayAllPrice = document.getElementsByName("product_amount_price"); // 주문 가격
        var arrayFee = document.getElementsByName("product_fee"); // 배송비
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
        document.getElementById("order_all_amount").value = amount;
        document.getElementById("order_price").value = original;
        document.getElementById("order_discount").value = discount;
        document.getElementById("order_fee").value = fee;
        document.getElementById("order_all_price").value = allPrice;

        /*var array7 = document.getElementsByName("member_grade");
        var grade = array7[0].value;
        var val = 0;
        if ("NOMAL" == grade) {
            val = 0.03;
        } else if ("GOLD" == grade) {
            val = 0.05;
        } else {
            val = 0.1;
        }
        var point = Number(hap) * Number(val); //등급별 적립율
        document.getElementById("ORDER_SAVE_POINT").value = point; //할인과 상관없이 주문금액별 적립*/
    }

    //주문자정보와 동일
    function fn_chkinfo() {
        var chk = document.getElementById("chkinfo").checked;
        if (chk == true) {
            document.getElementById("ORDER_NAME").value = "${map.MEMBER_NAME}";
            document.getElementById("ORDER_PHONE").value = "${map.MEMBER_PHONE}";
            document.getElementById("ORDER_ZIPCODE").value = "${map.MEMBER_ZIPCODE}";
            document.getElementById("ORDER_ADDR1").value = "${map.MEMBER_ADDR1}";
            document.getElementById("ORDER_ADDR2").value = "${map.MEMBER_ADDR2}";
        } else if (chk == false) {
            document.getElementById("ORDER_NAME").value = "";
            document.getElementById("ORDER_PHONE").value = "";
            document.getElementById("ORDER_ZIPCODE").value = "";
            document.getElementById("ORDER_ADDR1").value = "";
            document.getElementById("ORDER_ADDR2").value = "";
        }
    }

    /*//쿠폰, 포인트 사용
    function fn_price() {
        var f = document.orderWrite;
        var hap_buy = Number(f.ORDER_TOTAL_ORDER_PRICE.value);  //총 주문금액
        var u_p = ${map.POINT_TOTAL}; //보유포인트
        var o_point = Number(f.ORDER_USE_POINT.value); //사용할포인트
        var a = f.COUPON_VALUE.value; // 할인쿠폰 값

        var sum_point = u_p - o_point;  // 남은 포인트(보유포인트-사용할포인트)
        var hap_discount = hap_buy * (a / 100); // 쿠폰할인값
        var cp_buy = (hap_buy - hap_discount); // 쿠폰할인만 한 가격
        var sum_buy = (hap_buy - hap_discount) - o_point; // 주문금액-쿠폰할인-포인트사용(최종결제금액)

        var array = document.getElementsByName("ORDER_DETAIL_PRICE");
        var array2 = document.getElementsByName("COUPON_DISCOUNT");
        var array3 = document.getElementsByName("ORDER_DISCOUNT_APPLY");
        var len = array.length;
        for (var i = 0; i < len; i++) {
            var COUPON_DISCOUNT = array[i].value * (a / 100);
            array2[i].value = COUPON_DISCOUNT;
            array3[i].value = Number(array[i].value) - Number(array2[i].value);
        }
        if (u_p < o_point) {
            alert("사용가능 마일리지를 확인해주세요!");
            return false;
        }
        if (o_point > cp_buy) {
            alert("결제금액 보다 큽니다!");
            location.reload(true);
            return false;
        }
        f.discount.value = hap_discount + o_point; //총 할일된 금액
        f.pay_price1.value = sum_buy + 3000; //배송비를 포함한 결제금액
        f.ORDER_TOTAL_PAY_PRICE.value = sum_buy + 3000;
        f.POINT_TOTAL.value = sum_point; //사용하고 남은 보유 포인트금액
        //선택된 쿠폰 인덱스
        var index = ($("#COUPON_VALUE option").index("#COUPON_VALUE option:selected")) * (-1) - 1;
        var array9 = document.getElementsByName("COUPON_STATUS_NO");
        var array11 = document.getElementsByName("COUPON_NO");
        f.COUPON_STATUS_NO_1.value = array9[index].value;
        f.COUPON_NO_1.value = array11[index].value;
    }*/

    //주문완료
    function fn_order_pay() {

        var f = document.orderWrite;

        if (f.ORDER_NAME.value == "") {
            alert("주문자 이름을 입력해주세요.");
            f.ORDER_NAME.focus();
            return false;
        }
        if (f.ORDER_PHONE.value == "") {
            alert("전화번호를 입력해주세요.");
            f.ORDER_PHONE.focus(); //커서자동클릭
            return false;
        }
        if (f.ORDER_ZIPCODE.value == "" || f.ORDER_ADDR1.value == "" || f.ORDER_ADDR2.value == "") {
            alert("주소를 정확히 입력해주세요.");
            return false;
        }
        if (document.getElementById("OPTION1").checked == false && document.getElementById("OPTION2").checked == false) {
            alert("결제방법을 선택해주세요.");
            return false;
        }

        f.submit();
    }

    //주소 찾기
    function findAddr() {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== ''
                    && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== ''
                    && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', '
                        + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraRoadAddr !== '') {
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('ORDER_ZIPCODE').value = data.zonecode;
                document.getElementById("ORDER_ADDR1").value = roadAddr
                    + data.jibunAddress;
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if (roadAddr !== '') {
                    document.getElementById("ORDER_ADDR2").value = extraRoadAddr;
                } else {
                    document.getElementById("ORDER_ADDR2").value = '';
                }
            }
        }).open();
    }

</script>