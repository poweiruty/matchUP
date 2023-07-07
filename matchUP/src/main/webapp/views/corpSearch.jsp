<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 초기화 css -->
    <link rel="stylesheet" href="resources/style/reset.css">
    <!-- header css -->
    <link rel="stylesheet" href="resources/style/grid.css">
    <link rel="stylesheet" href="resources/style/corpSearch.css">
</head>

<body>
    <!-- header 시작 -->
         <jsp:include page="header"></jsp:include>

    <!-- header 끝 -->
    <!-- body 시작 -->
    <section class="container">
        <div class="msg">
            <p id="msg_title">기업검색</p>
            <p>당신을 기다리고 있습니다!</p>
        </div>
        <form action="" method="post" name="corpSearch" enctype="multipart/form-data">
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
                <ul>
                    <li class="search_btn">
                        <input type="button" value="검색" id="search_btn">
                    </li>
                </ul>
            </div>
        </form>
    </section>

    <!-- body 끝 -->

      <!-- footer 시작 -->
     	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>