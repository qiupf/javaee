<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="js/verify.js"></script>
    <s:head/>
</head>
<body onLoad="createCode()">
<%@include file="WEB-INF/head.jsp" %>
<div class="box" id="box">
    <div class="inner">
        <ul>
            <li><a href="#"><img src="images/zy.jpg" alt=""></a></li>
            <li><a href="#"><img src="images/zz.jpg" alt=""></a></li>
            <li><a href="#"><img src="images/wangzhe.jpg" alt=""></a></li>
        </ul>
        <ol class="bar">
        </ol>
        <div id="arr">
                    <span id="left">
                        <
                    </span>
            <span id="right">
                        >
                    </span>
        </div>
    </div>

</div>
<%--<s:fielderror />--%>
<div id="login_box">
    <s:form action="login" method="post" onSubmit="return userCheck()">
        <table>
            <tr>
                <td align="center" class="head">登录</td>
            </tr>
            <tr>
                <td>&nbsp; <s:actionerror/></td>
            </tr>
            <tr>
                <td width=280 height=50><input class="txt" type="text" name="loginUser.id" placeholder="账号"
                                               id="name"/>
                </td>
            </tr>
            <tr>
                <td width=280 height=50><input class="txt" type="password" name="loginUser.password" placeholder="密码"
                                               id="passwd"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>输入验证码：<input id="validCode" style="color:black;width:100px;height:60%" type="text" name="authcode"/>
                    <input type="text" onClick="createCode()" readonly="readonly" id="checkCode" class="unchanged"
                           style="width: 90px;cursor:pointer"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td align="center"><input class="sub" type="submit" name="submit" value="登录"/>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td align="center"><a href="#" style="position:relative;float:right">忘记密码?</a></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
        </table>
    </s:form>
</div>
<script src="js/loop.js"></script>
</body>
</html>
