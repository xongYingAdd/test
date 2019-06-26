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
			//��ȡ�������������
			String tname = request.getParameter("tname");

			int count = topicService.addTopic(tname);
			if (count > 0) {
				out.println("<script>alert('��ǰ���ⴴ���ɹ������ȷ�Ϸ��������б�');location.href='TopicServlet?opr=list'</script>");
			} else if (count == -1) {
				out.println("<script>alert('��ǰ�����Ѿ����ڣ������벻ͬ�����⣡');location.href='newspages/topic_add.jsp'</script>");
			} else {
				out.println("<script>alert('��ǰ���ⴴ��ʧ�ܣ�');location.href='newspages/topic_add.jsp'</script>");
			}
		} else if ("del".equals(opr)) {
			//��ȡ��������ı��
			int tid = Integer.parseInt(request.getParameter("tid"));

			int count = topicService.deleteTopic(tid);
			if (count > 0) {
				out.println("<script>alert('��ǰ����ɾ���ɹ������ȷ�Ϸ��������б�');location.href='TopicServlet?opr=list'</script>");
			} else if (count == -1) {
				out.println("<script>alert('��ǰ�����������ţ�����ɾ����');location.href='TopicServlet?opr=list'</script>");
			} else {
				out.println("<script>alert('��ǰ����ɾ��ʧ�ܣ����ȷ�Ϸ��������б�');location.href='TopicServlet?opr=list'</script>");
			}
		} else if ("update".equals(opr)) {
			//��ȡ��������ı��
			int tid = Integer.parseInt(request.getParameter("tid"));
			//��ȡ�������������
			String tname = request.getParameter("tname");
			Topic topic = new Topic();
			topic.setTid(tid);
			topic.setTname(tname);
			int count = topicService.updateTopic(topic);
			if (count > 0) {
				out.println("<script>alert('��ǰ������³ɹ������ȷ�Ϸ��������б�');location.href='TopicServlet?opr=list'</script>");
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
