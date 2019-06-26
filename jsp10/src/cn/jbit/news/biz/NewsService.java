package cn.jbit.news.biz;

import java.util.List;

import cn.jbit.news.entity.News;
import cn.jbit.news.util.Page;

public interface NewsService {
		//获取新闻列表
		public List<News> findAllnews();	
		
		public List<News> getNewsByTid(int tid);
		//根据新闻主题编号，查询最近的新闻信息
		public List<News> getLatestNewsByTID(int tid,int count);
		//分页查询新闻信息
		public List<News> findPageNews(Page pageObj);
		
		
}
