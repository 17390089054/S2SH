<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="login5.action" method="post" name="logForm">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" size="15"/></td>
			</tr>		
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" size="15"/></td>
			</tr>		
			<tr>
				<td colspan="2"><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>
</body>
</html>