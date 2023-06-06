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
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/product.css">
</head>
<aside>
    <ul class="category">
        <li>
            <i class="fa fa-bars" aria-hidden="true"></i>카테고리
        </li>
        <li>
            <a href="#">
                <i class="fa fa-star-o" aria-hidden="true">컴퓨터
                </i>
            </a>
            <ol>
                <li>
                    <a href="<c:url value="/shop/bestProductList.do"/>">컴퓨터 전체</a>
                </li>
                <li>
                    <a href="#">PC견적</a>
                </li>
                <li>
                    <a href="#">병목현상 계산기</a>
                </li>
                <li>
                    <a href="#">PC 파워 계산기</a>
                </li>
                <li>
                    <a href="#">게시판</a>
                </li>
                <li>
                    <a href="#">새 소식</a>
                </li>
            </ol>
        </li>
        <li>
            <a href="#">
                <i class="fas fa-laptop" aria-hidden="true">브랜드PC/조립PC
                </i>
            </a>
            <ol>
                <li>
                    <a href="<c:url value="/shop/productList/brand/allPC/newItem.do"/>">데스크탑 전체</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/brand/brandPC/newItem.do"/>">브랜드</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/brand/officePC/newItem.do"/>">사무/작업용PC</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/brand/gamingPC/newItem.do"/>">게이밍 PC</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/brand/AIOPC/newItem.do"/>">일체형PC</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/brand/server/newItem.do"/>">서버/워크스테이션</a>
                </li>
            </ol>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-gears" aria-hidden="true">PC 주요부품
                </i>
            </a>
            <ol>
                <li>
                    <a href="<c:url value="/shop/productList/parts/CPU/newItem.do"/>">CPU</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/mainBoard/newItem.do"/>">메인보드</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/RAM/newItem.do"/>">RAM</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/GPU/newItem.do"/>">그래픽카드(VGA)</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/SSD/newItem.do"/>">SSD</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/HDD/newItem.do"/>">HDD</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/case/newItem.do"/>">케이스</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/power/newItem.do"/>">파워</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/parts/cooler/newItem.do"/>">쿨러/튜닝</a>
                </li>
            </ol>
        </li>
        <li>
            <a href="#">
                <i class="fas fa-home" aria-hidden="true">PC 저장장치
                </i>
            </a>
            <ol>
                <li>
                    <a href="<c:url value="/shop/productList/storage/SSD/newItem.do"/>">SSD</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/storage/HDD/newItem.do"/>">HDD</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/storage/externalSSD/newItem.do"/>">외장 SSD</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/storage/externalHDD/newItem.do"/>">외장 하드</a>
                </li>
                <li>
                    <a href="<c:url value="/shop/productList/storage/externalCase/newItem.do"/>">외장 케이스</a>
                </li>
            </ol>
        </li>
    </ul>
</aside>
</body>

</html>