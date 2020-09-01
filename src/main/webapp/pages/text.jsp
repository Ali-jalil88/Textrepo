<%--
  Created by IntelliJ IDEA.
  User: Ali Jalil
  Date: 30-Aug-20
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page</title>
    <link rel="stylesheet" href="../static/text.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <label>Text</label>
    <TEXTAREA name="text" placeholder="Enter text" rows="7"></TEXTAREA>

    <div class="navigator">
        <input type="hidden" name="command" value="command_create_text">
        <input type="submit" value="analyzing">
    <a href="${pageContext.request.contextPath}/pages/text.jsp">next</a>

    </div>
</form>
</body>
</html>
