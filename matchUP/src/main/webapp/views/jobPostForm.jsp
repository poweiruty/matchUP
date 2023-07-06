<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 채용관리 페이지 -->
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
<link rel="stylesheet" href="../resources/style/jobPost.css">
</head>

<body>
	<!-- header 시작 -->
	<header id="header">
		<div class="index">
			<a href="../index.jsp"> Match-UP </a>
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

	<!-- 
        채용공고
    
    직무 (필)
    채용공고 인원수 (필)
    광고 지역 (필)
    
    세부사항(어떤 종류의 직업?)(필)
    - 정규직, 아르바이트, 임시직, 계약직, 인턴, 신입공채, 병역특례
    
    급여 및 복지 
    
    급여 - (최소 - 최대) (연봉, 시급, 일급, 주급)
    
    직무내용 상세설명 (최소 글자 설정)
     
    채용공고 일정 (필)
    
    필수/우대 자격 설정
    (경력, 교대근무 가능, 자격증, 가능 언어, 학력, 사용자 지정 질문)
    면접 가능한 날짜 설정 
    -->
	<!-- body 시작 -->
	<section class="container">
		<div class="jobPost_wrap">
			<div class="title">
				<p>채용 관리</p>
			</div>
			<div class="main_con">
				<form action="" method="post" name="jobPost" class="jobPostForm"
					enctype="multipart/form-data">
					<ul>
						<li><label for="job">직종</label> <input type="text" name="job"
							id="job" placeholder="직종에 대해 간략히 적어주세요."></li>
						<li><label for="job_detail">직무 세부사항</label> <input
							type="text" name="job_detail" id="job_detail"
							placeholder="직무에 관련된 세부사항을 적어주세요."></li>
						<li><label for="job_style">채용형태</label> <select
							name="job_style" id="job_style" required>
								<option value="sel3">옵션 선택</option>
								<option value="1-">정규직</option>
								<option value="2-">임시직</option>
								<option value="3-">기간직</option>
								<option value="4-">아르바이트</option>
						</select></li>
						<li><label for="people">인원수</label> <select name="people"
							id="people" required>
								<option value="sel2">옵션 선택</option>
								<option value="1_">1명</option>
								<option value="2_">2~5명</option>
								<option value="3_">6~9명</option>
								<option value="4_">10명 이상</option>
								<option value="5_">20명 이상</option>
								<option value="always">상시 채용</option>
						</select></li>
						<li><label for="region">지역</label> <select name="region"
							id="region">
								<option value="sel3">옵션 선택</option>
								<option value="1!">서울특별시</option>
								<option value="2!">경기도</option>
								<option value="3!">인천광역시</option>
								<option value="4!">부산광역시</option>
								<option value="5!">대구광역시</option>
								<option value="6!">광주광역시</option>
								<option value="7!">대전광역시</option>
								<option value="8!">울산광역시</option>
								<option value="9!">세종특별시</option>
								<option value="10!">강원도</option>
								<option value="11!">충청남도</option>
								<option value="12!">충청북도</option>
								<option value="13!">경상남도</option>
								<option value="14!">경상북도</option>
								<option value="15!">전라남도</option>
								<option value="16!">전라북도</option>
								<option value="17!">제주도</option>
						</select> <select name="region_detail" id="region_detail">
								<option value="sel4">옵션 선택</option>
								<option value="1!!">서초구</option>
								<option value="2!!">강남구</option>
								<option value="3!!">성남시</option>
								<option value="4!!">수원시</option>
								<option value="5!!">서구</option>
								<option value="6!!">해운대구</option>
								<option value="7!!">동구</option>
								<option value="8!!">춘천시</option>
								<option value="9!!">강릉시</option>
								<option value="10!!">천안시</option>
								<option value="11!!">청주시</option>
								<option value="12!!">제천시</option>
								<option value="13!!">통영시</option>
								<option value="14!!">포항시</option>
								<option value="15!!">목포시</option>
								<option value="16!!">여수시</option>
								<option value="17!!">전주시</option>
								<option value="18!!">군산시</option>
								<option value="19!!">제주시</option>
								<option value="20!!">서귀포시</option>
						</select></li>
						<li><label for="salary">급여</label> <select name="salary"
							id="salary">
								<option value="sel5">옵션 선택</option>
								<option value=""></option>
						</select></li>
						<li><label for="post_date">채용공고 일정</label> <select
							name="post_date" id="post_date" required>
								<option value="sel6">옵션 선택</option>
								<option value="1=">1~3일</option>
								<option value="2=">4~7일</option>
								<option value="3=">1~2주</option>
								<option value="4=">3~4주</option>
								<option value="5=">한달</option>
						</select></li>
						<li><label for="qual">필수/우대 자격</label> <input type="text"
							name="qual" id="qual"></li>
						<li><label for="date">면접 희망 날짜</label> <input type="date"
							name="date" id="date"> <span>~</span> <input type="date"
							name="date" id="date"> <select name="date_detail"
							id="date_detail">
								<option value="sel7">옵션 선택</option>
								<option value="1+">주중</option>
								<option value="1+">주말</option>
								<option value="1+">항상</option>
						</select></li>
					</ul>
					<div class="bottom">
						<span><a href="#">수정</a></span> <span><a href="index.html">취소</a></span>
					</div>
				</form>
			</div>
		</div>
			<!-- body 끝 -->
			<!-- footer 시작 -->
			<footer>
				<div class="footer_box">
					<span>
					<a href="../index.jsp">© 2023 MatchUP</a></span> 
					<span><a href="#">회사소개</a></span> 
					<span><a href="#">고객센터</a></span> 
					<span><a href="term.jsp">이용약관</a></span> 
					<span><a href="term2.jsp">개인정보취급방침</a></span> 
					<span><a href="#">오류신고</a></span>
				</div>
			</footer>
			<!-- footer 끝 -->
</body>

</html>