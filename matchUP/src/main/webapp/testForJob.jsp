<%@page import="java.util.ArrayList"%>
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
 	// 출력구문 1 : 왜 안나올까요 시부랄거
	//  ㄴ 해결 : clean -> 이제 나옵니다 시부랄거
	JobDao dao = JobDao.getInstance();
	Job job = dao.getJob("디자인");
	
	System.out.println("데이터 1개 불러오기>>");
	if (job != null) {
		System.out.println(job);
	} else {
		System.out.println("Job not found\n");
	}
	
	// 출력구문 2
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<Job> list = dao.getJobAll();
	for(Job jobs:list){
		System.out.println(jobs);
	} 
%>
</body>
</html>