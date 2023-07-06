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
    <link rel="stylesheet" href="../resources/style/corpSearch.css">
</head>

<body>
    <!-- header 시작 -->
    <header id="header">
        <div class="index">
            <a href="index.html">
                Match-UP
            </a>
        </div>

        <!-- 검색 -->
        <div class="nav">
            <div class="corpSearch">
                <a href="corpSearch.html">
                    <h3>기업검색</h3>
                </a>
            </div>
            <!-- 기업리뷰 -->
            <div class="corpReview">
                <a href="corpReview.html">
                    <h3>기업리뷰</h3>
                </a>
            </div>
            <!-- 로그인 & 마이페이지 -->
            <div class="login">
                <a href="login.html">
                    <h3>로그인</h3>
                </a>
            </div>
            <!-- 회원가입 -->
            <div class="login">
                <a href="join.html">
                    <h3>회원가입</h3>
                </a>
            </div>
            <!-- 스크랩 -->
            <div class="scrap">
                <a href="scrap.html">
                    <h3>스크랩</h3>
                </a>
            </div>
            <!-- 이력서 -->
            <div class="resumeForm">
                <a href="resume.html">
                    <h3>이력서 관리</h3>
                </a>
            </div>
            <!-- 채용 관리 -->
            <div class="jobPostForm">
                <a href="jobPost.html">
                    <h3>채용 관리</h3>
                </a>
            </div>
        </div>
    </header>
    <!-- header 끝 -->
    <section class="container">
        <form action="" method="post" name="searching" enctype="multipart/form-data">
            <div id="tab_search">
                <ul class="search">
                    <label for="search_bar">
                        <h2>검색어</h2>
                    </label>
                    <input type="text" id="search_bar" placeholder="업종, 직무 및 회사명">
                </ul>
                <ul class="region">
                    <label for="region_bar">
                        <h2>지역</h2>
                    </label>
                    <input type="text" id="region_bar" placeholder="근무지(도, 시, 군, 구, 동)" required>
                </ul>
                <ul >
                    <li class="search_btn">
                        <input type="button" value="검색" id="search_btn">
                    </li>
                </ul>
            </div>
        </form>
    </section>
    <!-- body 시작 -->

    <!-- body 끝 -->
</body>

</html>