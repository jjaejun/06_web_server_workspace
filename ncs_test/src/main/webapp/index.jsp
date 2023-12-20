<%@page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>회원 정보 조회(아이디 검색)</h2>
<form action="${pageContext.request.contextPath}/selectUser">
    <input type="text" id="userId" name="userId">
    <button type="submit">조회</button>
</form>
</body>
</html>
