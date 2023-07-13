<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<p>채용 공고 등록</p>
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
								<select name="job" id="job" size="1">
                   				<option value="" selected></option>
                   				<%
                   				Connection conn = null;
                   				PreparedStatement pstmt=null;
                   				ResultSet rs=null;
                   				
                   				try{
                   					conn = DBManager.getConnection();
                   					String sql="select job from job_tb group by job order by job_id ASC";
                   					
                   					pstmt=conn.prepareStatement(sql);
                   					rs=pstmt.executeQuery();
                   					
                   					while(rs.next()){
                   						String job=rs.getString("job");
                   				%>
                   						<option value="<%= job %>"><%= job%></option>
                   				<%
                   					}
                   				}catch(Exception e){
                   					e.printStackTrace();
                   					System.out.println("직업 데이터 연동 및 출력 실패");
                   				}finally{
                   					try{
                   						if(rs!=null){
                   							rs.close();
                   						}
                   						if(pstmt!=null){
                   							pstmt.close();
                   						}
                   						if(conn!=null){
                   							conn.close();
                   						}
                   					}catch(Exception e){
                   						e.printStackTrace();
                   					}
                   				}
                   				%>
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
							<select name="job" id="job" size="1">
                   				<option value="" selected></option>
                   				<%
                   				                   				
                   				try{
                   					conn=DBManager.getConnection();
                   					String sql="select main_region from main_region_tb group by main_region order by main_region_id ASC";
                   					
                   					pstmt=conn.prepareStatement(sql);
                   					rs=pstmt.executeQuery();
                   					
                   					while(rs.next()){
                   						String main_region=rs.getString("main_region");
                   				%>
                   						<option value="<%= main_region %>"><%= main_region%></option>
                   				<%
                   					}
                   				}catch(Exception e){
                   					e.printStackTrace();
                   					System.out.println("직업 데이터 연동 및 출력 실패");
                   				}finally{
                   					try{
                   						if(rs!=null){
                   							rs.close();
                   						}
                   						if(pstmt!=null){
                   							pstmt.close();
                   						}
                   						if(conn!=null){
                   							conn.close();
                   						}
                   					}catch(Exception e){
                   						e.printStackTrace();
                   					}
                   				}
                   				%>
                   			</select>
							<select name="job" id="job" size="1">
                   				<option value="" selected></option>
                   				<%
                   				                   				
                   				try{
                   					conn=DBManager.getConnection();
                   					String sql="select semi_region from semi_region_tb group by semi_region order by semi_region_id ASC";
                   					
                   					pstmt=conn.prepareStatement(sql);
                   					rs=pstmt.executeQuery();
                   					
                   					while(rs.next()){
                   						String semi_region=rs.getString("semi_region");
                   				%>
                   						<option value="<%= semi_region %>"><%= semi_region%></option>
                   				<%
                   					}
                   				}catch(Exception e){
                   					e.printStackTrace();
                   					System.out.println("직업 데이터 연동 및 출력 실패");
                   				}finally{
                   					try{
                   						if(rs!=null){
                   							rs.close();
                   						}
                   						if(pstmt!=null){
                   							pstmt.close();
                   						}
                   						if(conn!=null){
                   							conn.close();
                   						}
                   					}catch(Exception e){
                   						e.printStackTrace();
                   					}
                   				}
                   				%>
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