<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- var userName=document.getElementsByName("userName")[0].value;
	
		if(userName==null || userName==""){
		alert("用户名不能为空");
		return;
		} -->
 
	<script type="text/javascript">
	 
		function checkSubmit(){
		
	  	document.forms[0].submit();
	}
	</script>
	

  </head>
  
  <body>
    <form action="<%=path%>/reg" method="post"><br>
    用户名：<input type="text" name="userName"> <font color="red"><form:errors path="userInfo.userName"></form:errors></font>
    <br>
    密码：<input type="password" name="password"> <font color="red"><form:errors path="userInfo.password"></form:errors></font><br>
    确认密码：<input type="password" name="regPassword"> <font color="red"><form:errors path="userInfo.regPassword"></form:errors></font><br>
    手机号：<input type="text" name="phone"> <font color="red"><form:errors path="userInfo.phone"></form:errors></font><br>
    邮箱：<input type="text" name="email"> <font color="red"><form:errors path="userInfo.email"></form:errors></font><br>
    日期：<input type="text" name="data"> <font color="red"><form:errors path="userInfo.data"></form:errors></font><br>
    <input type="button" onclick="checkSubmit()" value="提交"/>
    </form>
  </body>
</html>
