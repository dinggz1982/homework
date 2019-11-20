<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--加入该标签手动开启el功能--%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理--用户管理</title>
<%@include file="../include/head.jsp"%>
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
								<a href="<%=basePath%>admin/school">学校管理</a>
							</dd>
							<dd>
								<a href="<%=basePath%>admin/college">学院管理</a>
							</dd>
							<dd>
								<a href="javascript:;">专业管理</a>
							</dd>
							<dd>
								<a href="<%=basePath%>admin/user" class="layui-this">用户管理</a>
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
				<h1
					style="margin: 0 auto; padding-bottom: 20px; text-align: center;">用户列表</h1>
				<div style="width: 90%; margin: 0 auto;">

					<div class="layui-upload">
						<a onclick="addUser()" class="layui-btn layui-btn-normal">批量导入用户</a>
					</div>
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
							<th>用户名</th>
							<th>真实姓名</th>
							<th>性别</th>
							<th>类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list }" var="user" varStatus="status">
							<tr>
								<td>${status.index+1 }</td>
								<td>${user.username }</td>
								<td>${user.realname }</td>
								<td>${user.gender }</td>
								<td>${user.type }</td>
								<td><a onclick="" class="layui-btn layui-btn-normal">作业</a>
									<a onclick="" class="layui-btn layui-btn-normal">修改</a> <a
									onclick="" class="layui-btn layui-btn-normal">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="page"></div>
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
		layui.use(['element','laypage','upload'], function() {
			
			//处理用户上传
			 var $ = layui.jquery,upload = layui.upload;
			//选完文件后不自动上传
			  upload.render({
			    elem: '#file'
			    ,url: 'user?method=fileUpload'
			    ,accept: 'file' //普通文件
			    ,exts: 'xls|excel|xlsx' //只允许上传压缩文件
			    ,auto: false
			    //,multiple: true
			    ,bindAction: '#upload'
			    ,done: function(res){
			      console.log(res)
			    }
			  });
			var element = layui.element;
			var laypage = layui.laypage;
			 //执行一个laypage实例
			  laypage.render({
			    elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
			    ,count: ${page.total} //数据总数，从服务端得到
			    ,limit:${page.size}
			    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
			    ,curr:${page.currentPage}
			    ,jump: function(obj,first){
		            if (!first) {
		                var size=obj.limit;
		                var pageNum=obj.curr;
		                window.location.href="user?size="+size+"&currentPage="+pageNum;//跳转链接
		            }
		            console.log(obj)
		        }
			  });
		});
		layui.use('layer', function(){
			  var layer = layui.layer;
			});     
		function addCollege(schoolId,schoolName){
			layer.open({
				  type: 2,
				  title: '为'+schoolName + '新增学院',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['600px', '400px'],
				  content: 'college?method=add&schoolId='+schoolId //iframe的url
				}); 
		}
		//新增用户
		function addUser(){
			layer.open({
				  type: 2,
				  title: '批量导入用户',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['600px', '400px'],
				  content: 'user?method=import', //iframe的url
				  end:function(){
					  location.reload();
				  }
				}); 
		}
		//修改学校
		function editSchool(schoolId){
			layer.open({
				  type: 2,
				  title: '修改学校信息',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['600px', '400px'],
				  content: 'school?method=edit&schoolId='+schoolId //iframe的url
				}); 
		}
		//刪除學校
		function deleteSchool(schoolId){
			layer.confirm('确定删除？', {
				  btn: ['确定','放弃'] //按钮
				}, function(){
				  //以后改成通过ajax删除学校
				  window.location.href='school?method=delete&schoolId='+schoolId;
				}, function(){
				  
				});
		}
	</script>
</body>
</html>