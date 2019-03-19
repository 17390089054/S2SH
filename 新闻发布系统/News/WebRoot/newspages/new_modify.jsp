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
    <title>My JSP 'news_add.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
		<s:form action="doNewsModify" method="post" onsubmit="return check()">
			<s:hidden name="newsinfo.id" value="%{#request.newsinfo.id}"/>
			<p>
				<s:select list="#request.topicList" name="newsinfo.topic.id" label="主题" 
				listKey="id" listValue="name" value="%{#request.newsinfo.topic.id}" cssClass="opt_input"/>
			</p>
			<p>
				<s:textfield label="标题" name="newsinfo.title" cssClass="opt_input" value="%{#request.newsinfo.title}"/>
			</p>
			<p>
				<s:textarea label="摘要" name="newsinfo.summary" value="%{#request.newsinfo.summary}" cols="40" rows="3"/>
			</p>
			<p>
				<s:textarea label="内容" name="newsinfo.content" value="%{request.newsinfo.content}" cols="70" rows="10"/>
			</p><br/>
			<p>
				<s:submit value=" 提 交 " cssClass="opt_sub" align="center"/>
			</p>
		</s:form>
  </body>
</html>
