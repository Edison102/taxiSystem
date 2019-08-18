<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  </head>
  
  <body>
  <div class="panel panel-primary col-md-6 col-md-offset-3">
      <div class="panel-heading">
          <h3 class="panel-title">系统登录</h3>
      </div>
      <form action="${pageContext.request.contextPath}/user/loginController" method="post">
          <p style="color: red">${loginError }</p>
          用户名<input class="form-control" type="text" name="name" /><br>
          密码：<input class="form-control" type="password" name="password"/><br>
          <button type="submit" class="btn btn-success">提交</button>
      </form>
      <br>
      <a href="${pageContext.request.contextPath}/user/toRegisterController" class="btn btn-info">注册</a>
  </div>
  </body>
</html>
