<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-18
  Time: 오전 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
    <title>SearchSuccess</title>
    <style>
        table {
            border: 1px solid #000;
            border-collapse: collapse;
            margin: 20px 10px;
        }

        th, td {
            border: 1px solid #000;
            padding: 5px;
        }
    </style>
</head>
<body>
    <h2>회원정보</h2>

    <table>
        <tr>
            <td>회원번호</td>
            <td>회원아이디</td>
            <td>회원이름</td>
            <td>회원나이</td>
        </tr>
        <tr>
            <td>${user.userNo}</td>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userAge}</td>
        </tr>
    </table>

    <a href="${pageContext.request.contextPath}">메인페이지로 돌아가기</a>
</body>
</html>
