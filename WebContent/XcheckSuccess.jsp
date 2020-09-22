<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(window.name=="update"){
		window.opener.parent.location.href=
			"boardUpdate.do?num=${param.num}";
	}else if(window.name=="delete"){
		window.opener.parent.location.href=
			"boardDelete.do?num=${param.num}";
		alert('삭제되었습니다.');
	}
	window.close();
</script>
</head>
<body>

</body>
</html>