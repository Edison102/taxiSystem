<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dispatch.jsp' starting page</title>
    
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
     <div class="panel panel-body">
      <div class="panel-heading">
     <h3>发车信息界面</h3>
     <form action="${pageContext.request.contextPath }/dispatchInfo/searchController" method="post">
     	目的地：  <input type="text" name="dispatch"  /> <input type="submit" class="btn btn-success" value="确定"/>
     </form>
     <br>
     <form action="${pageContext.request.contextPath }/dispatchInfo/searchAllController" method="post">
     	<input type="submit" class="btn btn-info" value="查看所有发车信息" />
         <input type="submit"  class="btn btn-inverse" value="取消查看" name="cancel"/>
     </form>
   <%--  <form action="${pageContext.request.contextPath }/dispatchInfo/noSearchController" method="post">
     	<input type="submit"  class="btn btn-inverse" value="取消查看" />
     </form>--%>
          <br>

             <h3 class="panel-title" style="color:black">查询结果</h3>
     
     
    
                <%--<h3 style="text-align:center;color:black">查询结果</h3>--%>
               
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
					    <th>查看详情</th>
                   
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
	                        <td><a href="${pageContext.request.contextPath}/dispatchInfo/dispatchInfoMoreController?id=${dis.id}">查看</a></td>
                        </tr>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
                   </table>
      </div>
     </div>
  </body>
</html>
