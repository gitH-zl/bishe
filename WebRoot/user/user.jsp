<%@ page language="java" pageEncoding="UTF-8"%>
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

<script language="javascript" type="text/javascript" src="jquery.min.js"></script>

<script language="javascript" type="text/javascript">

function checkregisterform()
{
	 
	

	if (document.getElementById('password2id').value=="")
	{
		alert("新密码不能为空");
		return false;
	}
	if (document.getElementById('password2id').value.length<6)
	{
		alert("新密码长度必须大于6位");
		return false;
	}
	if (document.getElementById('password3id').value != document.getElementById('password2id').value)
	{
		alert("确认密码与密码不一致");
		return false;
	}	 
	
	return true;
	
}




</script>
</head>

<body>
<div id="Layer1">
<div style="padding-top: 10px;padding-left: 20px;">
<span style="color:#ffffff;font-size: 18px;font-weight: bold;" >修改用户密码</span>
</div></div>
<br/>
<br/>
<br/>
<div style="margin-left:-10px">
<form onsubmit="return checkregisterform()" method="post" action="passwordupdate">
<table width="1150" height="120" border="1">
	<tr>
    <td background="img/bg7.jpg"><div align="right" class="STYLE1">用户名</div></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    ${user.username }
    </td>
  	</tr>
  <tr>
    <td width="212" background="img/bg7.jpg"><div align="right" class="STYLE1">原密码</div></td>
    <td width="913">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="password" name="password1" id="password1id"/> 
    </td>
  </tr>
  <tr>
    <td width="212" background="img/bg7.jpg"><div align="right" class="STYLE1">新密码</div></td>
    <td width="913">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="password" name="password2" id="password2id"/> 
    </td>
  </tr>
  <tr>
    <td width="212" background="img/bg7.jpg"><div align="right" class="STYLE1">确认新密码</div></td>
    <td width="913">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="password" name="password3" id="password3id"/> 
    </td>
  </tr>
  <tr>
    <td background="img/bg7.jpg"><div align="right" class="STYLE1">操作</div></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="submit" value="修改" style="width: 60px"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>
