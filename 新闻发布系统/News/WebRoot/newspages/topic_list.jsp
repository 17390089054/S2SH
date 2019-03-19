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
    
    <title>My JSP 'topic_list.jsp' starting page</title>
    
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
	  	<div style="width:75%;float:left;margin:10px">
	  		<s:iterator id="topic" value="#request.topicList">
	  			<li>
	  				&#160;&#160;&#160;&#160;
	  				${topic.name}
	  				&#160;&#160;&#160;&#160;
	  				<a href='toTopicModify?id=${topic.id}'>修改</a>
	  				&#160;&#160;&#160;&#160;
	  				<a href='deletetopic?id=${topic.id}' onclick="clickdel()">
	  					删除
	  				</a>
	  			</li>
	  		</s:iterator>
	  	</div>
  </div>
  <script>
  	function clickdel(){
  		if(confirm("确实要删除吗？")){
            return true;
        }else {
           return false;
        }
  		
  	}	
  </script>
  
  </body>
</html>
