package com.qst.giftems.user.pojos;

import java.util.Date;
/**
 * 用户实体类
 */
@SuppressWarnings("serial")
public class User implements java.io.Serializable{
    /** ID **/
    private Integer id;
    /** 用户名 **/
    private String  userName;
    /** 密码 **/
    private String  password;
    /** 邮箱 **/
    private String  email;
    /** 性别 **/
    private String  sex;
    /** 生日 **/
    private Date    birthday;
    /** 昵称 **/
    private String  nickName;
    /** 真实姓名 **/
    private String  realName;
    /** 手机 **/
    private String  mobile;
    /** QQ **/
    private String qq;
    /** 城市 **/
    private String city;
    /** 地址 **/
    private String address;
    /** 邮编 **/
    private String postcode;
    /** 头像图片的url **/
    private String headImg;
    /** 账户余额 **/
    private Float balance;
    /** 积分 **/
    private Integer point;
    /** 创建时间 **/
    private Date   createTime;
    /** 更新时间 **/
    private Date    updateTime;
    /** 用户状态 0:正常 1:冻结 **/
    private Integer status;
    /** 0:正常,1:删除 **/
    private Integer deleted;
    /** 密码激活时的票据 **/
    private String ticket;
    /** 最后登录时间 **/
    private Date lastLoginTime;
    /** 最后登录Ip **/
    private String lastLoginIp;
    /**手机token**/
    private String mobileToken;
    /**职业**/
    private String work;
    /**绑定状态**/
    private Integer bindStatus;
    // ////////////////////////
    // getter/setter
    // ////////////////////////


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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getLastLoginIp() {
        return lastLoginIp;
    }
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getMobileToken() {
		return mobileToken;
	}
	public void setMobileToken(String mobileToken) {
		this.mobileToken = mobileToken;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Integer getBindStatus() {
		return bindStatus;
	}
	public void setBindStatus(Integer bindStatus) {
		this.bindStatus = bindStatus;
	}
}
