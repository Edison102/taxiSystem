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
          <h3 class="panel-title">待审车主</h3>
    <table align="left"  class="table table-striped">
                    <tr >
                        <th>用户编号</th>
                        <th>身份证号</th>
                        <th>车牌号</th>
                        <th>车型</th>
                        <th>是否通过</th>
                    </tr>
                    
                    <c:choose>
                     <c:when test="${empty p.dataList}">
                       <tr>
	                        <td colspan="5" align="center">暂无数据！</td>
	                        
                        </tr>
                    </c:when>
                    <c:otherwise>
                     <c:forEach items="${p.dataList}" var="owner">
                       <tr>
	                        <td>${owner.uid }</td>
	                        <td>${owner.id_num }</td>
	                        <td>${owner.lic_num }</td>
	                        <td>${owner.model }</td>
	                        <td><a href="${pageContext.request.contextPath}/admin/auditJudgmentController?pass=1&uid=${owner.uid}">通过</a>/
                            <a href="${pageContext.request.contextPath}/admin/auditJudgmentController?pass=0&uid=${owner.uid}">不通过</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
                   </table>

          <a href="${pageContext.request.contextPath }/admin/searchPendingByPageController?page=1">首页</a>&nbsp;
          <c:if test="${p.pageNo ne 1}">
                  <a href="${pageContext.request.contextPath }/admin/searchPendingByPageController?page=${p.pageNo-1}">上一页</a>
              </c:if>&nbsp;
              当前页：${p.pageNo} |  ${p.pages} &nbsp;
              <c:if test="${p.pageNo < p.pages}">
                  <a href="${pageContext.request.contextPath }/admin/searchPendingByPageController?page=${p.pageNo+1}">下一页</a>
              </c:if>&nbsp;
          <a href="${pageContext.request.contextPath }/admin/searchPendingByPageController?page=${p.pages}">尾页</a>


      </div>
  </div>
  </body>
</html>
