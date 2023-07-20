<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="shortcut icon" href="resources/img/favicon.png">
<link rel="stylesheet" href="resources/style/delete.css">
		
	</head>

	<body>
		<!-- header 시작 -->
		<jsp:include page="header_form"></jsp:include>
		<!-- header 끝 -->
		<style>
			.container div{
				margin-top: 150px;
			}
			.container{
				min-height: 50vh;
			}
		</style>
		
		<div class="container">
			<div class="section">
				<form method="POST" action="CLeave">
					<ul class="delete_main">
						<span class="if">*비밀번호를 입력하시면, 탈퇴 절차가 진행됩니다.</span>
						<li>
							<p class="title">회원탈퇴</p>
						</li>
						<li><label for="id">
								<h2>아이디</h2>
							</label></li>
						<li class="id"><input type="text" name="id" id="id" value="${sessionScope.log}" readonly></li>

						<!-- 비밀번호 부분 -->
						<li><label for="pwd">
								<h2>비밀번호</h2>
							</label></li>
						<li id="pwd">
							<input type="password" name="password" id="password" required>

							<!-- 버튼 -->
						<li>
							<input type="submit" id="submit" value="회원탈퇴" onclick="checkValue(form)">
							<a href="index"><input type="button" id="submit" value="취소"></a>
						</li>
					</ul>
				</form>
			</div>
		</div>
		<script src="resources/script/validation_log.js"></script>

	</body>

	<!-- footer 시작 -->
	<jsp:include page="footer"></jsp:include>
	<!-- footer 끝 -->

	</html>