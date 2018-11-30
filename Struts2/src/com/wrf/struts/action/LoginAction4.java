package com.wrf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction4 extends ActionSupport implements ServletRequestAware{
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
			HttpSession session=request.getSession();
			session.setAttribute("CurUser", username);
			//返回成功页面
			return SUCCESS;
		}else {
			//返回失败页面
			return ERROR;
		}
	}

	//重写validate()方法
	@Override
	public void validate() {
		//简单验证用户输入
		if(this.username==null||this.username.equals("")) {
			//将错误信息写入到Action类的FieldErrors中
			//此时Struts2框架自动返回INPUT视图
			this.addFieldError("username", "用户名不能为空");
			System.out.println("用户名为空!");
		}
		if(this.password==null||this.password.length()<6) {
			this.addFieldError("password", "密码长度不能为空!且密码长度不能小于6位");
			System.out.println("密码不能为空且密码长度不能小于6!");
		}
	}

	//声明request对象
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}
	
	

	
}
