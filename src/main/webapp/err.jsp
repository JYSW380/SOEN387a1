<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 10/11/2020
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <nav><a href="index.jsp"></a></nav>
    <h1>
        <%
            String err = (String) request.getAttribute("errmessage");
            out.println(err);
        %>
    </h1>
</body>
</html>
