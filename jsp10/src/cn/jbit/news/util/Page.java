package cn.jbit.news.util;

import java.util.List;

import cn.jbit.news.entity.News;

/**
 * ��ҳ��
 * @author Administrator
 * 
 */
public class Page {
	private int currPageNo; // ��ǰҳ��
	private int pageSize; // ÿҳ��ʾ�ļ�¼����
	private int totalCount; // �ܼ�¼��
	private int totalPageCount;// ��ҳ��
	private List<News> newsList;// ÿҳ��ʾ�������б�

	public int getCurrPageNo() {
		if (totalPageCount == 0)
			return 0;
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo > 0)
			this.currPageNo = currPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0)
			this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			// ������ҳ��
			this.totalPageCount = totalCount % pageSize == 0 ? totalCount
					/ pageSize : totalCount / pageSize + 1;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
