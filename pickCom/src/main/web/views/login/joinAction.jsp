<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../tiles/loginHeader.jsp" %>
<%@ include file="../../tiles/footer.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입 성공</title>

  <style>
    .Action2 {
      border:1px solid black;
      width:120px;
      height:40px;
      background-color:#000000;
      color:white;
    }
  </style>

</head>
<body>
<br>
<br>
<br>
<br>
<br>
<p align="center" style="font-size:35px;">
  환영합니다, ${MEMBER_NAME }님! <br />
  회원가입이 완료되었습니다. ^^
<p>
  <br>

<p align="center">
  <button type="button" class="Action2"
          onclick="location.href='<c:url value="/loginForm.do"/>'">로그인</button>
</p>

</body>
</html>