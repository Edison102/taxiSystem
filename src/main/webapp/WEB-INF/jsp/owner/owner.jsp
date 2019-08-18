<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'owner.jsp' starting page</title>
	  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div class="panel panel-body">
	  <div class="panel-heading">
    <c:choose>
    	<c:when test="${empty owner  or (owner.is_pass ne 1)}">
	    
	    	<c:choose>
	    		<c:when test="${empty owner }">
	    			<h4>您现在还不是车主</h4>
	    		</c:when>
	    		<c:when test="${owner.is_audit ne 1 }">
	    			<h4>申请已发出，请耐心等待审核</h4>
	    		</c:when>
	    		<c:otherwise>
	    			<h4>抱歉，审核未通过，请重新申请</h4>
	    		</c:otherwise>
	    	</c:choose>
	    	
    		<c:if test="${empty owner  or (owner.is_audit eq 1)}">
    		<form action="${pageContext.request.contextPath }/owner/toApplyOwnerController" method="post">
    			<input type="submit" value="申请车主" class="btn btn-success" />
    		</form>
    		</c:if>
    	</c:when>
    	
    	<c:otherwise>
    		<h4>尊敬的车主，欢迎您</h4>
    		<form action="${pageContext.request.contextPath }/owner/searchDispatchInfoController" method="post">
    			<input type="submit" value="查看发车" class="btn btn-info" />
				<input type="submit" value="取消查看" class="btn btn-inverse" name="cancel"/>
    		</form>
    		<form action="${pageContext.request.contextPath }/owner/toDepartController" method="post">
    			<input type="submit" value="我要发车" class="btn btn-success"/>
    		</form>
    		<table align="left" class="table table-striped">
                    <tr >
                        <th>发车编号</th>
                        <th>发车地点</th>
                        <th>上车时间</th>
                        <th>目的地点</th>
					    <th>已有人数</th>
                        <th>最大人数</th>
                        <th>总金额</th>
					    <th>是否结束</th>
					    <th>结束行程</th>
                   
                    </tr>
                    
                    <c:choose>
                     <c:when test="${empty dispatchInfos}">
                       <tr>
	                        <td colspan="9" align="center">暂无数据！</td>
	                        
                        </tr>
                    </c:when>
                    <c:otherwise>
                     <c:forEach items="${dispatchInfos}" var="dis">
                       <tr>
	                        <td>${dis.id }</td>
	                        <td>${dis.origin }</td>
	                        <td>${dis.start_time }</td>
	                        <td>${dis.end_location }</td>
	                        <td>${dis.num_peo }</td>
	                        <td>${dis.max_peo}</td>
	                        <td>${dis.total_price }</td>
	                        <td>
	                        <c:choose>
	                        <c:when test="${dis.is_over eq 0}">
	                       		 未结束
	                        </c:when>
	                        <c:otherwise>
	                            	已结束
	                        </c:otherwise>
	                        </c:choose>
	                        </td>
	                        <td><a href="${pageContext.request.contextPath}/dispatchInfo/finishController?id=${dis.id}">结束</a></td>
                        </tr>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
                   </table>
    		
    	</c:otherwise>
    </c:choose>
	  </div>
  </div>
  </body>
</html>
