<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<%@include file="/comm/base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" href="${ctx}/styles/css/style.css" rel="stylesheet" >
<script type="text/javascript" src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctx}/styles/scripts/qrsx.login.js"></script>
<style type="text/css">
	.index_main > div {
	    width: 698px;
	}
</style>
</head>

<body class="login_bg" style="">
	    <br/>
	    <br/>
	    <br/>
	    <br/><br/>
	<div class="login_content">
		<h2 class="reg_top">
			登录 <span class="close"></span> 
		</h2>
		<form action="${ctx}/user/l.action?method=login" name="loginForm" id="loginForm" method="POST">
			<dl class="login_text1">
				<dt>账号：</dt>
				<dd>
					<input type="text" class="input1" name="userName" id="userName" value="${userName}" placeholder="登录账号可以为手机号" />
					<span class="red" id="userName-info-span"></span>
				</dd>
				<dt>密码：</dt>
				<dd>
					<input type="password" class="input1" name="password" id="password" value="${password }" placeholder="密码在6~15位之间" />
					<span class="red" id="password-info-span"></span>
				</dd>
				<dd>
					<span class="faq"></span><a href="${ctx}/user/l.action?method=forgetPassword">忘记密码</a>
					<span class="red">
						<c:if test="${not empty msg and msg ne 'unseted'}">【${msg }】</c:if>
					</span>
				</dd>
			</dl>
			<div class="clear"></div>
			<div style="padding-left:20px;">
				<span class="reg_button" id="login-button" style="cursor: pointer;">登录</span>
				
				<a href="${ctx}/user/l.action?method=toRegister">
				&nbsp;&nbsp; &nbsp;&nbsp;<span  id="register-button">还没注册</span>
				</a>
			</div>
		</form>
	</div>
</body>
</html>
