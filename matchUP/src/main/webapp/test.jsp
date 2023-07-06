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
	UserDao userDao = UserDao.getInstance();	
	User user = userDao.getUserbyId("1green");
	//UserRequestDto dto = new UserRequestDto(user.getPid(), "qweqwe123", user.getPname(), user.getBirth(), 1065502899, user.getEmail(), user.getUser_address());
	//boolean res = userDao.createUser(dto);		
	
	//userDao.updateUser(dto, "qwe123");
	System.out.println(user);	
	%>
</body>
</html>