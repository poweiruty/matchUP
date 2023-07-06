<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 초기화 css -->
    <link rel="stylesheet" href="../resources/style/reset.css">
    <!-- header css -->
    <link rel="stylesheet" href="../resources/style/grid.css">
    <link rel="stylesheet" href="../resources/style/resume.css">
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

    <!-- body 시작 -->
    <section class="container">
        <div class="msg">
            <p class="msg_title">이력서 관리</p>
        </div>
        <div class="main_con">
            <p class="resume_title">나의 이력서</p>
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="" method="post" name="resume" class="resumeForm" enctype="multipart/form-data">
                    <ul>
                        <li>
                            <label for="name">이름 </label>
                            <input type="text" id="name">
                        </li>
                        <li>
                            <label for="date">생년월일 </label>
                            <input type="date" id="date">
                        </li>
                        <li>
                            <label for="tel">연락처 </label>
                            <input type="text" id="tel">
                        </li>
                        <li>
                            <label for="email">이메일 </label>
                            <input type="text" name="email" id="email"> @
                            <input type="text" name="email2" id="email2">

                        </li>
                        <div class="add_wrap">
                            <li id="add">
                            <label for="address">주소</label>
                            <input type="text" name="address" id="address" placeholder="우편번호를 검색하세요.">
                            <input type="button" name="address_btn" id="address_btn" value="우편번호 검색">
                        </li>
                            <input type="text" name="address_detail" id="address_detail" placeholder="상세주소">
                        </div>
                        <li>
                            <label for="job">희망직종 </label>
                            <input type="text" id="job">
                        </li>
                        <li>
                            <label for="qual">보유자격증</label>
                            <input type="text" id="qual">
                        </li>
                        <li>
                            <label for="edu">최종학력</label>
                            <select name="edu" id="edu">
                                <option value="sel">옵션 선택</option>
                                <option value="1">초졸</option>
                                <option value="2">중졸</option>
                                <option value="3">고졸</option>
                                <option value="4">대졸(2~3년제)</option>
                                <option value="5">대졸(4년제)</option>
                                <option value="6">대학원졸</option>
                            </select>
                        </li>
                        <li>
                            <label for="intro">자기소개 </label>
                            <textarea name="intro" id="intro" cols="30" rows="10">
                        </textarea>
                        </li>
                    </ul>
                </form>
            </div>
            <div class="bottom">
                <span><a href="#">수정</a></span>
                <span><a href="index.html">취소</a></span>
            </div>
        </div>
    </section>
    <!-- body 끝 -->

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
</body>

</html>