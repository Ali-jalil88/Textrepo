<%--
  Created by IntelliJ IDEA.
  User: Ali Jalil
  Date: 30-Aug-20
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page1</title>
    <link rel="stylesheet" href="/static/text1.css">

</head>
<body>
<div class="navigator1">
    <form action="text.jsp">
        <label>Word</label>
        <input type="text" name="number"><br><br>
        <label>Line</label>
        <input type="text" name="number"><br><br>
        <label>Letter</label>
        <input type="text" name="number"><br><br>
    </form>
    <a href="${pageContext.request.contextPath}/pages/text.jsp"><input type="submit" value="back"></a>

</div>
</body>
</html>
