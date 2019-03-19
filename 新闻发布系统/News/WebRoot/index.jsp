<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="index-elements/index_top.jsp"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>中国新闻网</title>
<style type="text/css">
.ul {
	list-style: none;
}

.li {
	float: left;
	margin-left: 20px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div style="width:99%;height:100%;margin:20px auto;">
		
		
		<div style="width:100%;border:1px #ccc dashed;margin-top:20px">
			<div style="width:20%;height:100%;border:1px #ccc dashed;float:left">
				<s:action name="indexsidebar" namespace="/" executeResult="true">
				</s:action>
			</div>
			<div
				style="width:79%;height:100%;height:400px;border:1px #ccc dashed;float:right">
				<h1>新闻中心</h1>
				<div style="width:100%;height:40px">
					<ul class="ul">
						<!-- 循环显示主题列表 -->
						<s:iterator id="topic" value="#request.topicList">
							<li class="li"><a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div style="width:100%;height:80%;border:1px #ccc dashed">
					<ul style="margin-left: 20px">
						<!-- 循环当前新闻列表 -->
						<s:iterator id="news" value="#request.newsinfoList">
							<li><a href="newsread?id=${news.id}">${news.title}</a> <span
								style="float:right;margin-right:300px">${news.createDate}</span>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div
					style="width:100%;height:90px;line-height:30px;text-align:center;border:1px #ccc solid;">
					<!-- 分页超链接部分 -->
					<s:if test="pager.curPage>1">
						<p align="center">
							<a
								href='index?pager.curPage=1 '>首页</a>&nbsp;&nbsp;
							<a
								href='index?pager.curPage=${pager.curPage-1}} & newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>上一页</a>
						</p>
					</s:if>

					<s:if test="pager.curPage<pager.pageCount">
						<p align="center">
							<a
								href='index?pager.curPage=${pager.curPage+1}  & newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>下一页</a>&nbsp;&nbsp;
							<a
								href='index?pager.curPage=${pager.pageCount}'>尾页</a>
						</p>
					</s:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>