<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-03-04
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    //세션 지우기
    session.removeAttribute("sess1");
    session.removeAttribute("sess2");

    //세션 무효화(삭제)
    session.invalidate();

    response.sendRedirect("session_read.jsp");
%>