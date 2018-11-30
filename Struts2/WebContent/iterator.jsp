<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>iterator标签示例</title>
</head>
<body>
<s:bean name="com.wrf.struts.action.NumberAction">
	<!--循环输出1-10,实现for循环 -->
	<s:iterator var="num" begin="1" end="10" step="1">
		<s:property value="#num"/>
	</s:iterator>
</s:bean>
</body>
</html>