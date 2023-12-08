<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Jsp | Test</title>
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
<h1>Test</h1>

<h3>names</h3>
<ul>
  <c:forEach begin="0" end="3" var="i">
    <li>${names[i]}</li>
  </c:forEach>
</ul>

<h3>items</h3>
<table>
  <c:forEach items="${items}" var="item">
    <td>${item}</td>
  </c:forEach>
</table>

<h3>map</h3>
<table>
  <tbody>
  <tr>
    <th>이름</th>
    <td>
      <input type="text" value="${map.name}"/>
    </td>
  </tr>
  <tr>
    <th>나이</th>
    <td>
      <input type="number" value="${map.age}"/>
    </td>
  </tr>
  <tr>
    <th>결혼여부</th>
    <td>
      <input type="checkbox" checked/>
    </td>
  </tr>
  </tbody>
</table>


<h2>숫자</h2>
<ul>
  <li><fmt:formatNumber value="${no1}" pattern="###.##"/></li><%-- 123.46 --%>
  <li><fmt:formatNumber value="${no1}"/></li><%-- 123.456 --%>
  <li><fmt:formatNumber value="${no1}" pattern="###.#####"/></li><%-- 123.45600 --%>
  <li><fmt:formatNumber value="${no2}" pattern="#,###,###"/></li><%-- 3,000,000 --%>
  <li><fmt:formatNumber value="${no2}" pattern="\\#,###,###"/></li><%-- ₩3,000,000 --%>
  <li><fmt:formatNumber value="${no3}*100" pattern="##\%"/></li><%-- 15% --%>
</ul>

<h2>날짜/시각</h2>
<ul>
  <li><fmt:formatNumber value="${date}" pattern="yyyy년MM월dd일"/></li><%-- 2023년07월24일 --%>
  <li><fmt:formatNumber value="${datetime}" pattern="yyyy/"/></li><%-- 2023/12/07 18:00:52.335 --%>
</ul>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>