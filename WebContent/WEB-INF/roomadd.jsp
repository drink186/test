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
<script type="text/javascript" src="../js/roomadd.js"></script>

</head>


<body>
	<form class="form-horizontal" role="form" method="post"
		action="roomaction.do">
		<div class="form-group">
			<label for="g_id" class="col-sm-2 control-label">编号</label>
			<div class="col-sm-5">
				<input type="text" id="id" name="id" 
				 value="${room.id}" class="form-control" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="g_name" class="col-sm-2 control-label">描述</label>
			<div class="col-sm-5">
				<input type="text"  required class="form-control"
					 value="${room.description}" id="description" name="description" placeholder="请输入门牌号">
			</div>
		</div>

		<div class="form-group">
			<label for="g_room" class="col-sm-2 control-label">客房类型</label>
			<div class="col-sm-5">
				<select id="roomType" name="roomType" class="form-control"
					style="width: 270px; float: left">
					<option value="-1">==客房类型==</option>
					<c:if test="${not empty roomTypes }">
						<c:forEach var="roomType" items="${roomTypes }">
							<option ${roomType.id eq room.roomType.id?'selected':''} value="${roomType.id }">${roomType.name }</option>
						</c:forEach>
					</c:if>
				</select>
				<button id="new" type="button" class="btn btn-default"
					style="margin-left: 5px; float: left">新建</button>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<div class="checkbox">
					<label>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-5">
								<input type="hidden" name="opt" value="${opt}">
								<button id="add" type="button" class="btn btn-default">保存</button>
							</div>
						</div>
	</form>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新建客房类型</h4>
				</div>
				<div class="modal-body">
					<!-- 表单开始 -->
					<div class="form-group">
						<label for="g_id" class="col-sm-2 control-label">编号</label>
						<div class="col-sm-5">
							<input type="number" min="1" id="id" name="id" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="g_name" class="col-sm-2 control-label">类型</label>
						<div class="col-sm-5">
							<input type="text" pattern="" required class="form-control"
								id="name" name="name" placeholder="请输入类型名称">
						</div>
					</div>
					<div class="form-group">
						<label for="g_id" class="col-sm-2 control-label">床位</label>
						<div class="col-sm-5">
							<input type="number" min="1" id="beds" name="beds" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="g_id" class="col-sm-2 control-label">单价</label>
						<div class="col-sm-5">
							<input type="text" id="price" name="price" class="form-control">
						</div>
					</div>
					<!-- 表单结束 -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="ok" type="button" class="btn btn-primary">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>

</html>