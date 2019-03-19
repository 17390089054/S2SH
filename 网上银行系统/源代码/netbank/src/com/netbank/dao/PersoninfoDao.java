package com.netbank.dao;

import java.util.List;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;

public interface PersoninfoDao {
	//修改个人信息
	public void modifyPersoninfo(Personinfo personinfo);
	//获取所有用户信息
	public List<Personinfo> getAllPersoninfo();
	//根据账户状态获取用户信息
	public List<Personinfo> searchPersoninfo(Status status);
	//根据条件查询个人信息
	public List<Personinfo> searchPersoninfo(Personinfo personinfo);
	//添加个人信息
	public boolean add(Personinfo personinfo);
}
