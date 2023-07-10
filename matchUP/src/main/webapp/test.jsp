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
	<%
	UserDao dao = UserDao.getInstance();
	User res = dao.getUserbyId("green");
	ArrayList<User> list = dao.getUserAll();
	
/* 	for(User user : list){
		System.out.println(user);
	} */
	System.out.println(res);
	
	

	%>
</body>
</html>