<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/style/corpReview.css">
    <link rel="shortcut icon" href="resources/img/favicon.png">
    
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="header"></jsp:include>

    <!-- header 끝 -->
    <!-- body 시작 -->
    <section class="container">
        <form action="Review" method="post" name="corpReview" class="corpReview" enctype="multipart/form-data">

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
                                <h2>기업명</h2>
                            </label>
                            <input type="text" id="search_bar" placeholder="회사명">
                        </li>
                    </ul>
                </div>
                <ul>
                    <li class="search_btn">
                        <input type="button" value="검색" id="search_btn">
                    </li>
                    
                    <li>
						<a class="btn_join" href="reviewCreate">리뷰 작성</a>
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