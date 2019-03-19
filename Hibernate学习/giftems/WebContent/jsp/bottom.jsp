<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/comm/taglibs.jsp"%>
<!--底部start-->
<div class="clear"></div>
<div class="footer">
	<div class="footer_content">
		<span class="contat_foot">联系我们<Br /> 客服中心：400-658-0166<Br />
			客服邮箱：qrsx@itshixun.com<Br /> 官网地址：www.itshixun.com</span> <span class="weixin"></span>
		<dl class="aboutus">
			<dd>
				<a href="#" target="_parent">关于我们</a>
			</dd>
			<dd>
				<a href="#" target="_parent">加入我们</a>
			</dd>
			<dd>
				<a href="#" target="_parent">商业合作</a>
			</dd>
		</dl>
	</div>
	<p align="center" style="font-size:14px; clear:both;margin-top:5px;">青岛软件园人力资源服务有限公司
		&nbsp;&nbsp;All Rights Reserved&nbsp;&nbsp; 鲁ICP备13021294 <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253772990'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1253772990%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));</script></p>
</div>
<!--右边在线客服-->
<div class="go_top" id="right_goTopBtn">
	<ul>
		<li id="go-top"><a href="javascript:" title="返回头部" id="return_top" rel="external nofollow"><span class="up1"></span></a></li>
		<%--
		<li><span class="up2"></span> </li>
		 --%>
		<li><a href="${ctx}/user/fb.action?method=fb" target="_parent"><span
				class="up3"></span> </a></li>
		<li id="erweima">
			<a href="javascript:void(0)" tabindex="-1"><span class="up4"></span> </a>
			<div id="erwema-div" tabindex="-1" style="border:1px solid #ccc;width: 250px; z-index: 99999; 
				position: absolute; right:54px; bottom: 35px; display: none;">
				<div class="" data-role="content"
					style="background: none repeat scroll 0% 0% rgb(255, 255, 255); height: 100%;">
					<div id="weixin-content" class="p20 text-center">
						<img src="${ctx}/styles/images/weixin.jpg">
						<p>
							微信“发现”扫一扫，<br />动态全知道！
						</p>
					</div>
				</div>
			</div>
		</li>
		<li><a  href="tencent://message/?uin=10001&Site=qq&Menu=yes"><span	class="up5" ></span> </a></li>
		<li id="go-bottom"><a href="javascript:" title="返回底部" id="return_bottom" rel="external nofollow"><span class="up6"></span></a></li>
	</ul>
	
</div>
<script type="text/javascript">function goTopEx(){var a=document.getElementById("right_goTopBtn");window.onscroll=function(){if(window.navigator.userAgent.indexOf("Chrome")>=0){if(document.body.scrollTop>300){a.style.display=""}else{a.style.display="none"}}else{document.documentElement.scrollTop>300?a.style.display="":a.style.display="none"}}}if(document.getElementById("right_goTopBtn")){document.getElementById("right_goTopBtn").style.display="none"}goTopEx();</script>
<!--底部end-->
<script type="text/javascript">
	$(function() {
		$("#go-top").click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 'slow');
		});
		$("#go-bottom").click(function() {
			$('html, body').animate({
				scrollTop : $(document).height()
			}, 'slow');
		});
		var flag = false;
		$("#erweima").hover(function(){
			$("#erwema-div").show(2000, function(){
				flag = true;
			});
		},function(){
			if(flag) {
				$("#erwema-div").hide(2000, function(){
					flag = false;
				});
			}
		});
	});
</script>