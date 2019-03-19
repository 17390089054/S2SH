<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index_top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="focusOnLogin()">
  <div id="header">
  	 <div style="width:99%;height:30px;margin:auto;border:1px #ccc dashed;" id="top_login">
  	 	<s:if test="#session.admin==null">
			<form id="myForm" action="validateLogin" method="post" onsubmit="return check()" style="margin-top:2px">
				<label>用户名:</label><input type="text" name="loginName" />&nbsp;&nbsp;&nbsp; 
				<label>密 码:</label><input type="password" name="loginPwd" />&nbsp;&nbsp;&nbsp; 
					<input type="submit" value="登 录" />&nbsp;&nbsp;&nbsp;
					<label id="error"></label>
			</form>
  	 	</s:if>
  	 	<s:if test="#session.admin!=null">
  	 		欢迎您:<s:property value="#session.admin.loginName"/>
  	 		&nbsp;&nbsp;&nbsp;
  	 		<a href="/news/admin">登录控制台</a>&nbsp;
  	 		<a href="loginout">退出</a>
  	 	</s:if>
	</div>
	<div style="width:99%;margin:auto;height:100px;border:1px #ccc dashed;">
			<img src="Images/img.jpg" height="100px" width="20%"
				style="display: block;float:left;margin-left:0px" /> 
			<img src="Images/logo.jpg" height="100px" width="79%"
			style="display: block;float:right;margin-right: 10px" />
	</div>
	
  </div>
   
  </body>
</html>
