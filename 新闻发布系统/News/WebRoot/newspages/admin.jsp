<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/index-elements/index_top.jsp"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'admin.jsp' starting page</title>
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
  		<s:form action="admin" method="post" theme="simple">
  			主题:
  				<s:select name="newsinfo.topic.id" list="#request.topicList"
  				listKey="id" listValue="name" cssClass="opt_input"/>
  				&nbsp;&nbsp;&nbsp;
  				新闻标题：
  				<s:textfield name="newsinfo.title"/>
  				<s:submit value="查询"/>
  		</s:form>
  	
	  	<s:iterator id="news" value="#request.newsinfoList">
			<li>
				${news.title}
				<span style="float:right;margin-right:15px">
					作者：${news.author}	&#160;&#160;&#160;&#160;
					<a href='toNewsModify?id=${news.id}'>修改</a>		
					&#160;&#160;&#160;&#160;
					<a href='deleteNews?id=${news.id}' onclick='clickdel()'>删除</a>
				</span>
			</li>
		
		</s:iterator>
		
		<!-- 分页超链接部分 -->
		<s:if test="pager.curPage>1">
			<p align="center">
				<a
					href='admin?pager.curPage=1 & newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>首页</a>&nbsp;&nbsp;
				<a
					href='admin?pager.curPage=${pager.curPage-1} & newsinfo.topic.id=${requestScope.newsinfo.topic.id}& newsinfo.title=${requestScope.newsinfo.title}'>上一页</a>
			</p>
		</s:if>

		<s:if test="pager.curPage<pager.pageCount">
			<p align="center">
				<a
					href='admin?pager.curPage=${pager.curPage+1} & newsinfo.topic.id=${requestScope.newsinfo.topic.id}& newsinfo.title=${requestScope.newsinfo.title}'>下一页</a>&nbsp;&nbsp;
				<a
					href='admin?pager.curPage=${pager.pageCount} & newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>尾页</a>
			</p>
		</s:if>
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
