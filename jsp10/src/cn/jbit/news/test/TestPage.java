package cn.jbit.news.test;

import java.sql.Connection;
import java.util.List;

import cn.jbit.news.dao.NewsDao;
import cn.jbit.news.dao.impl.NewsDaoImpl;
import cn.jbit.news.entity.News;
import cn.jbit.news.util.DataBaseUtil;
import cn.jbit.news.util.Page;

public class TestPage {

	public static void main(String[] args) {
		Connection conn = DataBaseUtil.getConnection();
		NewsDao newsDao = new NewsDaoImpl(conn);
		try {
			// 获取新闻总记录数
			int totalCount = newsDao.getTotalCount();

			Page page = new Page();
			page.setCurrPageNo(2);
			page.setPageSize(15);
			page.setTotalCount(totalCount);

			List<News> newsList = newsDao.getPageNewsList(page.getCurrPageNo(),
					page.getPageSize());
			page.setNewsList(newsList);

			System.out.println("新闻总记录数：" + page.getTotalCount());
			System.out.println("每页条数：" + page.getPageSize());
			System.out.println("总页数：" + page.getTotalPageCount());
			System.out.println("当前第" + page.getCurrPageNo() + "页");
			for (News news : newsList) {
				System.out.println(news.getNid() + "\t" + news.getNtitle()
						+ "\t" + news.getNcreateDate());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
	}

}
