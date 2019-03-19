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
    <title>存款</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	<body onload="disptime()">
		<form action="/netbank/transaction/withdrawal" method="post" onsubmit="return deposit()">
			<div align="center" style="margin-top:20px">
				<table width="400" border="0" class="table">
					<tbody>
						<tr>
							<td width="100">&nbsp;取款日期：</td>
							<td><input type="text" name="log.datetime" value="${log.datetime}" id="datetime"/></td>
						</tr>
						<tr>
							<td width="100">&nbsp;取款金额：</td>
							<td><input type="text" name="log.trMoney" id="trMoney" value="${log.trMoney}"/>
								<span id="errormoney" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td >&nbsp;</td>
							<td><input type="submit" value="取款"/></td>
						</tr>
					</tbody>
				</table>
				<div style="color:red;">
					<s:fielderror/>
				</div>
			</div>
		</form>
  </body>
</html>
