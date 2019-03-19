package com.netbank.biz;

import java.util.List;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;

public interface PersoninfoBiz {
	//修改个人信息
	public boolean modifyPersoninfo(Personinfo personinfo);
	//根据账户状态获取个人信息
	public List<Personinfo> searchPersoninfo(Status status);
	//根据条件查询个人信息
	public List<Personinfo> searchPersoninfo(Personinfo personinfo);
	//添加个人信息
	public boolean add(Personinfo personinfo);
	
}
