<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery.min.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
	</head>
   
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
						<li>
							<a href="#">
								<i class="glyphicon glyphicon-th-large"></i> 首页
							</a>
						</li>
						<li>
							<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-cog"></i> 系统管理

								<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
							</a>
							<ul id="systemSetting" class="nav nav-list secondmenu collapse" style="height: 0px;">
								<li>
									<a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a>
								</li>
								<li>
									<a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a>
								</li>
								<li>
									<a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a>
								</li>
								<li>
									<a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a>
								</li>
								<li>
									<a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#configSetting" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-credit-card"></i> 住宿管理
								<span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
							</a>
							<ul id="configSetting" class="nav nav-list secondmenu collapse in">
								<li class="active">
									<a href="guestaction.do?opt=url" target="rightFrame"><i class="glyphicon glyphicon-globe"></i>&nbsp;客人登记</a>
								</li>
								<li>
									<a href="guestaction.do?opt=query" target="rightFrame"><i class="glyphicon glyphicon-star-empty"></i>&nbsp;入住查询</a>
								</li>

							</ul>
						</li>

						<li>
							<a href="#disSetting" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-globe"></i> 客房管理
								<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
							</a>
							<ul id="disSetting" class="nav nav-list secondmenu collapse">
								<li>
									<a href="roomaction.do?opt=list" target="rightFrame"><i class="glyphicon glyphicon-th-list"></i>&nbsp;客房信息</a>
								</li>
								<li>
									<a href="roomaction.do?opt=addurl" target="rightFrame"><i class="glyphicon glyphicon-th-list"></i>&nbsp;添加客房</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#dicSetting" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-bold"></i> 字典配置
								<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
							</a>
							<ul id="dicSetting" class="nav nav-list secondmenu collapse">
								<li>
									<a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;关键字配置</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">
								<i class="glyphicon glyphicon-fire"></i> 关于系统
								<span class="badge pull-right">1</span>
							</a>
						</li>

					</ul>
				</div>

			</div>
		</div>
	</body>

</html>