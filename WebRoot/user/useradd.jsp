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
#Layer1 {
	position:absolute;
	width:1300px;
	height:40px;
	z-index:1;
	top: 10px;
	left: 1px;
	background-image: url(img/bg6.jpg);
	
}
.STYLE1 {font-size: large;font-weight: bold;}
-->
</style>


</head>

<body>
<div id="Layer1">
<div style="padding-top: 10px;padding-left: 20px;">
<span style="color:#ffffff;font-size: 18px;font-weight: bold;" >增加用户</span>
</div></div>
<br/>
<br/>
<br/>
<div style="margin-left:-10px">
<form action="useradd2" method="post" accept-charset="utf-8" >
<table width="1150" height="120" border="1">
  <tr>
    <td width="212" background="img/bg7.jpg"><div align="right" class="STYLE1">真实姓名</div></td>
    <td width="913">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="xingming" size="30"/>
    </td>
  </tr>
  <tr>
    <td width="212" background="img/bg7.jpg"><div align="right" class="STYLE1">用户名</div></td>
    <td width="913">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="username" size="30"/>
    </td>
  </tr>

  

  <tr>
    <td background="img/bg7.jpg"><div align="right" class="STYLE1">操作</div></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="submit" value="提交" style="width: 60px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>
