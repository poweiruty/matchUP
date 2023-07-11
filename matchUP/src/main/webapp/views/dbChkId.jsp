<%@page import="java.io.PrintWriter"%>
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
	String id = request.getParameter("id");
	UserDao dao = UserDao.getInstance();
	User user = dao.getUserbyId(id);
	PrintWriter script = response.getWriter();
	String res = "";
	if(user != null){
		script.println("<script>");
		script.println("localStrage.setItem('idChk', 'no')");		
		script.println("</script>");
	}else{
		script.println("<script>");
		script.println("localStrage.setItem('idChk', 'yes')");		
		script.println("</script>");
	}
%>
</body>
</html>