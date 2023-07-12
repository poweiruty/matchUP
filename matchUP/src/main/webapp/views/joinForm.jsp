<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
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
                    <a class="join_sub_btn" href="joinPerson">개인 회원</a>
                </li>
                <li>
                    <a class="join_sub_btn" href="joinCorp">기업 회원</a>
                </li>
            </ul>
        </div>
    </div>

    <!-- footer 시작 -->
            <jsp:include page="footer"></jsp:include>
    <!-- footer 끝 -->

</html>