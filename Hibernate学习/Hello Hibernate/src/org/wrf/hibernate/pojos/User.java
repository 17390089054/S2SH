package org.wrf.hibernate.pojos;

import java.io.Serializable;

public class User implements Serializable {
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	
	//用户id 
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String userPwd;
	//权限
	private Integer role;
	//默认构造方法
	public User() {

	}
	//根据属性创建构造方法
	public User(String userName, String userPwd, Integer role) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", role=" + role + "]";
	}
	

}
