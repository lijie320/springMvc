<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.util.JavaScriptUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	/*
	  url 发送请求地址
	      方法类型 get或者post
	      参数 通过键=值 方式
	      回调函数 当结果返回后 自动调用的函数 第一个参数返回的的结果
	  funtion（responseText）{}
	
	*/
   	  function sendAjax(url,methodType,param,retnFuntion){
   	  var xmlhttp=null;
   	  if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//回調函數 當請求發送后 收到結果自動調用該方法
   	  xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				retnFuntion(xmlhttp.responseText)
			}
   	  }
   	  if(methodType=="get" || methodType=="GET" ){
				  xmlhttp.open("GET", url+"?"+param, true);
				  xmlhttp.send();
			}else{
				  xmlhttp.open("POST", url, true);
				  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
				  xmlhttp.send(param);
			}
		}
	
	
	  function query(){
	  var foodName=document.getElementsByName("foodName")[0].value;
	  sendAjax("${pageContext.request.contextPath}/myQueryFood","GET","foodName="+foodName,function(responseText){
	       //返回的是字符串的json
	      var resutlJson = responseText;
			//转换为js对象
		  var resutlObj = JSON.parse(resutlJson);
			//获取表格对象
		  var table = document.getElementById("myTable");
			//将所有名字为dataTr的tr全部删除
		  var allDataTr = document.getElementsByName("dataTr");
		  var length = allDataTr.length;
		  for(var i=0;i<length;i++){
		      table.removeChild(allDataTr[0]);
		  }
			//根据json的行数追加多个tr
		  for(var i=0;i<resutlObj.length;i++){
			  var obj = resutlObj[i];
			  var td = document.createElement("td");
			  td.innerText=obj.foodname;
			  var td1 = document.createElement("td");
			  td1.innerText=obj.money;
			  var td2 = document.createElement("td");
			  var ib = document.createElement("button");
			  ib.innerText="删除";
			  var up = document.createElement("button");
			  up.innerText="修改";
			  td2.appendChild(ib);
			  td2.appendChild(up);
			  var tr = document.createElement("tr");
				//将当前行的json对象绑定到当前按钮
			  ib.foodobj=obj;
				//将当前行的tr对象绑定到当前按钮
			  ib.myLineTr=tr;
				//删除按钮的事件
			  ib.addEventListener("click",function(){
				  var eventSrc=event.srcElement;
					//删除当前行，发送ajax请求到后台 删除数据库
				  table.removeChild(eventSrc.myLineTr);
				  sendAjax("${pageContext.request.contextPath}/deleteFood/"+eventSrc.foodobj.foodid,"POST","_method=delete",function(responseText){
					  if(responseText==1){
					      alert("删除成功！");
					  }else{
					       alert("删除失败！");
					  }
			        });
			    });
			up.foodobj=obj;
			up.addEventListener("click",function(){
				var eventSrc=event.srcElement;
				document.getElementById('updateDiv').style.display='block';
				document.getElementsByName("umyFoodName")[0].value=eventSrc.foodobj.foodname;
				document.getElementsByName("umyMoney")[0].value=eventSrc.foodobj.money;
				document.getElementsByName("umyFoodId")[0].value=eventSrc.foodobj.foodid;
			});
			tr.setAttribute("name", "dataTr");
			tr.appendChild(td);
			tr.appendChild(td1);
			tr.appendChild(td2)
			table.appendChild(tr);
	    }
	 });
	  //无刷新调用地址 获取数据 数据通过dom方式到tabel中 
	  //ajax(异步的jax) 

	//var xmlhttp=null;
	//兼容所有浏览器创建这个对象xhr对象
		//if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			//xmlhttp = new XMLHttpRequest();
		//} else {// code for IE6, IE5
			//xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		//}
		//回调函数 当请求发送后，收到结果自动调用该方法
		//xmlhttp.onreadystatechange = function() {
			//if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {	
			//}
		//}
		//取文本框里的内容 
		//open表示产生一个气请求的关联（get 提交）
		//xmlhttp.open("GET", "${pageContext.request.contextPath}/myQueryFood?foodName="+foodName, true);
		//xmlhttp.send();
		
		//xmlhttp.open("POST", "${pageContext.request.contextPath}/myQueryFood", true);
		//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
		//xmlhttp.send("foodName="+foodName);
	}
	
	function saveFood(){
	    var foodName=document.getElementsByName("myFoodName")[0].value;
	    var myMoney=document.getElementsByName("myMoney")[0].value;
	    sendAjax("${pageContext.request.contextPath}/saveFood","POST","foodname="+foodName+"&money="+myMoney,function(responseText){
			if(responseText==1){
				document.getElementById('addDiv').style.display='none';
				query();
				alert("新增成功！");
			}else{
				alert("新增失败！");
			}
		});
	}
	
	function updateFood(){
	    var foodid=document.getElementsByName("umyFoodId")[0].value;
	    var foodName=document.getElementsByName("umyFoodName")[0].value;
	    var myMoney=document.getElementsByName("umyMoney")[0].value;
	    sendAjax("${pageContext.request.contextPath}/updateFood/"+foodid,"POST","_method=put&foodname="+foodName+"&money="+myMoney,function(responseText){
			if(responseText==1){
				document.getElementById('updateDiv').style.display='none';
				query();
				alert("修改成功！");
			}else{
				alert("修改失败！");
			}
		});
	}
</script>

  </head>
  
  <body>
   	<input type="text" name="foodName"/>
   	<input type='button' value="查询" onclick="query()"><input type='button' value="新增" onclick="document.getElementById('addDiv').style.display='block';">
   	<table id="myTable">
   	<tbody id="a"> 
   	  <tr><th>菜品名</th><th>菜品价格</th><th>操作</th></tr>
   	  </tbody>
   	</table>
  </body>
  
  <div id="addDiv" style="display:none; position:absolute; left: 40%;top: 40%;z-index:100;border: 1px solid black;width: 250px;height: 200px">
  菜品名：<input type="text" name="myFoodName">
  价&nbsp;格：<input type="text" name="myMoney">
  <input type="button" value="保存" onclick="saveFood()"><input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';">
  
  </div>
  
    <div id="updateDiv" style="display:none; position:absolute; left: 40%;top: 40%;z-index:100;border: 1px solid black;width: 250px;height: 200px">
    <input type="hidden" name="umyFoodId">
  菜品名：<input type="text" name="umyFoodName">
  价&nbsp;格：<input type="text" name="umyMoney">
  <input type="button" value="修改" onclick="updateFood()"><input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';">
  
  </div>
</html>
