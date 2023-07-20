<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>마이페이지(개인)</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="shortcut icon" href="resources/img/favicon.png">

<!-- header css -->
<link rel="stylesheet" href="resources/style/join.css">
</head>

<body>
	<!-- header 시작 -->
	<jsp:include page="header_form"></jsp:include>
	<!-- header 끝 -->
	<!-- body 시작 -->
	<c:if test="${empty sessionScope.log }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<div class="container">
		<div class="section">
			<div class="section_box">
				<form action="Update" method="POST">
					<ul>
						<div class="pc_1">
							<li class="start">
								<h2>회원정보수정(개인 회원)</h2>
							</li>
							<!-- 아이디 부분 -->
							<li><label for="pid">
									<h2>아이디</h2>
							</label></li>
							<li class="pid"><input type="text" name="pid" id="pid"
								value="${sessionScope.log}" readonly></li>

							<!-- 비밀번호 부분 -->
							<li>
								<h2 class="password_title">비밀번호</h2> <input type="text" id="password"
								name="password" autofocus>
							</li>
								<ul>
									<li class="error" id="error-password">비밀번호를 입력하세요.</li>
								</ul>
							<li><h2 id="pwd_center">
									변경할 비밀번호<br>
								</h2></li>

							<li class="new-password"><input type="text" name="new-password"
								id="new-password"> </li>
							<!-- 이름 부분 -->
							<li class="pname"><label for="pname">
									<h2>이름</h2>
							</label> <input type="text" name="pname" id="pname"
								value="${sessionScope.pname}" readonly></li>

							<!-- 생년월일 부분 -->
							<li><label for="birth">
									<h2>생년월일</h2>
							</label></li>
							<li class="birth"><input type="text" name="birth" id="birth"
								value="${sessionScope.birth}" readonly></li>
							

							<!-- 휴대폰 부분 -->
							<li>
								<h2>연락처</h2>
							</li>
							<li class="tel"><input type="text" name="tel" id="tel"
								value="${sessionScope.phone}"></li>

							<!-- 이메일 부분 -->
							<li><label for="email">
									<h2>이메일</h2>
							</label></li>
							<li class="email"><input type="text" name="email" id="email"
								value="${sessionScope.email}"></li>
						
							<!-- 주소 부분 시작 -->
							<div class="add_wrap">
									<h2 id="user_address">주소</h2>
								 <input type="text" name="user_address" id="user_address"
									value="${sessionScope.address}"> 
							</div>
							<!-- 주소 끝 -->

							<!-- 수정하기 부분 -->
							<li class="sub">	
								<div class="submit">
								<input type="button" id="submit-btn" value="수정하기" onclick="checkPupdate(form)">
								<a href="index"> 
								</div>
								<!-- 초기 화면으로 돌아감 -->
								<div id="index">메인 페이지로 돌아가기</div>
								</a>
							</li>
						</div>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<script src="resources/script/validation_join.js"></script>
</body>
<!-- footer 시작 -->
<jsp:include page="footer"></jsp:include>
<!-- footer 끝 -->

</html>