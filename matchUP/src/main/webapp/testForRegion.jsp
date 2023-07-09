<%@page import="java.util.ArrayList"%>
<%@page import="model.region.MainRegion"%>
<%@page import="model.region.SemiRegion"%>
<%@page import="model.region.MainRegionRequestDto"%>
<%@page import="model.region.SemiRegionRequestDto"%>
<%@page import="model.region.RegionDao"%>


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
	// 출력구문 1 : 광역자치 1개
	RegionDao daoMain = RegionDao.getInstance();
	MainRegion mainRegion = daoMain.getMainRegion("경기도");
	
	System.out.println("데이터 1개 불러오기>>");
	if (mainRegion != null) {
		System.out.println(mainRegion);
	} else {
		System.out.println("Main region not found\n");
	}
	
	// 출력구문 2 : 광역자치 전체
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<MainRegion> listMain = daoMain.getMainRegionAll();
	for(MainRegion mainRegions:listMain){
		System.out.println(mainRegions);
	}
	
	// 출력구문 1 : 지역자치 1개
	RegionDao daoSemi = RegionDao.getInstance();
	SemiRegion semiRegion = daoSemi.getSemiRegion("청주시");
		
	System.out.println("데이터 1개 불러오기>>");
	if (semiRegion != null) {
		System.out.println(semiRegion);
	} else {
		System.out.println("Semi region not found\n");
	}
		
	// 출력구문 2 : 지역자치 전체
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<SemiRegion> listSemi = daoSemi.getSemiRegionAll();
	for(SemiRegion semiRegions:listSemi){
		System.out.println(semiRegions);
	}
%>
</body>
</html>