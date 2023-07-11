<%@page import="model.scrap.ScrapRequestDto"%>
<%@page import="model.scrap.Scrap"%>
<%@page import="model.scrap.ScrapDao"%>
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
	// ★ Scrap에서 Update는 생략 : 채용공고가 수정될 경우, 스크랩에도 반영 ★
	
	ScrapDao dao = ScrapDao.getInstance();

	// Create : clear
	System.out.println("\n데이터 추가하기>>");
	ScrapRequestDto newScrap = new ScrapRequestDto(15,7);
	boolean created = dao.createScrap(newScrap);
	if (created) {
    	System.out.println("데이터가 성공적으로 추가되었습니다.");
	} else {
    	System.out.println("데이터 추가에 실패했습니다.");
	} 
	
	// Read
	//출력구문 1 : 스크랩 1개
	Scrap scrap = dao.getScrapByPusersId(1);
	
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
	
	// Delete
	System.out.println("\n데이터 삭제하기>>");
	int deleteId=5; // 삭제할 데이터의 Resume ID를 지정해주세요.
	boolean deleted = dao.deleteScrap(deleteId);
	if (deleted) {
	    System.out.println("데이터가 성공적으로 삭제되었습니다.");
	} else {
	    System.out.println("데이터 삭제에 실패했습니다.");
	}
%>
</body>
</html>