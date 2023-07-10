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
	<%
	ResumeDao dao = ResumeDao.getInstance();
	Resume res = dao.getResumeById("");

	%>
</body>
</html>