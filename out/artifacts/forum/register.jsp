<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册页面</title>
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <link href="css/regist.css" rel="stylesheet">

    <!-- Custom-Files -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //Custom-Files -->

</head>
<body>
<div class="container">
    <!-- 注册页面左图 -->
    <div class="left">
        <div class="w3_testimonials_grids">
            <section class="slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <div class="w3_testimonials_grid">
                                <img src="image/timg.jpg" alt=" " class="img-responsive" />

                            </div>
                        </li>
                        <li>
                            <div class="w3_testimonials_grid">
                                <img src="image/timg2.jpg" alt=" " class="img-responsive" />

                            </div>
                        </li>
                        <li>
                            <div class="w3_testimonials_grid">
                                <img src="image/timg3.jpg" alt=" " class="img-responsive" />

                            </div>
                        </li>
                    </ul>
                </div>
            </section>

        </div>
    </div>

    <!-- 注册栏 -->
    <div class="right">
        <div class="reg-label">
            <label>用 户 注 册</label>
            <hr>
        </div>
        <div class="reg-box">
            <form action="<%=request.getContextPath()%>/servlet/UserServlet"
                  id="formId" class="reg-form" method="POST">
                <div>
                    <tr>
                        <td><input type="text" name="Username" id="InputUsername"
                                   placeholder="用户名" onblur="InputUsernameBlur()"></td>
                        <td><label id="errorName"></label></td>
                    </tr>
                </div>
                <div>
                    <tr>
                        <td><input type="password" name="Password"
                                   id="InputPassword" placeholder="密码" onblur="InputPasswordBlur()"></td>
                        <td><label id="errorPassword"></label></td>
                    </tr>
                </div>
                <div>
                    <tr>
                        <td><input type="password" name="Repassword"
                                   id="InputRepassword" placeholder="确认密码"
                                   onblur="InputRepasswordBlur()"></td>
                        <td><label id="errorRepassword"></label></td>
                    </tr>
                </div>
                <div>
                    <tr>
                        <td><input type="email" name="E-mail" id="InputEmail"
                                   placeholder="电子邮箱" onblur="InputEmailBlur()"></td>
                        <td><label id="errorEmail"></label></td>
                    </tr>
                </div>
                <div class="reg-sub">
                    <input id="submitButton" type="button" onclick="checkForm()"
                           value="免费注册">
                </div>
            </form>
        </div>
    </div>
    <div class="bottom">
        <label>© 浙江工业大学软件工程 16011602</label>
    </div>
</div>
<!-- regist.js -->
<script type="text/javascript" charset="UTF-8" src="js/regist.js"></script>
</body>
</html>
