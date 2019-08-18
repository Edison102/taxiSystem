<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'dispatchMore.jsp' starting page</title>
      <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
      <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <div class="panel panel-primary col-md-6 col-md-offset-3">
   <h3>订单支付</h3>
   ---------------------------------------------------------<br>
 <c:choose>
 <c:when test="${orders.is_pay eq 1}">
 <h4>您已支付过此账单</h4>
 </c:when>
 <c:otherwise>
<c:choose>
	<c:when test="${orders.dispatchInfo.is_over eq 0}">
		 <h4>行程尚未结束</h4>  
 	</c:when>
	<c:otherwise>
	                 此次行程需付金额：${orders.payment}<br>
  请为此次出行的满意程度打分:
   <form action="${pageContext.request.contextPath}/orders/topayController?oid=${orders.id}&uid=${orders.dispatchInfo.uid}" method="post">
  <select name="score" id="score">
  	<option selected="selected">10</option>
  	<option>9</option>
  	<option>8</option>
  	<option>7</option>
  	<option>6</option>
  	<option>5</option>
  	<option>4</option>
  	<option>3</option>
  	<option>2</option>
  	<option>1</option>
  </select>
  <br>
       <br>
	<input type="submit" value="确认提交" class="btn btn-success"/>
</form>
	</c:otherwise>
</c:choose>
<br>
  
</c:otherwise>
</c:choose>
  </div>
<br>
  <div class="panel panel-primary col-md-6 col-md-offset-3">
   <h3>订单详细信息</h3>
   --------------------------------------------------------<br>
   车主信息：
  <br>     <br>
  姓名：${owner.user.name }<br>
  电话:${owner.user.phone }<br>
  车牌号:${owner.lic_num }<br>
  车型：${owner.model }<br>
 获得评分：${owner.evaluation.score }<br>
 评论人数：${owner.evaluation.num_peo }<br>
  ----------------------------------------------------------<br>
  发车信息：
  <br><br>
 出发地点：${orders.dispatchInfo.origin }<br>
 发车时间：${orders.dispatchInfo.start_time }<br>
 目的地点：${orders.dispatchInfo.end_location }<br>
 已有人数：${orders.dispatchInfo.num_peo }<br>
 最大人数：${orders.dispatchInfo.max_peo }<br>
 总共价钱：${orders.dispatchInfo.total_price}<br>
<br>

  <br>
<a href="javascript:history.go(-1)" class="btn btn-primary">返回</a>
  </div>
  </body>
</html>
