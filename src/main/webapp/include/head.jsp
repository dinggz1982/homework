<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
	+":"+request.getServerPort()+path+"/";

%>
<link rel="stylesheet" href="<%=basePath %>static/layui/css/layui.css">
<script src="<%=basePath %>static/layui/layui.js"></script>
 