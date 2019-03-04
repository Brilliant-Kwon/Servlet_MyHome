<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-04
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>세션 읽기</h3>
<%
    String str = (String) session.getAttribute("sess1");
    Integer i = (Integer) session.getAttribute("sess2");
%>
<ul>
    <li>문자열 세션 : <%=str%>
    </li>
    <li>정수 세션 : <%=i%>
    </li>
</ul>

<p>
    <a href="session_delete.jsp">세션 삭제</a>
    <a href="session_write.jsp">세션 기록</a>
</p>
</body>
</html>
