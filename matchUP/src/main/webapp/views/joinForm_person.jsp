<!-- 오류 떠서 임포트 두줄 삭제함. 필요시 다시 넣으셈! -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- header css -->
<link rel="stylesheet" href="resources/style/join.css">

</head>

<body>
	<%		
		String id = "";
		String notice = "";
		String status = "none";
		/* if(request.getAttribute("id") != null){
			id = request.getAttribute("id").toString();
		} */
		if(session.getAttribute("id") != null){
			id = session.getAttribute("id").toString();
		}
		
		if(session.getAttribute("notice") != null){
			notice = session.getAttribute("notice").toString();
			status = "block";
		}
	%>
	<!-- header 시작 -->
    <jsp:include page="header_form"></jsp:include>
	<!-- header 끝 -->  
	<div id="wrap">
		<div class="section">
			<div class="section_box">	
				<form action="UserIdCheck" method="POST" name="idForm" id="idForm" style="display: none;">
					<input type="hidden" name="pageInfo" id="pageInfo" value="puser">					
					<input type="hidden" name="tmpId" id="tmpId" value="">
					<%-- <input type="hidden" name="idchk" id="idchk" value="<%=request.getAttribute("idDupl")%>"> --%>
					<input type="hidden" name="idchk" id="idchk" value="<%=session.getAttribute("idDupl")%>">	
				</form>			
				<form action="PJoin" method="POST" name="joinForm" id="joinForm">
					<ul>
						<div class="pc_1">
							<li class="start">
								<h2>회원정보입력(개인 회원)</h2>
								<br>
							</li>
							<!-- 아이디 부분 -->
							<li>
								<label for="id">
										<h2>아이디</h2>
								</label>
							</li>
							<li class="id">							
								<input type="text" name="id" id="id" placeholder="길이 4-12자 이내" value="<%=id %>">									
								<input type="button" form="idForm" name="btn1" id="btn1" value="중복확인" onclick="idChk(form); idNotice();"><br/>																														
							</li>														
							<li class="error" id="error-duplId" style="display:<%=status%>"><%=notice %></li>								
							<li class="error" id="error-noneId">* 아이디는 필수 정보입니다.</li>
							
							<!-- 비밀번호 부분 -->
							<li>
								<label for="pwd1">
									<h2 id="pwd_center">
										비밀번호<br><span class="pwd_warning"> *특수문자는 '! @ # $ % ^ &
											+='만 사용 가능합니다.</span>
									</h2>
								</label>
							</li>
							<li class="pwd">
								<input type="password" name="password" id="password" placeholder="최소 8자리 이상 입력하세요." required>
								<input type="password" name="passwordChk" id=passwordChk placeholder="비밀번호 확인" required>								
								<span id="chkNotice" size="1"></span>
								<li class="error" id="error-password">* 비밀번호는 필수 정보입니다.</li>
								<li class="error" id="error-passwordRegex">* 비밀번호: 8~20자의 영어 대/소문자, 숫자, 특수문자를 이용해주세요.</li>
								<li class="error" id="error-password_chk">* 비밀번호를 다시 입력해주세요.</li>
								<li class="error" id="error-pwdEquals">* 비밀번호가 일치하지 않습니다.</li>
							</li>
							
							<!-- 이름 부분 -->
							<li class="name">
								<label for="name"><h2>이름</h2></label>
								<input type="text" name="name" id="name" required>
								<li class="error" id="error-name">* 이름은 필수 정보입니다.</li>
							</li> 
							<!-- 생년월일 부분 -->
							<li>
								<label for="birth"> 
									<h2 id="birth_center"> 생년월일<br>
										<span class="birth_warning"> *만 14세 미만의 사용자는 가입할 수 없습니다.</span>
									</h2>
								</label>
							</li>
							<li class="birth">
								<input type="hidden" name="tmpBirth" id="tmpBirth" value="">
								<select name="year" id="year">
									<option value="">연도 선택</option>
									<option value="1980">1980</option>
									<option value="1981">1981</option>
									<option value="1982">1982</option>
									<option value="1983">1983</option>
									<option value="1984">1984</option>
									<option value="1985">1985</option>
									<option value="1986">1986</option>
									<option value="1987">1987</option>
									<option value="1988">1988</option>
									<option value="1989">1989</option>
									<option value="1990">1990</option>
									<option value="1991">1991</option>
									<option value="1992">1992</option>
									<option value="1993">1993</option>
									<option value="1994">1994</option>
									<option value="1995">1995</option>
									<option value="1996">1996</option>
									<option value="1997">1997</option>
									<option value="1998">1998</option>
									<option value="1999">1999</option>
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
								</select> 
								<select name="month" id="month">
									<option value="">월 선택</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<select name="date" id="date">
									<option value="">일 선택</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
								</select>								
							</li>							
							<li class="error" id="error-birth">* 생일은 필수 정보입니다.</li>
							<!-- 휴대폰 부분 -->
							<li>
								<h2>휴대폰</h2>
							</li>
							<li class="phone">
								<input type="hidden" name="tmpTel" id="tmpTel" value="">
								<select name="phone" id="phone">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>	
								</select> 
								<span>-</span> 
								<input type="text" name="phone1" id="phone1" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
								<span>-</span> 
								<input type="text" name="phone2" id="phone2" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
							</li>
							<li class="error" id="error-tel">* 휴대폰번호는 필수 정보입니다.</li>					
							<!-- 이메일 부분 -->
							<li>
								<label for="email">
									<h2>이메일</h2>
								</label>
							</li>
							<li class="email">
								<input type="text" name="email" id="email">@
								<input type="text" name="email2" id="email2" value="naver.com">
								<li class="error" id="error-email">* 이메일은 필수 정보입니다.</li>
							</li>
							<!-- 인증 이메일 부분 -->
							<li>
								<input type="hidden" name="emailchk" id="emailchk" value="0">
								<input type="button" name="btn2" id="btn2" value="인증메일 전송" onclick="sendEmail()">
								<input type="button" name="btn3" id="btn3" value="인증번호 확인" onclick="emailAuthChk()">
								<li class="error" id="error-emailChk">* 이메일 인증을 완료해주세요.</li>
							</li>
							<li>
								<label for="address">
									<h2>주소</h2>
								</label>
							</li>
							<li class="address">
								<input type="text" name="postcode" id="postcode" placeholder="우편번호">
								<input type="button" class="postcode_find" onclick="daumPostCode()" value="우편번호 찾기">								
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
							
							<!-- 가입하기 부분 -->

							<li class="sub">
								<input type="button" name="submit-btn" id="submit-btn" value="가입하기" onclick="pJoinCheckValue()"> <!-- 메인 페이지로 돌아가기 부분 -->
								<a href="index"> 
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