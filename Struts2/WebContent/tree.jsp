<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tree标签和treenode标签</title>
<s:head theme="xhtml"/>
<sx:head parseContent="true"/>
</head>
<body>
	<sx:tree label="技术分类" id="book" showRootGrid="true" showGrid="true" treeSelectedTopic="treeSelected">
		<sx:treenode label="Java方向" id="java">
			<sx:treenode label="JavaWeb" id="javaweb">
				<sx:treenode label="Servlet" id="java"/>
				<sx:treenode label="JSP" id="jsp"/>
			</sx:treenode>
			<sx:treenode label="Hibernate" id="hibernate"/>
			<sx:treenode label="Struts2" id="struts"/>
		</sx:treenode>
		<sx:treenode label=".NET方向" id="NET">
			<sx:treenode label="C#" id="C"/>
		</sx:treenode>
		<sx:treenode label="C++方向" id="C++">
			<sx:treenode label="Arm" id="arm"/>
		</sx:treenode>
	</sx:tree>
</body>
</html>