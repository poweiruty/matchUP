<%@page import="java.util.ArrayList"%>
<%@page import="model.scrap.Scrap"%>
<%@page import="model.scrap.ScrapDao"%>
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
	//출력구문 1 : 스크랩 1개
	ScrapDao dao = ScrapDao.getInstance();
	Scrap scrap = dao.getScrap(1);
	
	System.out.println("데이터 1개 불러오기>>");
	if (scrap != null) {
		System.out.println(scrap);
	} else {
		System.out.println("Scrap not found\n");
	}
	
	// 출력구문 2 : 스크랩 전체
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<Scrap> list = dao.getScrapAll();
	for(Scrap scraps:list){
		System.out.println(scraps);
	}
	
%>
</body>
</html>