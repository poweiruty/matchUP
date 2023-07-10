<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link rel="stylesheet" href="resources/style/scrap.css">
</head>

<body>
    <!-- header 시작 -->
       <jsp:include page="header"></jsp:include>

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
    	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>