<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>图书在线阅读下载系统</title>
    <%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
html,body{
	font-size: 12px;
	margin:0px;
	height:100%;
}
.InputCss {  
    font-size: 12px; 
    font-family: ""; 
    border: 1px #93BEE2 solid; 
}
</style>
<script type="text/javascript">


	
function IsValid()
{
	if (document.form1.adminId.value=="")
	{
		alert("帐号不能为空");
		document.form1.adminId.focus();
		return false;
	}
	if (document.form1.passWord.value=="")
	{
		alert("密码不能为空");
		document.form1.passWord.focus();
		return false;
	}
	document.getElementById("login").disabled="true";
	return true;
}
</script>
<style type="text/css"><!--body { background-image: url(img/bg.jpg);}--></style>
</head>
<body>
   <form name="form1" onSubmit="return IsValid();" action="login" method="post">
     <div><center>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table border="0" cellpadding="0" cellspacing="0"  bordercolor="#111111" width="420" id="AutoNumber1" height="250" style="border-collapse: collapse; border: 2px solid #0000FF">
              <tr> 
                <td height="18" bgcolor="#0000FF" colspan="4" align="left">&nbsp;<font color="#FFFFFF" size="2"><b>系统登录</b></font></td>
              </tr>
              <tr>
                <td height="75" colspan="4" align="left" background="images/loginIn.gif"> 
                  <font color="#FF0000" size="4">&nbsp;&nbsp;&nbsp;<strong>图书在线阅读下载系统</strong></font></td>
              </tr>
              <tr>
                <td height="5" background="images/loginLine.gif" colspan="4"></td>
              </tr>
              <tr>
                <td width="72" align="center" bgcolor="#ECE9D8" style="width: 71px; height: 51px;"><img border="0" src="images/computer.gif" width="27" height="31"/></td>
                <td colspan="3" align="left" bgcolor="#ECE9D8" style="height: 51px">请在下面区域登录</td>
              </tr>
              <tr>
                <td bgcolor="#ECE9D8" height="89" rowspan="3" style="width: 71px"></td>
                <td width="60" align="right" bgcolor="#ECE9D8" style="height: 30px; width: 60px;">帐号：</td>
                <td colspan="2" align="left" bgcolor="#ECE9D8" style="height: 30px">
                    <input class="InputCss" type="text" name="adminId" style="width:150px" value="${adminId}" /> <span style="color:#FF0000">${errorMessage}</span></td>
              </tr>
              <tr>
                <td bgcolor="#ECE9D8" align="right" style="height: 30px; width: 60px;">密码：</td>
                <td colspan="2" align="left" bgcolor="#ECE9D8" style="height: 30px"> 
                    <input class="InputCss" type="password" name="passWord" style="width:150px" /></td>
              </tr>
              <tr>  
                <td bgcolor="#ECE9D8" style="height: 40px; width: 60px;"></td>
                <td width="255" align="right" bgcolor="#ECE9D8" style="height: 40px;"> 
                    <input name="login" type="submit" id="login" value="登录" style="width:80px" />
                             &nbsp; &nbsp; &nbsp;<input name="reset" type="reset" id="reset" value="取消" style="width:60px" />
                </td>
                <td width="29" bgcolor="#ECE9D8" style="height: 40px">&nbsp;</td>
              </tr>
            </table>
            <br />
            <table border="0" cellpadding="0" cellspacing="0" width="420">
            <tr>
            <td>
         
                </td>
			</tr>
		</table>
      </center></div>
    </form>
</body>
</html>