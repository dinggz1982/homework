<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/head.jsp"%>
<meta charset="UTF-8">
<title>导入用户</title>
<link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body class="layui-layout-body">

	<!-- 内容主体区域 -->
	<div style="padding: 15px;">

		<div style="width: 80%; margin: 0 auto;">
			<!-- 新增导入用户学校的表单 -->
			<form class="layui-form" action="school" method="post">
				<input type="hidden" name="method" value="add"> <input
					type="hidden" name="id" value="${school.id }">
				<div class="layui-form-item">
					<label class="layui-form-label">学校名字</label>
					<div class="layui-input-block">
						<select name="school" id="school">
							<c:forEach items="${schools }" var="school">
								<option value="${school.id }">${school.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">导入用户</label>
					<div class="layui-input-block">
						<button type="button" class="layui-btn layui-btn-normal" id="file">选择文件</button>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" id="upload">开始上传</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="../static/layui/layui.js"></script>
	<script>
	layui.use(['element','upload','form'], function() {
		var form = layui.form;
		//处理用户上传
		 var $ = layui.jquery,upload = layui.upload;
		 var loading;
		//选完文件后不自动上传
		 var uploadInst = upload.render({
		    elem: '#file'
		    ,data:{
		    	school_id:$("#school option:selected").val()
		    }
		    ,url: '<%=basePath%>admin/user?method=fileUpload',
				accept : 'file' //普通文件
				,
				exts : 'xls|excel|xlsx' //只允许上传压缩文件
				,
				auto : false
				//,multiple: true
				,
				bindAction : '#upload',
				before : function(obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
					uploadInst.config.data.school_id = $("#school option:selected").val();
					loading = layer.load(1, {
						shade : [ 0.3, '#000' ]
					});
				},
				done : function(res) {
					layer.close(loading);
					if(res.status=="success"){
						layer.msg("上传成功！");
					}else{
						layer.msg("上传失败！");
					}
					
				}
			});
		});
	</script>
</body>
</html>