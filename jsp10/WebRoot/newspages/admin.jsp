
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="loginControl.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻发布系统管理后台</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function()
{
function initNews()
{
$.ajax({
"url":"../util/news",
"type":"GET",
"data":"opr=list",
"dataType":"json",
"success":"processNewList"
});
}
function processNewsList(data)
{
var $newsList=$("#opt_area>ul").empty();//展示新闻
 for(var i=0;i<data.length;)
 {
 $newsList.append("<li>"+data[i].ntitle+"<span>作者:"
 +data[i].nauthor+"$nbsp;$nbsp;$nbsp;$nbsp;"
 +"<a href='#'>修改</a>$nbsp;$nbsp;$nbsp;$nbsp;"
 +"<a href='#'>onclick='return clickdel()'>删除</a>"
 +"</span></li>");
 if((++i)%5==0)
 {
 $newsList.append("<li class='space'></li>");
 }
 }
}
initNews();
});
</script>
</head>

<body>
	<div id="header">
		<div id="welcome">欢迎使用新闻管理系统！</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
		</div>
	</div>
	<div id="admin_bar">
		<div id="status">
			管理员：<%=session.getAttribute("loginUser")%>
			登录 &#160;&#160;&#160;&#160; <a href="util/do_logout.jsp">login
				out</a>
		</div>
		<div id="channel"></div>
	</div>
	<div id="main">
		<div id="opt_list">
			<ul>
				<li><a href="util/news_control.jsp?opr=findTopics">添加新闻</a>
				</li>
				<li><a href="util/news_control.jsp?opr=list">编辑新闻</a>
				</li>
				<li><a href="newspages/topic_add.jsp">添加主题</a>
				</li>
				<li><a href="TopicServlet?opr=list">编辑主题</a>
				</li>
			</ul>
		</div>

		<div id="opt_area">
			<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
			<ul class="classlist">

				<li>《新恋爱时代》登东方卫视 的《非诚》元素遭删除<span> 作者：
						&#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a>
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=del&nid=187'
						onclick='return clickdel()'>删除</a> </span></li>

				<li>《致命黑兰》佐伊坐拥7种武器 暴力登陆全国院线<span> 作者：
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=findNew&nid=186'>修改</a>
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=del&nid=186'
						onclick='return clickdel()'>删除</a> </span></li>

				<li>"星跳水立方"决战临近 陈楚生被华谊要求进前三<span> 作者：
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=findNew&nid=185'>修改</a>
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=del&nid=185'
						onclick='return clickdel()'>删除</a> </span></li>

				<li>步行者崩盘主要原因在哪 解决3问题能发起更强挑战<span> 作者：魑魅
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=findNew&nid=184'>修改</a>
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=del&nid=184'
						onclick='return clickdel()'>删除</a> </span></li>

				<li>高中女生邀帕森斯参加舞会 高富帅租豪车护花<span> 作者：
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=findNew&nid=183'>修改</a>
						&#160;&#160;&#160;&#160; <a
						href='util/news_control.jsp?opr=del&nid=183'
						onclick='return clickdel()'>删除</a> </span></li>

				<li class='space'></li>


			</ul>
		</div>
	</div>
	<div id="footer">
		<div id="site_link">
			<a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span>
			<a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span>
			<a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span>
			<a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span>
			<a href="#">留言反馈</a>
		</div>
		<div id="footer">
			<p class="">
				24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a>
				&#160;&#160;&#160;&#160; 新闻热线：010-627488888<br />
				文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a>
			</p>
			<p class="copyright">
				Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
				新闻中国 版权所有
			</p>
		</div>
</body>
</html>