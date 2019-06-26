package cn.jbit.news.dao.impl;

import java.sql.SQLException;

import cn.jbit.news.dao.BaseDao;
import cn.jbit.news.dao.NewsUsersDao;
import cn.jbit.news.entity.NewsUsers;

public class NewsUsersDaoImpl extends BaseDao implements NewsUsersDao {

	@Override
	public NewsUsers getUserInfo(NewsUsers user) {
		String sql = "select uid,uname,upwd from news_users where uname=? and upwd=?";
		rs = super.executeQuery(sql, user.getUname(),user.getUpwd());
		NewsUsers u = null ;
		try {
			if(rs.next()){
				u = new NewsUsers();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			super.closeAll(conn, pstmt, rs);
		}
		return u;
	}

}
