<%@ page language="java" pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- TemplateBeginEditable name="doctitle" -->
<title>无标题文档</title>
<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" --><!-- TemplateEndEditable -->
<style type="text/css">
<!--
a {
	color: black;
	font-weight: bold;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}
#Layer1 {
	position:absolute;
	width:185px;
	height:590px;
	z-index:1;
	left: 4px;
	top: 3px;
	background-image: url(img/bg5.jpg);
}
#Layer2 {
	position:absolute;
	width:186px;
	height:22px;
	z-index:2;
	left: 3px;
	top: 2px;
	background-image: url(img/bg4.jpg);
}
.STYLE1 {font-size: x-large}
.STYLE2 {
	font-size: 18px;
	font-weight: bold;
	color: #ffffff;
}
-->
#Layer3 {
	position:absolute;
	width:156px;
	height:356px;
	z-index:3;
	left: 19px;
	top: 45px;
}
.STYLE3 {font-size: 15px;font-weight: bold;}
</style>
</head>

<body style="background-image: url(5.jpg);">
<%
String title = request.getParameter("title");
if(title==null){
	title = "首页";
}else if("1".equals(title)){
	title = "图书信息";
}else if("3".equals(title)){
	title = "系统设置";
}


%>
<div id="Layer1">
</div>
<div class="STYLE1" id="Layer2">
  <div align="center" class="STYLE2" style="padding-top: 5px;"><%=title %></div>
</div>
 <div id="Layer3">
  <div align="center" class="STYLE3">
  <%
  if("图书信息".equals(title)){
	  out.println("<a href='book/booklist2' target='mainFrame'>图书信息</a>");
	  out.println("<br/><br/>");
	  
  }else if("系统设置".equals(title)){
	  out.println("<a href='user/user.jsp' target='mainFrame'>修改密码</a>");  
  }else{
	  out.println("<a href='loginout' target='_top'>安全退出</a>");
	  
  }
  %>
  
  
  </div>
</div>
</body>
</html>
