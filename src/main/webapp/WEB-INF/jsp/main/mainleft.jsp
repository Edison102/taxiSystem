<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>无标题文档</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-primary col-md-6 col-md-offset-3">
     <c:if test="${sessionScope.user.isAdmin == 1 }">
                <div >
                    <div >拼车系统管理员</div>
                    <ul >
                        <li ><a href="${pageContext.request.contextPath }/goods/searchgoodsController" target="main">所有商品</a></li>
                        <li ><a href="${pageContext.request.contextPath }/goods/toInStoreController" target="main">商品入库</a></li>
                        <li ><a href="${pageContext.request.contextPath }/goods/toOutStoreController" target="main">商品出库</a></li>
						<li ><a href="${pageContext.request.contextPath }/goods/toAddGoodsController" target="main">新增商品</a></li>
                    </ul>
                </div>
                </c:if>
                <c:if test="${sessionScope.user.isAdmin == 0 }">
                <div >
                    <div >菜单选项</div>
                    <ul >
                        <li ><a href="${pageContext.request.contextPath }/dispatchInfo/toDispatchInfoController" target="main" >查看打车信息</a></li>
                        <li ><a href="${pageContext.request.contextPath }/orders/searchAllController" target="main">查看订单</a></li>
                        <li ><a href="${pageContext.request.contextPath }/owner/toOwnerController" target="main">车主相关</a></li>
                        <li ><a href="${pageContext.request.contextPath }/goodsCart/searchCartController" target="main">个人信息</a></li>
                    </ul>
                </div>
              </c:if>
</div>
</body>
</html>
