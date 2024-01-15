<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 테스트</title>
    <script>
        <c:if test="${msg != null}">
        alert(`${msg}`); // 여러줄 입력이 가능하도록 ``(백틱)으로 감싼다.
        <%-- session속성 msg 제거해서 1회만 출력되도록 한다.
             제거하지 않을 시 메세지가 계속 출력됨 --%>
        <%-- session.removeAttribute("msg"); --%>
        <c:remove var="msg" scope="session"/>
        </c:if>
    </script>
</head>
<body>
<c:if test="${empty loginMember}">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>ID : </label> <input type="text" name="memberId"> <br>
        <label>PWD : </label> <input type="password" name="memberPwd"> <br>
        <button type="submit">로그인</button>
    </form>
</c:if>
<c:if test="${!empty loginMember}">
    <h3>${loginMember.memberName} 님 환영합니다.</h3>
</c:if>
</body>
</html>