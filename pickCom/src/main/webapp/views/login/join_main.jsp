<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../tiles/loginHeader.jsp" %>
<%@ include file="../../tiles/footer.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PickCom:대한민국 1등 PC 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="../img/favicon.ico" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/common.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<body>
<div id="wrapper">
    <main id="member">
        <div class="register">
            <nav>
                <h1>일반 회원가입</h1>
            </nav>
            <form action="/joinAction.do" method="post">

                <section>
                    <table>
                        <caption>필수 정보입력</caption>
                        <tr>
                            <th>
                                <span class="essential">*</span>
                                아이디
                            </th>
                            <td>
                                <input type="text" name="MEMBER_ID" placeholder="아이디를 입력" required>
                                <span class="msgId">&nbsp;&nbsp;영문, 숫자로 4~12자까지 설정해 주세요.</span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="essential">*</span>
                                이름
                            </th>
                            <td>
                                <input type="text" name="MEMBER_NAME" placeholder="이름을 입력" required>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="essential">*</span>
                                비밀번호
                            </th>
                            <td>
                                <input type="password" name="MEMBER_PASSWD" placeholder="비밀번호를 입력" required>
                                <span class="msgPass">&nbsp;&nbsp;영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="essential">*</span>
                                비밀번호확인
                            </th>
                            <td>
                                <input type="password" name="km_pass" placeholder="비밀번호를 확인" required>
                                <span class="msgPass">&nbsp;&nbsp;비밀번호 재입력</span>
                            </td>
                        </tr>
                    </table>
                </section>
                <section>
                    <form action="#">
                        <table>
                            <caption>기본 정보입력</caption>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    닉네임
                                </th>
                                <td>
                                    <input type="text" name="MEMBER_NICKNAME" placeholder="닉네임을 입력" required>
                                </td>
                            </tr>
                            <%--<tr>
                                <th>
                                    <span class="essential">*</span>
                                    성별
                                </th>
                                <td>
                                    <label>
                                        <input type="radio" name="km_gentder" value="1" checked>
                                        &nbsp;남
                                    </label>
                                    <label>
                                        <input type="radio" name="km_gentder" value="2">
                                        &nbsp;여
                                    </label>
                                </td>
                            </tr>--%>
                            <tr>
                                <th>
                                    <span class="essential">*</span>
                                    이메일
                                </th>
                                <td>
                                    <input type="email" name="MEMBER_EMAIL" placeholder="이메일 입력" required>
                                </td>
                            </tr>
                            <%--<tr>
                                <th>
                                    <span class="essential">*</span>
                                    휴대폰
                                </th>
                                <td>
                                    <input type="text" name="km_hp" placeholder="휴대폰번호 입력" required>
                                    <span class="msgHp"> &nbsp;&nbsp;-포함 13자리를 입력하세요.</span>
                                </td>
                            </tr>
                            <tr class="addr">
                                <th>주소</th>
                                <td>
                                    <div>
                                        <input type="text" name="km_zip" id="zip" placeholder="우편번호 입력 클릭" readonly>
                                    </div>
                                    <div>
                                        <input type="text" name="km_addr1" id="addr1" size="50" placeholder="주소를 검색하세요." readonly>
                                    </div>
                                    <div>
                                        <input type="text" name="km_addr2" id="addr2" size="50" placeholder="상세주소를 입력하세요.">
                                    </div>
                                </td>
                            </tr>--%>
                        </table>
                    </form>
                </section>
                <div>
                    <input type="submit" class="join" value="회원가입">
                </div>
            </form>
        </div>
    </main>
</div>
</body>
</html>