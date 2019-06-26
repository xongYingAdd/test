
<%@page import="cn.jbit.news.entity.NewsUsers"%>
<%@page import="cn.jbit.news.dao.impl.NewsUsersDaoImpl"%>
<%@page import="cn.jbit.news.dao.NewsUsersDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
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
  		session.setAttribute("loginUser", name);
  		//session.setMaxInactiveInterval(60*10);
  		//登录成功，重定向到欢迎页面
  		response.sendRedirect("../newspages/admin.jsp");
  		
  	}else{
  		out.println("<script>alert('用户名或密码错误，登录失败');location.href='../index.jsp';</script>");
  	}
   %>
