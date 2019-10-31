<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增学院</title>
<link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<!-- 内容主体区域 -->
	<div style="padding: 15px;">
		<div style="width: 80%; margin: 0 auto;">
			<!-- 新增学校的表单 -->
			<form class="layui-form" action="college?method=addAction" method="post">
				<input type="hidden" name="method" value="add">
				<div class="layui-form-item">
					<label class="layui-form-label">学院名字</label>
					<div class="layui-input-block">
						<input type="text" name="name" required lay-verify="required"
							placeholder="请输入学院名字" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">学院地址</label>
					<div class="layui-input-block">
						<input type="text" name="address" required lay-verify="required"
							placeholder="请输入学院地址" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">学院电话</label>
					<div class="layui-input-block">
						<input type="text" name="tel" required lay-verify="required"
							placeholder="请输入学院电话" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
									<label class="layui-form-label">选择学校</label>
									<div class="layui-input-block">
				<select  name="schoolId">
					<c:forEach items="${schools }" var="school">
						<c:choose>
							<c:when test="${school.id == schoolId}">
								<option selected="selected" value="${school.id }">${school.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${school.id }">${school.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
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