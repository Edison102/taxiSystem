<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'orders.jsp' starting page</title>


  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div class="panel panel-body">
      <div class="panel-heading">
          <h3 class="panel-title">订单信息</h3>
    <table align="left"  class="table table-striped">
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
                     <c:when test="${empty p.dataList}">
                       <tr>
	                        <td colspan="7" align="center">暂无数据！</td>
	                        
                        </tr>
                    </c:when>
                    <c:otherwise>
                     <c:forEach items="${p.dataList}" var="order">
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

          <a href="${pageContext.request.contextPath }/orders/searchByPageController?page=1">首页</a>&nbsp;
          <c:if test="${p.pageNo ne 1}">
                  <a href="${pageContext.request.contextPath }/orders/searchByPageController?page=${p.pageNo-1}">上一页</a>
              </c:if>&nbsp;
              当前页：${p.pageNo} |  ${p.pages} &nbsp;
              <c:if test="${p.pageNo < p.pages}">
                  <a href="${pageContext.request.contextPath }/orders/searchByPageController?page=${p.pageNo+1}">下一页</a>
              </c:if>&nbsp;
          <a href="${pageContext.request.contextPath }/orders/searchByPageController?page=${p.pages}">尾页</a>


      </div>
  </div>
  </body>
</html>
