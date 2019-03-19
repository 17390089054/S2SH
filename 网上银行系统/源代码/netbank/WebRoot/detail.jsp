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
    <title>个人详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <div align="center">
  	<table>
		<tr>
			<td width="100">账号:</td>
			<td><s:property value="#session.user.username"/></td>
		</tr>  	
		<tr>
			<td width="100">姓名:</td>
			<td><s:property value="#session.personinfo.realname"/></td>
		</tr> 
		<tr>
			<td width="100">年龄:</td>
			<td><s:property value="#session.personinfo.age"/></td>
		</tr> 
		<tr>
			<td width="100">性别:</td>
			<td><s:property value="#session.personinfo.sex"/></td>
		</tr> 
  		<tr>
			<td width="100">身份证号:</td>
			<td><s:property value="#session.personinfo.cardid"/></td>
		</tr> 
		<tr>
			<td width="100">地址:</td>
			<td><s:property value="#session.personinfo.address"/></td>
		</tr> 
		<tr>
			<td width="100">联系电话:</td>
			<td><s:property value="#session.personinfo.telephone"/></td>
		</tr> 
		<tr>
			<td width="100">账户余额:</td>
			<td><s:property value="#session.user.balance"/></td>
		</tr> 
		<tr>
			<td width="100">账户状态:</td>
			<td><s:property value="#session.user.status.name"/></td>
		</tr> 
		
  	</table>
  
  </div>
  	
  </body>
</html>
