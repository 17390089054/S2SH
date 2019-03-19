<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>导航栏</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		ul {
			list-style:none;
			
		}
		ul li{
			padding:4px;
		}
		ul li a{
			text-decoration: none;
			color: #000;
		}
		.menu{
			margin-left:40px;
			font-size:18px;
		}
		
	</style>
  </head>
  		<div style="width:160px;height:100%;background-color:#fff">
			<span class="menu">操作菜单</span>
			<ul>
				<li>
					<a href="#">存款</a>
				</li>
				<li>
					<a href="#">取款</a></li>
				<li>
					<a href="#">转账</a>
				</li>
				<li>
					<a href="#">查询交易记录</a>
				</li>
				<li>
					<a href="#">查看信息</a>
				</li>
				<li>
					<a href="#">修改个人信息</a>
				</li>
				<li>
					<a href="changepwd.jsp" target="main">修改密码</a>
				</li>
				<li>	
					<a href="#">注销</a>
				</li>
			</ul>

  		</div>
  <body>
  </body>
</html>
