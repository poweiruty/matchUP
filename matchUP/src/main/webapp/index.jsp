<%@page import="model.resume.ResumeRequestDto" %>
<%@page import="model.resume.ResumeDao"%>
<%@page import="model.resume.Resume"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>matchUP</title>
    <!-- 초기화 css -->
    <link rel="stylesheet" href="resources/style/reset.css">
    <!-- header css -->
    <link rel="stylesheet" href="resources/style/grid.css">
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>

<body>
    <!-- header 시작 -->
    <header id="header">
        <div class="index">
            <a href="index.jsp">
                Match-UP
            </a>
        </div>

<%-- <%	
	UserDao userDao = UserDao.getInstance();	
	User user = userDao.getUserbyId("qkrrb0032");
	UserRequestDto dto = new UserRequestDto(user.getPid(), "qweqwe123", user.getPname(), user.getBirth(), 1065502899, user.getEmail(), user.getUser_address());
	//boolean res = userDao.createUser(dto);		
	
	userDao.updateUser(dto, "qwe123");
	System.out.println(user);
%> --%>

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
            <!-- 스크랩 -->
            <div class="scrap">
                <a href="scrap">
                    <h3>스크랩</h3>
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


    <!-- main 시작 -->

    <!-- main 끝 -->

    <!-- footer 시작 -->

    <!-- footer 끝 -->
</body>

</html>