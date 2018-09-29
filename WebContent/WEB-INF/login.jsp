<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>

<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">用户登录</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" method="post"
				action="">
				<div class="form-group">
					<h4 style="color:red">${err}</h4>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputName"
							name="inputName" value="${name }" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword"
							name="inputPassword" value="${password }" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label"></label>
					<div class="checkbox">
						<label> <input type="checkbox" name="remember" value="1">记住用户
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label"></label>
					<div id="myButtons1" class="bs-example">
						<input type="hidden" value="login" name="opt">
						<button type="submit" class="btn btn-primary">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>


</body>
</html>