package cn.jbit.news.dao;

import java.util.List;

import cn.jbit.news.entity.Topic;

/**
 * 新闻主题DAO接口
 * @author Administrator
 *
 */
public interface TopicDao {
	
	public List<Topic> getAllTopics();
	
	public int updateTopic(Topic topic);
	
	public Topic findTopicByName(String tname) throws Exception;
	
	public int addTopic(String tname);
	
	public int deleteTopic(int tid);
}
