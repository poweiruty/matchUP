<%@page import="model.region.MainRegion"%>
<%@page import="model.region.RegionDao"%>
<%@page import="java.util.ArrayList"%>

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
	// 출력구문 1
	RegionDao dao = RegionDao.getInstance();
	MainRegion mainRegion = dao.getMainRegion("경기도");
	
	System.out.println("데이터 1개 불러오기>>");
	if (mainRegion != null) {
		System.out.println(mainRegion);
	} else {
		System.out.println("Main region not found\n");
	}
	
	// 출력구문 2
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<MainRegion> list = dao.getMainRegionAll();
	for(MainRegion mainRegions:list){
		System.out.println(mainRegions);
	} 
%>
</body>
</html>