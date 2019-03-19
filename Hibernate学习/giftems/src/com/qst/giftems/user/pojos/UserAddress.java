package com.qst.giftems.user.pojos;

/**
 * 收件人
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserAddress implements java.io.Serializable{
	
	
	private Integer id;
	
	// 创建者id
	private Integer userId;
	
	private String name;
	
	private String mobile;
	
	private Integer provinceId;
	
	private Integer cityId;
	
	private Integer areaId;
	
	private String address;
	
	private String postcode;
	
	private String info;
	/** 默认地址标志位 1默认0非默认 **/
	
	private Integer defaultFlag;
	
	// 冗余字段
	
	private String provinceName;
	
	private String cityName;
	
	private String areaName;
	
	private String pca;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(name).append(provinceId).append(cityId).append(areaId).append(address).append(mobile);
		return sb.toString();
	}
	public String getPca() {
		if(pca == null){
			pca = getProvinceName() + getCityName() + getAreaName();
		}
		return pca;
	}
	public void setPca(String pca) {
		this.pca = pca;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(Integer defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
}
