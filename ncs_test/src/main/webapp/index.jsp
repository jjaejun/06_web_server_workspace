<%@page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>회원 정보 조회(회원 번호 검색)</h2>
<form action="${pageContext.request.contextPath}/selectUser">
    <input type="text" id="userNo" name="userNo">
    <button type="submit">조회</button>
</form>
</body>
</html>
