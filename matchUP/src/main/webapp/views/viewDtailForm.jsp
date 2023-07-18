<%@page import="model.region.SemiRegion"%>
<%@page import="model.region.MainRegionRequestDto"%>
<%@page import="model.region.MainRegion"%>
<%@page import="model.region.RegionDao"%>
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
	JobPostDao pdao = JobPostDao.getInstance();
	JobPostDto dto = pdao.getJobPostbyId(post_id);
	RegionDao rdao = RegionDao.getInstance();
	
	int main_id = Integer.parseInt(dto.getRegion());
	int semi_id = Integer.parseInt(dto.getRegionDetail());
	MainRegion main = rdao.getMainRegion(main_id);
	SemiRegion semi = rdao.getSemiRegion(semi_id);
	
	String main_region = main.getMainRegion();
	String semi_region = semi.getSemiRegion();
	
	dto.setRegion(main_region);
	dto.setRegionDetail(semi_region);
%>
	<p><%=dto %></p>
	
</body>
</html>