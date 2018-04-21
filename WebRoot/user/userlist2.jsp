<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- TemplateBeginEditable name="doctitle" -->
<title>无标题文档</title>
<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>


<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	width:1150px;
	height:32px;
	z-index:1;
	top: 10px;
	left: -1px;
	background-image: url(img/bg6.jpg);
}
.STYLE1 {font-size: large}
#Layer2 {
	position:absolute;
	width:1150px;
	height:32px;
	z-index:2;
	left: -2px;
	top: 85px;
	background-image: url(img/bg4.jpg);
}

body,th {font-size: 12px;color: #435f79;}
a {
	color: #435f79;
}
a:hover {
	text-decoration: none;
}
-->
</style>
<script src="../js/Common.js" type="text/javascript"></script>
<script type="text/javascript">
function delbanci()
{
	if(IsCheckReturnCount()>=1)
	{
		if(MessgerBox('确定删除吗？'))
		{
			form1.action="userdel";
			form1.submit();
		}
	}else{
		alert("请选择要删除的项！");
        return false;
	}
}

function bancishow(id){
		window.showModalDialog("bancishow?id="+id, null, 
		'dialogWidth:300px;dialogHeight:300px;help:no;unadorned:no;resizable:no;status:no;scroll:yes');
	}
</script>
</head>

<body>
<div id="Layer1">
<div style="padding-top: 5px;padding-left: 20px;">
<span style="color:#ffffff;font-size: 18px;font-weight: bold;" >教师信息列表</span>
</div>
</div>
<br/>
<br/>
<br/>

<a href="####" onclick="javascript:history.go(-1);"><img src="img/fanhui.jpg" width="56" height="27" border="0"/></a>
<div id="Layer2">

<form action="usersearch" method="post" accept-charset="utf-8">
<div style="padding-top: 5px;padding-left: 20px;">
<span style="color:#ffffff;font-size: 18px;font-weight: bold;" >老师姓名：</span><input type="text" size="30" name="keyword"/> 
</div>
<div style="margin-top:  -25px;padding-left: 400px;">
<input type="image" src="img/sosuo.jpg"/>
 </div>
</form>

</div>
<br/>
<br/>
<br/>
<br/>
<table style="width: 100%;" cellpadding="" cellspacing="0">
			<tr>
				<td>
					<form name="form1" method="post">
						<table cellpadding="5" cellspacing="0" style="width: 100%;border-collapse:collapse;
							background-color: #edf3f7;">
							<tr>
								<th  align="center">
									选择
								</th>
								<th  align="center">
									教师姓名
								</th>
								<th  align="center">
									密码
								</th>
								<th  align="center">
									教师编号
								</th>
								<th  align="center">
									性别
								</th>
								<th  align="center">
									出生年月
								</th>
								<th  align="center">
									名族
								</th>
								<th  align="center">
									政治面貌
								</th>
								<th  align="center">
									职称
								</th>
								<th  align="center">
									就职单位
								</th>

								
								
							</tr>
							<c:forEach items="${list}" var="bean" varStatus="row">
								<tr onmouseover="this.style.backgroundColor='#e0ffff';"
									onmouseout="this.style.backgroundColor='';">
									<td align="center">
										<input id="chk_row" name="ids" type="checkbox"
											onclick="uncheckAll()" value="${bean.id}" />
									</td>
									<td align="center">
										${bean.xingming}
									</td>
									<td align="center">
										${bean.password}
									</td>
									<td align="center">
										${bean.jiaoshibianhao}
									</td>
									
									<td align="center">
										${bean.sex}
									</td>
									<td align="center">
										${bean.chushengnianyue}
									</td>
									<td align="center">
										${bean.mingzu}
									</td>
									<td align="center">
										${bean.zhezhimianmao}
									</td>
									<td align="center">
										${bean.zhichen}
									</td>
									<td align="center">
										${bean.jiuzhidanwei}
									</td>

									
								</tr>
							</c:forEach>
						</table>

						<table style="width: 100%;" cellpadding="0" cellspacing="0">
							<tr>
								<td height="8"></td>
							</tr>
						</table>
						<table id="tbbottom" style="width: 100%;" cellpadding="0"
							cellspacing="0" align="center" border="0">
							<tr>
								<td align="center" style="width: 65px; height: 30px;">
									<input id="chk_selall" type="checkbox" onclick="CheckAll()" />
									全选
								</td>
								<td width="400" align="center">
									${pagerinfo }
								</td>
								<td align="right" style="padding-right: 15px;">
									
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
</body>
</html>
