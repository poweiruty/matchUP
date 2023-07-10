<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 채용관리 페이지 -->
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="resources/style/jobPost.css">
</head>

<body>
	<!-- header 시작 -->

	<jsp:include page="header_form"></jsp:include>
	<!-- header 끝 -->

	<!-- body 시작 -->
	<section class="container">
		<div class="jobPost_wrap">
			<div class="title">
				<p>채용 관리</p>
			</div>
			<div class="main_con">
				<form action="JobPost" method="post">
					<ul>
						<li>
							<span class="corp_id">회사명: </span> 
							<span>${sessionScope.cname }</span>
						</li>
						<li>
							<span class="phone">담당자 연락처: </span> 
							<span>0${sessionScope.phone }</span>
						</li>
						<li>
							<span class="phone">담당자 이메일: </span> 
							<span>${sessionScope.email }</span>
						</li>
						<li>
							<span class="phone">본사 소재지: </span> 
							<span>${sessionScope.map }</span>
						</li>
						<li>
							<span class="ceo">대표자명: </span>
							<span>${sessionScope.ceo }</span>
						</li>
						<li> 
							<span class="staffs">총 사원 수: </span>
							<span>${sessionScope.staffs }</span> 
						</li>
						<li>
							<label for="job">직종</label> 
							<select name="job" id="job" required>
								<option value="">옵션 선택</option>
								<option value="1">기획,전략</option>
								<option value="2">마케팅,홍보</option>
								<option value="3">회계,세무,재무</option>
								<option value="4">인사,노무</option>
								<option value="5">총무,법무,사무</option>
							</select>
						</li>
						<li>
							<label for="people">인원수</label> 
							<select name="people" id="people" required>
								<option value="">옵션 선택</option>
								<option value="1">1명</option>
								<option value="2">2~5명</option>
								<option value="3">6~9명</option>
								<option value="4">10명 이상</option>
								<option value="5">20명 이상</option>
								<option value="6">상시 채용</option>
							</select>
						</li>
						<li>
							<label for="region">지역</label> 
							<select name="region" id="region">
								<option value="">옵션 선택</option>
								<option value="1">서울특별시</option>
								<option value="2">경기도</option>
								<option value="3">인천광역시</option>
								<option value="4">부산광역시</option>
								<option value="5">대구광역시</option>
								<option value="6">광주광역시</option>
								<option value="7">대전광역시</option>
								<option value="8">울산광역시</option>
								<option value="9">세종특별시</option>
								<option value="10">강원도</option>
								<option value="11">충청남도</option>
								<option value="12">충청북도</option>
								<option value="13">경상남도</option>
								<option value="14">경상북도</option>
								<option value="15">전라남도</option>
								<option value="16">전라북도</option>
								<option value="17">제주도</option>
							</select> 
							<select name="region_detail" id="region_detail">
								<option value="">옵션 선택</option>
								<option value="1">서초구</option>
								<option value="2">강남구</option>
								<option value="3">성남시</option>
								<option value="4">수원시</option>
								<option value="5">서구</option>
								<option value="6">해운대구</option>
								<option value="7">동구</option>
								<option value="8">춘천시</option>
								<option value="9">강릉시</option>
								<option value="10">천안시</option>
								<option value="11">청주시</option>
								<option value="12">제천시</option>
								<option value="13">통영시</option>
								<option value="14">포항시</option>
								<option value="15">목포시</option>
								<option value="16">여수시</option>
								<option value="17">전주시</option>
								<option value="18">군산시</option>
								<option value="19">제주시</option>
								<option value="20">서귀포시</option>
							</select>
						</li>
						<li>
							<label for="salary">급여</label> 
							<select name="salary" id="salary">
								<option value="">옵션 선택</option>
								<option value="연 2000~3000만원">연 2000~3000만원</option>
								<option value="연 3000~5000만원">연 3000~5000만원</option>
								<option value="연 5000만원 이상">연 5000만원 이상</option>
							</select>
							</li>
							<li>
							<label for="post_date">채용공고 일정</label> 
							<select name="post_date" id="post_date" required>
								<option value="">옵션 선택</option>
								<option value="1~3일">1~3일</option>
								<option value="4~7일">4~7일</option>
								<option value="1~2주">1~2주</option>
								<option value="3~4주">3~4주</option>
								<option value="한 달">한 달</option>
							</select></li>
							<li>
						<label for="welfare">복지</label>
						<input type="text" name="welfare" id="welfare" placeholder="회사 내 복지사항에 대해 적어주세요.">
						</li>
						<li><label for="job_detail">직무 세부사항</label> 
						<input type="text" name="job_detail" id="job_detail"placeholder="직무에 관련된 세부사항을 적어주세요.">
						</li>
					</ul>
					<div class="bottom">
						<input type="submit" name="submit" id="submit" value="등록">
						<span><a href="index">취소</a></span>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- body 끝 -->
	<!-- footer 시작 -->
	<jsp:include page="footer"></jsp:include>

	<!-- footer 끝 -->
</body>

</html>