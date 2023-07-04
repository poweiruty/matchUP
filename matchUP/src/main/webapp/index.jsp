<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserDao"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
matchUP 프로젝트
test #1
I got you

<%	
	UserDao userDao = UserDao.getInstance();
	
	ArrayList<User> list = userDao.getUserAll();
	for(User user : list){
		System.out.println("-------------------------");
		System.out.println(user);
	}
%>

+ #2 Plus

</body>
</html>