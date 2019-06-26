<%@page import="cn.jbit.news.util.Page"%>
<%@page import="cn.jbit.news.entity.Topic"%>
<%@page import="cn.jbit.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html>
<head>
   <base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();	
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}
	
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
</script>
</head>

<%
	List<News> list1 = (List<News>)request.getAttribute("list1");
	List<News> list2 = (List<News>)request.getAttribute("list2");
	List<News> list3 = (List<News>)request.getAttribute("list3");
	//List<News> list4 = (List<News>)request.getAttribute("list4");
	List<Topic> list = (List<Topic>)request.getAttribute("list");
	
	if(list1==null && list2==null && list3==null){
	 	request.getRequestDispatcher("util/news_control.jsp?opr=listTitle").forward(request, response);
	 	return;
	}
	
	Page pageObj = (Page)request.getAttribute("pageObj");
	List<News> list4 =pageObj.getNewsList();
	int pageIndex = pageObj.getCurrPageNo();  //当前页码
	int totalPages = pageObj.getTotalPageCount();//总页数
 %>
  
 
<body onload="focusOnLogin()">
  
<div id="header">
  <div id="top_login">
    <form action="UserServlet?opr=login" method="post" onsubmit="return check()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">

<div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>      
          <%
       	for(News news:list2){
        %>  	
     	<li> <a href='news_read.jsp?nid=49'><b> <%=news.getNtitle() %></b></a> </li>      	
     <% } %>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>      
       <%
       	for(News news:list2){
        %>  	
     	<li> <a href='news_read.jsp?nid=49'><b> <%=news.getNtitle() %></b></a> </li>      	
     <% } %>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>      
       <%
       	for(News news:list3){
        %>  	
     	<li> <a href='news_read.jsp?nid=49'><b> <%=news.getNtitle() %></b></a> </li>      	
     <% } %>
      </ul>
    </div>
  </div>


 
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
	      	<li id='class_month'>
	      	<%
	      		int i = 0;
	      		for(Topic topic:list){
	      			i++;
	      	 %>
	      	<a href="util/news_control.jsp?opr=listTitle&tid=<%=topic.getTid() %>"><b> <%=topic.getTname() %> </b></a>
	         <%
	         	if(i%11 == 0){
	          %>
	      	</li><li id='class_month'>
      		<%  }
      		  } %>
      		</li>	
      </ul>
      <ul class="classlist">
          <%
          	int j = 0;
          	for(News news:list4){
          		j++;
           %>    
	      <li><a href='news_info.html'><%=news.getNtitle() %> </a><span> <%=news.getNcreateDate() %> </span></li>
	      <%
	      	if(j % 5 == 0){
	       %>
	       <li class='space'></li>
        <%
        	} 
          } %>	
      </ul>
      <p align="right"> 当前页数:[<%=pageIndex %>/<%=totalPages %>] 
      <%
      	if(pageIndex>1){
       %>
      <a href="util/news_control.jsp?opr=listTitle&pageIndex=1">首页</a>
      <a href="util/news_control.jsp?opr=listTitle&pageIndex=<%=pageIndex-1 %>">上一页</a>
      <% }
      	if(pageIndex<totalPages){
       %>
      <a href="util/news_control.jsp?opr=listTitle&pageIndex=<%=pageIndex+1 %>">下一页</a>
      <a href="util/news_control.jsp?opr=listTitle&pageIndex=<%=totalPages %>">末页</a>
      <% } %>
      </p>
    </div>   
<div class="picnews">
  <ul>
    <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
    <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">百度</a> </li>
      <li> <a href="#">谷歌</a> </li>
      <li> <a href="#">新浪</a> </li>
      <li> <a href="#">网易</a> </li>
      <li> <a href="#">搜狐</a> </li>
      <li> <a href="#">人人</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>
</body>

</html>
܀@$ĀĀ⢏污ࠀǤŰ Ɛ蠀ȃ㄁新宋体yoiaSCS-ExtBm Condold新宋体yoiaSCS-ExtBm Condold슬豈