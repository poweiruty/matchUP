<%@page import="model.region.Region"%>
<%@page import="model.region.RegionDao"%>
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
	RegionDao dao = RegionDao.getInstance();
	//Region re = dao.getMainRegion("서울특별시");
	ArrayList<Region> list = dao.getMainRegionAll();	
	
	for(Region region : list){
		System.out.println(region);
	}
%>
</body>
</html>