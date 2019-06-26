package cn.jbit.news.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.news.dao.BaseDao;
import cn.jbit.news.dao.TopicDao;
import cn.jbit.news.entity.Topic;
import cn.jbit.news.util.DataBaseUtil;

/**
 * TopicDao接口的实现类
 * @author Administrator
 *
 */
public class TopicDaoImpl extends BaseDao implements TopicDao {
	public TopicDaoImpl(){
		
	}
	
	public TopicDaoImpl(Connection conn){
		super(conn);
	}
	
	@Override
	public List<Topic> getAllTopics() {
		String sql = "select tid,tname from topic";
		rs = super.executeQuery(sql);
		List<Topic> topicList = new ArrayList<Topic>();
		try {
			while(rs.next()){
				Topic topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
				topicList.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(null, pstmt, rs);
		}
		return topicList;
	}

	@Override
	public int updateTopic(Topic topic) {
		String sql = "update topic set tname=? where tid=?";
		return super.executeUpdate(sql, topic.getTname(),topic.getTid());
	}

	@Override
	public Topic findTopicByName(String tname) throws SQLException {
		String sql = "select tid,tname from topic where tname=?";
		rs = super.executeQuery(sql,tname);
		Topic topic = null;
		try {
			if(rs.next()){
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DataBaseUtil.closeAll(null, pstmt, rs);
		}
		return topic;
	}

	@Override
	public int addTopic(String tname) {
		String sql = "insert into topic(tname) values(?)";
		return super.executeUpdate(sql, tname);
	}

	@Override
	public int deleteTopic(int tid) {
		String sql = "delete from topic where tid=?";
		return super.executeUpdate(sql, tid);
	}

}
