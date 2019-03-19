package com.news.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.news.biz.AdminBiz;
import com.news.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {
	//定义用于保存用户登录表单参数的两个属性
	private String loginName;
	private String loginPwd;

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	//使用AdminBiz声明一个属性，并添加set方法用于依赖注入
	private AdminBiz adminBiz;
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	
	private Map<String, Object>session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	//处理登录请求
	public String validateLogin() throws Exception{
		Admin condition=new Admin();
		condition.setLoginName(loginName);
		condition.setLoginPwd(loginPwd);
		List<Admin>list=(List<Admin>) adminBiz.Login(condition);
		if(list.size()>0){
			//将管理员对象存入Session
			session.put("admin", list.get(0));
		}
		return "index";
	}
	
	


}
