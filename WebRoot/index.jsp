<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="util.Util"%>

<% 
Util.init(request);
if (session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<html>
<head>
<% 
response.setHeader("Pragma","No-Cache");   
response.setHeader("Cache-Control","No-Cache");   
response.setDateHeader("Expires",0);
%>
    <title>图书在线阅读下载系统</title>
    <style type="text/css">
    html,body{
         margin:0px;
         height:100%;
    }
    </style>
</head>
<noscript>
<iframe src="*.htm"></iframe>
</noscript>

<frameset rows="68,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="no"  >
  <frameset rows="*" cols="190,*" framespacing="4" frameborder="yes" border="0">
    <frame src="left.jsp" name="leftFrame" scrolling="no">
    <frame src="main.jsp?info1=${info1 }&info2=${info2 }&info3=${info3 }&info4=${info4 }&info5=${info5 }&info6=${info6 }" name="mainFrame" scrolling="no">
  </frameset>
</frameset>

<noframes><body>
</body></noframes>
</html>