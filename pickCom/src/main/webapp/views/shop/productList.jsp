<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../tiles/default_layout.jsp" %>
<!DOCTYPE html>
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
        <section class="list">
            <nav>
                <h1>${titleMain}</h1>
                <p>
                    HOME >
                    <span>컴퓨터</span>
                    >
                    <strong>${cate}</strong>
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
                        <td><a href="/pcom/shop/productDetail.do" class="thumb" name="title">
                            <img src="${item.product_img}" alt="상품이미지">
                        </a></td>
                        <td>
                            <input type="hidden" id="IDX" name="IDX" value="${item.product_num}">
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
                                <li><span class="free-delivery">${item.product_shippingFee}</span></li>
                            </ul>
                        </td>
                        <td>
                            <h4 class="seller"><i class="fas fa-home" aria-hidden="true"></i> ${item.seller_name}
                            </h4>
                            <h5 class="badge power">${item.seller_rank}</h5>
                            <h6 class="rating star1">${item.grade_score}</h6>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="paging">
                ${pagingStr}
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
        comSubmit.setUrl("/pcom/shop/productDetail.do");
        comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
        comSubmit.submit();
    }
</script>