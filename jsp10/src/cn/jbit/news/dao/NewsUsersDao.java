package cn.jbit.news.dao;

import cn.jbit.news.entity.NewsUsers;

/**
 * 用户DAO接口
 * @author Administrator
 *
 */
public interface NewsUsersDao {
	//获取用户信息
	public NewsUsers getUserInfo(NewsUsers user);
}
