
<%@page import="model.user_general.UserRequestDto"%>
<%@page import="model.user_general.User"%>
<%@page import="model.user_corp.CorpUser"%>
<%@page import="model.user_corp.CorpUserRequestDto"%>
<%@page import="model.user_corp.CorpUserDao"%>
<%@page import="model.user_general.UserDao"%>
<%@page import="java.util.ArrayList"%>
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
	UserRequestDto dto = new UserRequestDto("qkrrb0032", "qweasdzxc123", "박규태", 20001120, 1065502899,"qkrrb0032@naver.com", "서울 중랑구");
	//boolean res = userDao.createUser(dto);
	userDao.updateUser(dto, dto.getPpassword());
	
		
%>

+ #2 Plus

</body>
</html>