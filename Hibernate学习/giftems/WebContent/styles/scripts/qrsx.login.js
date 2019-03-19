		$(function(){
			// 提示信息
			var userNameInfoStr = "账号长度在3~20位之间";
			var passwordInfoStr = "密码长度在6~15位之间";
			// 输入框
			var userNameInput = $("input#userName");
			var passwordInput = $("input#password");
			// 提示区域
			var userNameSpan = $("span#userName-info-span");
			var passwordSpan = $("span#password-info-span");
			//当键盘按钮被按下时,会发生该事件。它发生在当前获得焦点的元素上,
			//每插入一个字符,就会发生 keypress事件.
			userNameInput.bind("keyup", function(event) {
				var userName = userNameInput.val();
				// 删除按钮  backspace
				if (event.which == 8) {
					if ($.trim(userName) == "") {
						userNameSpan.text(userNameInfoStr);
					}else{
						userNameSpan.text("");
					}
					return;
				}
			});
			passwordInput.bind("keyup", function(event) {
				var password = passwordInput.val();
				// 删除按钮 backspace
				if (event.which == 8) {
					if ($.trim(password) == "") {
						passwordSpan.text(passwordInfoStr);
					}else{
						passwordSpan.text("");
					}
					return;
				}
			});
            //提交表单
			function submitLoginForm(evnet){
				//分别获取用户名和密码的值
				var userName = userNameInput.val();
				var password = passwordInput.val();
                //进行用户名位数校验
				if ($.trim(userName) == "" || $.trim(userName).length<3||$.trim(userName).length>20) {
					userNameSpan.text(userNameInfoStr);
					userNameInput.focus();
					return;
				}
				userNameSpan.text("");
				//进行密码位数校验
				if ($.trim(password) == "" || $.trim(password).length<6 || $.trim(password).length>15) {
					passwordSpan.text(passwordInfoStr);
					passwordInput.focus();
					return;
				}
				userNameSpan.text("");
				$("#loginForm").submit();
			}
			//提交表单
			$("#login-button").click(submitLoginForm);
			$(".close").click(function(){
			     history.back(-1);
			});
		});