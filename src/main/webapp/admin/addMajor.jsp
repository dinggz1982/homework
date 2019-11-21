<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增专业</title>
<link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<div style="width: 80%; margin: 0 auto;">
					<!-- 新增专业学校的表单 -->
					<form class="layui-form" action="major" method="post">
						<input type="hidden" name="method" value="addAction">
						<input type="hidden" name="collegeId" value="${collegeId }"> 
						<div class="layui-form-item">
							<label class="layui-form-label">专业名字</label>
							<div class="layui-input-block">
								<input type="text" name="name" required lay-verify="required" value="${school.name }"
									placeholder="请输入专业名字" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">专业简介</label>
							<div class="layui-input-block">
								<textarea rows="" cols="" name="description" style="width: 344px; height: 94px;">
								
								</textarea>
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