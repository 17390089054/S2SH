package com.qst.giftems.login;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qst.core.utils.ActionContextUtils;
import com.qst.core.utils.CommonUtils;
import com.qst.core.utils.ExceptionUtils;
import com.qst.core.utils.MD5;
import com.qst.core.utils.StringUtils;
import com.qst.core.web.action.BaseAction;
import com.qst.giftems.user.pojos.User;
import com.qst.giftems.user.service.UserService;
/**
 * 用与用户的登录与退出
 */
@SuppressWarnings("serial")
public class LoginAction extends BaseAction {
	private static final String REGISTER = "toRegister";
	/**
     * 日志记录类
     */
    public static Log logger = LogFactory.getLog(LoginAction.class); 
    private static final String LOGIN = "toLogin";
    /** 默认登录首页 **/
    private static final String INDEX = "main";
    /**用户Service**/
    private UserService userService = new UserService();
    /** 用户Id **/
    private Integer id;
    /** 用户名 **/
    private String userName;
    /** 用户姓名 **/
    private String name;
    /** 密码 **/
    private String password;
    /** 邮箱(可用于登录) **/
    private String email;
    /**手机号**/
    private String mobile;
    /** 验证码 **/
    private String validateCode;
    /**
     * 跳转到主页
     */
    public String main(){
    	return INDEX;
    }
    /**
     * 转向注册界面
     * @return
     */
    public String toRegister(){
    	return REGISTER;
    }
    /**
     * 跳转到登录界面
     * @return
     */
    public String toLogin(){
    	// 回传字符串
    	String result = LOGIN;
    	if (LoginManager.isOnline()) {
			result = INDEX;
			ActionContextUtils.setAtrributeToRequest("msg","登录成功!");
		}
    	return result;
    }
    /**
     * 用户登录
     */
	public String login() {
		HttpServletRequest request = ActionContextUtils.getRequest();
		HttpSession session = request.getSession();
		// 回传字符串
		String result = LOGIN;
		// 处理刷新系统的情况
		if (LoginManager.isOnline()) {
			result = INDEX;
			ActionContextUtils.setAtrributeToRequest("msg","登录成功!");
			return result;
		}
		try {
			if (StringUtils.isEmpty(this.userName)) {
				// 如果用户名为空，返回提示信息
				ActionContextUtils.setAtrributeToRequest("msg","登录成功!");
			} else if (StringUtils.isEmpty(this.password)) {
				// 如果密码为空,返回提示信息
				ActionContextUtils.setAtrributeToRequest("msg","密码不能为空!");
			} else {
				// 根据姓名或电话进行查询
				User user = userService.findUserByNameOrMobile(userName.trim());
				// 判读用户是否已经注册
				if (user != null) {
					String pass2 = new MD5().getMD5ofStr(this.password);
					if (!user.getPassword().equals(pass2)) {
						// 判断密码是否正确
						ActionContextUtils.setAtrributeToRequest("msg","密码错误!");
					} else if (user.getStatus() != 0) {
						// 用户冻结
						ActionContextUtils.setAtrributeToRequest("msg","用户已经被冻结!");
					} else {
						User user2 = LoginManager.getLoggedinUser(user.getId());
						if (user2 != null) {
							session.setAttribute("anotherUser", user2);
							LoginManager.logout(user2.getId());
						}
						// 登录时间
						user.setLastLoginTime(new Date(System
								.currentTimeMillis()));
						LoginManager.login(user);
						// 保存信息
						ActionContextUtils.setAtrributeToRequest("user", user);
						// 返回成功界面
						result = INDEX;
						ActionContextUtils.setAtrributeToRequest("msg","登录成功!");
					}
				} else {
					ActionContextUtils.setAtrributeToRequest("msg","用户不存在!");
				}
			}
		} catch (Exception ex) {
			String event = ExceptionUtils.formatStackTrace(ex);
			logger.error(event);
		}
		return result;
	}
	   /***
     * 注册功能:注册成功回到主页
     */
    @NotNecessaryLogin
    public String register(){
		// 回传字符串
		String result = REGISTER;
		
		// 获取验证码
    	if(StringUtils.isEmpty(this.userName)||this.userName.length()<3 || this.userName.length()>20){
			// 如果用户名为空，返回提示信息
    		ActionContextUtils.setAtrributeToRequest("msg","用户名长度在3~20之间!");
    	}else if(StringUtils.isEmpty(this.password)||this.password.length()<6 || this.password.length()>15){
			// 如果密码为空,返回提示信息
    		ActionContextUtils.setAtrributeToRequest("msg","密码长度在6~15之间!");
    	}else if(StringUtils.isEmpty(this.mobile)){
    		//验证手机号是否为空
    		ActionContextUtils.setAtrributeToRequest("msg","手机号不能为空!");
    	}else {
    		String validateCode = (String)ActionContextUtils.getAttribute("validateCode", "session");
    		if(StringUtils.isEmpty(validateCode) || StringUtils.isEmpty(this.validateCode)){
				// 检查验证码是否为空
    			ActionContextUtils.setAtrributeToRequest("msg","验证码不能为空!");
    		}else if(!validateCode.trim().equalsIgnoreCase(
					this.validateCode.trim())){
				// 验证码错误
    			ActionContextUtils.setAtrributeToRequest("msg","验证码错误!");
    		}else{
    			User u = userService.findUserByUserName(this.userName);
    			if(u!=null && StringUtils.isNotEmpty(u.getUserName())){
    				//该用户已经注册过
    				ActionContextUtils.setAtrributeToRequest("msg","该用户已经注册过!");
    			}else{
    				u = userService.findUserByNameOrMobile(this.mobile);
    				if(u!=null){
    					ActionContextUtils.setAtrributeToRequest("msg","该手机号已经注册过!");
    				}else{
    					//可以注册了
    		    		User user = new User();
    		    		user.setUserName(this.userName);
    		    		user.setMobile(mobile);
    		    		//密码进行MD5加密
    		    		user.setPassword(new MD5().getMD5ofStr(this.password));
    		    		user.setCreateTime(new Date());
    		    		//手机处于绑定状态
    		    		user.setBindStatus(1);
    		    		user.setLastLoginIp(CommonUtils.getIP());
    		    		user.setDeleted(0);
    		    		user.setStatus(0);
    		    		userService.doRegister(user);
    		    		//处于登录状态
    		    		LoginManager.login(user);
    		    		ActionContextUtils.setAtrributeToRequest("user", user);
    		    		result = "regSuccess";
    				}
    			}
    		}
    	}
    	return result;

    }
    /**
     * 退出系统,并进行日志记录
     */
    public String logout() throws Exception {
    	try{
        User user = LoginManager.currentUser();
        if (user != null) {
            LoginManager.logout(user.getId());
        }
    	}catch(Exception ex){
			String event = ExceptionUtils.formatStackTrace(ex);
			logger.error(event);
    	}
        return INDEX;
    }
    // ///////////////////////////////////////////
    // //getter/setter方法
    // //////////////////////////////////////////

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
