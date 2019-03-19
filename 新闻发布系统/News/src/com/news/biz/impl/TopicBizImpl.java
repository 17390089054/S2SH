package com.news.biz.impl;

import java.util.List;

import com.news.biz.TopicBiz;
import com.news.dao.TopicDao;
import com.news.entity.Topic;

public class TopicBizImpl implements TopicBiz{

	private TopicDao topicDao;
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	
	//获取所有主题
	@Override
	public List<?> getAllTopics() {
		return topicDao.getAllTopics();
	}
	//添加主题
	@Override
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
	}

	//根据编号获取主题
	@Override
	public Topic getTopicById(int id) {
		return topicDao.getTopicById(id);
	}
	//更新主题
	@Override
	public void updateTopic(Topic topic) {
		topicDao.updateTopic(topic);
	}
	//通过编号删除主题
	@Override
	public void deleteTopic(int id) {
		Topic topic=topicDao.getTopicById(id);
		topicDao.deleteTopic(topic);
		
	}

}
