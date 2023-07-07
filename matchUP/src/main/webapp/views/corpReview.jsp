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
    <link rel="stylesheet" href="resources/style/corpReview.css">
</head>

<body>
     <!-- header 시작 -->
         <jsp:include page="header"></jsp:include>

    <!-- header 끝 -->
    <!-- body 시작 -->
    <section class="container">
        <form action="" method="post" name="corpReview" class="corpReview" enctype="multipart/form-data">

            <div class="msg">
                <p id="msg_title">기업리뷰</p>
                <p>현직자들의 생생한 증언!</p>
                <p>원하시는 기업을 검색해 보세요.</p>
            </div>
            <div class="main_con">
                <div class="main">
                    <ul>
                        <li class="main_search">
                            <label for="search_bar">
                                <h2>기업명 또는 직무</h2>
                            </label>
                            <input type="text" id="search_bar" placeholder="직무 혹은 회사명">
                        </li>
                    </ul>
                </div>
                <ul>
                    <li class="search_btn">
                        <input type="button" value="검색" id="search_btn">
                    </li>
                </ul>
            </div>
        </form>
    <!-- body 끝 -->

    <!-- footer 시작 -->
      	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
    </section>
    </body>


</html>