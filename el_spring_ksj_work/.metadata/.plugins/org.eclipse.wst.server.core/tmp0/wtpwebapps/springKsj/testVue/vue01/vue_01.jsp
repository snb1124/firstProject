<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vue_01</title>
</head>
<script type="text/javascript" src="https://unpkg.com/vue@2.5.16/dist/vue.js"></script>
<body>
<%
	String s = "첫번째  Vue.js 앱 입니다.!.jsp!";
%>
<div id="simple">
	<h2>{{message}}</h2>
	<h2 v-text="message"></h2>
	<h2 v-html="message"></h2>
</div>
<script>
	let ss = "<%= s %>"
	// Model
	var model= { message: ss };
	
	// ViewModel
	var simple = new Vue({
		el : '#simple',
		data : model
	});
</script>
</body>
</html>