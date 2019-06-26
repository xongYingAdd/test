<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:forEach var="news" items="${list}" varStatus="status">
	<li>${news.ntitle}<span> 作者： ${news.nauthor}&#160;&#160;&#160;&#160; <a href='util/news_control.jsp?opr=findNew&nid=183'>修改</a> &#160;&#160;&#160;&#160; <a href='util/news_control.jsp?opr=del&nid=183' onclick='return clickdel()'>删除</a> </span> </li>
	<c:if test="${status.count % 5 == 0 }">      
		<li class='space'></li>
	</c:if>
</c:forEach>
