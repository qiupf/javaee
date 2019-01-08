<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 1/8/2019
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>
</head>
<body>
<form action="addTopicAction" method="post">
    <div>
        类型：<input type="text" name="topic.mode"/>
    </div>
    <div style="margin-top: 10px">
        标题：<input type="text" name="topic.name"/>
    </div>
    <div style="margin-top: 10px">
        内容：<textarea name="topic.content"></textarea>
    </div>
    <div style="margin-top: 10px">
        <input type="submit" value="发帖" style="cursor: pointer">
    </div>
</form>
<a href="topic.jsp">返回</a>
</body>
</html>
