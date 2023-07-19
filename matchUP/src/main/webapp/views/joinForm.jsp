<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="resources/style/join.css">
    <link rel="shortcut icon" href="resources/img/favicon.png">
    
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="header_form"></jsp:include>
    <!-- header 끝 -->

    <div id="wrap">
        <div class="section">
            <ul class="join_main">
                <li>
                    <p class="title">회원가입</p>
                    <span>개인회원과 기업회원을 선택하세요.</span>
                </li>
                <li>
                    <a href="joinPerson"><button class="join_sub_btn">개인회원</button></a>
                </li>
                <li>
                    <a href="joinCorp"><button class="join_sub_btn">기업회원</button></a>
                </li>
            </ul>
        </div>
    </div>

    <!-- footer 시작 -->
            <jsp:include page="footer"></jsp:include>
    <!-- footer 끝 -->

</html>