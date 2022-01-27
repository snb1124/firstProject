<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vue02_1</title>
<script src="https://unpkg.com/vue@2.5.16/dist/vue.js"></script>
</head>
<body>
<div id="example">
	<p>원본 메시지 : {{message}}</p>
	<p>뒤집히도록 계싼된 메시지 : {{reverseMessage}}</p>
</div>
<script>
	var vm = new Vue({
		el : "#example",
		data: {message:"안녕하세요"},
		computed: {
			reverseMessage: function(){
				return this.message.split('').reverse().join('');
			}
		}	
	});

</script>

</body>
</html>