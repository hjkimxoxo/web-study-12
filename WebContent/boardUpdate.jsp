<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
<script type="text/javascript" 
src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$('#modify').on("click", function(){
		var updateBoard = {
				num:$('#num').val(),
				name:$('#name').val(),
				pass:$('#pass').val(),
				email:$('#email').val(),
				title:$('#title').val(),
				content:$('#content').val()};
		$.ajax({
			type:"post",
			url:"boardUpdate.do",
			data: JSON.stringify(updateBoard),
			success:function(data){
				if(data==1){
					alert("수정되었습니다.");
					window.location.href="boardList.do";
				}
			}
		})
	})
	 $('#list').on("click", function(){
	        location.href="boardList.do";
	    });
})
</script>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 수정</h1>
	<!--  <form action="boardUpdate.do" name="frm" method="post">-->
	<input type="hidden" name="num" id="num" value="${board.num}">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="name" id="name" size="12" value="${board.name}"> * 필수</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" id="pass" size="12" value="${board.pass}"> * 필수 (게시물 수정삭제시 필요합니다.)</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" size="40" value="${board.email}"> </td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title" size="70" value="${board.title}"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" id="content" name="content">${board.content}</textarea> </td>
		</tr>
	</table>
	<br>
	<input type="submit" value="수정" id="modify">
	<input type="reset" value="다시 작성">
	<input type="button" id="list" value="목록">
	
</div>
</body>
</html>