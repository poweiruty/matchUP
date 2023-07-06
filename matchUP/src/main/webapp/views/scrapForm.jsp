<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 초기화 css -->
    <link rel="stylesheet" href="../resources/style/reset.css">
    <!-- header css -->
    <link rel="stylesheet" href="../resources/style/grid.css">
    <link rel="stylesheet" href="../resources/style/scrap.css">
</head>

<body>
    <!-- header 시작 -->
     <header id="header">
        <div class="index">
            <a href="../index.jsp">
                Match-UP
            </a>
        </div>

        <!-- 검색 -->
        <div class="nav">
            <div class="corpSearch">
                <a href="corpSearch.jsp">
                    <h3>기업검색</h3>
                </a>
            </div>
            <!-- 기업리뷰 -->
            <div class="corpReview">
                <a href="corpReview.jsp">
                    <h3>기업리뷰</h3>
                </a>
            </div>
            <!-- 로그인 & 마이페이지 -->
            <div class="login">
                <a href="loginForm.jsp">
                    <h3>로그인</h3>
                </a>
            </div>
            <!-- 회원가입 -->
            <div class="login">
                <a href="joinForm.jsp">
                    <h3>회원가입</h3>
                </a>
            </div>
            <!-- 관심채용정보(스크랩) -->
            <div class="scrap">
                <a href="scrapForm.jsp">
                    <h3>관심채용정보</h3>
                </a>
            </div>
            <!-- 이력서 -->
            <div class="resumeForm">
                <a href="resumeForm.jsp">
                    <h3>이력서 관리</h3>
                </a>
            </div>
            <!-- 채용 관리 -->
            <div class="jobPostForm">
                <a href="jobPostForm.jsp">
                    <h3>채용 관리</h3>
                </a>
            </div>
        </div>
    </header>
    <!-- header 끝 -->
    <!-- body 시작 -->
    <section class="container">
        <div class="msg">
            <p id="msg_title">관심채용정보</p>
        </div>
        <div class="main">
            <div class="saved">
                <p id="saved_title">저장됨</p>
                <div class="saved_con">
                    <span>저장된 스크랩: #건</span>
                </div>
                <div class="saved_con_detail">
                    <!-- 여기에 내용 -->
                </div>
            </div>
            <div class="completed">
                <p id="completed_title">지원완료</p>
                <div class="completed_con">
                    <span>완료된 스크랩: #건</span>
                </div>
                <div class="completed_con_detail">
                    <!-- 여기에 내용 -->
                </div>
            </div>
        </div>
    </section>
    <!-- body 끝 -->

    <!-- footer 시작 -->
      <footer>
        <div class="footer_box">
            <span><a href="../index.jsp">© 2023 MatchUP</a></span>
            <span><a href="#">회사소개</a></span>
            <span><a href="#">고객센터</a></span>
            <span><a href="term.jsp">이용약관</a></span>
            <span><a href="term2.jsp">개인정보 취급방침</a></span>
            <span><a href="#">오류신고</a></span>
        </div>
    </footer>
    <!-- footer 끝 -->
</body>

</html>