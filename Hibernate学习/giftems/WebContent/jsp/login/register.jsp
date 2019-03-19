<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<jsp:include page="/comm/base.jsp" />
<meta charset="utf-8">
<title>注册</title>
<link href="${ctx}/styles/css/style.css" rel="stylesheet" type="text/css">
<script src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<script src="${ctx}/styles/scripts/qrsx.register.js"></script>
<style type="text/css">
.index_main>div {
	width: 598px;
}
</style>
</head>

<body class="login_bg">
	    <br/>
	    <br/><br/>
	<div class="reg_content">
		<h2 class="reg_top">
			注册
			 <span class="close"></span>
		</h2>
		<form id="register-form" name="register-form" action="${ctx}/user/l.action?method=register" method="post">
			<dl class="reg_text">
				<dt>账号：</dt>
				<dd>
					<input type="text" class="input1" name="userName" id="userName" autocomplete="off"
						placeholder="至少3位以上" onblur="javascript:validateUserName()"/> <span class="red"
						id="userName-info-span"></span><span id="name_message"></span>
				</dd>
				<dt>密码：</dt>
				<dd>
					<input type="password" name="password" class="input1"
						placeholder="长度在6-15位之间" /> <span class="red"
						id="password-info-span"></span>
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input name="confirm_password" type="password" class="input1"
						placeholder="密码确认" />
				</dd>
				<dt>手机号码：</dt>
				<dd>
					<input name="mobile" type="text" id="mobile" class="input1" autocomplete="off"
						placeholder="请输入手机号"/>
				</dd>
				<dt>验证码：</dt>
				<dd>
					<input name="validateCode" type="text" class="input2" id="validateCode"/>
                          <span><a href="javascript:" onclick="document.getElementById('img_code').src='${ctx}/imgcode?r='+Math.random();"><img
												height="30px" id="img_code"
												 width="70px"
												src='${ctx}/imgcode' align="absmiddle"
												onclick="document.getElementById('img_code').src='${ctx}/imgcode?r='+Math.random();" /><span class="blue">换一张</span>
								</a> 
						 </span>
				</dd>
				<c:if test="${not empty msg}">
				  <dd>&nbsp;&nbsp;&nbsp;提示:<font style="font-size: 12;color: red">${msg}</font></dd>
				</c:if>
				<dd><input name="" type="checkbox" value="" checked="checked" style="vertical-align: middle;margin-right:5px;" />我已阅读并同意<a href="${ctx}/about.action?method=copyright" target="_blank" class="blue">《礼记用户注册协议》</a></dd>
			</dl>
			<div align="center">
				<a href="javascript:void(0)" id="register"><span
					class="reg_button">注册</span></a>&nbsp;&nbsp; &nbsp;&nbsp;
                  <a href="${ctx}/user/l.action?method=login" id="login"><span
					class="reg_button">直接登录</span></a>
			</div>
		</form>
	</div>
</body>
</html>
