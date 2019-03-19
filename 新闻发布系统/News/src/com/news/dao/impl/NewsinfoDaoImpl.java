package com.news.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.news.dao.NewsinfoDao;
import com.news.entity.Newsinfo;

public class NewsinfoDaoImpl implements NewsinfoDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据指定页码获取新闻列表
	@Override
	public List<?> getAllNewsinfoByPage(int page, int pagesize) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		c.setFirstResult(pagesize*(page-1));
		c.setMaxResults(pagesize);
		c.addOrder(Order.desc("createDate"));
		return c.list();
	}

	//获取所有新闻的数量
	@Override
	public Integer getCountOfAllNewsinfo() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		return c.list().size();
	}

	//根据主题、新闻标题等条件获取所属的新闻数量
	@Override
	public List<?> getNewsinfoByConditionAndPage(Newsinfo condition, int page, int pageSize) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		if(condition!=null){
			if((condition.getTopic()!=null) && (condition.getTopic().getId()!=null)){
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if((condition.getTitle()!=null) && !("".equals(condition.getTitle()))){
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		}
		//分页
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		
		return c.list();
	}
	
	//根据主题、新闻标题等条件获取所属新闻数量
	@Override
	public Integer getCountOfNewsinfo(Newsinfo condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		if(condition!=null){
			if(condition.getTopic()!=null &&condition.getTopic().getId()!=null){
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if(condition.getTitle()!=null && !("".equals(condition.getTitle()))){
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		}
		return c.list().size();
	}
	//根据新闻编号获取新闻
	@Override
	public Newsinfo getNewsinfoById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Newsinfo newsinfo=(Newsinfo) session.get(Newsinfo.class, id);
		return newsinfo;
	}
	//添加新闻
	@Override
	public void addNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
	}
	//更新新闻
	@Override
	public void updateNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
	}
	//删除新闻
	@Override
	public void deleteNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}	

}
