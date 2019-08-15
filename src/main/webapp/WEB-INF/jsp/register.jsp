<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

  </head>
  
  <body>
    <form action="user/registerController" method="post">
    	用户名：<input type="text" name="name" id="name"/>${userNameError }<br>
    	密    码：<input type="password" name="password"/> <br>
    	确认密码：<input type="password" name="password2">${passwordError }<br>
    	手机号：<input type="text" name="phone"><br>
    	<input type="submit" value="确认注册">
    </form>
    
    <a href="${pageContext.request.contextPath }/user/toLoginController">返回</a>
  </body>
</html>
