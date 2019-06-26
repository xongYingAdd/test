<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="loginControl.jsp" %>
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
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： admin 登录  &#160;&#160;&#160;&#160; <a href="../util/do_logout.jsp">login out</a></div>
  <div id="channel"> </div>
</div>
</head>
<body>

<div id="main">
  <div id="opt_list">
   <ul>
    <li><a href="util/news_control.jsp?opr=add">添加新闻</a></li>
    <li><a href="util/news_control.jsp?opr=list">编辑新闻</a></li>
    <li><a href="newspages/topic_add.jsp">添加主题</a></li>
    <li><a href="util/topic_control.jsp?opr=list">编辑主题</a></li>
  </ul>
</div>

  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
       
	      <li>《新恋爱时代》登东方卫视 的《非诚》元素遭删除<span> 作者： &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=187' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>《致命黑兰》佐伊坐拥7种武器 暴力登陆全国院线<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=186'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=186' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>"星跳水立方"决战临近 陈楚生被华谊要求进前三<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=185'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=185' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>步行者崩盘主要原因在哪 解决3问题能发起更强挑战<span> 作者：魑魅 &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=184'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=184' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>高中女生邀帕森斯参加舞会 高富帅租豪车护花<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=183'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=183' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>美男篮邀请考辛斯参加训练营 厄文小乔丹同获邀<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=182'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=182' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>“奶粉大盗”穿女人紧身裤作案 裤裆藏货偷20多罐<span> 作者：韦鹏 &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=181'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=181' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>男子用微信“摇一摇”寻找女网友 见面劫财又劫色<span> 作者：陈彧 &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=180'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=180' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>美国学者公开指责奥巴马对台政策变“沉默”<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=179'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=179' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>巴基斯坦中国制ZDK—03预警机和枭龙大批服役<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=178'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=178' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>朱成虎：中美两国均有加强军事合作的意愿<span> 作者：张洁娴 &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=177'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=177' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>菲律宾称仁爱礁是中国在南海的立足点<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=176'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=176' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>我军少将：中印两国不会因领土争端大打出手<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=175'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=175' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>习近平在墨国会发表演讲:朋友要老 好酒要陈<span> 作者：刘潇潇 &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=174'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=174' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>普京逮捕铁腕市长展示肌肉向世人表明克宫仍大权在握<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=173'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=173' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>美国海豹突击队硬汉变性成美女<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=172'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=172' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>潘基文祝贺赖斯被任命为美国国家安全顾问<span> 作者： &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=171'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=171' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>景区，如何不再依靠门票收入<span> 作者：余荣华  &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=167'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=167' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>外星人真的来过地球吗？？<span> 作者：维基解密                                           &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=165'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=165' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>非主流，真可怕<span> 作者：激进八十后                                         &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=164'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=164' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>惊奇！！小虫吃大蛇！<span> 作者：环球搜奇                                           &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=108'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=108' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>伊朗称放弃美元作为外储地位 人民币或上位<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=78'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=78' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>“持械抢劫，当场击毙” 浙江永康现超雷人标语<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=77'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=77' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>国内成品油价格上调几成定局<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=76'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=76' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>俄数百所幼儿园和学校因流感停课<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=75'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=75' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>喀布尔市中心传出爆炸和枪声 目前原因不明<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=74'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=74' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>国台办介绍大陆高校加大对台招生力度情况<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=73'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=73' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>人保部将首次就同工同酬做出规定<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=71'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=71' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>重庆警方否认被围殴致死吸毒者曾针刺民众<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=70'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=70' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>美国一名外交官辞职抗议美对阿富汗政策<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=69'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=69' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>埃及交通部长因致18死火车相撞事故辞职<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=68'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=68' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>无姚时代如何关注内线比拼 新赛季中锋PK五岳崛起<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=67'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=67' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>火箭揭幕战是试金石摸底测验 五号位二选一有玄机<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=66'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=66' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>时过境迁火箭优势变劣势 对抗双塔阿帅只一计可施<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=65'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=65' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>无姚新赛季落寞油然而生 周遭一种改变正悄悄开始<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=64'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=64' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>美媒体称小布乃火箭新核心 一大缺陷令阿帅很担心<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=63'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=63' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>皮特车祸之后仍然开朗 轻松改驾四轮车(图)<span> 作者：pastime                                            &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=62'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=62' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>8名美军士兵在阿富汗遭路边炸弹袭击身亡<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=61'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=61' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>与基地有关组织宣称对巴格达连环爆炸负责<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=60'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=60' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>伊朗将于30日前就核燃料供应方案作出答复<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=59'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=59' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>黎巴嫩以色列再次交火互射炮弹<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=58'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=58' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>河南2个乡镇政绩报告内容完全一致引关注<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=57'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=57' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>莫雷：低姿态总比被高估好 进攻端利器新添三分雨<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=56'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=56' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>《风云2》入魔造型曝光 郑伊健戴高级眼镜<span> 作者：pastime                                            &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=55'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=55' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>《海角七号》导演新片开机 吴宇森等出席1111<span> 作者：pastime                                            &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=53'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=53' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>《沧海》导演回应观众质疑 自信能超越《亮剑》<span> 作者：pastime                                            &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=52'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=52' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>施瓦辛格启动影视业回迁计划 推进加州经济复苏<span> 作者：pastime                                            &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=51'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=51' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>日本首相鸠山首次全面阐述新政府外交政策<span> 作者：out                                                &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=50'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=50' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>发改委：4万亿投资计划不会挤占民间投资空间<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=49'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=49' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=48'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=48' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>深足教练组：说我们买球是侮辱 朱广沪常暗中支招<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=86'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=86' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>省政府500万悬赏建业登顶 球员:遗憾主场放跑国安<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=85'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=85' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>洪元硕：北京人的脸就看你们了 最后一哆嗦看着办<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=84'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=84' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>临界冠军京城夺票总动员 球迷:夺冠!让所有人闭嘴<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=83'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=83' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>一纸传真暗含申花处理态度 国足征调杜威突生悬疑<span> 作者：sport                                              &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=82'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=82' onclick='return clickdel()'>删除</a> </span> </li>
	      
	      <li class='space'></li>
	       
	      <li>气候变化导致海平面上升 <span> 作者：                                                   &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=81'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=81' onclick='return clickdel()'>删除</a> </span> </li>
	       
	      <li>商贸联委会在杭州开会 中美对贸易争端态度低调<span> 作者：news                                               &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=findNew&nid=80'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control.jsp?opr=del&nid=80' onclick='return clickdel()'>删除</a> </span> </li>
	      
    </ul>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</body>
</html>