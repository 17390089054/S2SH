package com.news.action;

import java.util.Date;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import com.news.biz.NewsinfoBiz;
import com.news.biz.TopicBiz;
import com.news.entity.Admin;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class NewsinfoAction extends ActionSupport implements RequestAware,SessionAware{
	private Newsinfo newsinfo;//封装表单参数
	public Newsinfo getNewsinfo() {
		return newsinfo;
	}
	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}
	
	//主题业务逻辑接口
	private TopicBiz topicBiz;
	public TopicBiz getTopicBiz() {
		return topicBiz;
	}
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	
	//新闻业务逻辑接口
	private NewsinfoBiz newsinfoBiz;
	public NewsinfoBiz getNewsinfoBiz() {
		return newsinfoBiz;
	}
	public void setNewsinfoBiz(NewsinfoBiz newsinfoBiz) {
		this.newsinfoBiz = newsinfoBiz;
	}
	
	//分页实体类
	private Pager pager;
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public Pager getPager() {
		return pager;
	}
	
	//封装超链接传递的新闻编号
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private Map<String, Object>session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	private Map<String, Object>request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	//根据条件和页码获取新闻列表，再转向新闻浏览首页index.jsp
	public String index(){
		try{
			int curPage=1;
			if(pager!=null){
				curPage=pager.getCurPage();
			}
			
			List<?>newsinfoList=null;
			if(newsinfo==null){
				//如果没有指定查询条件，获取指定页码的新闻列表
				newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage, 5);
				//在获取所有新闻总数，用来初始化分页类Pager对象
				pager=newsinfoBiz.getPagerOfAllNewsinfo(5);
			}else{
				//如果指定了查询条件，根据条件获取指定页码的新闻列表
				newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 5);
				//在根据条件获得所属的新闻总数，用来初始化分页类Pager对象
				pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo, 5);
			}
			//设置Pager对象中的当前页码
			pager.setCurPage(curPage);
			//pager.setPageCount(pager.getRowCount()%pager.getPerPageRows()==0?pager.getRowCount()/pager.getPerPageRows():pager.getRowCount()/pager.getPerPageRows()+1);
			//System.out.println(pager);
			//封装表单参数
			request.put("newsinfo", newsinfo);
			//将待显示的当前页新闻列表存入request范围
			request.put("newsinfoList", newsinfoList);
			//获取所有主题
			List<Topic>topicList=(List<Topic>) topicBiz.getAllTopics();
			//将主题列表存入request范围
			request.put("topicList", topicList);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//转向新闻浏览首页index.jsp显示
		return "index";
	}
	
	
	//从国内新闻和国际新闻中各获取两条记录，再转到index_sidebar.jsp页面
	public String indexsidebar(){
		try{
			//获取5条国内新闻
			Newsinfo condition=new Newsinfo();
			Topic topic=new Topic();
			topic.setId(1);
			condition.setTopic(topic);
			List<Newsinfo> domesticNewsList=(List<Newsinfo>) newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
			
			//获取五条国际新闻
			topic.setId(2);
			condition.setTopic(topic);
			List<Newsinfo> internationalNewsList=(List<Newsinfo>) newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 3);
			
			request.put("domesticNewsList", domesticNewsList);
			request.put("internationalNewsList", internationalNewsList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "index_sidebar";
	}
	
	//浏览新闻内容
	public String newsread(){
		try {
			//根据新闻编号获取新闻
			Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
			//将新闻存入request范围
			request.put("newsinfo", newsinfo);
			
			//获取5条国内新闻
			Newsinfo condition=new Newsinfo();
			Topic topic=new Topic();
			topic.setId(1);
			condition.setTopic(topic);
			List<Newsinfo> domesticNewsList=(List<Newsinfo>) newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
			
			//获取5条国际新闻
			topic.setId(2);
			condition.setTopic(topic);
			List<Newsinfo> internationalNewsList=(List<Newsinfo>) newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 3);
			
			request.put("domesticNewsList", domesticNewsList);
			request.put("internationalNewsList", internationalNewsList);
			//获取所有主题，并存入request范围
			List<Topic>topicList=(List<Topic>) topicBiz.getAllTopics();
			request.put("topicList", topicList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "news_read";
	}
	
	//获取指定页的新闻列表，再转到新闻管理业
	public String admin() throws Exception{
		List<Newsinfo> newsinfoList=null;
		int curPage=1;
		if(pager!=null){
			curPage=pager.getCurPage();
		}
		if(newsinfo==null){
			//如果没有指定查询条件,获取指定页码的新闻列表
			newsinfoList=(List<Newsinfo>) newsinfoBiz.getAllNewsinfoByPage(curPage, 5);
			//再获得所有新闻总数，用来初始化分页类pager对象
			pager=newsinfoBiz.getPagerOfAllNewsinfo(5);
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=(List<Newsinfo>) newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 5);
			//根据条件获得所属新闻总数，用来初始化分页类pager对象
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo, 5);
		}
		
		request.put("newsinfo", newsinfo);
		
		//设置pager对象中的待显示页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List<Topic> topicList = (List<Topic>) topicBiz.getAllTopics();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		
		return "admin";
	}
	
	//获取主题列表，再转到新闻添加页
	public String toNewsAdd() throws Exception{
		List<Topic>topicList=(List<Topic>) topicBiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_add";
	}
	
	//执行新闻添加
	public String doNewsAdd() throws Exception{
		//获取当前登录管理员对象
		Admin admin=(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.addNews(newsinfo);
		return "admin";
	}
	
	//根据新闻编号获取新闻，并获取主题列表，再转到新闻修改页
	public String toNewsModify() throws Exception{
		//根据新闻编号获取新闻
		Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
		//将要修改的新闻存入request
		request.put("newsinfo",newsinfo);
		//获取主题列表
		List<Topic> topicList = (List<Topic>) topicBiz.getAllTopics();
		//将主题列表存入request
		request.put("topicList", topicList);
		return "news_modify";
	}
	
	//执行新闻修改
	public String doNewsModify() throws Exception{
		//从Session中获取管理员对象
		Admin admin=(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.updateNews(newsinfo);
		return "admin";
	}
	
	//执行新闻删除
	public String deleteNews() throws Exception{
		newsinfoBiz.deleteNews(id);
		return "admin";
	}
	
	
	
	
}
