<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'depart.jsp' starting page</title>
    
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
  	<form action="${pageContext.request.contextPath}/owner/departController" method="post">
    	发车地点：<input type="text" name="origin" id="name"/><br>
    	发车时间：<input type="date" name="start_time"/> <br>
    	目的地点：<input type="text" name="end_location"><br>
    	最大人数：<input type="text" name="max_peo"><br>
    	总金额：<input type="number" name="total_price"><br>
    	<input type="submit" value="确认发车">
    </form>
    
    <a href="javascript:history.go(-1)" >返回</a>
  
  </body>
</html>
