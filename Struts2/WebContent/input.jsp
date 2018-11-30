<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息采集</title>
</head>
<body>
	<form action="user.action" method="post" >
		用户名:<input type="text" name="userName"/><br/>
		地址:<input type="text" name="address"/><br/>
		电话:<input type="text" name="telephone"/><br/>
		邮箱:<input type="text" name="email"/><br/>
		<input type="submit" value=" 提 交 "/><br/>
	</form>
</body>
</html>