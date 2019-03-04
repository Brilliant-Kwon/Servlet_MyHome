<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-04
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    //세션 객체 생성
    //어떤 객체도 담을 수 있다.
    session.setAttribute("sess1", "문자열 세션");
    session.setAttribute("sess2", 2019);

    //세션 유효 시간
    session.setMaxInactiveInterval(2 * 60 * 60);//2 시간

%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>세션 변수 저장</h3>
<p><a href="session_read.jsp">세션 변수 확인</a></p>
</body>
</html>
