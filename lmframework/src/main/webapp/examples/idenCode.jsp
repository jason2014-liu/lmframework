<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'idenCode.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function reloadCode(){
			alert(99);
			//import point: add 'rc=Math.random()'
			document.getElementById('num').src = "<%=basePath%>IdenCodeServlet?rc="+Math.random();
		}
	</script>

  </head>
  
  <body>
    <table> 
            <tr> 
                <td valign="middle" align="right"> 
                验证码:<input type="text" id="input_checkcode"> 
                <a><img src="<%=basePath%>servlet/IdenCodeServlet" alt="" id="num" /></a>
                <a onclick="reloadCode()">看不清楚,换一张</a>
                </td>
            </tr> 
        </table> 
  </body>
</html>
