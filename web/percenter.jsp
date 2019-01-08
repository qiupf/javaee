<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>游戏论坛</title>
    <link href="css/percenter.css" rel="stylesheet" type="text/css"/>
    <script src="js/noimg.js"></script>
</head>
<body>
<%@include file="WEB-INF/head.jsp" %>
<div class="leftbox">
    <div class="Lfirst">
        <div class="firstin">
            <a href="percenter.jsp">
                <p style="font-size: 25px;color: red">个 人 中 心</p>
            </a>
        </div>
    </div>
    <div class="Lsecond">
        <div class="secondin">
            <img src="images/account.png" style="height: 20px;width: 20px;margin-top: 10px"> <span
                style="cursor: pointer">&emsp;<b>账号信息</b></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="perinfo.jsp">个人资料</a></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a
                    href="modifyImg.jsp">修改头像</a></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">账号绑定</a></span>
        </div>

    </div>
    <div class="Lthird">
        <div class="secondin">
            <img src="images/forum.png" style="height: 20px;width: 20px;margin-top: 10px"> <span
                style="cursor: pointer">&emsp;<b>我的论坛</b></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">我的主题</a></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">我的空间</a></span>
        </div>
    </div>
    <div class="Lforth">
        <div class="secondin">
            <img src="images/manage.png" style="height: 20px;width: 20px;margin-top: 10px"> <span
                style="cursor: pointer">&emsp;<b>个人管理</b></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">我的消息</a></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">视频订阅</a></span>
        </div>
        <div class="secondin">
            <span style="display:inline-block;margin-top: 10px;margin-left: 39px"><a href="#">视频收藏</a></span>
        </div>
    </div>

</div>
<div class="rightbox">
    <div class="Rfirst">
        <div class="Rimg">
            <img src="upload/${customer.image}" onerror="nofind()">
        </div>
        <div class="Rname">
            <p style="font-size: 25px">
                ${customer.account}
            </p>
            <p>
                发帖数：<s:property value="#session.customer.topics.size"/>
            </p>
        </div>
        <div class="Rlevel">
            <p>
                座右铭：${customer.motto}
            </p>
            <p style="margin-top: 30px">
                回复数：<s:property value="#session.customer.floors.size"/>
            </p>
        </div>
    </div>
    <div class="Rsecond">
        <div class="Rmiss">
            <span style="display: inline-block;margin-top: 10px;margin-left: 20px">
                <a href="#">
                    <img src="images/message.png" style="height: 70px;width: 70px;margin-top: 10px">
                    <p>
                        <a href="missMessageAction">未读消息</a>
                    </p>
                </a>
            </span>
        </div>
        <div class="Rmiss">
            <span style="display: inline-block;margin-top: 10px;margin-left: 20px">
                <a href="#">
                    <img src="images/follow.png" style="height: 70px;width: 70px;margin-top: 10px">
                    <p>
                        <a href="#">关注的人</a>
                    </p>
                </a>
            </span>
        </div>

    </div>
    <div class="Rthird">
        <s:if test="#session.customer.favorModels.size!=0">
            <p>您关注的模块如下：</p>
            <s:iterator value="#session.customer.favorModels">
                <div class="Rmodel">
                    <img src="modelImg/${model.image}" style="height: 100px;width: 100px" onerror="noModelImg()">
                    <p>
                            ${model.name}
                    </p>
                </div>
            </s:iterator>
        </s:if>
        <s:else>
            您还没有关注任何模块！
        </s:else>

    </div>
</div>
</body>
</html>
