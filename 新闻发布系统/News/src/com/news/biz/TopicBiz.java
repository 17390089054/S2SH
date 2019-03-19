package com.news.biz;

import java.util.List;
import com.news.entity.Topic;

public interface TopicBiz {
	//获取所有主题
	public List<?>getAllTopics();
	//添加主题
	public void addTopic(Topic topic);
	//根据编号获取主题
	public Topic getTopicById(int id);
	//更新主题
	public void updateTopic(Topic topic);
	//通过编号删除主题
	public void deleteTopic(int id);
	
}
