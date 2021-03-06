<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--加入该标签手动开启el功能--%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理--学院管理</title>
<%@include file="../include/head.jsp" %>
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
								<a href="../admin/school" class="layui-this" >学校管理</a>
							</dd>
							<dd>
								<a href="javascript:;">学院管理</a>
							</dd>
							<dd>
								<a href="javascript:;">专业管理</a>
							</dd>
							<dd>
								<a href="<%=basePath %>admin/user">用户管理</a>
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
	<h1>${school.name }--学院列表</h1>
				<div style="width: 90%; margin: 0 auto;">
					
					<div>
					<a href="addSchool.jsp" class="layui-btn layui-btn-normal">新增学院</a>
					</div>
					
					<table class="layui-table">
						<colgroup>
							<col width="50">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>序号</th>
								<th>学校名字</th>
								<th>学校地址</th>
								<th>学校电话</th>
								<th>学院名字</th>
								<th>学院地址</th>
								<th>学院电话</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${colleges }" var="college" varStatus="status">
								<tr>
									<td>${status.index+1 }</td>
									<td>${college.school.name }</td>
									<td>${college.school.address }</td>
									<td>${college.school.tel }</td>
									<td>${college.name }</td>
									<td>${college.address }</td>
									<td>${college.tel }</td>
									<td>
									<a onclick="addMajor(${college.id },'${college.school.name }','${college.name }')" class="layui-btn layui-btn-normal">新增专业</a>
									<a href="#" class="layui-btn layui-btn-normal">修改</a>
									<a href="#" class="layui-btn layui-btn-normal">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
		//引入layer弹出层
		layui.use('layer', function(){
			  var layer = layui.layer;
			}); 
		//新增专业
		function addMajor(collegeId,schoolName,collegeName){
			layer.open({
				  type: 2,
				  title: '为'+schoolName +"--" +collegeName+'新增专业',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['600px', '400px'],
				  content: 'major?method=add&collegeId='+collegeId //iframe的url
				}); 
		}
	</script>
</body>
</html>