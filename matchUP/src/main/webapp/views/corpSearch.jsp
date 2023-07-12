<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

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
						<button onclick="search()">검색</button>
                    </li>
                </ul>
            </div>
        <!-- 검색 내역 부분 -->
        <div class="con_wrap">
            <div class="search_con">
			
        </div>
    </section>
        
    <!-- body 끝 -->

      <!-- footer 시작 -->
     	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>