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
    <title>添加账户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	<form action="/netbank/admin/kaihu" method="post" name="myform" onsubmit="return check()">
		<div align="center" style="margin-top:80px">
			<table width="800" border="0" class="table">
				<tbody>
					<tr>
						<td>&nbsp;用户名：</td>
						<td>
							<input type="text" name="account.username"  />
							<span style="color:red">*<s:fielderror/></span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;密码：</td>
						<td>
							<input type="password" name="account.password" />
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;开户金额：</td>
						<td>
							<input type="text" name="account.balance" />
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;姓名：</td>
						<td>
							<input type="text" name="personinfo.realname" />
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;年龄</td>
						<td>
							<input type="text" name="personinfo.age" />
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;性别：</td>
						<td>
							<select name="personinfo.sex">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;家庭地址</td>
						<td>
							<input type="text" name="personinfo.address" />
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;联系电话</td>
						<td>
							<input type="text" name="personinfo.telephone" />
							<font size="1" style="color:red">区号(3或4位)-电话(8或9位)</font>
						</td>
					</tr>
					<tr>
						<td width="100">&nbsp;证件号码</td>
						<td>
							<input type="text" name="personinfo.cardid" />
							<font size="1" style="color:red">15位或者18位</font>
							<s:fielderror/>
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;<input type="submit" value="提交"/></td>					
					</tr>
				</tbody>
			</table>
		</div>
	</form>	
  </body>
</html>
