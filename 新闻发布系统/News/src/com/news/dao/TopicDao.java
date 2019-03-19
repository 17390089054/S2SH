package com.news.dao;

import java.util.List;

import com.news.entity.Topic;

public interface TopicDao {
	//获取所有主题
	public List<?> getAllTopics();
	//添加主题
	public void addTopic(Topic topic);
	//根据编号获取主题
	public Topic getTopicById(int id); 
	//更新主题
	public void updateTopic(Topic topic);
	//删除主题
	public void deleteTopic(Topic topic);
	
	
}
