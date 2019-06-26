package cn.jbit.news.biz.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.biz.NewsService;
import cn.jbit.news.dao.NewsDao;
import cn.jbit.news.dao.impl.NewsDaoImpl;
import cn.jbit.news.entity.News;
import cn.jbit.news.util.DataBaseUtil;
import cn.jbit.news.util.Page;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> findAllnews() {
		Connection conn = null;
		List<News> list= null;
		try {
			conn = DataBaseUtil.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			list=newsDao.getAllNews();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<News> getNewsByTid(int tid) {
		Connection conn = null;
		List<News> list= null;
		try {
			conn = DataBaseUtil.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			list=newsDao.getNewsByTID(tid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<News> getLatestNewsByTID(int tid, int count) {
		Connection conn = null;
		List<News> list= null;
		try {
			conn = DataBaseUtil.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			list=newsDao.getLatestNewsByTID(tid, count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<News> findPageNews(Page pageObj) {
		Connection conn = null;
		List<News> list= null;
		try {
			conn = DataBaseUtil.getConnection();
			NewsDao newsDao = new NewsDaoImpl(conn);
			//获取新闻总记录数
			int totalCount = newsDao.getTotalCount();
			pageObj.setTotalCount(totalCount);
			
			if(totalCount>0){
				if(pageObj.getCurrPageNo()>pageObj.getTotalPageCount()){
					pageObj.setCurrPageNo(pageObj.getTotalPageCount());
				}
				//分页查询新闻信息
				list = newsDao.getPageNewsList(pageObj.getCurrPageNo(), pageObj.getPageSize());
				pageObj.setNewsList(list);
				
			}else{
				pageObj.setCurrPageNo(0);
				pageObj.setNewsList(new ArrayList<News>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

}
