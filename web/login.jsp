<%@ page contentType="text/html;charest=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="js/verify.js"></script>
    <s:head />
</head>
<body onLoad="createCode()">

<div id="leftimg">
    <img src="images/zz.jpg">
</div>
<div id="login_box">
    <form action="user.action" method="post" onSubmit="return userCheck()">
        <table>
            <tr>
                <td align="center" class="head">登录</td>
            </tr>
            <tr>
                <td>&nbsp; <s:actionerror/></td>
            </tr>
            <tr>
                <td width=280 height=50><input class="txt" type="text" name="user.account" placeholder="账号/邮箱/手机"
                                               id="name"/>
                </td>
            </tr>
            <tr>
                <td width=280 height=50><input class="txt" type="password" name="user.password" placeholder="密码"
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
    </form>
</div>
</body>
</html>
