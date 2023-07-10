<%@page import="java.util.ArrayList"%>
<%@page import="model.resume.Resume"%>
<%@page import="model.resume.ResumeRequestDto"%>
<%@page import="model.resume.ResumeDao"%>
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
	Resume resume = dao.getResumeByPusersId(1);
	
	
	System.out.println("데이터 1개 불러오기>>");
	if (resume != null) {
		System.out.println(resume);
	} else {
		System.out.println("Resume not found\n");
	}
	
	// 출력구문 2
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<Resume> list = dao.getResumeAll();
	for(Resume resumes:list){
		System.out.println(resumes);
	}
%>
</body>
</html>