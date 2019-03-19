<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<c:set var="user" value="${LoginManager.currentUser}" />
<!--头部start-->
<div class="login_top">
	<div class="login_text">
		<c:if test="${empty user}">
		<span class="fl">
			<a href="${ctx}/user/l.action?method=toLogin" target="_parent">登录</a>
			<a href="${ctx}/user/l.action?method=toRegister" target="_parent">注册</a></span>
		</c:if>
		<c:if test="${not empty user}">
			<div class="right_zh">
				亲爱的 <span class="green">
					<div>${user.userName }</div>
					<span class="arrow_down"></span>
					<div class="box_zh">
						<ul>
							<li><a href="${ctx}/user/point.action?method=point">我的积分</a></li>
							<li><a href="${ctx}/user/order.action?method=myOrders">我的订单</a></li>
							<li><a href="${ctx}/user/addr.action?method=list">收礼人</a></li>
							<li><a href="${ctx}/co.action?method=list">我的收藏</a></li>
							<li><a href="javascript:void(0)" onclick="if(confirm('确实要退出系统？')) location.href='${ctx}/user/l.action?method=logout';">安全退出</a></li>
							<div class="clear"></div>
						</ul>
					</div>
				</span> 欢迎回来~
			</div>
		</c:if>
	</div>
</div>
<div class="clear"></div>
<div class="top_bg">
	<div class="top_content">
		<div class="logo">
			<a href="${ctx}/user/l.action?method=main"><img src="${ctx}/styles/images/logo.png" /></a>
		</div>
		<ul class="nav">
			<li><a href="${ctx}/user/l.action?method=main" class="white">首页</a></li>
			<li><a href="${ctx}/g.action?method=giftList" class="white">礼品中心</a></li>
			<li><a href="#" class="white" target="_parent">送礼攻略</a></li>
			<li><a href="#" class="white" target="_parent">下载APP</a></li>
		</ul>
	</div>
</div>
<div class="clear"></div>
<!--头部end-->