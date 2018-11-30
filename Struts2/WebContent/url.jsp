<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url标签示例</title>
</head>
<body>
	<h3 align="left">url标签使用范例</h3>
	<h3 align="left">action由value属性指定,不显示全路径URL</h3>
	<p>
		<s:url value="actionTag.action">
			<s:param name="param" value="'frank'"/>
		</s:url>
	</p>
	<h3 align="left">action由action属性指定,显示全路径URL</h3>
	<p>
		<s:url action="actionTag">
			<s:param name="param" value="'frank'"/>
		</s:url>
	</p>
	<h3 align="left">action,value属性同时指定,以value指定为准即不显示全路径URL</h3>
	<p>
		<s:url action="actionTag" value="actionTag.action">
			<s:param name="param" value="'frank'"/>
		</s:url>
	</p>
	
	<h3 align="left">
		<p>value,action属性都不指定,则显示当前浏览器中URL内容</p>
		<p>若有参数定义则URL后以"?"开头,使用" 参数名=参数值"格式显示参数名和参数值</p>
	</h3>
	<p>
		<s:url includeParams="get">
			<s:param name="param" value="'frank'"/>
		</s:url>
	</p>
	
	
	
</body>
</html>