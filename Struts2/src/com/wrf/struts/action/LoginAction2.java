package com.wrf.struts.action;

import com.opensymphony.xwork2.Action;

public class LoginAction2 implements Action{
	//用户名
	private String username;
	//密码
	private String password;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
		System.out.println("---登录的用户信息----");
		System.out.println("用户名: "+username);
		System.out.println("密码: "+password);
		if(username.startsWith("wrf")&&password.length()>=6) {
			//返回成功页面
			return SUCCESS;
		}else {
			//返回失败页面
			return ERROR;
		}
	}

	
}
