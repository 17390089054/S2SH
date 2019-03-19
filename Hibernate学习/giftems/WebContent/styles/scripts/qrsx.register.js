var isRegister = false;
$(function(){
		//注册账号
		$('#register').live('click',function(){
			var userName = $('#userName').val();
			//用户名长度
			if($.trim(userName).length <3 || userName.length > 20){
				alert("用户名长度在3~20位之间");
				return;
			}
			//不能连续点击多次注册按钮
			if(isRegister){
				return;
			}
			//判断密码长度
			var password = $('input[name=password]').val();
			if(password.length <6 || password.length > 15){
				alert("密码长度在6~15位之间");
				return;
			}
			//确认密码
			var confirm_password = $('input[name=confirm_password]').val();
			if($.trim(confirm_password) == ''){
				alert("请输入确认密码!");
				return;
			}
			//前后密码是否一致
			if(confirm_password !=password){
				alert("前后密码输入不一致,请确认!");
				return;
			}
			var confirm_password = $('input[name=confirm_password]').val();
			if($.trim(confirm_password) == ''){
				alert("请输入确认密码!");
				return;
			}
			if(confirm_password !=password){
				alert("前后密码输入不一致,请确认!");
				return;
			}
			//验证手机格式
			var mobile =$.trim($('#mobile').val());
			var mobileReg_ = /^1\d{10}$/;
			if(mobile == '' || !mobileReg_.test(mobile)){
			   alert("手机格式不正确!");
			   return;
			 }
			/*
			var validateCode = $('input[name=validateCode]').val();
			if($.trim(validateCode) == ''){
				alert("验证码不能为空!");
				return;
			}
            */
			$('#register-form').submit();
		});//end
		$(".close").click(function(){
		     history.back(-1);
		});
	});
//在注册前测试用户名是否没使用过
function validateUserName(){
	  //var isRegister = false;
	  //进行Ajax校验
	  var userName = $('#userName').val();
		if($.trim(userName).length <3/* || userName.length > 12*/){
			$('#name_message').html("<font color=red>用户名长度至少3位</font>").show();
			return;
		}
	  var url = config.ctx+"/user/l.action?method=isRegister";
	  $.ajax({
			url:url,
			dataType:"json",
			data:{userName:userName},
			type:"POST",
			cache:false,
			async:false,
			success:function(data){
				if (typeof(data.success)!=undefined &&data.success) {
				   $('#name_message').html("<font color=red>该用户已经被注册过!</font>").show();
				   //已经被注册过就隐藏
				   $('#sendSmsCode').attr("id","");
				   isRegister = true;
				}else{
				   $('.operate1').attr("id","sendSmsCode");
					isRegister = false;
				   $('#name_message').html("<font color=green>可以使用该用户名!</font>").show();
				} 
			},
			error:function(data){
				alert("系统出现故障，请联系管理员!");
			}
		});		
	  return isRegister;
}