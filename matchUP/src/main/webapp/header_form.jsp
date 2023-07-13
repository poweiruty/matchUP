<!-- form 태그를 사용하는 회원가입, 로그인, 이력서, 채용관리 페이지 전용 header -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header_form</title>

<!-- 초기화 css -->
    <link rel="stylesheet" href="resources/style/reset_form.css">
    <!-- header css -->
    <link rel="stylesheet" href="resources/style/grid.css">
    
    <!-- js -->
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<!-- header 시작 -->
    <header id="header">
        <div class="index">
            <a href="index.jsp">
                Match-UP
            </a>
        </div>

        <!-- 검색 -->
        <div class="nav">
            <div class="corpSearch">
                <a href="search">
                    <h3>기업검색</h3>
                </a>
            </div>
            <!-- 기업리뷰 -->
            <div class="corpReview">
                <a href="review">
                    <h3>기업리뷰</h3>
                </a>
            </div>
			<!-- 마이페이지 -->
			<c:choose>
				<c:when test="${not empty sessionScope.cname }">
					<a href="mypageCorp">
						<h3>마이페이지</h3>
					</a>
				</c:when>
				<c:when test="${not empty sessionScope. log}">
					<a href="mypagePerson">
						<h3>마이페이지</h3>
					</a>
				</c:when>
				<c:otherwise>
					<a href="login">
						<h3>로그인</h3>
					</a>
				</c:otherwise>
			</c:choose>


			<!-- 회원가입 -->
            <div class="join">
                <c:choose>
					<c:when test="${not empty sessionScope.cname or not empty sessionScope.log }">
						<a href="leave"><h3>회원탈퇴</h3></a>
					</c:when>
					<c:otherwise>
						<a href="join"><h3>회원가입</h3></a>
					</c:otherwise>
				</c:choose>
            </div>
            <!-- 관심채용정보(스크랩) -->
            <div class="scrap">              
                <c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="jobPostUpdate"><h3>채용공고관리</h3></a>
					</c:when>
					
					<c:otherwise>
						<a href="resume"><h3>관심채용정보</h3></a>
					</c:otherwise>
				</c:choose>
            </div>
            <!-- 이력서 / 채용관리 -->
			<div class="resumeForm">
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="jobPost"><h3>채용공고등록</h3></a>
					</c:when>
					
					<c:otherwise>
						<a href="resume"><h3>이력서 관리</h3></a>
					</c:otherwise>
				</c:choose>

			</div>
		
        </div>
    </header>
    <!-- header 끝 -->
</body>
</html>