<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bean标签示例</title>
</head>
<body>
	<s:bean name="com.wrf.struts.action.Person">
		<s:param name="name" value="'张先生'"/>
		<s:param name="sex" value="'男'"/>
		<s:param name="age" value="31"/>
		姓名:<s:property value="name"/><br/>
		性别:<s:property value="sex"/><br/>
		年龄:<s:property value="age"/><br/>
	</s:bean>
</body>
</html>