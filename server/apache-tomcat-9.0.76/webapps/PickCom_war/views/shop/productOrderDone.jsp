<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    #product > .complete > article {
      margin-top: 16px;
    }
    #product > .complete > .message > h2 {
      font-size: 32px;
      font-weight: bold;
      text-align: center;
      color: #555;
      padding: 10px;
    }
    #product > .complete > .message > h2 > i {
      font-size: 26px;
    }
    #product > .complete > .message > p {
      font-size: 18px;
      font-weight: bold;
      padding: 10px;
      text-align: center;
    }
    #product > .complete > article {
      margin-top: 16px;
    }
    #product > .complete > article > h1 {
      font-weight: bold;
      font-size: 14px;
      color: #111;
      padding: 6px 0;
    }
    #product > .complete table {
      width: 100%;
      border-collapse: collapse;
      border-spacing: 0;
      border-top: 2px solid #000;
    }
    #product > .complete table tr {
      border-bottom: 1px solid #d3d3d3;
    }
    #product > .complete table tr > th {
      padding: 12px 0;
      background: #fff;
      color: #383838;
      font-size: 0.95em;
      text-align: center;
      letter-spacing: -0.1em;
    }
    /* 상품정보 */
    #product > .complete > .info > table tr > th:last-child {
      width: 200px;
    }
    #product > .complete > .info table tr > td {
      text-align: center;
    }
    #product > .complete > .info table tr > td:last-child {
      color: #ff006c;
      font-weight: bold;
      text-align: right;
    }
    #product > .complete > .info table tr > td > article {
      overflow: hidden;
      padding: 6px;
    }
    #product > .complete > .info table tr > td img {
      float: left;
      width: 80px;
    }
    #product > .complete > .info table tr > td div {
      float: left;
      margin-left: 10px;
      text-align: left;
    }
    #product > .complete > .info table tr > td div > p {
      text-align: left;
      color: #777;
      margin-top: 4px;
    }
    #product > .complete > .info .total > td > table {
      border: none;
    }
    #product > .complete > .info .total > td > table tr {
      border: none;
    }
    #product > .complete > .info .total > td > table td {
      text-align: right;
      color: #111;
      background: #f2f2f2;
      font-weight: normal;
      border-bottom: none;
      padding: 10px;
      box-sizing: border-box;
    }
    #product > .complete > .info .total > td > table tr:last-child span {
      font-weight: bold;
      color: #ff006c;
    }
    /* 주문정보 */
    #product > .complete > .order table tr > td {
      padding: 10px;
      box-sizing: border-box;
    }
    #product > .complete > .order > table tr > td:nth-child(1) {
      width: 160px;
      background: #f2f2f2;
    }
    #product > .complete > .order table tr > td:nth-child(2) {
      width: auto;
    }
    #product > .complete > .order table tr > td:nth-child(3) {
      width: 100px;
      text-align: right;
      vertical-align: top;
      background: #f2f2f2;
    }
    #product > .complete > .order table tr > td:nth-child(4) {
      width: 100px;
      text-align: right;
      vertical-align: top;
      background: #f2f2f2;
    }
    #product > .complete > .order table span {
      font-weight: bold;
      color: #ff006c;
    }
    /* 배송정보 */
    #product > .complete > .delivery table tr > td:nth-child(1) {
      width: 160px;
      background: #f2f2f2;
    }
    #product > .complete > .delivery table tr > td {
      padding: 10px;
      box-sizing: border-box;
    }
    #product > .complete > .delivery table tr > td:nth-child(3) {
      width: 200px;
      background: #f2f2f2;
    }
    /* 꼭 알아두세요 */
    #product > .complete > .alert {
      width: 100%;
      background-color: #f7f7f7;
      padding: 10px;
      padding-left: 24px;
      color: #999;
      box-sizing: border-box;
    }
    #product > .complete > .alert > h1 {
      margin-left: -12px;
    }
    #product > .complete > .alert > ul {
      list-style: inherit;
    }
    #product > .complete > .alert > ul > li {
      line-height: 20px;
    }
    #product > .complete > .alert > ul > li > span {
      position: relative;
      left: -6px;
    }
  </style>
