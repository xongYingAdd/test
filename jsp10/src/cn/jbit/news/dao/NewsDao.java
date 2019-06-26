package cn.jbit.news.dao;

import java.util.List;

import cn.jbit.news.entity.News;

public interface NewsDao {
	public List<News> getAllNews() throws Exception;
	
	public List<News> getNewsByTID(int tid);
	
	public List<News> getLatestNewsByTID(int tid,int count);
	//��ȡ�����ܼ�¼��
	public int getTotalCount();
	//��ҳ��ѯ������Ϣ
	public List<News> getPageNewsList(int pageIndex,int pageSize);
}
