<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/register.js"></script>
		
	</head>
	

	<body>
		<form class="form-horizontal" role="form" method="post" action="guestaction.do">
			<div class="form-group">
				<label for="g_id" class="col-sm-2 control-label">编号</label>
				<div class="col-sm-5">
					<input type="text" id="id" name="id" class="form-control" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="g_name" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-5">
					<input type="text" pattern="[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*" required class="form-control" id="name" name="name" placeholder="请输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="g_cid" class="col-sm-2 control-label">身份证号码</label>
				<div class="col-sm-5">
					<input type="text" pattern="[\d]{17}[\dxX]{1}" required class="form-control" id="idcard" name="idcard" placeholder="请输入身份证号码">
				</div>
			</div>
			<div class="form-group">
				<label for="g_indate" class="col-sm-2 control-label">入住日期</label>
				<div class="col-sm-5">
					<input type="date" required class="form-control" id="indate" name="indate" placeholder="请输入入住日期">
				</div>
			</div>

			<div class="form-group">
				<label for="g_money" class="col-sm-2 control-label">押金</label>
				<div class="col-sm-5">
					<input type="number" min="0" required class="form-control" id="deposit" name="deposit" >
				</div>
			</div>
			<div class="form-group">
				<label for="g_money" class="col-sm-2 control-label">人数</label>
				<div class="col-sm-5">
					<input type="number" min="1" required class="form-control" id="number" name="number"  value="1">
				</div>
			</div>

			<div class="form-group">
				<label for="g_room" class="col-sm-2 control-label">客房类型</label>
				<div class="col-sm-5">
					<select id="roomType" name="roomType" class="form-control">
						<option value="-1">==客房类型==</option>
						<c:forEach var="roomType" items="${roomTypes}">
							<option value="${roomType.id}">${roomType.name}</option>
						</c:forEach>

					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="g_room" class="col-sm-2 control-label">客房地址</label>
				<div class="col-sm-5">
					<select id="room" name="room" class="form-control">
						<option value="-1">==客房地址==</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<div class="checkbox">
						<label>
     
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<input type="hidden" name="opt" value="add"> 
					<button type="submit" class="btn btn-default">登记</button>
				</div>
			</div>
		</form>
	</body>

</html>