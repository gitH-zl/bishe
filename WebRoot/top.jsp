<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width:1400px;
	height:65px;
	z-index:1;
	left: 2px;
	top: 3px;
	background-image: url(img/bg8.jpg);
}
#Layer2 {
	position:absolute;
	width:1000px;
	height:22px;
	z-index:1;
	left: 135px;
	top: 44px;
}
#Layer3 {
	position:absolute;
	width:271px;
	height:28px;
	z-index:2;
	left: 1050px;
	top: 3px;
}
-->
</style>
<script language="javascript" type="text/javascript"> 

function changeimg(topid){
document.getElementById("top1").src='img/12.jpg';
document.getElementById("top2").src='img/22.jpg';
document.getElementById("top3").src='img/32.jpg';
document.getElementById("top4").src='img/42.jpg';




document.getElementById("top"+topid).src ='img/'+topid+'1.jpg';
}


</script>

</head>

<body>
<div id="Layer1">
<span style="font-size: 20px;font-weight: bold;color: white;">
图书在线阅读下载系统
</span> 
  <div  id="Layer2" >

  
  
  	<a href="index" target="_top" onclick="changeimg(1)"><img id="top1" src="img/11.jpg" width="113" height="20" border="0"/></a>&nbsp;&nbsp;
  	<a href="left.jsp?title=1" target="leftFrame" onclick="changeimg(2)"><img id="top2" src="img/22.jpg" width="113" height="20" border="0"/></a>&nbsp;&nbsp;
  	<a href="left.jsp?title=2" target="leftFrame" onclick="changeimg(3)"><img id="top3" src="img/32.jpg" width="113" height="20" border="0"/></a>&nbsp;&nbsp;
 	<a href="left.jsp?title=3" target="leftFrame" onclick="changeimg(4)"><img id="top4" src="img/42.jpg" width="113" height="20" border="0"/></a>&nbsp;&nbsp;  
 	
 
  <div id="Layer3">
  <!--  
    <div align="right">
    <a href="../" target="_top"><span style="color:#ffffff; font-size: 14px;font-weight: bold;">访问首页</span></a>&nbsp;&nbsp;&nbsp;&nbsp; 
    <a href="#" target="_top"><span style="color:#ffffff; font-size: 14px;font-weight: bold;">修改密码</span></a> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="loginout" target="_top"><span style="color:#ffffff; font-size: 14px;font-weight: bold;">安全退出</span></a></div>
  </div>
  -->
</div>
</body>
</html>
