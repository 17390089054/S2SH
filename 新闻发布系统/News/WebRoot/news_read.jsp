<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_read.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<table width="80%" align="center">
   		<tr width="100%">
   			<td colspan="2" align="center">${newsinfo.title}</td>
   		</tr>
   		<tr>
   			<td colspan="2"><hr/></td>
   		</tr>
   		<tr>
   			<td align="center">
   				作者：${newsinfo.author}&nbsp;&nbsp;
   				类型：<a href="index?tid=${newsinfo.topic.id}">${newsinfo.topic.name}</a>
   				发布时间：${newsinfo.createDate}
   			</td>
   		</tr>
   		<tr>
   			<td align="left">
   				<strong>摘要：${newsinfo.summary}</strong>
   			</td>
   		</tr>
   		<tr>
   			<td colspan="2" align="center"></td>
   		</tr>
   		<tr>
   			<td colspan="2">${newsinfo.content}</td>
   		</tr>
   		...
   	</table>
  </body>
</html>
