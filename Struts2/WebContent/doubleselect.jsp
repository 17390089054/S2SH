<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doubleselect标签示例</title>
</head>
<body>
	<s:form action="eg" name="selectForm">
		<s:doubleselect label="选择部门" headerValue="--请选择--" formName="test"
		labelposition="left" name="dept" list="{'人事部','财务部'}"
		doubleName="employee" doubleList="top=='人事部'?{'张小小','李双双'}:{'王亮亮','赵明明'}"
		/>
	</s:form>
</body>
</html>