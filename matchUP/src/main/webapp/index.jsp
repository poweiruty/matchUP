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
</head>
<body>
	<!-- header -->
	<jsp:include page="header"></jsp:include>

	<!-- body 시작 -->

	<!-- main 시작 -->
	<section class="container">
	<p class="idx_title">
		당신에게 딱 맞는 사람들을 매칭해드립니다. <br> 구인구직 플랫폼, Match-UP
	</p>

	<c:choose>
		<c:when test="${not empty sessionScope.cname }">
			${sessionScope.log }님 환영합니다!
		<button onclick="location.href='Clogout'">로그아웃</button>
			<button onclick="location.href='leave'">회원탈퇴</button>
		</c:when>

		<c:when test="${not empty sessionScope.log }">
			${sessionScope.log }님 환영합니다!
		<button onclick="location.href='Plogout'">로그아웃</button>
			<button onclick="location.href='leave'">회원탈퇴</button>
		</c:when>

		<c:otherwise>
			<!-- 비 로그인시 메인 메시지 -->
			<p class="welcome">환영합니다! 로그인 후 서비스를 이용해 주세요.</p>
		</c:otherwise>

	</c:choose>
	</section>
	<!-- body 끝 -->

	<!-- footer -->
	<jsp:include page="footer"></jsp:include>
</body>
</html>