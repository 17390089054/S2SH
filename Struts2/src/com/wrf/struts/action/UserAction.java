package com.wrf.struts.action;

public class UserAction {
	//用户名
	private String userName;
	//地址
	private String address;
	//电话
	private String telephone;
	//邮箱
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute() {
		if(userName.startsWith("wrf")&&address.equals("北京")) {
			return "success";
		}else {
			return "error";
		}
	}

	
	
	
	
	
	
}