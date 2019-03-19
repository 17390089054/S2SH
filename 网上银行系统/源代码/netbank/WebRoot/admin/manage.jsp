<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.admin==null">
	<jsp:forward page="login.jsp"></jsp:forward>
</s:if> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员页面</title>
    
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
	  
	<jsp:include page="/header.jsp"/>
	<body>
		<div style="width:100%;height:100%">
			<div style="width:18%;height:100%;background-color:#fff;border:2px dashed #ccc;margin-top:5px;float:left">
				<span class="menu">后台管理</span>
				<ul>
					<li>
						<a href="/netbank/admin/listUsers?status.id=0" target="main">所有账户</a>
					</li>
					<li>
						<a href="" target="main">已冻结账户</a></li>
					<li>
						<a href="" target="main">已启用账户</a>
					</li>
					<li>
						<a href="/netbank/admin/add.jsp" target="main">开户</a>
					</li>
					<li>
						<a href="changepwd.jsp" target="main">修改密码</a>
					</li>
					<li>	
						<a href="#" onclick="logout()">注销</a>
					</li>
				</ul>
  			</div>
  			<div style="width:80%;height:100%;float:right;margin:5px">
  				<iframe name="main"  style="width:100%;height:100%;border:2px dashed #ccc"></iframe>
  			</div>
		</div>
		
		<script type="text/javascript">
			function logout(){
				if(confirm("确认退出系统?")){
					window.location.href='/netbank/user/logout';
					return true;
				}else{
					return false;
				}
			}
		</script>
	</body>
</html>
