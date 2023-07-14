<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>

<!-- 초기화 css -->
    <link rel="stylesheet" href="resources/style/reset.css">
    <!-- header css -->
    <link rel="stylesheet" href="resources/style/grid.css">
<!-- 로고 css -->
<style>
    .logo{
         width: 150px;
         height: 150px;
     }
     
     .Rlogo{
        width: 300px;
		height: 300px;
    }
     
 </style>
    <!-- js -->
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
     <script>
    $(document).ready(function () {
        $(".login_tab li").click(function () {
            var idx = $(this).index();
            $(".login_tab li").removeClass("on");
            $(".login_tab li").eq(idx).addClass("on");
            $(".tab_cont .tab").hide();
            $(".tab_cont .tab").eq(idx).show();
        });
    });
</script>
</head>
<body>
  <!-- header 시작 -->
    <header id="header">
        <div class="index">
            <a href="index">
                <img class="logo" src="resources/img/Rlogo.png">
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
           <!-- 기업회원 마이페이지 -->
			<c:choose>
				<c:when test="${not empty sessionScope.cname }">
					<a href="mypageCorp">
						<h3>마이페이지</h3>
					</a>
				</c:when>
				<c:when test="${not empty sessionScope.log}">
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
                <a href="scrap">
                    <h3>관심채용정보</h3>
                </a>
            </div>
         
			  <!-- 이력서 / 채용관리 -->
			<div class="resumeForm">
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="jobPost"><h3>채용 관리</h3></a>
					</c:when>
					
					<c:otherwise>
						<a href="resume"><h3>이력서 관리</h3></a>
					</c:otherwise>
				</c:choose>

			</div>
    </header>
    <!-- header 끝 -->
</body>
</html>