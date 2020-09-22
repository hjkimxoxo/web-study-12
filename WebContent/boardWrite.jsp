<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
$(function() {
    $('#add').on("click", function() {
       if ($("#name").val() == ""){
          alert("작성자를 입력하세요.")
          $("#name").focus()
          return false
       }
       if ($("#pass").val() == ""){
          alert("비밀번호를 입력하세요.")
          $("#pass").focus()
          return false
       }
       if ($("#title").val() == ""){
          alert("제목을 입력하세요.")
          $("#title").focus()
          return false
       }
       
       var newBoard = {
          name : $('#name').val(),
          pass : $('#pass').val(),
          email : $('#email').val(),
          title : $('#title').val(),
          content : $('#content').val()
       };
       $.ajax({
          type : "post",
          url : "boardWrite.do",
          cache : false,
          data : JSON.stringify(newBoard),
          success : function(data) {
        	  if(data==1){
	             alert("추가되었습니다.");
	             window.location.href = "boardList.do";
        	  }
          }
       });
    });
 });

</script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 등록</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="name" id="name"> * 필수</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" id="pass"> * 필수</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email"> </td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" id="title" size="70"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content" id="content"></textarea> </td>
		</tr>
	</table>
	<br>
	<input type="submit" id="add" value="등록">
	<input type="reset" value="취소">
	<input type="button" value="목록" onclick="location.href='boardList.do'">
	</form>
</div>
</body>
</html>