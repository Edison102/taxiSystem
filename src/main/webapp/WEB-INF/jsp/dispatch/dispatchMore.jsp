<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'dispatchMore.jsp' starting page</title>

  </head>
  
  <body>
   <h3>发车详细信息</h3>
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
 出发地点：${dispatchInfo.origin }<br>
 发车时间：${dispatchInfo.start_time }<br>
 目的地点：${dispatchInfo.end_location }<br>
 已有人数：${dispatchInfo.num_peo }<br>
 最大人数：${dispatchInfo.max_peo }<br>
 总共价钱：${dispatchInfo.total_price}<br>
 是否结束：<c:choose>
		 <c:when test="${dispatchInfo.is_over eq 0}">
		   	未结束
	     </c:when>
	     <c:otherwise>
	                已结束
	    </c:otherwise>
	    </c:choose>
<br><br>
<c:if test="${dispatchInfo.num_peo <  dispatchInfo.max_peo  and dispatchInfo.is_over ne 1 }">
<form action="${pageContext.request.contextPath}/dispatchInfo/aboardController?id=${dispatchInfo.id}" method="post">
	<input type="submit" value="确认上车">${aboardError }
</form>
</c:if>
<a href="javascript:history.go(-1)" >返回</a>
  </body>
</html>
