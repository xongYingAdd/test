<%@page import="cn.jbit.news.entity.*"%>
<%@page import="cn.jbit.news.biz.impl.*"%>
<%@page import="cn.jbit.news.biz.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String opr = request.getParameter("opr");

	TopicService topicService = new TopicServiceImpl();
	if ("list".equals(opr)) {
		List<Topic> list = topicService.findAllTopics();
		request.setAttribute("list", list);
		request.getRequestDispatcher("../newspages/topic_list.jsp")
				.forward(request, response);
	} else if ("add".equals(opr)) {
		//获取新闻主题的名称
		String tname = request.getParameter("tname");

		int count = topicService.addTopic(tname);
		if (count > 0) {
			out.println("<script>alert('当前主题创建成功，点击确认返回主题列表！');location.href='topic_control.jsp?opr=list'</script>");
		} else if (count == -1) {
			out.println("<script>alert('当前主题已经存在，请输入不同的主题！');location.href='../newspages/topic_add.jsp'</script>");
		} else {
			out.println("<script>alert('当前主题创建失败！');location.href='../newspages/topic_add.jsp'</script>");
		}
	} else if ("del".equals(opr)) {
		//获取新闻主题的编号
		int tid = Integer.parseInt(request.getParameter("tid"));

		int count = topicService.deleteTopic(tid);
		if (count > 0) {
			out.println("<script>alert('当前主题删除成功，点击确认返回主题列表！');location.href='topic_control.jsp?opr=list'</script>");
		} else if (count == -1) {
			out.println("<script>alert('当前主题下有新闻，不能删除！');location.href='topic_control.jsp?opr=list'</script>");
		} else {
			out.println("<script>alert('当前主题删除失败，点击确认返回主题列表！');location.href='topic_control.jsp?opr=list'</script>");
		}
	} else if ("update".equals(opr)) {
		//获取新闻主题的编号
		int tid = Integer.parseInt(request.getParameter("tid"));
		//获取新闻主题的名称
		String tname = request.getParameter("tname");
		Topic topic = new Topic();
		topic.setTid(tid);
		topic.setTname(tname);
		int count = topicService.updateTopic(topic);
		if (count > 0) {
			out.println("<script>alert('当前主题更新成功，点击确认返回主题列表！');location.href='topic_control.jsp?opr=list'</script>");
		}
	}
%>
