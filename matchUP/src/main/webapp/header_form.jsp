<!-- form 태그를 사용하는 회원가입, 로그인, 이력서, 채용관리 페이지 전용 header -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header_form</title>

<!-- 초기화 css -->
    <link rel="stylesheet" href="resources/style/reset_form.css">
    <!-- header css -->
    <link rel="stylesheet" href="resources/style/grid.css">
    <link rel="stylesheet" href="resources/style/join.css">
    <!-- js -->
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
            <!-- 로그인 & 마이페이지 -->
            <div class="login">
                <a href="login">
                    <h3>로그인</h3>
                </a>
            </div>
            <!-- 회원가입 -->
            <div class="login">
                <a href="join">
                    <h3>회원가입</h3>
                </a>
            </div>
            <!-- 관심채용정보(스크랩) -->
            <div class="scrap">              
                <a href="scrap">
                    <h3>관심채용정보</h3>
                </a>
            </div>
            <!-- 이력서 -->
            <div class="resumeForm">
                <a href="resume">
                    <h3>이력서 관리</h3>
                </a>
            </div>
            <!-- 채용 관리 -->
            <div class="jobPostForm">
                <a href="jobPost">
                    <h3>채용 관리</h3>
                </a>
            </div>
        </div>
    </header>
    <!-- header 끝 -->
</body>
</html>