package cn.jbit.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.news.dao.NewsUsersDao;
import cn.jbit.news.dao.impl.NewsUsersDaoImpl;
import cn.jbit.news.entity.NewsUsers;

public class UserServlet extends HttpServlet {

	private String contextPath;

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	  	String name = request.getParameter("uname");
	  	String pwd = request.getParameter("upwd");
	  	
	    NewsUsersDao newsUsersDao = new NewsUsersDaoImpl();
	    NewsUsers user = new NewsUsers();
	    user.setUname(name);
	    user.setUpwd(pwd);
	    
	    NewsUsers nuser =newsUsersDao.getUserInfo(user);
	  	if(nuser!=null){
	  		//将登录用户对象存入session
	  		request.getSession().setAttribute("loginUser", name);
	  		//session.setMaxInactiveInterval(60*10);
	  		//登录成功，重定向到欢迎页面
	  	response.sendRedirect("newspages/admin.jsp");
	  		//response.sendRedirect(contextPath+"/newspages/admin.jsp");
	  	}else{
	  		out.println("<script>alert('用户名或密码错误，登录失败');location.href='../index.jsp';</script>");
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
