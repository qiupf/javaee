<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>上传页面</title>
</head>
<body>
    <s:form action="fileUpload" method="post" enctype="multipart/form-data">
        <s:file name="file" label="上传文件" />
        <s:submit value="上传" />
    </s:form>
</body>
</html>
