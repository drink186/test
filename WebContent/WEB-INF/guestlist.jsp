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
<script type="text/javascript" src="../js/guestlist.js"></script>

<script>
	
</script>
</head>

<body>
	<form action="guestaction.do?opt=query" method="post">
		<table class="table table-striped">
			<tbody>
				<tr>
					<td>姓名</td>
					<td><input type="text" value="${name}" name="name"
						class="form-control"></td>
					<td>房间</td>
					<td><select id="room" name="room" class="form-control">
							<option value="-1">==客房地址==</option>
					</select>
					<input type="hidden" id="hideRoom" value="${room}"> 
					</td>
					<td><button id="query" type="button">查询</button></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>姓名</th>
					<th>身份证号码</th>
					<th>入住日期</th>
					<th>退房日期</th>
					<th>客房地址</th>
					<th>费用</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty page.content}">
					<c:forEach var="guest" items="${page.content}">
						<tr>
							<td>${guest.name }</td>
							<td>${guest.idcard }</td>
							<td>${guest.inDate }</td>
							<td>${guest.outDate }</td>
							<td>${guest.room.description }</td>
							<td>${guest.amount }</td>
						</tr>
					</c:forEach>
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
				href="javaScript:void(0)">尾页</a>&nbsp;&nbsp; <input type="number"
				min="1" max="${page.totalPage}" value="${page.currentPage }"
				style="width: 40px" name="page"> <input id="go"
				type="button" value="GO">
		</p>
	</form>
</body>

</html>