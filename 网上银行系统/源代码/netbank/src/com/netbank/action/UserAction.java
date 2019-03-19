package com.netbank.action;

import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.PersoninfoBiz;
import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Password;
import com.netbank.entity.Personinfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware, SessionAware {
	//定义通过@Resource注解注入的属性userBiz，可省略set方法
	@Resource private UserBiz userBiz;
	
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	//定义Account类型对象，用于封装登陆表单参数
	private Account account;
	private Personinfo personinfo;
	private Password pwd;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	public Password getPwd() {
		return pwd;
	}
	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	/**
	 * 登录表单校验,根据用户名获取账户对象
	 */
	public void validateLogin(){
		Account a=userBiz.getAccount(account.getUsername());
		if(a==null){
			this.addFieldError("username","用户名不存在");
		}else {
			if(!account.getPassword().equals(a.getPassword())){
				this.addFieldError("password", "账户或密码不正确");
			}
		}
		account=a;
	}
	
	/**
	 * 执行页面客户登录请求
	 * @return
	 */
	public String login(){
		//根据关联关系，从账户对象中获取个人信息对象
		if(account!=null){
			personinfo=(Personinfo) account.getPersoninfos().iterator().next();
		}
		if(personinfo!=null){
			//将账户对象存入Session
			session.put("user", account);
			//将该账户个人信息对象存入Session
			session.put("personinfo", personinfo);
		}
		
		//页面转发
		return "success";
	}
	
	/**
	 * 修改密码页面验证
	 */
	public void validateChangepwd(){
		account=(Account)session.get("user");
		if(!pwd.getOldpwd().equals(account.getPassword())){
			this.addFieldError("pwd.oldpwd", "密码不正确");
		}
		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())){
			this.addFieldError("pwd.confirmpwd", "两次密码不一致");
		}
		
		
	}
	
	/**
	 * 执行修改密码请求
	 * @return
	 */
	public String changepwd(){
		account.setPassword(pwd.getNewpwd());
		if(userBiz.modifyAccount(account)){
			session.put("user",account);
			request.put("message", "密码修改成功!");
			return "message";
		}
		request.put("message", "密码修改失败!");
		return "message";
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		//移除session中的键值对
		session.remove("user");
		session.remove("personinfo");
		return "login";
	}
	

}
