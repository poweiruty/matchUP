<%@page import="java.util.ArrayList"%>
<%@page import="model.review.Review"%>
<%@page import="model.review.ReviewRequestDto"%>
<%@page import="model.review.ReviewDao"%>
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

	ReviewDao dao = ReviewDao.getInstance();

	//Create : Clear
	System.out.println("\n데이터 추가하기>>");
	ReviewRequestDto newReview = new ReviewRequestDto(4,8,4,"높지 않은 급여이나 워라밸이 매우 훌륭함");
	boolean created = dao.createReview(newReview);
	if (created) {
    	System.out.println("데이터가 성공적으로 추가되었습니다.");
	} else {
    	System.out.println("데이터 추가에 실패했습니다.");
	}
	
	// Read : CLEAR
	Review review = dao.getReviewByPusersId(1);
	
	System.out.println("\n데이터 1개 불러오기>>");
	if (review != null) {
		System.out.println(review);
	} else {
		System.out.println("Resume not found\n");
	}
	
	System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<Review> list = dao.getReviewAll();
	for(Review reviews:list){
		System.out.println(reviews);
	}
	
	//Update : CLEAR
	System.out.println("\n데이터 업데이트하기>>");
	review = dao.getReviewByPusersId(3);
	ReviewRequestDto updateReview = new ReviewRequestDto(3,7,1,"어우 개노답회사 빨리 도망가세요");
	dao.updateReview(updateReview);
	
	// Delete : clear
	System.out.println("\n데이터 삭제하기>>");
	int deleteId=3; // 삭제할 데이터의 Resume ID를 지정해주세요.
	boolean deleted = dao.deleteReview(deleteId);
	if (deleted) {
	    System.out.println("데이터가 성공적으로 삭제되었습니다.");
	} else {
	    System.out.println("데이터 삭제에 실패했습니다.");
	} 
	
	
%>
</body>
</html>