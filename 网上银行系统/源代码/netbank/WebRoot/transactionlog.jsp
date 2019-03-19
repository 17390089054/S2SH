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
    <title>交易记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <div align="center">
  	<table width="650" border="1px dashed #ccc" class="table">
  		<tbody align="center">
  			<!-- 标题部分 -->
  			<tr>
  				<td colspan="5" style="font-size:20;">交易记录</td>
  			</tr>
  			<tr>
  				<td width="50">&nbsp;序号</td>
  				<td width="80">&nbsp;对方账户</td>
  				<td width="80">&nbsp;交易金额</td>
  				<td width="100">&nbsp;交易类型</td>
  				<td width="200">&nbsp;交易日期</td>
  			</tr>
  			<!-- 循环显示记录部分 -->
  			<s:iterator value="#request.logs"  status="status">
  				<tr>
  					<td>&nbsp;<s:property value="#status.count"/></td>
  					<s:if test="otherid==#session.user.accountid &&transactionType.name !='取款'">
  						<td>&nbsp;<s:property value="account.accountid"/></td>
  						<td>&nbsp;<s:property value="trMoney"/></td>
  					</s:if>
  					<s:else>
  						<td>&nbsp;<s:property value="otherid"/></td>
  						<td>&nbsp;-<s:property value="trMoney"/></td>
  					</s:else>
  					<td><s:property value="transactionType.name"/></td>
  					<td>&nbsp;<s:property value="datetime"/></td>
  				</tr>
  			</s:iterator>
  			<tr>
  				<td width="130"></td>
  				<td width="80" colspan="2">
  					<s:if test="pager.curPage>1">
  						<a href="/netbank/transaction/list?pager.curPage=1">首页</a>&nbsp;&nbsp;
  						<a href="/netbank/transaction/list?pager.curPage=${pager.curPage-1}">上一页</a>
  					</s:if>
  				</td>
  				<td width="80">
  					<s:if test="pager.curPage <pager.pageCount">
  						<a href="/netbank/transaction/list?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
  						<a href="/netbank/transaction/list?pager.curPage=${pager.pageCount}">尾页</a>
  					</s:if>
  				</td>
  				<td colspan="2">
  					共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;转至
  					<select onchange="select()" id="curPage">
  						<s:iterator begin="1" end="pager.pageCount" status="status">
  							<s:if test="#status.count==pager.curPage">
  								<option value="${status.count}" selected="selected">
  									${status.count}
  								</option>
  							</s:if>
  							<s:else>
  								<option value="${status.count}">${status.count}</option>
  							</s:else>
  						</s:iterator>
  					</select>页
  				</td>
  			</tr>
  		</tbody>
  	
  	</table>
  </div>
  	
  	
  </body>
</html>
