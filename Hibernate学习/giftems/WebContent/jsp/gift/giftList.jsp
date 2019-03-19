<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>

<!doctype html>
<html>
<head>
<%@include file="/comm/base.jsp"%>
<title>礼品中心</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<link type="text/css" href="${ctx}/styles/css/style.css"
	rel="stylesheet">
<script type="text/javascript" src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<style type="text/css">

div.lp_banner div.lp_hover {
	display: none;
}

div.lp_banner:hover div.lp_hover {
	display: block;
}
/* Gift图片规定大小 以免影响样式  */
div.lp_img img{
	width: 554px;
	height: 290px;
	margin:0px auto 10px;
}
/*礼物中心 beigin*/
.giftbanner{height: 280px;width: 1440px; margin: 0 auto}
.giftsidenav{height: 100px; line-height: 100px; color: #fff; margin: 0px 80px;font-size: 14px;}
.sidenav a{color:white;}
.giftsidenavleft{float: left; width: 400px;}
.giftsidenavleft a,.giftsidenavleft span{color:#30e0ff;}
.giftsidenavright{float: right; width: 400px; text-align: right;}
.gifsnrinput{width: 130px; height: 20px; line-height:20px; vertical-align: middle;background: #2b2b2b; border:1px solid #2cb0c7; font-size: 18px; color: #fff}
.giftsurchbtn{display:inline-block;width: 35px; height: 30px; background: url(../images/nrico.png) no-repeat 0px -416px; vertical-align: middle; cursor: pointer;}
.gifttable{width: 100%; text-align: center;}
.gifttable td{background: #35d0e4;width: 10%;  font-size: 20px; }
.gifttable td a{color:#000; font-weight: 600}
.giftindexicon{width: 30px; height: 30px; display: inline-block; background: url(../images/dficon.png) no-repeat 0px 0px; vertical-align: middle;}
.giftpaixu{	background: #35d0e4; padding: 0px 100px; margin: 5px auto; line-height: 35px; position: relative;z-index: 100}
.giftpaixu ul{height: 35px;}
.giftpaixu ul li{float: left; margin-right: 10px;position: relative; z-index: 100}
.giftpaixu ul li > a{display: inline-block; color: #fff; line-height: 35px;padding: 0 30px 0 10px; font-size: 14px;}
.giftpaixu ul li > a.time{background: url(../images/nrico.png) no-repeat 70px -220px;}
.giftpaixu ul li > a.time2{background: url(../images/nrico.png) no-repeat 45px -220px;}
.giftpaixu ul li .gifdl{display: none;}
.giftpaixu ul li:hover .gifdl{display:block;position:absolute; top: 34px; left: -26px; width: 125px; text-align: center; background-image: url(../images/nrxgbg.png); border:1px solid #3fbecf; border-top: 0}
.giftpaixu ul li .gifdl a{color: #fff;}
.giftpaixu ul li .gifdl a:hover{background:#30e0ff;color:white;}
.giftlist{width: 1292px; margin: 0 auto;}
.giftlist dl{position: relative;float: left; width: 360px; height: 400px; border:1px solid #babdbc; margin: 15px 10px 20px;}
.giftlist dl:hover{border:1px solid #36e4ff;}
.giftlist .dttitle a{color: #fff;}
.giftlist .dttitle a:hover{color: #e0b8b8}
.giftlist .dtsm .xinjia{color:#ff0000;}
.giftlist .dtsm .laojia{ text-decoration: line-through}
.giftlist .dlsc{display: inline-block; position: absolute; top: 0px; cursor: pointer; left: 0px; width: 30px; height: 30px; background:url(../images/nrico.png) no-repeat 0px -280px; }
.giftlist .dlysc{background-position:0px -347px; }
.ddimg img{width: 100%}
.giftlist .ddimg {width: 100%;height: auto;text-align: center;	}
.giftzhezhao{position:absolute; top：0; left:0; width: 100%; height: 100%; background: #000; opacity: .5; filter:alpha(opacity=50);z-index: 1}
.giftlist dt {position:absolute; bottom: 1px; width:100%; color: #fff;text-align: center;line-height: 30px; height: 139px;padding-top: 1px;}
.giftlist .dttitle {font-size: 26px;margin-top: 10px;line-height: 40px; position: relative; z-index: 5}
.giftlist .dtsm {font-size: 22px;margin-top: 10px; position: relative; z-index: 5}
.giftlist .ddxian {position: absolute;top: 330px;left: 20px;width: 30px;height: 30px; z-index: 5}
.giftlist .ddzhezhao{position: absolute; top: 0; left: 0; width: 100%; height: 100%; z-index: 10}
.giftlist .ddzhezhao .dlsc{ top:350px; left: 50%; margin-left: -15px;}

</style>
</head>
<body>
	<div class="index_main">
		<!--头部-->
	<jsp:include page="/jsp/top.jsp"></jsp:include>
		<div class="position2">
			<span class="home"></span>首页→礼品中心→<span class="green14">全部类型</span>
		</div>
		<table class="gifttable" cellspacing="0" cellpadding="5">
			<tr>
				<td><a href="${ctx}/g.action?method=giftList">全部类型</a></td>
				<s:iterator value="#request.list" var="item">
									<td><a
						href="${ctx}/g.action?method=giftList&typeId=${item.id}">${item.name }</a></td>
				</s:iterator>
			</tr>
		</table>
		<!--lp_banner start-->
       <div class="giftlist">
			<s:iterator value="#request.giftList" var="item">
				<dl>
					<dd class="ddimg">
						<a href="${ctx}/g.action?method=info&id=${item.id}"> <img
							src="${item.pic}" width="100%" height="400">
						</a>
					</dd>
					<dt>
						<div class="giftzhezhao"></div>
						<h3 class="dttitle">
							<a href="${ctx}/g.action?method=info&id=${item.id}">${item.name}</a>
						</h3>
					</dt>
				</dl>
			</s:iterator>
			<div class="clear"></div>
	</div>
		<!--lp_banner end-->
		<!--七大图标 start-->
		<ul class="tb_list">
			<li><span class="tb1"></span>
				<p>礼物首选</p>
			</li>
			<li><span class="tb2"></span>
				<p>正品采购</p>
			</li>
			<li><span class="tb3"></span>
				<p>闪电发货</p>
			</li>
			<li><span class="tb4"></span>
				<p>精美包装</p>
			</li>
			<li><span class="tb5"></span>
				<p>万千信赖</p>
			</li>
			<li><span class="tb6"></span>
				<p>全场包邮</p>
			</li>
			<li><span class="tb7"></span>
				<p>退货保障</p>
			</li>
		</ul>
		<!--七大图标 end-->
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<!--底部-->
	<jsp:include page="/jsp/bottom.jsp"></jsp:include>
</body>
</html>
