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
    <title>login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body onload="init()">
	<div align="center">
		<form action="user/user_login" method="post" name="myform" onsubmit="login()">
			<table width="450" border="1px dashed #f00" class="table">
				<tbody>
					<tr>
						<td>&nbsp;用户名：</td>
						<td>&nbsp;
							<input id="username1" type="text" name="account.username"/>
							<input id="username2" type="text" name="admin.username"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;密码：</td>
						<td>&nbsp;
							<input id="password1" type="password" name="account.password"/>
							<input id="password2" type="password" name="admin.password"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;用户类型：</td>
						<td>&nbsp;
						<select name="type" onchange="change()">
							<option value="0" selected>客户</option>
							<option value="1">管理员</option>
						</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>&nbsp;
							<input type="submit" value="登录" id="login"/>
							<input type="hidden" id="hidden"/>
						</td>
					</tr>
				</tbody>
			</table>
			<s:fielderror fieldName="username" cssStyle="color:red"/>
			<s:fielderror fieldName="password" cssStyle="color:red"/>
		</form>
	</div>  
	<script>
		//登录主方法
		function login(){
			var hidden=document.getElementById("hidden").value;
			if(document.getElementById("username"+hidden).value==""){
				alert("用户名不能为空!");
				return false;
			}else if(document.getElementById("password"+hidden).value==""){
				alert("密码不能为空!");
				return false;
			}else{
				return true;
			}
		}	
		
		//管理员登录
		function adminLogin(){
			document.getElementById("username1").style.display="none";
			document.getElementById("password1").style.display="none";
			document.getElementById("username2").style.display="block";
			document.getElementById("password2").style.display="block";
			document.myform.action="admin/login";
		}
		
		//普通用户登录
		function init(){
			document.getElementById("username1").style.display="block";
			document.getElementById("password1").style.display="block";
			document.getElementById("username2").style.display="none";
			document.getElementById("password2").style.display="none";
			document.myform.action="user/user_login";
		}
		
		//选择框更改登录角色
		function change(){
			var select=document.myform.type.value;
			if(select=="0"){
				var username2=document.getElementById("username2").value;
				var password2=document.getElementById("password2").value;
				init();
				document.getElementById("username1").value=username2;
				document.getElementById("password1").value=password2;
			}
			if(select=="1"){
				var username1=document.getElementById("username1").value;
				var password1=document.getElementById("password1").value;
				adminLogin();
				document.getElementById("username2").value=username1;
				document.getElementById("password2").value=password1;
			}
			
		}
		
	</script>
  </body>
</html>
