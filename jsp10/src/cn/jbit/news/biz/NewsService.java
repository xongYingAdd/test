package cn.jbit.news.biz;

import java.util.List;

import cn.jbit.news.entity.News;
import cn.jbit.news.util.Page;

public interface NewsService {
		//��ȡ�����б�
		public List<News> findAllnews();	
		
		public List<News> getNewsByTid(int tid);
		//�������������ţ���ѯ�����������Ϣ
		public List<News> getLatestNewsByTID(int tid,int count);
		//��ҳ��ѯ������Ϣ
		public List<News> findPageNews(Page pageObj);
		
		
}
