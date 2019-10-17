<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增学校</title>
<link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">教育技术181-作业管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">管理设置</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="../static/images/tx.jpg" class="layui-nav-img"> 管理员
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">管理设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" class="layui-this">学校管理</a>
							</dd>
							<dd>
								<a href="javascript:;">学院管理</a>
							</dd>
							<dd>
								<a href="javascript:;">专业管理</a>
							</dd>
							<dd>
								<a href="">教师管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">作业管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">发布作业</a>
							</dd>
							<dd>
								<a href="javascript:;">批阅作业</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">用户日志</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">

				<div style="width: 80%; margin: 0 auto;">
					<!-- 新增学校的表单 -->
					<form class="layui-form" action="school" method="post">
						<input type="hidden" name="method" value="add">
						<div class="layui-form-item">
							<label class="layui-form-label">学校名字</label>
							<div class="layui-input-block">
								<input type="text" name="name" required lay-verify="required"
									placeholder="请输入学校名字" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">学校地址</label>
							<div class="layui-input-block">
								<input type="text" name="address" required lay-verify="required"
									placeholder="请输入学校地址" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">学校电话</label>
							<div class="layui-input-block">
								<input type="text" name="tel" required lay-verify="required"
									placeholder="请输入学校电话" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© 广州大学-教育技术181-作业管理系统
		</div>
	</div>
	<script src="../static/layui/layui.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			form.on('submit(formDemo)', function(data) {
				//直接提交
			});
		});
	</script>
</body>
</html>