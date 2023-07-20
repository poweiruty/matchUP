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
    <!-- favicon -->
    
<!-- 로고 css -->
<style>
	.logo {
		width: 150px;
		height: 150px;
	}

	.Rlogo {
		width: 300px;
		height: 300px;
	}
	.nav {
	height: 30px;
	display: flex;
	align-items: center;
	background-color: cadetblue;
}
</style>
    <!-- js -->
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<!-- header 시작 -->
	<header id="header">
		<div class="index">
			<a href="index.jsp">
				<img class="logo" src="resources/img/Rlogo.png">
			</a>
			<!-- 마이페이지 -->
			<div class="top_1">
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="index">
							<h3>MATCH-UP(기업회원)</h3>
						</a>
					</c:when>
					<c:when test="${not empty sessionScope. log}">
						<a href="index">
							<h3>MATCH-UP(개인회원)</h3>
						</a>
					</c:when>
					<c:otherwise>
						<a href="index">
							<h3>MATCH-UP</h3>
						</a>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="top_2">
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<button class="logout_btn" onclick="location.href='Clogout'">로그아웃</button>
						<button class="leave_btn" onclick="location.href='cleave'">회원탈퇴</button>
					</c:when>

					<c:when test="${not empty sessionScope.log }">
						<button class="logout_btn" onclick="location.href='Plogout'">로그아웃</button>
						<button class="leave_btn" onclick="location.href='leave'">회원탈퇴</button>
					</c:when>
					<c:otherwise>
						<button class="login_link" onclick="location.href='login'">로그인</button>
					</c:otherwise>
				</c:choose>
			</div>
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
					<c:when test="${not empty sessionScope.cname }">
					<a href="cleave">
						<h3>회원탈퇴</h3>
					</a>
				</c:when>
				<c:when test="${not empty sessionScope. log}">
					<a href="leave">
						<h3>회원탈퇴</h3>
					</a>
				</c:when>
					<c:otherwise>
						<a href="join">
							<h3>회원가입</h3>
						</a>
					</c:otherwise>
				</c:choose>
			</div>
          
			<!-- 채용공고조회/이력서관리 -->
			<div class="scrap">
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="jobPostUpdate">
							<h3>채용공고조회</h3>
						</a>
					</c:when>
					
					<c:when test="${not empty sessionScope.log }">
						<a href="resumeRead">
							<h3>이력서 관리</h3>
						</a>
					</c:when>

					<c:otherwise>
						<a href="login">
							<h3>이력서 관리</h3>
						</a>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- 이력서 / 채용작성 -->
			<div class="resumeForm">
				<!-- 로그인 상태에서는 이력서관리 페이지 이동 불가 -->
				<c:choose>
					<c:when test="${not empty sessionScope.cname }">
						<a href="jobPost">
							<h3>채용공고등록</h3>
						</a>
					</c:when>

					<c:when test="${not empty sessionScope.pname }">
						<a href="resumeCreate">
							<h3>이력서 작성</h3>
						</a>
					</c:when>

					<c:otherwise>
						<a href="makers.jsp">
							<h3>만든이들</h3>
						</a>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
	</header>
	<!-- header 끝 -->
</body>
</html>