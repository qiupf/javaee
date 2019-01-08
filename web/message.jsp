<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 1/8/2019
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>未读消息</title>
</head>
<body>
<s:iterator value="#session.customer.receive">
    <div style="margin-top: 10px">
        <p>
            发送者：${sender.account}
        </p>
        <p>
            发送日期：${date}
        </p>
        <p>
            主题：${theme}
        </p>
        <p>
            内容：${detail}
        </p>
    </div>
</s:iterator>
<div>
    <a href="percenter.jsp">返回</a>
</div>
</body>
</html>
