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
	  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <div class="panel panel-primary col-md-6 col-md-offset-3">
	  <div class="panel-heading">
		  <h3 class="panel-title">发车页面</h3>
	  </div>
  	<form action="${pageContext.request.contextPath}/owner/departController" method="post">
    	发车地点：<input type="text" name="origin" id="name" class="form-control"/><br>
    	发车时间：<input type="date" name="start_time" class="form-control"/> <br>
    	目的地点：<input type="text" name="end_location" class="form-control"/><br>
    	最大人数：<input type="text" name="max_peo" class="form-control"/><br>
    	总金额：<input type="number" name="total_price" class="form-control"/><br>
    	<input type="submit" value="确认发车" class="btn btn-success"/>
    </form>
    
    <a href="javascript:history.go(-1)"  class="btn btn-primary">返回</a>
  </div>
  </body>
</html>
