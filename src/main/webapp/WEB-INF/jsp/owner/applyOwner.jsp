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
	  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <div class="panel panel-primary col-md-6 col-md-offset-3">
	  <div class="panel-heading">
		  <h3 class="panel-title">申请车主</h3>
	  </div>
  	<form action="${pageContext.request.contextPath}/owner/applyOwnerController" method="post">
    	身份证号：<input type="text" name="origin" id="id_num" class="form-control"/><br>
    	车牌号：<input type="text" name="lic_num" class="form-control"/><br>
    	车型：<input type="text" name="model" class="form-control"/><br>
    	<input type="submit" value="确认申请" class="btn btn-success"/>
    </form>
    
    <a href="javascript:history.go(-1)" class="btn btn-primary">返回</a>
  </div>
  </body>
</html>
