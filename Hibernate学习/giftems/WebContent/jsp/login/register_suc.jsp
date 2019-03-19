<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>注册成功</title>
<link href="${ctx}/styles/css/style.css" rel="stylesheet"
	type="text/css">
	<script type="text/javascript" src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<style type="text/css">
	.index_main > div {
	    width: 698px;
	}
</style>
</head>

<body class="login_bg">
        <script type="text/javascript">
         function isIFrameSelf(){try{if(window.top ==window){return false;}else{return true;}}catch(e){return true;}}
         function toHome(){ if(!isIFrameSelf()){ window.location.href="${ctx}/user/l.action?method=main";}}
         window.setTimeout("toHome()",5000);
        </script>
          <br/>
	    <br/>
	    <br/>
	    <br/><br/>
	<div class="login_content_suc">
		<h2 class="reg_top">
			注册成功<a onclick="window.close();"><span class="close"></span>
			</a>
		</h2>
		<div class="forget_text">
			<div align="center">
				<img src="${ctx}/styles/images/right.jpg">
			</div>
			<h2 align="center">
				恭喜您注册成功，账号<span class="blue18">${user.userName }</span>
			</h2>
			<p align="center" class="blue">5秒后跳转到首页</p>
		</div>
	</div>
</body>
</html>
