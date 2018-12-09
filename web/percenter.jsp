<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>游戏论坛</title>
    <link href="css/percenter.css" rel="stylesheet" type="text/css"/>
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

    </div>
    <div class="Lthird">

    </div>
    <div class="Lforth">

    </div>

</div>
<div class="rightbox">
    <div class="Rfirst">
        <div class="Rimg">
            <img src="upload/${user.image}">
        </div>
        <div class="Rname">
            <p style="font-size: 25px">
                ${user.name}
            </p>
            <p>
                论坛积分：20
            </p>
        </div>
        <div class="Rlevel">
            <p>
                用户组： Lv：1
            </p>
            <p style="margin-top: 30px">
                发帖数：10
            </p>
        </div>
    </div>

</div>
</body>
</html>
