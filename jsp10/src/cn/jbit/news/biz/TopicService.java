package cn.jbit.news.biz;

import java.util.List;

import cn.jbit.news.entity.Topic;

/**
 * ��������ҵ��ӿ�
 * @author Administrator
 *
 */
public interface TopicService {
	public List<Topic> findAllTopics();

	public int updateTopic(Topic topic);
	
	public int addTopic(String tname);

	public int deleteTopic(int tid);
}
