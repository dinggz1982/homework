<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<style type="text/css">
tr {
	line-height: 40px;
}
</style>
</head>
<body>
	<h1 style="text-align: center; color: red;">欢迎注册</h1>
	<form action="register" method="post">
		<table
			style="width: 50%; margin: 0 auto; text-align: center; font-size: 28px;">
			<tr>
				<td width="50%" style="text-align: right;">用户名：</td>
				<td width="50%" style="text-align: left;"><input type="text"
					name="username"></td>
			</tr>
			<tr>
				<td width="50%" style="text-align: right;">密码：</td>
				<td width="50%" style="text-align: left;"><input
					type="password" name="password"></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2"><input
					type="submit" value="提交" style="font-size: 28px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>