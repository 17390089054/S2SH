<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>optiontransferselect标签示例</title>
</head>
<body>
<s:form>
	<s:optiontransferselect list="{'chapter01工程','chapter02工程','chapter03工程'}"
	headerKey="headerKey" headerValue="---Web工程列表---"
	doubleHeaderValue="---已选择要部署的工程列表---" doubleHeaderKey="doubleHeaderKey"
	name="leftRecords" leftTitle="Avaliable:" rightTitle="Configured:" doubleList=""
	doubleName="rightRecords"/>
</s:form>
</body>
</html>