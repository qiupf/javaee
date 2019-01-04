<%--
  Created by IntelliJ IDEA.
  User: 47954
  Date: 1/2/2019
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>话题讨论</title>
    <link href="css/floor.css" rel="stylesheet" type="text/css"/>
    <script src="js/noimg.js"></script>
</head>
<body>
<%@include file="WEB-INF/head.jsp" %>
<div class="publish">
    <div class="inpublish">
        <a href="#" style="margin-top:20%;margin-left: 15px">发帖</a>
    </div>
</div>
<div class="leftitem">
    <div class="inleft1">
        <span style="display:inline-block;margin-top: 30px;margin-left: 90px;font-size: 25px">
            <a href="#">${topic.customer.account}</a>
        </span>
    </div>
    <div class="inleft2">
        <span style="display:inline-block;margin-top: 20px;margin-left: 30px;font-size: 25px">
            <img style="cursor: pointer" src="upload/${topic.customer.image}" onerror="nofind()">
        </span>
    </div>
    <div class="inleft3">
        <p>
            ${topic.customer.motto}
        </p>
        <br>
        <p>
            发帖数：
        </p>
        <br>
        <span>
            <form style="display:inline">
                <input type="submit" value="私信" style="cursor: pointer">
            </form>
            &emsp;&emsp;
            <form style="display:inline">
                <input type="submit" value="关注" style="cursor: pointer">
            </form>
        </span>
    </div>
</div>
<div class="rightitem">
    <div class="inright1">
        <div style="float: right;margin-top:7px;margin-right: 5px">
            楼主
        </div>
    </div>
    <div class="inright2">
        ${topic.name}
    </div>
    <div class="inright1">
        <div style="float: right;margin-top:7px;margin-right: 5px">
            <a href="#">赞</a>
            &emsp;&emsp;
            <a href="#">踩</a>
        </div>
    </div>
</div>

</body>
</html>