</head>
<body>
<div id="wrapper">
  <main id="product">
    <section class="complete">
      <nav>
        <h1>주문완료</h1>
        <p>
          HOME > 장바구니 > 주문결제
          <strong>주문완료</strong>
        </p>
      </nav>
      <article class="message">
        <h2>
          고객님의 주문이 정상적으로 완료되었습니다.
          <i class="far fa-smile" aria-hidden="true"></i>
        </h2>
        <p>
          즐거운 쇼핑이 되셨습니까? 고객님을 최우선으로 생각하는 PickCom(픽컴)이 되겠습니다.
        </p>
      </article>
      <!-- 상품정보 -->
      <article class="info">
        <h1>상품정보</h1>
        <table border="0">
          <tr>
            <th>상품명</th>
            <th>상품금액</th>
            <th>할인금액</th>
            <th>수량</th>
            <th>주문금액</th>
          </tr>
          <c:forEach var="item" items="${list}">
          <tr>
            <td>
              <article>
                <img src="${item.product_img}" alt="">
                <div>
                  <h2>
                    <a href="#">${item.product_name}</a>
                  </h2>
                  <p>${item.product_description}</p>
                </div>
              </article>
            </td>
            <td>${item.product_originalPrice}원</td>
            <td>${item.DISCOUNT_AMOUNT}원</td>
            <td>${item.list_quantity}</td>
            <td>16,000원</td>
          </tr>
          </c:forEach>
          <tr class="total">
            <td colspan="4"></td>
            <td>
              <table>
                <tr>
                  <td>총 상품금액</td>
                  <td>
                    <span>34,000원</span>
                  </td>
                </tr>
                <tr>
                  <td>총 할인금액</td>
                  <td>
                    <span>-2,000원</span>
                  </td>
                </tr>
                <tr>
                  <td>배송비</td>
                  <td>
                    <span>3,000원</span>
                  </td>
                </tr>
                <tr>
                  <td>총 결제금액</td>
                  <td>
                    <span>35,000</span>원
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
      </article>
      <!-- 주문정보 -->
      <article class="order">
        <h1>주문정보</h1>
        <table border="0">
          <tr>
            <td>주문번호</td>
            <td>${order_num}</td>
            <td rowspan="3">총 결제금액</td>
            <td rowspan="3">
              <span>${list_price}</span>원
            </td>
          </tr>
          <tr>
            <td>결제방법</td>
            <td>${payMethod}</td>
          </tr>
          <tr>
            <td>주문자/연락처</td>
            <td>${orderer}/${orderPhone}</td>
          </tr>
        </table>
      </article>
      <!-- 배송정보 -->
      <article class="delivery">
        <h1>배송정보</h1>
        <table border="0">
          <tr>
            <td>수취인</td>
            <td>${reciever}</td>
            <td>주문자 정보</td>
          </tr>
          <tr>
            <td>연락처</td>
            <td>${recieverPhone}</td>
            <td rowspan="2">
              ${orderer}
              <br> ${orderPhone}
            </td>
          </tr>
          <tr>
            <td>배송지 주소</td>
            <td>${address}</td>
          </tr>
        </table>
      </article>
      <!-- 꼭 알아두세요 -->
      <article class="alert">
        <h1>꼭 알아두세요.</h1>
        <ul>
          <li>
                            <span>
                                케이마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 케이마켓은 상품, 거래정보 및 거래에 대하여 책임을 지지 않습니다.
                            </span>
          </li>
          <li>
                            <span>
                                구매주문내역, 배송상태 확인, 구매영수증 출력, 구매취소/반품/교환은 사이트 상단의 주문/배송조회에서 확인 할 수 있습니다.
                            </span>
          </li>
          <li>
                            <span>
                                고객님의 주문이 체결된 후 상품품절 및 단종 등에 의해 배송이 불가능할 경우, 전자상거래등에서의 소비자 보호에 관한 법률 제15조 2항에 의거하여 3영업일(공휴일 제외) 이내에 자동으로 취소될 수 있으며, 이 경우 취소 안내 메일이 고객님께 발송되오니 양지 바랍니다.
                            </span>
          </li>
          <li>
                            <span>
                                극히 일부 상품에 대해 수량 부족, 카드결제승인 오류 등의 사례가 간혹 있을 수 있으니 `나의쇼핑정보`에서 다시 한번 확인해 주세요.
                            </span>
          </li>
          <li>
                            <span>
                                현금 잔고로 구매하셨을 경우, 나의 쇼핑정보에서 입금확인이 되었는지를 다시 한번 확인해 주세요.
                            </span>
          </li>
          <li>
                            <span>
                                배송 주소를 추가하거나 변경, 삭제 등의 관리는 `나의쇼핑정보 > 나의정보`에서 가능합니다.
                            </span>
          </li>
        </ul>
      </article>
    </section>
  </main>
  <button type="button" id="top">상단이동</button>
</div>

</body>
</html>

<script>

</script>