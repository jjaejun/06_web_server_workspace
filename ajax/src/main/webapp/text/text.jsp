<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-22
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Ajax | text</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
    <h1>text</h1>
    <button id="btn1">확인</button>
    <br><br>
    <div class="ui-widget">
        <label for="studentSearch">학생검색: </label>
        <input id="studentSearch">
    </div>

    <script>
        const contextPath = '${pageContext.request.contextPath}';
    </script>
    <%-- jquery 사용시 slim버전은 ajax가 없으므로 쓰지 말자 --%>
    <%-- uncompressed 권장 --%>
    <script src="${pageContext.request.contextPath}/js/text.js"></script>
</body>
</html>
