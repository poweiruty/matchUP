<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form method="POST" action="CLeave">
				<ul class="delete_main">
					<li>
						<p class="title">회원탈퇴</p>
					</li>
					<li><label for="id">
							<h2>아이디</h2>
					</label></li>
					<li class="id"><input type="text" name="id" id="id"
						value="${sessionScope.log}" readonly></li>

					<!-- 비밀번호 부분 -->
					<li>
					<h2>
						비밀번호<span class="pwd_warning"> 비밀번호를 입력하세요.</span>
					</h2>
					</li>
					<li id="pwd">
					<input type="password" name="password" id="password" required> 
					<input type="submit" id="submit-btn" value="회원탈퇴"
						onclick="checkValue(form)">						
						<a href="index">취소</a></li>
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