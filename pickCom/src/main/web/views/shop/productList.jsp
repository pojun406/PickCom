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
</head>
<body>
<div id="wrapper">
    <main id="product">
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
                            <a href="#">컴퓨터 전체</a>
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
                            <a href="#">데스크탑 전체</a>
                        </li>
                        <li>
                            <a href="#">브랜드</a>
                        </li>
                        <li>
                            <a href="#">사무/작업용PC</a>
                        </li>
                        <li>
                            <a href="#">게이밍 PC</a>
                        </li>
                        <li>
                            <a href="#">일체형PC</a>
                        </li>
                        <li>
                            <a href="#">서버/워크스테이션</a>
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
                            <a href="#">CPU</a>
                        </li>
                        <li>
                            <a href="#">메인보드</a>
                        </li>
                        <li>
                            <a href="#">RAM</a>
                        </li>
                        <li>
                            <a href="#">그래픽카드(VGA)</a>
                        </li>
                        <li>
                            <a href="#">SSD</a>
                        </li>
                        <li>
                            <a href="#">HDD</a>
                        </li>
                        <li>
                            <a href="#">케이스</a>
                        </li>
                        <li>
                            <a href="#">파워</a>
                        </li>
                        <li>
                            <a href="#">쿨러/튜닝</a>
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
                            <a href="#">SSD</a>
                        </li>
                        <li>
                            <a href="#">HDD</a>
                        </li>
                        <li>
                            <a href="#">외장 SSD</a>
                        </li>
                        <li>
                            <a href="#">외장 하드</a>
                        </li>
                        <li>
                            <a href="#">외장 케이스</a>
                        </li>
                    </ol>
                </li>
            </ul>
        </aside>
        <section class="list">
            <nav>
                <h1>${titleMain}</h1>
                <p>
                    HOME >
                    <span>컴퓨터</span>
                    >
                    <strong>컴퓨터 전체</strong>
                </p>
            </nav>
            <ul class="sort">
                <li>
                    <a href="#" class="on">판매많은순</a>
                </li>
                <li>
                    <a href="#">낮은가격순</a>
                </li>
                <li>
                    <a href="#">높은가격순</a>
                </li>
                <li>
                    <a href="#">평점높은순</a>
                </li>
                <li>
                    <a href="#">후기많은순</a>
                </li>
                <li>
                    <a href="#">최근등록순</a>
                </li>
            </ul>
            <table>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td><a href="#" class="thumb" name="title">
                            <img src="	https://via.placeholder.com/120x120" alt="상품이미지">
                        </a></td>
                        <td>
                            <h3 class="name">${item.product_name}</h3>
                            <a href="#" class="desc">${item.product_description}</a>
                        </td>
                        <td>
                            <ul>
                                <li>
                                    <ins class="dis-price">${item.salePrice}</ins>
                                </li>
                                <li>
                                    <del class="org-price">${item.originalPrice}</del>
                                    <span class="discount">10%</span>
                                </li>
                                <li><span class="free-delivery">무료배송</span></li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller"><i class="fas fa-home" aria-hidden="true"></i> ${item.manufacturer_name}
                            </h4>
                            <h5 class="badge power">판매자등급</h5>
                            <h6 class="rating star1">상품평</h6>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="paging">
                    <span class="prev">
                        <a href="#">< 이전</a>
                    </span>
                <span class="num">
                        <a href="#" class="on">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                    </span>
                <span class="next">
                        <a href="#">다음 ></a>
                    </span>
            </div>
        </section>
    </main>
    <button type="button" id="top">상단이동</button>
</div>
<form id="commonForm" name="commonForm"></form>
</body>

</html>
<script type="text/javascript">
    $(document).ready(function () {
        $("a[name='title']").on("click", function (e) {
            e.preventDefault();
            fn_openBoardDetail($(this));
        });
    });

    function fn_openBoardDetail(obj) {
        var comSubmit = new ComSubmit();
        var url = '<c:url value="/shop/productDetail.do" />';
        comSubmit.setUrl(url);
        comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
        comSubmit.submit();
    }
</script>