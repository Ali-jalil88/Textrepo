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
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <label>Word
            <textarea class="Word" name="word" rows="1">${sessionScope.number.word}</textarea><br>
        </label>
        <label>numberWord
            <textarea class="Word" name="word" rows="1">${sessionScope.number.numberWord}</textarea><br>
        </label>
        <label>Line
            <textarea class="Line" name="line" rows="1">${sessionScope.number.numberLine}</textarea><br>
        </label>
        <label>numberLetter
            <textarea class="Letter" name="letter" rows="1">${sessionScope.number.numberLetter}</textarea><br>
        </label>
        <label>Letter
            <textarea class="Word" name="word" rows="1">${sessionScope.number.letter}</textarea><br>
        </label>
    </form>
    <a href="${pageContext.request.contextPath}/pages/text.jsp"><input type="submit" value="back"></a>
</div>
</body>
</html>
