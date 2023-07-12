<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	<c:if test="${empty sessionScope.log }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<section class="container">
        <div class="msg">
            <p id="msg_title">채용공고관리</p>
        </div>
        <div class="main">
            <div class="saved">
                <p id="saved_title">진행중인 채용공고</p>
               <div class="saved_con_detail">
                    <!-- 여기에 내용 -->
                </div>
            </div>
            <div class="completed">
                <p id="completed_title">마감된 채용공고</p>
                
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