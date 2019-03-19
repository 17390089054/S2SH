<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<%@include file="/comm/base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

<title>GIFT-EMS.礼记-礼品管家  </title>
<meta name="keywords" content="礼品 ,礼物 ,礼盒 ,送礼"/>
<meta name="description" content="礼记专注于国内礼品市场，为您提供一站式礼品解决方案。">
<link type="text/css" href="${ctx}/styles/css/style.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<style type="text/css">
div.lp_banner{
	overflow: hidden;
	height: 290px;
}
div.lp_banner div.lp_hover {
	display: none;
}

div.lp_banner:hover div.lp_hover {
	display: block;
}
/* Gift图片规定大小 以免影响样式  */
div.lp_img img{
	width: 1170px;
	height: 280px;
}
ul#index-banner-ul{
	position: relative;
	height: 280px;
}
ul#index-banner-ul > li{
	float: left;
}
/** 轮播图片  **/
div.banner-image-index{
	position: absolute; 
	bottom: 20px; 
	left: 40px; 
	z-index: 1000;
}
div.banner-image-index ul li{
	float: left;
	margin-left: 5px;
}
div.banner-image-index ul li{
	float: left;
	width: 24px;
	height: 24px;
	line-height: 24px;
	border: 1px solid #f58586;
	border-radius: 24px;
	background: white;
	cursor: default;
}
div.banner-image-index ul li:hover, div.banner-image-index ul li.current{
	background: #f58586;
	color: white;
}
</style>
</head>
<body>
	<div class="index_main">
		<!--头部-->
		<jsp:include page="/jsp/top.jsp"></jsp:include>
		<!--banner start-->
		<div class="lp_banner" style="position: relative;">
			<ul id="index-banner-ul">
				<li>
					<div class="lp_img">
				      <a href="javascript:void(0)"><img src="${ctx}/styles/images/img1.png" /></a>
					</div>
				</li>
				<li>
					<div class="lp_img">
				      <a href="javascript:void(0)"><img src="${ctx}/styles/images/img2.png" /></a>
					</div>
				</li>
				<li>
					<div class="lp_img">
				      <a href="javascript:void(0)"><img src="${ctx}/styles/images/img3.jpg" /></a>
					</div>
				</li>
				<li>
					<div class="lp_img">
				      <a href="javascript:void(0)"><img src="${ctx}/styles/images/img4.jpg" /></a>
					</div>
				</li>
			</ul>
			<div class="banner-image-index">
				<ul>
				    <c:forEach begin="1" end="4" step="1" var="item">
				       <li <c:if test="${item == 1}">class="current"</c:if>>${item }</li>
				    </c:forEach>
				</ul>
			</div>
		</div>
		<!--banner end-->
		<!--服务类别 start-->
		<div class="pics">
			<ul>
				<li class="pic4"><div class="arrow_pink2">
						<h3>他人代付</h3>
						<h4 class="pic_text2">想要礼物，发到<br/>朋友圈里求代付，<br/>测试人品的时候到了！</h4>
					</div>
				</li>
				<li class="pic5"><div class="arrow_pink2">
						<h3>定时送达</h3>
						<h4 class="pic_text2">就想要礼物<br/>在某一天送到？<br/>礼记不会让你错过！</h4>
					</div>
				</li>
				<li class="pic6"><div class="arrow_pink2">
						<h3>语音贺卡</h3>
						<h4 class="pic_text2">扫描二维码<br/>听祝福留言，<br/>送礼送出新玩法！</h4>
					</div>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
		<!--服务类别 end-->
		<div class="clear"></div>
		<div class="ws_bg">
			<!--七大图标 start-->
			<div class="clear"></div>
			<ul class="tb_list" style="margin-top:10px;">
				<li><span class="tb1"></span>
					<p>礼物首选</p></li>
				<li><span class="tb2"></span>
					<p>正品采购</p></li>
				<li><span class="tb3"></span>
					<p>闪电发货</p></li>
				<li><span class="tb4"></span>
					<p>精美包装</p></li>
				<li><span class="tb5"></span>
					<p>万千信赖</p></li>
				<li><span class="tb6"></span>
					<p>全场包邮</p></li>
				<li><span class="tb7"></span>
					<p>退货保障</p></li>

			</ul>
			<!--七大图标 end-->
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!--底部-->
	<jsp:include page="/jsp/bottom.jsp"></jsp:include>
	<script type="text/javascript">
		$(function(){
			var indexbBnnerUl = $("#index-banner-ul");
			var lis = indexbBnnerUl.find("li");
			var firstLi = indexbBnnerUl.find("li").eq(0);
			var count = indexbBnnerUl.find("li").length;
			// 数字导航
			var indexLi = $("div.banner-image-index ul li");
			
			indexbBnnerUl.css("width", count + 1 + "00%");
			firstLi.clone(true).appendTo(indexbBnnerUl);
			var _left = 0;
			var flag = false;
			var i = function(){
				if(flag) return;
				_left = _left - 1;
				indexbBnnerUl.animate({left: _left + "00%"}, 1500, function(){
					if(_left + count <= 0){
						indexbBnnerUl.css("left", "0%");
						_left = 0;
					}
					indexLi.each(function(index, elem){
						var $elem = $(elem);
						if(index == Math.abs(_left)){
							$elem.addClass("current");
						}else{
							$elem.removeClass("current");
						}
					});
				});
			};
			var intervalId = setInterval(i, 8000);
			
			indexbBnnerUl.hover(function(){
				flag = true;
			}, function(){
				flag = false;
			});
			// 导航点击事件
			indexLi.each(function(index, elem){
				$(elem).click({index: index}, function(event){
					// 结束轮询
					clearInterval(intervalId);
					// 01234
					var _index = event.data.index;
					_left = 0 - _index;
					indexbBnnerUl.animate({left: _left + "00%"}, 1500, function(){
						if(_left + count <= 0){
							indexbBnnerUl.css("left", "0%");
							_left = 0;
						}
						indexLi.each(function(index, elem){
							var $elem = $(elem);
							if(index == Math.abs(_left)){
								$elem.addClass("current");
							}else{
								$elem.removeClass("current");
							}
						});
						// 重新开始轮询
						intervalId = setInterval(i, 8000);
					});
				});
			});
		});
		
	</script>
</body>
</html>
