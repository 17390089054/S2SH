<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示用户信息</title>
</head>
<body>
登录成功!欢迎用户 ${param.username}<br/>
当前用户 ${session.CurUser}<br/>
<a href="second.jsp">下一页</a>
</body>
</html>