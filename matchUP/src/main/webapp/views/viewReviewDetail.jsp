<%@page import="model.review.ReviewRequestDto"%>
<%@page import="model.review.ReviewDao"%>
<%@page import="model.review.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="resources/img/favicon.png">

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/style/corpSearch.css">
</head>
<body>
<% 

if(request.getParameter("reviewId") != null){
	int reviewId = Integer.parseInt(request.getParameter("reviewId")); 
	ReviewDao dao = ReviewDao.getInstance();
	Review reviews = dao.getReviewByReviewId(reviewId);
	
	String corpName=reviews.getCorpName();
	int star=reviews.getStar();
	String summary=reviews.getSummary();
	String review=reviews.getReview();
	String position=reviews.getPosition();
	String period=reviews.getPeriod();	
%>
		<div class="review_detail_con1">
			<h2 class="corp_name"><%=corpName %></h2>
			<p class="star"><%=star %></p>
			<p class="summary"><%=summary %></p>			
			<p class="review"><%=review %></p>			
			<p class="position"><%=position %></p>			
			<p class="period"><%=period %></p>			
			<br>
		</div>			
	<%
}
		
%>
	

</body>
</html>