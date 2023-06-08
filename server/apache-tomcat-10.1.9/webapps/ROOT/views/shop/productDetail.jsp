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
    <!--
        날짜 : 2023/04/14
        이름 : 김기한
        내용 : itemview.html
    -->
    <style>
        #product > .view > article {
            width: 100%;
            height: auto;
            overflow: hidden;
        }

        #product > .view > .info > div {
            float: left;
            width: 50%;
            height: 100%;
            padding: 10px;
            box-sizing: border-box;
        }

        #product > .view > .info > .image > img {
            width: 100%;
        }

        #product > .view > .info > .summary > nav {
            border-bottom: 1px solid #eaeaea;
            padding-bottom: 10px;
            margin-bottom: 12px;
            overflow: hidden;
        }

        #product > .view > .info > .summary > nav > h1 {
            float: left;
            color: #0231a6;
            font-weight: bold;
            font-size: 1.5em;
        }

        #product > .view > .info > .summary > nav > h2 {
            float: right;
            color: #777;
            margin-top: 8px;
        }

        #product > .view > .info > .summary > nav > h3 {
            font-size: 18px;
            font-weight: bold;
            color: #1e2732;
        }

        #product > .view > .info > .summary > nav > p {
            font-size: 14px;
            color: #474747;
            line-height: 36px;
            letter-spacing: -1px;
        }

        #product > .view > .info > .summary > nav:nth-child(2) > .rating > a {
            color: #346aff;
            text-decoration: underline;
        }

        #product > .view > .info > .summary .org_price > del {
            font-size: 18px;
            color: #aaa;
        }

        #product > .view > .info > .summary .org_price > del::after {
            content: "원";
        }

        #product > .view > .info > .summary .org_price > span {
            color: #eb000a;
            font-size: 16px;
            margin-left: 6px;
        }

        #product > .view > .info > .summary .org_price > span::after {
            content: "↓";
        }

        #product > .view > .info > .summary .dis_price > ins {
            font-size: 26px;
            font-weight: bold;
            text-decoration: none;
        }

        #product > .view > .info > .summary .dis_price > ins::after {
            content: "원";
        }

        #product > .view > .info > .summary .delivery {
            font-size: 16px;
            color: #2e8de5;
        }

        #product > .view > .info > .summary .origin {
            font-size: 16px;
        }

        #product > .view > .info > .summary .arrival {
            font-size: 14px;
            margin-left: 10px;
        }

        #product > .view > .info > .summary .desc {
            display: block;
            color: #aaa;
        }

        #product > .view > .info > .summary .card > i {
            display: inline-block;
            width: 30px;
            height: 18px;
            top: 4px;
            font-size: 0;
            vertical-align: text-top;
            margin-right: 2px;
        }

        #product > .view > .info > .summary .cardfree > i {
            background-position: -126px 0;
        }

        #product > .view > .info > .summary .cardadd > i {
            background-position: -51px -21px;
        }

        #product > .view > .info > .summary .banner {
            width: 100%;
        }

        #product > .view > .info > .summary .count {
            position: relative;
            width: 100px;
            height: 40px;
        }

        #product > .view > .info > .summary .count > button {
            position: absolute;
            width: 21px;
            height: 21px;
            background-image: url(../../img/ico_sprites.png);
            font-size: 0;
            background-color: transparent;
            border: none;
        }

        #product > .view > .info > .summary .count > input[name=num] {
            position: absolute;
            left: 30px;
            top: 0;
            width: 30px;
            height: 21px;
            border: 1px solid #ececec;
            font-size: 14px;
            text-align: center;
        }

        #product > .view > .info > .summary .count > .decrease {
            left: 0;
            top: 0;
            background-position: 0px -74px;
        }

        #product > .view > .info > .summary .count > .increase {
            left: 70px;
            top: 0;
            background-position: -48px -74px;
        }


        #product > .view > .info > .summary .total {
            overflow: hidden;
            margin-top: 16px;
        }

        #product > .view > .info > .summary .total > span {
            float: right;
            display: inline-block;
            line-height: 38px;
            font-size: 24px;
            font-weight: bold;
            color: #000;
            text-align: right;
            letter-spacing: -0.5px;
        }

        #product > .view > .info > .summary .total > span::after {
            content: "원";
        }

        #product > .view > .info > .summary .total > em {
            float: right;
            display: block;
            width: 100px;
            height: 22px;
            padding: 10px 0 0;
            font-size: 16px;
            line-height: 22px;
            color: #5e636d;
            letter-spacing: -1px;
        }

        #product > .view > .info > .summary .button {
            overflow: hidden;
            margin-top: 16px;
        }

        #product > .view > .info > .summary .button > input {
            float: left;
            width: 49%;
            height: 50px;
            margin: 2px;
            font-size: 20px;
            font-weight: bold;
            border-radius: 2px;
            cursor: pointer;
        }

        #product > .view > .info > .summary .button > .cart {
            background: #fff;
            border: 1px solid #d9d9d9;
            color: #233594;
        }

        #product > .view > .info > .summary .button > .order {
            background: #2e8de5;
            border: 1px solid #217fd7;
            color: #fff;
        }

        #product > .view > .review > .paging > .num > a.on {
            color: #fe434c;
            font-weight: bold;
        }

        #product > .view > article > nav {
            border-bottom: 1px solid #a4a9b0;
            padding: 6px 0;
            margin-bottom: 12px;
            overflow: hidden;
        }

        #product > .view > article > nav > p {
            float: left;
            color: #777;
            margin-top: 6px;
            margin-left: 6px;
        }

        #product > .view > article > nav > h1 {
            float: left;
            color: #1e2732;
            font-weight: bold;
            font-size: 1.5em;
        }

        #product > .view > .notice > table {
            width: 100%;
        }

        #product > .view > .notice > table:nth-of-type(2) {
            border-top: 1px solid #ececec;
        }

        #product > .view > .notice > table tr > td {
            padding: 5px 0 6px 21px;
            font-size: 14px;
            color: #777;
        }

        #product > .view > .notice > table tr > td:nth-child(1) {
            width: 20%;
            color: #222;
        }

        #product > .view > .review > ul {
            padding: 10px;
            box-sizing: border-box;
        }

        #product > .view > .review > ul > li {
            padding-top: 16px;
            border-bottom: 1px solid #ececec;
            box-sizing: border-box;
        }

        #product > .view > .review > ul > li > div {
            overflow: hidden;
        }

        #product > .view > .review > ul > li > div > span {
            float: right;
            color: #555;
        }

        #product > .view > .review > ul > li > div > h5 {
            float: left;
        }

        #product h5.rating {
            width: 150px;
            height: 20px;
            font-size: 0px;
            background-image: url(../../img/ico_rating_star.png);
            background-repeat: no-repeat;
            background-position: 36px 0px;
            text-indent: 86px;
        }

        #product > .view > .review > ul > li > h3 {
            color: #555;
            margin-top: 6px;
        }

        #product > .view > .review > ul > li > p {
            width: 100%;
            height: 60px;
            color: #555;
            font-size: 14px;
            line-height: 19px;
            word-break: break-all;
            word-wrap: break-word;
            margin-top: 10px;
        }

        #product > .view > .review > .paging {
            width: 100%;
            padding: 30px 0;
            text-align: center;
        }

        #product > .view > .notice > .notice {
            margin: 20px 0;
            padding: 21px 26px 20px 19px;
            line-height: 20px;
            font-size: 14px;
            color: #757c8a;
            background: #fafafa;
            border-radius: 2px;
            white-space: normal;
        }

        #product > .view > .review > .paging > span > a {
            color: #777;
            font-size: 11px;
            letter-spacing: -1px;
        }

        #product > .view > .review > .paging > .num > a {
            display: inline-block;
            min-width: 14px;
            margin: 0 2px;
            padding: 8px 9px;
            border: 1px solid #c4c4c4;
            color: #000;
            font-size: 12px;
            text-align: center;
            text-decoration: none;
        }

        #product > .view > .review > .paging > .num > a.on {
            color: #fe434c;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <main id="product">
        <section class="view">
            <nav>
                <h1>상품보기</h1>
                <p>
                    HOME >
                    <span>컴퓨터</span>
                    >
                    <strong>${cate}</strong>
                </p>
            </nav>
            <article class="info">
                <div class="image">
                    <img src="	https://via.placeholder.com/460x460" alt="상품이미지">
                </div>
                <div class="summary">
                    <nav>
                        <h1>${list.seller_name}</h1>
                        <h2>
                            상품번호 :
                            <span>${list.product_num}</span>
                        </h2>
                    </nav>
                    <nav>
                        <h3>${list.product_name}}</h3>
                        <p>${list.product_description}</p>
                        <h5 class="rating star'${list.garde_score}'}">
                            <a href="#">상품평보기</a>
                        </h5>
                    </nav>
                    <nav>
                        <div class="org_price">
                            <del>${list.product_originalPrice}</del>
                            <span>10%</span>
                        </div>
                        <div class="dis_price">
                            <ins>${list.product_salePrice}</ins>
                        </div>
                    </nav>
                    <nav>
                        <span class="delivery">${list.product_shippingFee}</span>
                        <span class="arrival">모레(금) 7/8 도착예정</span>
                        <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                    </nav>
                    <nav>
                            <span class="card cardfree">
                                <i>아이콘</i>무이자할부
                            </span>
                        <span class="card cardadd">
                                <i>아이콘</i>&nbsp&nbsp카드추가혜택
                            </span>
                    </nav>
                    <nav>
                        <span class="origin">원산지-상세설명 참조</span>
                    </nav>
                    <img src="../../img/vip_plcc_banner.png" alt="적립!" class="banner">
                    <div class="count">
                        <button class="decrease">-</button>
                        <input type="text" name="num" value="1" readonly>
                        <button class="increase">+</button>
                    </div>
                    <div class="total">
                        <span>35,000</span>
                        <em>총 상품금액</em>
                    </div>
                    <div class="button">
                        <input type="button" class="cart" value="장바구니" onclick="location.href='../../../java/pcom/shop/insertCart.do'">
                        <input type="button" class="order" value="구매하기" onclick="location.href='../../../java/pcom/shop/productOrder.do'">
                    </div>
                </div>
            </article>
            <article class="detail">
                <nav><h1>상품정보</h1></nav>
                <img src="https://via.placeholder.com/860x460" alt="상세페이지1">
                <img src="https://via.placeholder.com/860x460" alt="상세페이지2">
                <img src="https://via.placeholder.com/860x460" alt="상세페이지3">
            </article>
            <article class="notice">
                <nav>
                    <h1>상품 정보 제공 고시</h1>
                    <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
                </nav>
                <table>
                    <tr>
                        <td>상품번호</td>
                        <td>11111111111</td>
                    </tr>
                    <tr>
                        <td>상품상태</td>
                        <td>새상품</td>
                    </tr>
                    <tr>
                        <td>부가세 면세여부</td>
                        <td>과세상품</td>
                    </tr>
                    <tr>
                        <td>영수증발행</td>
                        <td>발행가능 - 신용카드 전표, 온라인 현금영수증</td>
                    </tr>
                    <tr>
                        <td>사업자구분</td>
                        <td>사업자 판매자</td>
                    </tr>
                    <tr>
                        <td>브랜드</td>
                        <td>블루포스</td>
                    </tr>
                    <tr>
                        <td>원산지</td>
                        <td>국내생산</td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>제품소재</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>색상</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>치수</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제소사/수입국</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제조국</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>취급시 주의사항</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>제조연월</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>품질보증기준</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>A/S 책임자와 전화번호</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td>주문후 예상 배송기간</td>
                        <td>상세정보 직접입력</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우
                        </td>
                    </tr>
                </table>
                <p class="notice">
                    소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                    동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                    환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                    제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                    산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                    환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
                </p>
            </article>
            <article class="review">
                <nav><h1>상품리뷰</h1></nav>
                <ul>
                    <c:forEach var="item" items="${reviewList}">
                    <li>
                        <div>
                            <h5 class="rating star'${item.reviewScore}'">상품평</h5>
                            <span>${item.member_name} ${item.review_regDate}</span>
                        </div>
                        <h3>${item.product_name}</h3>
                        <p> ${item.review_content}
                        </p>
                    </li>
                    </c:forEach>
                </ul>
                <div class="paging">
                    ${pagingStr}
                </div>
            </article>
        </section>
    </main>
    <button type="button" id="top">상단이동</button>
</div>
</body>
</html>

<script>

</script>