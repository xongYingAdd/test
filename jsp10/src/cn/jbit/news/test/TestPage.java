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
			// ��ȡ�����ܼ�¼��
			int totalCount = newsDao.getTotalCount();

			Page page = new Page();
			page.setCurrPageNo(2);
			page.setPageSize(15);
			page.setTotalCount(totalCount);

			List<News> newsList = newsDao.getPageNewsList(page.getCurrPageNo(),
					page.getPageSize());
			page.setNewsList(newsList);

			System.out.println("�����ܼ�¼����" + page.getTotalCount());
			System.out.println("ÿҳ������" + page.getPageSize());
			System.out.println("��ҳ����" + page.getTotalPageCount());
			System.out.println("��ǰ��" + page.getCurrPageNo() + "ҳ");
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
