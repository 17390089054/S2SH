<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>这是主页</title>
</head>
<body>
	<h3>构造Map</h3>
	<s:set name="foobar" value="#{'foo1':'bar1','foo2':'bar2'}" />
	<p>The value of key "fool" is<s:property value="#foobar['foo1']"/></p>
	<p>不使用%: <s:url value="#foobar['foo1']"/> </p>
	<p>使用%: <s:url value="%{#foobar['foo1']}"/> </p>
	<p>
	<s:if test="'zhao' in {'zhao','gao'}">
		在
	</s:if>
	<s:else>
		不在
	</s:else>
	
	<s:if test="'zhao' not in {'zhao','gao'}">
		不在
	</s:if>
	<s:else>
		在
	</s:else>
	</p>


	hello,这是主页!
</body>
</html>