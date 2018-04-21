<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >

     

        <table width="100%">
         <tr>
         <td align="center">
      
         </td>
          <td align="center">
       <span style="font-size: 30px;"> 图书名： ${bean.bookname }</span>
         </td>
         </tr>
        
        <tr>
        <td align="left">图书封面</td>
         <td>图书简介</td>
        </tr>
        <tr>
        <td align="left"> 
        <img src="<%=basePath %>uploadfile/${bean.path1 }" width="180" height="200"/></td>
        <td > ${bean.info} </td>
        </tr>
        </table>
        
        
       
        

<br/>
<br/>

     <div align="center">
   图书内容：<br/>
     <div align="left"  > 
     <textarea rows="20" cols="140">${content}</textarea>
     </div> 
    <div align="center"> ${pagerinfo }</div>
     </div>
  </body>
</html>
