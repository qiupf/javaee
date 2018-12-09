<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>个人资料</title>
</head>
<body>
    <p>当前我的头像</p>
    <img src="upload/${user.image}">
    <p>修改头像</p>
    <s:form action="fileUpload" method="post" enctype="multipart/form-data">
        <s:file name="file" label="选择图片" />
        <s:submit value="确定" />
    </s:form>
</body>
</html>
