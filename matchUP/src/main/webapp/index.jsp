<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>matchUP</title>
<link rel="stylesheet" href="resources/style/index.css">
<link rel="icon" href="resources/img/favicon.png" type="image/x-icon">
</head>
<body>
	<!-- header -->
	<jsp:include page="header"></jsp:include>

	<!-- body 시작 -->

	<!-- main 시작 -->
	<section class="container">
	<p class="idx_title">
		당신(yoU)과 사람들(People)을 잇습니다. <br> 구인구직 플랫폼, Match-UP
	</p>

	<c:choose>
		<c:when test="${not empty sessionScope.cname }">
			${sessionScope.log }님 환영합니다!
			<button class="logout_btn" onclick="location.href='Clogout'">로그아웃</button>
			<button class="leave_btn" onclick="location.href='leave'">회원탈퇴</button>
		</c:when>

		<c:when test="${not empty sessionScope.log }">
			${sessionScope.log }님 환영합니다!
			<button class="logout_btn" onclick="location.href='Plogout'">로그아웃</button>
			<button class="leave_btn" onclick="location.href='leave'">회원탈퇴</button>
		</c:when>
		<c:otherwise>
			<p class="welcome">환영합니다! <a class="login_link" href="login">로그인</a> 후 서비스를 이용해 주세요.</p>
		</c:otherwise>

	</c:choose>
	</section>
	<!-- body 끝 -->

	<!-- footer -->
	<jsp:include page="footer"></jsp:include>
</body>
</html>