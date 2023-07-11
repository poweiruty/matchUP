<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<link rel="stylesheet" href="resources/style/reset_form.css">
<!-- header css -->
<link rel="stylesheet" href="resources/style/grid.css">

<link rel="stylesheet" href="resources/style/join.css">
</head>

<body>
	<!-- header 시작 -->
	<jsp:include page="header_form"></jsp:include>

	<!-- header 끝 -->

	<div id="wrap">
		<div class="section">
			<div class="section_box">
				<form action="" method="post" name="membership"
					enctype="multipart/form-data">
					<ul>
						<div class="pc_1">
							<li class="start">
								<h2>회원정보입력(기업 회원)</h2>
							</li>
							<!-- 아이디 부분 -->
							<li><label for="id">
									<h2>아이디</h2>
							</label></li>
							<li class="id"><input type="text" name="id" id="id"
								placeholder="길이 4-12자 이내" required> <input type="button"
								name="btn1" id="btn1" value="중복확인"><br /></li>

							<!-- 비밀번호 부분 -->
							<li><label for="pwd1">
									<h2>
										비밀번호<span class="pwd_warning"> *특수문자는 '! @ # $ % ^ &
											+='만 사용 가능합니다.</span>
									</h2>
							</label></li>
							<html>
<li class="pwd"><input type="password" name="pwd1" id="pwd1"
	placeholder="4-10자의 영문, 특수문자, 숫자 조합" required> <input
	type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" required>
	<span id="chkNotice" size="1"></span></li>

<!-- 회사명 부분 -->
<li class="corp_name"><label for="corp_name">
		<h2>회사명</h2>
</label> <input type="text" name="name" id="name"
	placeholder="본사 주소를 기준으로 기입해 주세요." required></li>

<!-- 생년월일 부분 -->
<li><label for="corp_num">
		<h2>
			사업자등록번호<span class="corp_warning"> *사업자등록번호는 추후 수정이 불가능 합니다.
				정확히 입력해 주세요.</span>
		</h2>
</label></li>
<li class="corp_num"><input type="text" name="corp_num"
	id="corp_num" required></li>
<!-- 담당자 이름 부분 -->
<li><label for="mgr_name"><h2>채용 담당자 성명</h2></label></li>
<li><input type="text" name="mgr_name" id="mgr_name" required>
</li>
<!-- 담당자 번호 부분 -->
<li>
	<h2>채용 담당자 연락처</h2>
</li>
<li class="phone"><select name="phone" id="phone">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="016">016</option>
		<option value="017">017</option>
		<option value="018">018</option>
		<option value="019">019</option>
</select> <span>-</span> <input type="text" name="phone1" id="phone1"
	maxlength="4"
	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
	<span>-</span> <input type="text" name="phone2" id="phone2"
	maxlength="4"
	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
</li>

<!-- 이메일 부분 -->
							<li>
								<label for="email">
									<h2>이메일</h2>
								</label>
							</li>
							<li class="email">
								<input type="text" name="email" id="email">@ 
								<input type="text" name="email2" id="email2" value="naver.com">
							</li>
							<select name="selectEmail" id="selectEmail">
								<option value="1">직접입력</option>
								<option value="@naver.com" selected>naver.com</option>
								<option value="@hanmail.net">hanmail.net</option>
								<option value="@gmail.com">gmail.com</option>
								<option value="@nate.com">nate.com</option>
								<option value="@hotmail.com">hotmail.com</option>
								<option value="@yahoo.co.kr">yahoo.co.kr</option>
								<option value="@empas.com">empas.com</option>
								<option value="@dreamwiz.com">dreamwiz.com</option>
								<option value="@freechal.com">freechal.com</option>
								<option value="@lycos.co.kr">lycos.co.kr</option>
								<option value="@korea.com">korea.com</option>
								<option value="@hanmir.com">hanmir.com</option>
								<option value="@paran.com">paran.com</option>
							</select>
							<!-- 인증번호 전송 부분 -->
							<li>
								<input type="button" name="btn2" id="btn2" value="인증메일 전송" onclick="sendEmail()">
							</li>
							<!-- 인증번호 입력 부분 -->
							<li class="number">
								<input type="text" name="num" id="num" maxlength="5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
								<input type="button" name="btn3" id="btn3" value="인증번호 확인">
							</li>
						</div>
						<div class="hr">
							<hr class="pc_line">
						</div>

						<div class="pc_2">
							<li>
								<label for="address">
									<h2>주소</h2>
								</label>
							</li>
							<li class="address">
								<input type="text" name="postcode" id="postcode" placeholder="우편번호">
								<input type="button" onclick="daumPostCode()" value="우편번호 찾기">								
							</li>
							<li>
								<input type="text" name="address" id="address" placeholder="주소">
							</li>
							<li>
								<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소">
								<input type="text" name="extraAddress" id="extraAddress" placeholder="참고항목">
							</li>							
							<!-- <li>							
								<input type="text" id="extraAddress" placeholder="참고항목">
							</li>							 -->
							<!-- 마케팅 정보 수신동의 부분 -->
							<li>
								<div class="marketing_wrap">
									<div class="marketing">
										<h2>마케팅 정보 수신동의</h2>
										<br /> 중요한 알림 및 각종 혜택 알림을 수신합니다. <br /> 수업과 관련된 사항은 수신동의와
										관련없이 보내드립니다. <br />
										<br /> <input type="checkbox" name="chk1" id="chk">SNS
										서비스 동의 (선택) <br /> <input type="checkbox" name="chk2"
											id="chk">메일 수신 동의 (선택) <br />
									</div>
								</div> <!-- 약관동의 부분 -->
								<div class="agree_wrap">
									<div class="agree">
										<p>
										<h2>약관동의</h2>
										<input type="checkbox" name="chk3" id="chk" required>
										<a href="term">이용약관</a> 동의 (필수) <br /> 
										<input type="checkbox" name="chk4" id="chk" required>
										<a href="term2">개인정보처리방침</a> 동의 (필수) <br />
										</p>
									</div>
								</div>
							</li>
							<!-- 가입하기 부분 -->

							<li class="sub">
								<input type="submit" name="submit" id="submit" value="가입하기" onclick="checkValue(form)"> <!-- 메인 페이지로 돌아가기 부분 -->
								<a href="index"> <!-- 초기 화면으로 돌아감 -->
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