<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/roomlist.js"></script>

</head>

<body>
	<form action="?opt=list" method="post">
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>描述</th>
					<th>入住人数</th>
					<th>状态</th>
					<th>类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty page }">
				   <c:if test="${not empty page.content }">
				     <c:forEach var="room" items="${page.content }" >
				        <tr>
				           <td>${room.description}</td>
				           <td>${room.number}</td>
				           <td>${room.roomState.name}</td>
				           <td>${room.roomType.name}</td>
				           <td><a href="?opt=editurl&roomId=${room.id}">编辑</a></td>
				        </tr>
				     </c:forEach>
				   </c:if> 
				</c:if>
			</tbody>
		</table>
		<p class="text-center">
			显示 <select name="pageSize">
				<option value=5 ${page.pageSize eq 5?"selected":""}>5</option>
				<option value=10 ${page.pageSize eq 10?"selected":""}>10</option>
				<option value=15 ${page.pageSize eq 15?"selected":""}>15</option>
				<option value=20 ${page.pageSize eq 20?"selected":""}>20</option>
			</select> 条/页&nbsp;&nbsp; 共${page.count}条记录/<totalpage>${page.totalPage}</totalpage>页&nbsp;&nbsp; <a
				id="first" href="javaScript:void(0)">首页</a>&nbsp;&nbsp; <a id="prev"
				href="javaScript:void(0)">上一页</a>&nbsp;&nbsp; <a id="next"
				href="javaScript:void(0)">下一页</a>&nbsp;&nbsp; <a id="last"
				href="javaScript:void(0)">尾页</a>&nbsp;&nbsp; 
				<input type="number"
				min="1" max="${page.totalPage}" value="${page.currentPage }"
				style="width: 40px" name="page"> <input id="go"
				type="button" value="GO">
		</p>
	</form>
</body>

</html>