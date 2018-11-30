<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>optgroup标签示例</title>
</head>
<body>
	<s:form>
		<s:select label="请选择您的岗位" name="select" list="{'人事部','财务部'}">
			<s:optgroup label="人事部岗位"
			list="#{'HR1':'招聘专员','HR2':'人事专员'}"/>
			<s:optgroup label="财务部岗位"
			list="#{'CA1':'会计','CA2':'出纳'}"/>
		</s:select>
	</s:form>
</body>
</html>