<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="css/head.css" rel="stylesheet" type="text/css"/>
<div id="head">
    <div class="title"></div>
    <s:if test="#session.customer!=null">
        <div class="item"><a href="logoutAction" class="a2">注销</a></div>
        <div class="item"><a href="percenter.jsp" class="a2">welcome, ${customer.account}</a></div>
    </s:if>
    <s:else>
        <div class="item"><a href="register.jsp" class="a2">注册</a></div>
        <div class="item"><a href="login.jsp" class="a2">登录</a></div>
    </s:else>
    <div class="item"><a href="loadModelAction" class="a2">主页</a></div>
</div>