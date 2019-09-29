<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
    </script>

    <script>
        $(document).ready(function () {
            $("input#name").blur(function () {
                var name = document.getElementById("name").value;
                $.post("user/verifyUserNameController",{name:name},function (data, status) {
                    $("label#nameMessage").text(data.message);
                    if (data.success) {
                        $("label#nameMessage").css("color", "green");
                    } else {
                        $("label#nameMessage").css("color", "red");
                    }
                });
            });
        });

        $(document).ready(function () {
            $("input#password2").blur(function () {
                var password = document.getElementById("password").value;
                var password2 = document.getElementById("password2").value;
                $.ajax({
                    url: "user/verifyPasswordController", //后台查询验证的方法
                    data: {
                        "password": password,
                        "password2":password2
                    }, //携带的参数
                    type: "post",
                    success: function (data) {
                        $("label#passwordMessage").text(data.message);
                        if (data.success) {
                            $("label#passwordMessage").css("color", "green");
                        } else {
                            $("label#passwordMessage").css("color", "red");
                        }
                    }
                });
            });
        });

        $(document).ready(function () {
            $("input#phone").blur(function () {
                var phone = document.getElementById("phone").value;
                $.ajax({
                    url: "user/verifyPhoneFormatController", //后台查询验证的方法
                    data: {
                        "phone": phone
                    }, //携带的参数
                    type: "post",
                    success: function (data) {
                        $("label#phoneMessage").text(data.message);
                        if (data.success) {
                            $("label#phoneMessage").css("color", "green");
                        } else {
                            $("label#phoneMessage").css("color", "red");
                        }
                    }
                });
            });
        });
    </script>

</head>

<body>
<div class="panel panel-primary col-md-6 col-md-offset-3">
    <div class="panel-heading">
        <h3 class="panel-title">注册用户</h3>
    </div>

    <form action="user/registerController" method="post">
        <label id="nameMessage" style=""></label><br>
        用户名：<input type="text" name="name" id="name" class="form-control"/>${userNameError }<br>
        密 码：<input type="password" name="password" id="password" class="form-control"/> <br>
        <label id="passwordMessage" style=""></label><br>
        确认密码：<input type="password" name="password2" id="password2" class="form-control"/>${passwordError }<br>
        <label id="phoneMessage" style=""></label><br>
        手机号：<input type="text" name="phone" id="phone" class="form-control"/>${phoneError }<br>
        <input type="submit" value="确认注册" class="btn btn-success"/>
    </form>

    <a href="${pageContext.request.contextPath }/user/toLoginController" class="btn btn-primary">返回</a>

</div>
</body>
</html>
