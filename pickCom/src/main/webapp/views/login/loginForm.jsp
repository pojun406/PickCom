<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>PickCom:대한민국 1등 PC 쇼핑몰</title>
  <link rel="shortcut icon" type="image/x-icon" href="../../img/favicon.png" />
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
  <%@ include file="../../tiles/loginHeader.jsp" %>
  <form action="/loginAction.do" method="post">
    <main id="member">

      <div class="login">
        <nav>
          <h1>로그인</h1>
          <p>
            HOME >
            <strong>로그인</strong>
          </p>
        </nav>
        <form action="#">
          <table border="0">
            <input type="hidden" name="MEMBER_NAME">
            <input type="hidden" name="MEMBER_NICKNAME">
            <input type="hidden" name="MEMBER_EMAIL">
            <input type="hidden" name="MEMBER_RANK">
            <input type="hidden" name="MEMBER_REGDATE">
            <input type="hidden" name="MEMBER_LASTDATE">
            <input type="hidden" name="MEMBER_DELETE">
            <input type="hidden" name="MEMBER_VISITCOUNT">
            <tr>
              <td>아이디<td>
              <td>
                <input type="text" name="MEMBER_ID" placeholder="아이디 입력">
              </td>
            </tr>
            <tr>
              <td>비밀번호<td>
              <td>
                <input type="password" name="MEMBER_PASSWD" placeholder="비밀번호 입력">
              </td>
            </tr>
          </table>
          <input type="submit" name="memberLogin" value="로그인">
          <span>
            <label>
              <input type="checkbox" name="auto">자동 로그인
            </label>
            <a href="#">아이디찾기</a>
            <a href="#">비밀번호찾기</a>
            <a href="/joinForm.do">회원가입</a>
          </span>
        </form>
      </div>

    </main>
  </form>
  <%@ include file="../../tiles/footer.jsp" %>
</div>
</body>
</html>
