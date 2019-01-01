<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>个人资料</title>
    <script src="js/noimg.js"></script>
    <link href="css/perinfo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <p>当前我的头像</p>
    <div class="current">
        <img src="upload/${customer.image}" onerror="nofind()">
    </div>
    <p>修改头像</p>
    <s:form action="modifyImg" method="post" enctype="multipart/form-data">
        <s:file name="photo" label="选择图片" />
        <s:submit value="确定" />
    </s:form>
    <a href="percenter.jsp">返回个人中心</a>
</body>
</html>
