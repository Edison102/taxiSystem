<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'orders.jsp' starting page</title>

  </head>
  
  <body>
    <table align="left">
                    <tr >
                        <th>订单编号</th>
                        <th>发车地点</th>
                        <th>上车时间</th>
                        <th>目的地点</th>
                        <th>要付金额</th>
					    <th>是否支付</th>
					    <th>支付跳转</th>
                   
                    </tr>
                    
                    <c:choose>
                     <c:when test="${empty orders}">
                       <tr>
	                        <td colspan="7" align="center">暂无数据！</td>
	                        
                        </tr>
                    </c:when>
                    <c:otherwise>
                     <c:forEach items="${orders}" var="order">
                       <tr>
	                        <td>${order.id }</td>
	                        <td>${order.origin }</td>
	                        <td>${order.start_time }</td>
	                        <td>${order.end_location }</td>
	                        <td>${order.payment }</td>
	                        <td>
	                        <c:choose>
	                        <c:when test="${order.is_pay eq 0}">
	                       		 未支付
	                        </c:when>
	                        <c:otherwise>
	                            	已支付
	                        </c:otherwise>
	                        </c:choose>
	                        </td>
	                        <td><a href="${pageContext.request.contextPath}/orders/ordersMoreController?id=${order.id}">去支付</a></td>
                        </tr>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
                   </table>
  </body>
</html>
