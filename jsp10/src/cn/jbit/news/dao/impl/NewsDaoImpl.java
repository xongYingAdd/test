package cn.jbit.news.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.dao.BaseDao;
import cn.jbit.news.dao.NewsDao;
import cn.jbit.news.entity.News;
import cn.jbit.news.util.DataBaseUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	
	public NewsDaoImpl(){
		
	}
	
	public NewsDaoImpl(Connection conn){
		super(conn);
	}

	@Override
	public List<News> getAllNews() throws Exception {
		List<News> list = new ArrayList<News>();
		String sql = "select nid,ntid,ntitle,nauthor,tname,ncreateDate,nsummary,ncontent "
					+" from news,topic "
				    +"where news.ntid = topic.tid "
				    +"order by ncreateDate desc";
		rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtname(rs.getString("tname"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNcontent(rs.getString("ncontent"));
				
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DataBaseUtil.closeAll(null, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<News> getNewsByTID(int tid) {
		List<News> list = new ArrayList<News>();
		String sql = "select nid,ntid,ntitle,nauthor,tname,ncreateDate,nsummary,ncontent "
					+" from news,topic "
				    +"where news.ntid = topic.tid and topic.tid=? "
				    +"order by ncreateDate desc";
		rs = super.executeQuery(sql,tid);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtname(rs.getString("tname"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNcontent(rs.getString("ncontent"));
				
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<News> getLatestNewsByTID(int tid, int count) {
		List<News> list = new ArrayList<News>();
		String sql = "select nid,ntid,ntitle,nauthor,tname,ncreateDate,nsummary,ncontent "
					+" from news,topic "
				    +"where news.ntid = topic.tid and topic.tid=? "
				    +"order by ncreateDate desc limit ?";
		rs = super.executeQuery(sql,tid,count);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtname(rs.getString("tname"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNcontent(rs.getString("ncontent"));
				
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		int count = 0;
		String sql = "select count(1) from news";
		rs = super.executeQuery(sql);
		try {
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(null, pstmt, rs);
		}
		return count;
	}

	@Override
	public List<News> getPageNewsList(int pageIndex, int pageSize) {
		List<News> list = new ArrayList<News>();
		String sql = "select nid,ntid,ntitle,nauthor,tname,ncreateDate,nsummary,ncontent "
					+" from news,topic "
				    +"where news.ntid = topic.tid "
				    +"order by ncreateDate desc limit ?,?";
		rs = super.executeQuery(sql,(pageIndex-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtname(rs.getString("tname"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNcontent(rs.getString("ncontent"));
				
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(null, pstmt, rs);
		}
		return list;
	}

}
