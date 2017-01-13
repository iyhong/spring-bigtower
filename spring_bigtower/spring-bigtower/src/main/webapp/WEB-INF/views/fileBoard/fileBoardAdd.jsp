<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		//click 함수를 사용하지 않고 on() 함수를 사용해서 click이벤트 감지.. 이렇게 안하면 새로만들어진 버튼에 이벤트가 안걸림
		$(document).on('click', '.add', function() {
			//id가 formgroupcopy 인 태그(요소)의 html소스를 divHtml에 복사
			let
			divHtml = $('#formgroupcopy').html();
			//복사한 소스를 id가 addhtml인 태그에 추가
			$('#addhtml').append(divHtml);
		});
		$(document).on('click', '.del', function() {
			//2보다 크면이라고 한 이유는 display:none 되어있는 것때문에 두개보다크면 이라는 조건을 해줘야함
			if ($('.formgroup').length > 2) {
				$(this).parent().remove();
			} else {
				alert("삭제할수없습니다.");
			}
		});
	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/fileBoardAdd"
		method="post" enctype="multipart/form-data">
		title:<input type="text" name="bTitle"><br>
		 pw:<input type="password" name="bPw"><br>
		 content:<input type="text" name="bContent"><br>
		 mId:<input type="text"	name="mId"><br>
		<div id="addhtml">
			<div class="formgroup">
				file:<input type="file" name="multipartFileList">
				<button type="button" class="add">추가</button>
				<button type="button" class="del">삭제</button>
			</div>
		</div>
		<input type="submit">
	</form>
	<div id="formgroupcopy" style="display:none;">
		<div class="formgroup">
			file:<input type="file" name="multipartFileList">
			<button type="button" class="add">추가</button>
			<button type="button" class="del">삭제</button>
		</div>
	</div>
</body>
</html>