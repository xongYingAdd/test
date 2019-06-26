<%@page import="cn.jbit.news.util.Page"%>
<%@page import="cn.jbit.news.entity.*"%>
<%@page import="cn.jbit.news.biz.impl.*"%>
<%@page import="cn.jbit.news.biz.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String opr = request.getParameter("opr");
	NewsService newsService = new NewsServiceImpl();
	TopicService topicService = new TopicServiceImpl();
	
	if("listTitle".equals(opr)){
		List<News> list1 = newsService.getLatestNewsByTID(1, 5);
		List<News> list2 = newsService.getLatestNewsByTID(2, 5);
		List<News> list3 = newsService.getLatestNewsByTID(3, 5);
		List<Topic> list = topicService.findAllTopics();
		//List<News> list4 = null;
		
		String pageIndex = request.getParameter("pageIndex");
		if(pageIndex==null){
			pageIndex = "1";
		}
		
		int currPageNo = Integer.parseInt(pageIndex);
		if(currPageNo<1){
			currPageNo = 1;
		}
		
		Page pageObj = new Page();
		pageObj.setCurrPageNo(currPageNo);
		pageObj.setPageSize(15);
		newsService.findPageNews(pageObj);
		
		
		
		
		/* String tid = request.getParameter("tid");
		if(tid == null){
			list4 = newsService.getAllNews();
		}else{
			list4 = newsService.getNewsByTID(Integer.parseInt(tid));
		} */
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list", list);
		//request.setAttribute("list4", list4);
		request.setAttribute("pageObj", pageObj);
		request.getRequestDispatcher("../index.jsp").forward(request,response);
	}
 %>
