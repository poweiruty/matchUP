<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="../resources/style/reset_form.css">
    <!-- header css -->
    <link rel="stylesheet" href="../resources/style/grid.css">
    <link rel="stylesheet" href="../resources/style/join.css">
</head>

<body>
     <!-- header 시작 -->
     <header id="header">
        <div class="index">
            <a href="../index.jsp">
                Match-UP
            </a>
        </div>

        <!-- 검색 -->
        <div class="nav">
            <div class="corpSearch">
                <a href="corpSearch.jsp">
                    <h3>기업검색</h3>
                </a>
            </div>
            <!-- 기업리뷰 -->
            <div class="corpReview">
                <a href="corpReview.jsp">
                    <h3>기업리뷰</h3>
                </a>
            </div>
            <!-- 로그인 & 마이페이지 -->
            <div class="login">
                <a href="loginForm.jsp">
                    <h3>로그인</h3>
                </a>
            </div>
            <!-- 회원가입 -->
            <div class="login">
                <a href="joinForm.jsp">
                    <h3>회원가입</h3>
                </a>
            </div>
            <!-- 관심채용정보(스크랩) -->
            <div class="scrap">
                <a href="scrapForm.jsp">
                    <h3>관심채용정보</h3>
                </a>
            </div>
            <!-- 이력서 -->
            <div class="resumeForm">
                <a href="resumeForm.jsp">
                    <h3>이력서 관리</h3>
                </a>
            </div>
            <!-- 채용 관리 -->
            <div class="jobPostForm">
                <a href="jobPostForm.jsp">
                    <h3>채용 관리</h3>
                </a>
            </div>
        </div>
    </header>
    <!-- header 끝 -->

    <div id="wrap">
        <div class="section">
            <div class="section_box">
                <form action="" method="post" name="membership" enctype="multipart/form-data">
                    <ul>
                        <div class="pc_1">
                            <li class="start">
                                <h2>회원정보입력</h2>
                            </li>
                            <!-- 아이디 부분 -->
                            <li>
                                <label for="id">
                                    <h2>아이디</h2>
                                </label>
                            </li>
                            <li class="id">
                                <input type="text" name="id" id="id" placeholder="길이 4-12자 이내" required>
                                <input type="button" name="btn1" id="btn1" value="중복확인"><br />
                            </li>

                            <!-- 비밀번호 부분 -->
                            <li>
                                <label for="pwd1">
                                    <h2>비밀번호<span class="pwd_warning"> *특수문자는 '! @ # $ % ^ & +='만 사용 가능합니다.</span></h2>
                                </label>
                            </li>
                            <html>
                            <li class="pwd">
                                <input type="password" name="pwd1" id="pwd1" placeholder="4-10자의 영문, 특수문자, 숫자 조합"
                                    required>
                                <input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" required>
                                <span id="chkNotice" size="1"></span>
                            </li>

                            <!-- 이름 부분 -->
                            <li class="name">
                                <label for="name">
                                    <h2>이름</h2>
                                </label>
                                <input type="text" name="name" id="name" required>
                            </li>

                            <!-- 생년월일 부분 -->
                            <li>
                                <label for="birth">
                                    <h2>생년월일<span class="birth_warning"> *만 14세 미만의 사용자는 가입할 수 없습니다.</span></h2>
                                </label>
                            </li>
                            <li class="birth">
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
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                                <select name="date" id="date">
                                    <option value="">일 선택</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
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
                            <!-- 휴대폰 부분 -->
                            <li>
                                <h2>휴대폰</h2>
                            </li>
                            <li class="phone">
                                <select name="phone" id="phone">
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                                    <option value="016">016</option>
                                    <option value="017">017</option>
                                    <option value="018">018</option>
                                    <option value="019">019</option>
                                </select>
                                <span>-</span>
                                <input type="text" name="phone1" id="phone1" maxlength="4"
                                    oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                                <span>-</span>
                                <input type="text" name="phone2" id="phone2" maxlength="4"
                                    oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                            </li>
                            <!-- 인증번호 전송 부분 -->
                            <li>
                                <input type="button" name="btn2" id="btn2" value="인증번호 전송">
                            </li>
                            <!-- 인증번호 입력 부분 -->
                            <li class="number">
                                <input type="text" name="num" id="num" maxlength="5"
                                    oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                                <input type="button" name="btn3" id="btn3" value="인증번호 확인">
                            </li>
                            <!-- 이메일 부분 -->
                            <li>
                                <label for="email">
                                    <h2>이메일</h2>
                                </label>
                            </li>
                            <li class="email">
                                <input type="text" name="email" id="email"> @
                                <input type="text" name="email2" id="email2" disabled value="naver.com">
                            </li>
                            <select name="selectEmail" id="selectEmail">
                                <option value="1">직접입력</option>
                                <option value="naver.com" selected>naver.com</option>
                                <option value="hanmail.net">hanmail.net</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="nate.com">nate.com</option>
                                <option value="hotmail.com">hotmail.com</option>
                                <option value="yahoo.co.kr">yahoo.co.kr</option>
                                <option value="empas.com">empas.com</option>
                                <option value="dreamwiz.com">dreamwiz.com</option>
                                <option value="freechal.com">freechal.com</option>
                                <option value="lycos.co.kr">lycos.co.kr</option>
                                <option value="korea.com">korea.com</option>
                                <option value="hanmir.com">hanmir.com</option>
                                <option value="paran.com">paran.com</option>
                            </select>
                        </div>
                        <div class="hr">
                            <hr class="pc_line">
                        </div>

                        <div class="pc_2">
                            <!-- 주소 부분 시작 -->
                            <div class="add_wrap">
                                <label for="address">
                                    <h2 id="add">주소</h2>
                                </label>
                            <li id="add">
                                <input type="text" name="address" id="address" placeholder="우편번호를 검색하세요.">
                                <input type="button" name="address_btn" id="address_btn" value="우편번호 검색">
                            </li>
                                <input type="text" name="address_detail" id="address_detail" placeholder="상세주소">
                            </div>
                            <!-- 주소 끝 -->
                            <!-- 마케팅 정보 수신동의 부분 -->
                            <li>
                                <div class="marketing_wrap">
                                    <div class="marketing">
                                        <h2>마케팅 정보 수신동의</h2><br />
                                        중요한 알림 및 각종 혜택 알림을 수신합니다. <br />
                                        수업과 관련된 사항은 수신동의와 관련없이 보내드립니다. <br /><br />
                                        <input type="checkbox" name="chk1" id="chk">SNS 서비스 동의 (선택) <br />
                                        <input type="checkbox" name="chk2" id="chk">메일 수신 동의 (선택) <br />
                                    </div>
                                </div>
                                <!-- 약관동의 부분 -->
                                <div class="agree_wrap">
                                    <div class="agree">
                                        <p>
                                        <h2>약관동의</h2>
                                        <input type="checkbox" name="chk3" id="chk" required><a
                                            href="term.html">이용약관</a> 동의 (필수) <br />
                                        <input type="checkbox" name="chk4" id="chk" required><a
                                            href="term2.html">개인정보처리방침</a> 동의 (필수) <br />
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <!-- 가입하기 부분 -->
                            <li class="sub">
                                <input type="submit" name="submit" id="submit" value="가입하기">

                                <!-- 메인 페이지로 돌아가기 부분 -->
                                <a href="index.html"> <!-- 초기 화면으로 돌아감 -->
                                    <div id="index">메인 페이지로 돌아가기</div>
                                </a>
                            </li>
                        </div>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</body>
<!-- footer 시작 -->
      <footer>
        <div class="footer_box">
            <span><a href="../index.jsp">© 2023 MatchUP</a></span>
            <span><a href="#">회사소개</a></span>
            <span><a href="#">고객센터</a></span>
            <span><a href="term.jsp">이용약관</a></span>
            <span><a href="term2.jsp">개인정보 취급방침</a></span>
            <span><a href="#">오류신고</a></span>
        </div>
    </footer>
    <!-- footer 끝 -->

</html>