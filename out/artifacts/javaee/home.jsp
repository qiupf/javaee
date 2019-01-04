<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>游戏论坛</title>
    <link href="css/model.css" rel="stylesheet" type="text/css"/>
    <script src="js/noimg.js"></script>
</head>
<body>
<%@include file="WEB-INF/head.jsp" %>
<s:iterator value="#session.models">
    <div class="box">
        <div class="leftimg">
            <img src="modelImg/${image}" onerror="noModelImg()">
        </div>
        <div class="rightcontent">
            <div class="righttop">
                <center>
                    <h3 style="cursor: pointer"> ${name}</h3>
                </center>
            </div>
            <div class="rightmid">
                <p>${description}</p>
            </div>
            <div class="rightbottom">
                <center>
                    <form action="loadTopicAction" method="post">
                        <input type="hidden" name="modelId" value="${id}">
                        <input type="submit" style="cursor: pointer;margin-top: 10px" value="查看相关话题">
                    </form>
                </center>
            </div>
        </div>
    </div>
</s:iterator>
</body>
</html>
