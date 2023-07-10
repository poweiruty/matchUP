<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>

</head>

<body>
	<!-- header 시작 -->
	<jsp:include page="header_login"></jsp:include>
	<!-- header 끝 -->

	<!-- body 시작 -->

	<div class="containerwrap">
		<div class="login_box">
			<ul class="login_tab">
				<li class="login_person on"><a href="#">개인 로그인</a></li>
				<li class="login_corp"><a href="#">기업 로그인</a></li>
			</ul>
			<div class="tab_cont">
				<div class="tab on">
					<!-- form -->
					<form action="PLogin" class="index_form" method="POST">
						<h2>아이디</h2>
						<div class="id">
							<input type="text" class="id" name="id" id="id" placeholder="아이디">
						</div>
						<h2>비밀번호</h2>
						<div class="pwd">
							<input type="text" class="pwd" name="pwd" placeholder="비밀번호">
						</div>
						<input type="submit" name="login_btn" id="login_btn" value="로그인">
					</form>
				</div>
				<div class="tab">
					<!-- form -->
					<form action="CLogin" class="index_form" method="POST">
						<h2>아이디</h2>
						<div class="id">
							<input type="text" class="id" name="id" id="id" placeholder="아이디">
						</div>
						<h2>비밀번호</h2>
						<div class="pwd">
							<input type="text" class="pwd" name="pwd" placeholder="비밀번호">
						</div>

						<input type="submit" name="login_btn" id="login_btn" value="로그인">
					</form>
				</div>
			</div>

			<!-- 회원가입 연결 -->
			<div class="join_box">
				<a href="join">
					<button class="btn_join">회원가입</button>
				</a>
			</div>
			<!-- 아이디 비밀 번호 찾기 -->
			<div class="find_box">
				<h1>로그인 정보가 생각나지 않으세요?</h1>
				<p>아이디 또는 비밀번호를 찾으실 수 있습니다.</p>
				<a href="#"><button class="btn_find">아이디 찾기</button></a> <a href="#"><button
						class="btn_find">비밀번호 찾기</button></a>
			</div>
		</div>
	</div>
	<!-- footer 시작 -->
	<jsp:include page="footer"></jsp:include>

	<!-- footer 끝 -->
</body>

</html>