<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 12/30/2018
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>最新话题</title>
    <link href="css/topic.css" rel="stylesheet" type="text/css"/>
    <script src="js/noimg.js"></script>
</head>
<body>
<%@include file="WEB-INF/head.jsp" %>
<div class="modeltop">
    <div class="modeltop_img">
        <img src="modelImg/${model.image}" onerror="noModelImg()">
    </div>
    <div class="modeltop_content">
        <a href="#">${model.name}</a>
        <div style="margin-top:20px;margin-left: 15px">
            <form action="">
                <input type="submit" style="cursor: pointer" value="关注">
            </form>
        </div>
    </div>
</div>
<div class="itemhead">
    <div class="column1">
        <a href="#">主题</a>
    </div>
    <div class="column2">
        <a href="#">内容</a>
    </div>
    <div class="column3">
        <a href="#">作者</a>
    </div>
    <div class="column4">
        <a href="#">发布时间</a>
    </div>
    <div class="column5">
        <a href="#">回复数</a>
    </div>
    <div class="column5">
        <a href="#">关注数</a>
    </div>
</div>
<s:iterator value="#session.topics">
    <div class="itemtopic">
        <div class="column1">
            <a href="#">[${mode}]
            </a>
        </div>
        <div class="column2">
            <a href="loadFloorAction?topicId=${id}">${name}</a>
        </div>
        <div class="column3">
            <a href="#">${customer.account}</a>
        </div>
        <div class="column4">
            <a href="#"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></a>
        </div>
        <div class="column5">
            <a href="#"><s:property value="floors.size" /></a>
        </div>
        <div class="column5">
            <a href="#"><s:property value="favorTopics.size" /></a>
        </div>
    </div>
</s:iterator>
</body>
</html>
