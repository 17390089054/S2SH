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
    <title>My JSP 'topic_add.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
   <div style="width:100%;padding:5px">
  	<div style="width:20%;float:left;margin:5px">
  		<jsp:include page="/console_element/left.html"/>
  	</div>
  </div>
  <div style="width:75%;float:left;margin:10px">
	<s:form action="/addtopic" method="post" onsubmit="return check()">
		<p>
			<s:textfield label="主题名称" id="name" name="topic.name" cssClass="opt_input"/>
		</p>
		<p>
			<s:submit value="提 交" cssClass="opt_sub"/>		
		</p>
	</s:form>
	</div>
  </body>
</html>
