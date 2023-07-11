<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>matchUP</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="header"></jsp:include>

	<!-- body 시작 -->
	<c:choose>
		<c:when test="${not empty sessionScope.log }">
			${sessionScope.log }님 환영합니다!
		</c:when>
		<c:otherwise>
			<!-- 비 로그인시 메인 메시지 -->
		</c:otherwise>

	</c:choose>

	<!-- main 시작 -->
	<section class="container">
		<!-- <p>body 부분</p> -->
	</section>
	<!-- body 끝 -->

	<!-- footer -->
	<jsp:include page="footer"></jsp:include>
</body>
</html>