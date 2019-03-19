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
    
    <title>网上银行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
		<div style="width:99%;height:50px;background:#aaa;margin:auto 2px;padding:5px">
			<div style="width:100%;height:40px;margin-top:5px;background:#aaa">
				<span style="color:#fff;font-size:20px;display:bolck;line-height:40px;margin-left:20px">网上银行业务中心</span>	
				<span style="color:#fff;font-size:20px;display:bolck;float:right;line-height:40px;margin-right:40px">Net Bank System</span>		
				<span style="color:#fff;font-size:15px;display:bolck;float:right;line-height:40px;margin-right:60px">当前用户：<s:property value="#session.user.username"/></span>
			</div>
		</div>
  </body>
</html>
