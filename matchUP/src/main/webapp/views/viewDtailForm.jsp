<%@page import="model.JobPost.JobPostDto"%>
<%@page import="model.JobPost.JobPostDao"%>
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
	int post_id = Integer.parseInt(request.getParameter("post_id")); 
	JobPostDao dao = JobPostDao.getInstance();
	JobPostDto dto = dao.getJobPostbyId(post_id);
%>
	<p><%=dto %></p>
</body>
</html>