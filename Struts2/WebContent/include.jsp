<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 标签示例</title>
</head>
<body>
	<h1>我包含了bean.jsp</h1>
	<s:include value="bean.jsp"></s:include>
</body>
</html>