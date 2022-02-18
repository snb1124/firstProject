<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	
	$('#kakaoPay').click(function(){
		$.ajax({
			url : 'kakaoPay.cd',
			dataType : 'json',
			success : function(data){
				var box = data.next_redirect_pc_url;
				var tid = data.tid;
				$("#tid").val(data.tid);
				console.log(data);
				window.open(box);
			},
			error : function(error){
				console.log(error);
			}	
		});
	});
});
</script>
</head>
<body>

 
<h1> kakaoPay api 이용하기 </h1>
 <form method="post" id="kakaoPay">  
    <input type ="button"  id="kakaoPay"name="kakaoPay" value="카카오페이로 결제하기">
</form>
 
 
</body>
</html>