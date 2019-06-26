package cn.jbit.news.biz.impl;

import java.sql.Connection;
import java.util.List;

import cn.jbit.news.biz.TopicService;
import cn.jbit.news.dao.NewsDao;
import cn.jbit.news.dao.TopicDao;
import cn.jbit.news.dao.impl.NewsDaoImpl;
import cn.jbit.news.dao.impl.TopicDaoImpl;
import cn.jbit.news.entity.News;
import cn.jbit.news.entity.Topic;
import cn.jbit.news.util.DataBaseUtil;

public class TopicServiceImpl implements TopicService {
	Connection conn = DataBaseUtil.getConnection();
	TopicDao topicDao = new TopicDaoImpl();
	@Override
	public List<Topic> findAllTopics() {
		Connection conn =null;
		List<Topic> list =null;
		try {
			conn = DataBaseUtil.getConnection();
			TopicDao topicDao = new TopicDaoImpl(conn);
			 list = topicDao.getAllTopics();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public int updateTopic(Topic topic) {
		return topicDao.updateTopic(topic);
	}

	@Override
	public int addTopic(String tname) {
		//查询主题是否已经存在
		Topic topic;
		try {
			topic = topicDao.findTopicByName(tname);
			if(topic==null){
				//添加主题信息
				return topicDao.addTopic(tname);
			}else{
				return -1;  //新闻主题已经存在
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
	}

	@Override
	public int deleteTopic(int tid) {
		NewsDao newsDao = new NewsDaoImpl();
		List<News> list = newsDao.getNewsByTID(tid);
		if(list.size()==0){
			//删除新闻主题信息
			return topicDao.deleteTopic(tid);
		}else{
			return -1;  //该主题下有新闻，不能删除新闻主题信息
		}
	}

}
