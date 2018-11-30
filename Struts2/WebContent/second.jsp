<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示用户信息</title>
</head>
<body>
请求中的用户信息: ${param.username}<br/>
Session中的用户信息: ${session.CurUser}<br/>
</body>
</html>