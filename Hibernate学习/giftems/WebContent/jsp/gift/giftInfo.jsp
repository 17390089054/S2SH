<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>

<!doctype html>
<html>
<head>
<%@include file="/comm/base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>礼品详情 ${gift.name }</title>
<link type="text/css" href="${ctx}/styles/css/style.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/styles/scripts/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="${ctx}/styles/jquery-ui-1.11.2/jquery-ui.css" type="text/css"></link>
<script type="text/javascript" src="${ctx}/styles/jquery-ui-1.11.2/jquery-ui.min.js"></script>
<style type="text/css">
	.selected{
		outline: 2px solid #37aca9;
	}
</style>
<link href='${ctx}/styles/fancybox/fancybox.css' rel='stylesheet' />
<script type="text/javascript" src="${ctx}/styles/fancybox/jquery.fancybox-1.3.1.pack.js"></script>
</head>
<body>
	<c:set var="user" value="${LoginManager.currentUser}" />
	<div class="index_main">
		<!--头部-->
	 <jsp:include page="/jsp/top.jsp"></jsp:include>
		<!--商品详情 start-->
		<div class="position2">
			<span class="home"></span>首页→礼品中心→<span class="green14">${gift.name }</span>
		</div>
		<div style="margin:0 auto;">
			<div class="lpxx_left">
				<div id="view-pic-div" >
					<c:if test="${not empty style.pic1 }">
						<img id="view-img" src="${style.pic1}" style="width: 500px; height: 500px; vertical-align: center;" />
					</c:if>
				</div>
				<!-- 显示不同款式的图片 -->
				<ul class="small_pic" id="small-pic-ul">
					<c:if test="${not empty style.pic1}">
					<li>
						<img src="${style.pic1}"  />
					</li>
					</c:if>
					<c:if test="${not empty style.pic2}">
					<li>
						<img src="${style.pic2}" />
					</li>
					</c:if>
					<c:if test="${not empty style.pic3}">
					<li>
						<img src="${style.pic3}" />
					</li>
					</c:if>
					<c:if test="${not empty style.pic4}">
					<li>
						<img src="${style.pic4}" />
					</li>
					</c:if>
					<c:if test="${not empty style.pic5}">
					<li>
						<img src="${style.pic5}" />
					</li>
					</c:if>
				</ul>
			</div>
			<div class="lpxx_right">
				<form action="${ctx}/user/cart.action?method=addCart" name="giftFrom" id="giftFrom" method="POST">
				<input type="hidden" name="giftId" value="${id }" id="giftIdHidden" />
				<input type="hidden" name="styleId" value="${styleId}" id="styleIdHidden" />
				<h1>${gift.name }</h1>
				<div>
					<span class="price" title="折扣价格">¥${style.discount }</span>
					市场价：<span class="old_price" title="市场价">¥${style.price }</span>
				</div>
				<ul class="item" style="height: 150px;">
					<c:forEach items="${gift.styles}" var="style">
						<li class="${style.id eq styleId ? 'selected' : ''}">
							<a href="${ctx}/g.action?method=info&id=${gift.id}&styleId=${style.id}"><img src="${style.pic1}" width="100" height="100" /></a>
							<p><a href="${ctx}/g.action?method=info&id=${gift.id}&styleId=${style.id}">${style.name}</a></p>
						</li>
					</c:forEach>
				</ul>
				<div class="clear"></div>
				<p>品牌：XX品牌</p>
				<p>
					数量：<span class="add" id="add-count-btn"></span>
					<input name="count" type="text" value="1" class="input3" id="count-input" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="3" size="3"/>
					<span class="minus" id="minus-count-btn"></span>
				</p>
				<div class="operate">
					<span class="operate1" id="toCart-button">放入购物车</span>
					<span class="operate2" id="buy-button">立即购买</span>
					<span class="operate3" id="collect-button">收藏</span>
					<a href="${ctx}/user/order.action?method=rqt&id=${gift.id}&styleId=${style.id}"><span class="operate4">找人送我</span></a>
				</div>
				
				</form>
			</div>
		</div>
		<!--商品详情 end-->
		<!--商品详情 start-->
		<div class="clear"></div>
		<div class="pro_details">
			<div class="pro_details_top">
				<span class="details_bg" id="details_tab" style="cursor: pointer;">商品详情</span>
			</div>
			<div id="details_content">
			<!--商品信息-->
			<div class="middle">
				<c:choose>
					<c:when test="${empty gift.remark }">
						<div>呜呜，该礼品还没有上传图片！！</div>
					</c:when>
					<c:otherwise>
						<c:out value="${gift.remark }" escapeXml="false" />
					</c:otherwise>
				</c:choose>
			  </div>
			</div>
		<!--商品详情 end-->
		<div class="clear"></div>
	</div>
	</div>
	<!--底部-->
	<jsp:include page="/jsp/bottom.jsp"></jsp:include>
	<script type="text/javascript">
		$(function(){
			$("#details_tab").click(function(){ 
				$('#details_content').show();
				$('#comment_content').hide();
				$('#comments_tab').removeClass('details_bg').addClass('comments_bg');
				$('#details_tab').removeClass('comments_bg').addClass('details_bg');
		    });		
			var dialogInfoP = $("#dialog-info-p");
			var userAddressForm = $("#userAddressForm");
			
			var smallPicUl = $("ul#small-pic-ul");
			// 展示照片
			var viewImg = $("img#view-img");
			
			smallPicUl.find("img").hover(function(event){
				var $that = $(this);
				var imgsrc = $that.attr("src");
				viewImg.attr("src", imgsrc);
			});
			
			// 倒计时更新
			var downTimeSpan = $("span#down-time-span");
			
			var giftFrom = $("#giftFrom");
			// 放入购物车
			$("span#toCart-button").click(function(event){
				var url = giftFrom.attr("action") + "&r=" + Math.random();
				
				$.ajax({
					url:url,
					data: giftFrom.serialize(),
					type: "POST",
					dataType: "JSON",
					success: function (data){
						dialogInfoP.html(data.msg + "<br /><br /><p style='text-align: center;'><a href='${ctx}/user/cart.action?method=list' class='operate1' style='margin:0 auto'>去购物车</a></p>");
						
						$("#dialog").dialog({
							modal: true,
							buttons: {
						        "确定": function() {
						          $(this).dialog("close");
						          dialogInfoP.html("");
						        }
						      }
						});
					},
					error: function(data){
						dialogInfoP.html(data.msg);
						$("#dialog").dialog({
							modal: true,
							buttons: {
						        "确定": function() {
						          $(this).dialog("close");
						        }
						      }
						});
					}
				});
				
			});
			// 立即购买 http://localhost:8080/dwlt/user/order.action?method=checkOrder&giftId=14&styleId=21&count=5
			$("span#buy-button").click(function(event){
				var giftId = $("input#giftIdHidden").val();
				var styleId = $("input#styleIdHidden").val();
				var count = $("input#count-input").val();
				window.location.href = "${ctx}/user/order.action?method=checkOrder&giftId="+giftId+"&styleId="+styleId+"&count="+count;
			});
			
			// 收藏 
			$("span#collect-button").click(function(event){
				// 检查是否登录
				var loginFlag = ${empty user};
				if(loginFlag){
					window.location.href = "${ctx}/user/l.action?method=toLogin";
					return;
				}
				var giftId = $("input#giftIdHidden").val();
				var styleId = $("input#styleIdHidden").val();
				var url = "${ctx}/co.action?method=like";
				$.ajax({
					url:url,
					data: {giftId:giftId,styleId:styleId},
					type: "POST",
					dataType: "JSON",
					success: function (data){
						if(data.success){
							dialogInfoP.html(data.msg);
						}else{
							dialogInfoP.html(data.msg);
						}
						$("#dialog").dialog({
							modal: true,
							buttons: {
						        "确定": function() {
						          $(this).dialog("close");
						        }
						      }
						});
					},
					error: function(){
						dialogInfoP.html("访问失败");
						$("#dialog").dialog({
							modal: true,
							buttons: {
						        "确定": function() {
						          $(this).dialog("close");
						        }
						      }
						});
					}
				});
			});
			var countInput = $("#count-input");
			countInput.keyup(function(){
				var countInputValue = $(this).val();
				$(this).val(countInputValue.replace(/\D/g,''));
				countInputValue = $(this).val();
				if(countInputValue == undefined || $.trim(countInputValue) == '' || $.trim(countInputValue) == 'NaN' || $.trim(countInputValue) == '0'){
					countInput.val(1);
				}
			});
			// 增加数量
			$("#add-count-btn").click(function(){
				var countInputValue = countInput.val();
				countInput.val(countInputValue.replace(/\D/g,''));
				countInputValue = countInput.val();
				if(countInputValue == undefined || $.trim(countInputValue) == '' || $.trim(countInputValue) == 'NaN'){
					countInputValue = 1;
				}
				var _count = Math.floor(countInputValue);
				if(_count == undefined || _count < 2){
					countInput.val(1);
				}else{
					countInput.val(_count - 1);
				}
			});
			// 减少数量
			$("#minus-count-btn").click(function(){
				var countInputValue = countInput.val();
				countInput.val(countInputValue.replace(/\D/g,''));
				countInputValue = countInput.val();
				if(countInputValue == undefined || $.trim(countInputValue) == '' || $.trim(countInputValue) == 'NaN'){
					countInputValue = 1;
				}
				var _count = Math.floor(countInput.val());
				if(_count == undefined || _count < 1){
					countInput.val(1);
				}else{
					countInput.val(_count + 1);
				}
			});
			
			// 异步加载评论
			$.ajax({
				url: "${ctx}/cm.action?method=list",
				data: {giftId: ${empty id? '0':id}},
				type: "get",
				dataType: "HTML",
				success: function(data){
					$("#gift-comments").html(data);
				}
			});
		});
		
		// 倒计时更新
		var downTimeSpan = $("span#down-time-span");
		
		var delta = Math.floor('${delta}');
		
		/**
		 * 显示剩余时间
		 */
		function showLeftTime(){
			// 每次执行减少1000ms
			delta = delta - 1005;
			downTimeSpan.text(getLeftclock(delta));
		}
		
		/**
		 * 格式转换
		 */
		function getLeftclock(delta) {
		    var differenceDay = -1;// 天差
		    var differenceHour = -1;// 时差
		    var differenceMinute = -1;// 分钟差
		    // 一天的毫秒数
		    var daysMs = 24 * 60 * 60 * 1000;
		    // 一小时的毫秒数
		    var hoursMs = 60 * 60 * 1000;
		    // 一分钟毫秒数
		    var minuteMs = 60 * 1000;
		    // 一秒为1000毫秒
		    var microsecond = 1000;
		    // 相差毫秒数
		    var diffMs = delta;

		    // 剩余的时间长度
		    var alertTime = 0 * 60 * 60 * 1000 + 10 * 60 * 1000;
		    if (diffMs <= 0) {
		        return "已下架";
		    }
		    differenceDay = Math.floor(diffMs / daysMs);
		    // 去掉整数天的毫秒数
		    diffMs -= differenceDay * daysMs;
		    // 去掉整个小时的毫秒数
		    differenceHour = Math.floor(diffMs / hoursMs);
		    diffMs -= differenceHour * hoursMs;
		    // 去掉整分钟的毫秒数
		    differenceMinute = Math.floor(diffMs / minuteMs);
		    diffMs -= differenceMinute * minuteMs;
		    // 剩余秒数
		    var sec = Math.floor(diffMs / microsecond);
		    var str = "";
		    if (differenceDay >= 0) {
		        str += (differenceDay < 10 ? "0" : "") + differenceDay + "\u5929";
		    }
		    if (differenceHour >= 0) {
		        str += (differenceHour < 10 ? "0" : "") + differenceHour + "\u65f6";
		    }
		    if (differenceMinute >= 0) {
		        str += (differenceMinute < 10 ? "0" : "") + differenceMinute + "\u5206";
		    }
		    if (sec <= 0) {
		        sec = 0;
		    }
		    str += sec + "\u79d2";
		    return str;
		}
		// itvlCd = setInterval("showLeftTime()", 1000);
	</script>
</body>
</html>
