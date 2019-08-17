<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'applyOwner.jsp' starting page</title>
    
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
  	<form action="${pageContext.request.contextPath}/owner/applyOwnerController" method="post">
    	身份证号：<input type="text" name="origin" id="id_num"/><br>
    	车牌号：<input type="text" name="lic_num"><br>
    	车型：<input type="text" name="model"><br>
    	<input type="submit" value="确认申请">
    </form>
    
    <a href="javascript:history.go(-1)" >返回</a>
  </body>
</html>
