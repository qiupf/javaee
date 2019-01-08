<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 1/8/2019
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>私信</title>
</head>
<body>
<p>
    发送给${receiver.account}：
</p>
<form action="sendLetterAction" method="post">
    <div>
        主题：<input type="text" name="letter.theme"/>
    </div>
    <div style="margin-top: 10px">
        内容：<textarea name="letter.detail"></textarea>
    </div>
    <div style="margin-top: 10px">
        <input type="submit" value="发送" style="cursor: pointer">
    </div>

</form>
</body>
</html>
