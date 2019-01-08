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
            发帖数：<s:property value="#session.topic.customer.topics.size"/>
        </p>
        <br>
        <span>
            <form style="display:inline" action="editLetterAction" method="post">
                <input type="hidden" name="rid" value="${topic.customer.id}">
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
        ${topic.content}
    </div>
    <div class="inright3">
        <div class="inleft3left">
            <form action="floorReplyAction" method="post">
                <textarea name="floor.detail" style="width: 60%;height: 100%;float: left"></textarea>
                <input type="submit" style="cursor: pointer;margin-top: 55px;margin-left: 10px" value="回复">
            </form>
        </div>
    </div>
</div>
<s:iterator value="#session.floors" status="status">
    <div class="leftitem">
        <div class="inleft1">
    <span style="display:inline-block;margin-top: 30px;margin-left: 90px;font-size: 25px">
    <a href="#">${customer.account}</a>
    </span>
        </div>
        <div class="inleft2">
    <span style="display:inline-block;margin-top: 20px;margin-left: 30px;font-size: 25px">
    <img style="cursor: pointer" src="upload/${customer.image}" onerror="nofind()">
    </span>
        </div>
        <div class="inleft3">
            <p>
                    ${customer.motto}
            </p>
            <br>
            <p>
                发帖数：<s:property value="customer.topics.size"/>
            </p>
            <br>
            <span>
    <form style="display:inline" action="editLetterAction" method="post">
    <input type="hidden" name="rid" value="${topic.customer.id}">
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
                    ${status.count}楼
            </div>
        </div>
        <div class="inright2">
            <div style="width: 940px;height: 120px;background: cornsilk">
                    ${detail}
            </div>
            <div style="width: 940px;height: 200px;background: #f9f9f9">
                <s:iterator value="floorDiscusses" status="status">
                    <div style="float: left;width: 800px">
                            ${customer.account}回复：${detail}
                    </div>
                    <div style="float: right">
                            ${date}
                    </div>
                </s:iterator>
            </div>
        </div>
        <div class="inright3">
            <div class="inleft3left">
                <form action="inFloorReplyAction" method="post">
                    <textarea name="floorDiscuss.detail" style="width: 60%;height: 100%;float: left"></textarea>
                    <input type="hidden" style="float: left" name="rid" value="${customer.id}"/>
                    <input type="hidden" style="float: left" name="fid" value="${id}"/>
                    <input type="submit" style="cursor: pointer;margin-top: 55px;margin-left: 10px;float: left"
                           value="回复">
                </form>
                <div style="margin-top: 55px">
                    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                    <a href="praiseAction?floorId=${id}">赞${good}</a>
                    &emsp;&emsp;
                    <a href="stepAction?floorId=${id}">踩${bad}</a>
                </div>
            </div>
        </div>
    </div>
</s:iterator>

</body>
</html>
