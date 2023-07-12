<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="resources/style/resume.css">
</head>

<body>
	<!-- header 시작 -->
	<jsp:include page="header_form"></jsp:include>

	<!-- header 끝 -->

	<!-- body 시작 -->
	<c:if test="${empty sessionScope.log }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<section class="container">
		<div class="msg">
			<p class="msg_title">이력서 관리</p>
		</div>
		<div class="main_con">
			<p class="resume_title">나의 이력서</p>
			<div class="main_resume">
				<!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
				<form action="" method="post" name="resume" class="resumeForm"
					enctype="multipart/form-data">
					<ul>
						<li><label for="name">이름 </label> <input type="text"
							id="name"></li>
						<li><label for="date">생년월일 </label> <input type="date"
							id="date"></li>
						<li><label for="tel">연락처 </label> <input type="text" id="tel">
						</li>
						<li><label for="email">이메일 </label> <input type="text"
							name="email" id="email"> <input type="text" name="email2"
							id="email2"></li>
						<div class="add_wrap">
							<li id="add"><label for="address">주소</label> <input
								type="text" name="address" id="address"
								placeholder="우편번호를 검색하세요."> <input type="button"
								name="address_btn" id="address_btn" value="우편번호 검색"></li> <input
								type="text" name="address_detail" id="address_detail"
								placeholder="상세주소">
						</div>
						<li><label for="job">희망직종 </label> <input type="text"
							id="job"></li>
						<li><label for="career">경력</label> <input type="text"
							id="career"></li>
						<li><label for="degree">최종학력</label> <select name="degree"
							id="degree">
								<option value="sel">옵션 선택</option>
								<option value="1">초졸</option>
								<option value="2">중졸</option>
								<option value="3">고졸</option>
								<option value="4">대졸(2~3년제)</option>
								<option value="5">대졸(4년제)</option>
								<option value="6">대학원졸</option>
								<input type="text" id="degree_input">
						</select></li>
						<li><label for="activity">대외활동/수상이력</label> <input
							type="text" id="activity"></li>
						<li><label for="certificate">보유자격증</label> <input type="text"
							id="certificate"></li>

						<li><label for="intro">자기소개 </label> <textarea name="intro"
								id="intro" cols="30" rows="10">
                        </textarea></li>
					</ul>
				</form>
			</div>
			<div class="bottom">
				<span><a href="#">등록</a></span> <span><a href="index">취소</a></span>
			</div>
		</div>
	</section>
	<!-- body 끝 -->

	<!-- footer 시작 -->
	<jsp:include page="footer"></jsp:include>

	<!-- footer 끝 -->
</body>

</html>