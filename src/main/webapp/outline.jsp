<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/head.jsp" %>
<title>课程大纲</title>
  <link rel="stylesheet" href="<%=basePath %>static/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="<%=basePath %>static/zTree_v3/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="<%=basePath %>static/zTree_v3/js/jquery.ztree.core.js"></script>
</head>
<body>
<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</body>
<SCRIPT type="text/javascript">
		<!--
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		var zNodes =${tree};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		//-->
	</SCRIPT>
</html>