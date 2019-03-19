package com.news.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

import com.news.biz.TopicBiz;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport implements RequestAware {
	
	private Topic topic;
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Topic getTopic() {
		return topic;
	}
	
	private TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	public TopicBiz getTopicBiz() {
		return topicBiz;
	}
	
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	
	//添加主题
	public String addtopic() throws Exception{
		topicBiz.addTopic(topic);
		return "admin";
	}
	
	//获取主题列表，再转到主题编辑页
	public String topiclist() throws Exception{
		List<Topic> topicList = (List<Topic>) topicBiz.getAllTopics();
		request.put("topicList", topicList);
		return "topic_list";
	}
	
	//根据主题编号获取主题，在转到主题修改页
	public String toTopicModify() throws Exception{
		Topic modifyTopic=topicBiz.getTopicById(id);
		request.put("modifyTopic", modifyTopic);
		return "topic_modify";
	}
	
	//执行主题修改
	public String doTopicModify() throws Exception{
		topicBiz.updateTopic(topic);
		return "topiclist";
	}
	
	//删除主题
	public String deletetopic() throws Exception{
		topicBiz.deleteTopic(id);
		return "topiclist";
	}

}
