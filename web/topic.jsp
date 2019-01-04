<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 12/30/2018
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>话题</title>
</head>
<body>
    <table border="1">
        <tr>
            <th></th>
            <th></th>
        </tr>
        <s:iterator value="#session.topics">
        <tr>
            <td><s:property value="mode" /></td>
            <td><s:property value="name" /></td>
            <td><s:property value="customer.account" /> </td>
            <td><s:property value="date" /> </td>
        </tr>
        </s:iterator>

    </table>

</body>
</html>
