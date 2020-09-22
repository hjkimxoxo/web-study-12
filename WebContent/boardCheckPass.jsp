<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#submit").click(function(e){
		  var pass_check = {num:$("#num").val(), pass:$("#pass").val()};
		  e.preventDefault();
		  $.ajax({
	            type : "post",
	            url : "boardCheckPass.do",
	            data : pass_check,
	            cache : false,
	            success: function(data){
	               if (data == 1){
	            	  
	            	   alert("비밀번호가 틀렸습니다.");
	               }
	               if (data == 2){
	                  //window.location.href="checkSuccess.jsp?num="+ ${param.num};
	                  if (window.name == "update"){
	                     window.opener.parent.location.href="boardUpdate.do?num=${param.num}";
	                  } else if (window.name == "delete"){
	                     alert("삭제되었습니다.");
	                     window.opener.parent.location.href="boardDelete.do?num=${param.num}";
	                  }
	                  window.close();
	               }
	            }
	         })

		})
	});
</script>
</head>
<body>
<div align="center">
	<h1>비밀번호 확인</h1>
	<form name="frm" method="post" action="boardCheckPass.do">
	<input type="hidden" name="num" id="num" value="${param.num}">
	<table style="width:20%">
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" id="pass" size="10"></td>
		</tr>
	</table>
	<br>
	<input type="submit" id="submit" value="확인">
	<br>${message}
	</form>
</div>
</body>
</html>