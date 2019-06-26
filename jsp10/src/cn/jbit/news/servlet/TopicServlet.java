package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.biz.TopicService;
import cn.jbit.news.biz.impl.TopicServiceImpl;
import cn.jbit.news.entity.Topic;

public class TopicServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TopicServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String opr = request.getParameter("opr");

		TopicService topicService = new TopicServiceImpl();
		if ("list".equals(opr)) {
			List<Topic> list = topicService.findAllTopics();
			request.setAttribute("list", list);
			request.getRequestDispatcher("newspages/topic_list.jsp")
					.forward(request, response);
		} else if ("add".equals(opr)) {
			//获取新闻主题的名称
			String tname = request.getParameter("tname");

			int count = topicService.addTopic(tname);
			if (count > 0) {
				out.println("<script>alert('当前主题创建成功，点击确认返回主题列表！');location.href='TopicServlet?opr=list'</script>");
			} else if (count == -1) {
				out.println("<script>alert('当前主题已经存在，请输入不同的主题！');location.href='newspages/topic_add.jsp'</script>");
			} else {
				out.println("<script>alert('当前主题创建失败！');location.href='newspages/topic_add.jsp'</script>");
			}
		} else if ("del".equals(opr)) {
			//获取新闻主题的编号
			int tid = Integer.parseInt(request.getParameter("tid"));

			int count = topicService.deleteTopic(tid);
			if (count > 0) {
				out.println("<script>alert('当前主题删除成功，点击确认返回主题列表！');location.href='TopicServlet?opr=list'</script>");
			} else if (count == -1) {
				out.println("<script>alert('当前主题下有新闻，不能删除！');location.href='TopicServlet?opr=list'</script>");
			} else {
				out.println("<script>alert('当前主题删除失败，点击确认返回主题列表！');location.href='TopicServlet?opr=list'</script>");
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
				out.println("<script>alert('当前主题更新成功，点击确认返回主题列表！');location.href='TopicServlet?opr=list'</script>");
			}
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
