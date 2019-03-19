<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index_sidebar.jsp' starting page</title>
    
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
  	
		<div style="width:100%;height:400px;border:1px #ccc dashed;">
			<h3>国内新闻</h3>
			<ul>
				<!-- 循环显示5条国内新闻 -->
		    	<s:iterator id="domesticNews" value="#request.domesticNewsList">
		    		<li>
		    			<a href='newsread?id=${domesticNews.id}'>
		    				<b>${domesticNews.title }</b>
		    			</a>
		    		</li><br>
		    	</s:iterator>
			</ul>		
		</div>
		<div style="width:100%;height:400px;border:1px #ccc dashed;">
			<h3>国际新闻</h3>
			<ul>
				<!-- 循环显示5条国际新闻 -->
				<s:iterator id="internationalNews" value="#request.internationalNewsList">
				<li>
					<a href='newsread?id=${internationalNews.id}'>
						<b>${internationalNews.title }</b>
					</a>
				</li><br/>
				</s:iterator>
			</ul>		
		</div>
	
  		
		
	
		
		
		

  </body>
</html>
