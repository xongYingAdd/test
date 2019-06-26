package cn.jbit.news.dao;

import java.util.List;

import cn.jbit.news.entity.News;

public interface NewsDao {
	public List<News> getAllNews() throws Exception;
	
	public List<News> getNewsByTID(int tid);
	
	public List<News> getLatestNewsByTID(int tid,int count);
	//获取新闻总记录数
	public int getTotalCount();
	//分页查询新闻信息
	public List<News> getPageNewsList(int pageIndex,int pageSize);
}
