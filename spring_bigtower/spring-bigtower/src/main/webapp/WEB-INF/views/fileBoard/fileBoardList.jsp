<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>File Board List</h1>
	
	<table border="1">
	
		<tr>
			<td>no</td>
			<td>title</td>
			<td>content</td>
			<td>date</td>
			<td>files</td>
		</tr>
		<c:forEach var="bf" items="${boardFilesList}">
		<tr>
			<td>${bf.bNo}</td>
			<td>${bf.bTitle}</td>
			<td>${bf.bContent}</td>
			<td>${bf.bDate}</td>
			<td>
				<c:forEach items="${bf.filesList}" var="filesList">
					<a href="/resources/${filesList.fName}">${filesList.fPath}${filesList.fName}</a> 
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href="\resources\upload\1.jpg">ddddd</a>
	<a href="http://www.naver.com">ddddd</a>
</body>
</html>