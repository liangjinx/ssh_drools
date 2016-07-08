<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.mvel2.util.Make" %>
<html>
<body>
<h2>success OF THIS</h2>
<%
    String value= (String) request.getAttribute( "data" );
    out.println("用户名:"+value);//输出参数值
%>
</body>
</html>
