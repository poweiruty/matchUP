<%@page import="model.job.Job"%>
<%@page import="model.job.JobDao"%>
<%@page import="model.job.JobRequestDto"%>
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
	JobDao dao = JobDao.getInstance();
	Job job = dao.getJob("디자인");
	
	System.out.println(job);	
%>
</body>
</html>