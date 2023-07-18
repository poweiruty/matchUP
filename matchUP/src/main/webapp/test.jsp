<%@page import="java.util.ArrayList"%>
<%@page import="model.resume.Resume"%>
<%@page import="model.resume.ResumeDao"%>
<%@page import="model.user_general.UserRequestDto"%>
<%@page import="model.user_general.User"%>
<%@page import="model.user_general.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="myInput">
	<p id="output"></p>
	<script>
	const input = document.getElementById('myInput');
	const output = document.getElementById('output');

	input.addEventListener('input', function() {
	  output.textContent = input.value;
	});
	
	</script>
</body>
</html>