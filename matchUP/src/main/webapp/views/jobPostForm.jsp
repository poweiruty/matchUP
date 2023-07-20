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
<link rel="shortcut icon" href="resources/img/favicon.png">

<link rel="stylesheet" href="resources/style/jobPost.css">

</head>

<body>
	<!-- header 시작 -->

	<jsp:include page="header_form"></jsp:include>
	<style>
		li{
			margin: 3% 0;
		}
		section{
			font-size:1.5rem;
		}
	</style>
	<!-- header 끝 -->

	<!-- body 시작 -->


	<section class="container">
		<div class="jobPost_wrap">
			<div class="posting_title">
				<p>채용 공고 등록</p>
			</div>
			<div class="main_con">
				<form action="JobPost" method="post">
					<ul>
					<li>
						<span>회사정보</span><br>
						<span class="if">*입력된 정보가 상이할 시, 고객센터로 문의해 주시기 바랍니다.</span>
					</li>
					<div class="corpInfo">
											
						<li>
							<span>회사명: </span>
							<input type = "text" name ="corp_name" id="corp_name" value="${sessionScope.cname }"></span>
						</li>
																		
						<li>
							<span class="phone">담당자 연락처: </span> 
							<input type="text" id="phone" value="${sessionScope.phone }">
						</li>
						<li>
							<span class="email">담당자 이메일: </span> 
							<input type="text" id="email" value="${sessionScope.email }">
						</li>
						<li>
							<span class="map">본사 소재지: </span> 
							<input type="text" id="map" value="${sessionScope.map }">
						</li>
						<li>
							<span>대표자명: </span>
							<input type="text" name="ceo" id="ceo" value="${sessionScope.ceo }" readonly>
						</li>
						<li> 
							<span>사원 수</span>
							<input type="text" name="staffs" id="staffs" value="${sessionScope.staffs }"> 
						</li>
					</div>
						<hr class="line">
						<div class="postinfo">
							<li>
								<span>채용공고 정보입력</span><br>
								<span class="if">*채용시 필요한 정보들을 입력해 주세요.</span>
							</li>

							<li>
								<span>채용공고 제목: </span>
								<input type = "text" name ="title" id="title" >
							</li>

						<li>
							<label for="job">직종</label>	                                                                                                                          
								<%
									Connection conn = null;
	                   				PreparedStatement pstmt=null;
	                   				ResultSet rs=null;
                   				try{
                   					conn=DBManager.getConnection();
                   					String sql="select job_id, job from job_tb group by job order by job_id ASC";
                   					
                   					pstmt=conn.prepareStatement(sql);
                   					rs=pstmt.executeQuery();
                   				%>
                   					<select name="job" id="job" size="1">
                   					<option value="" selected>선택</option>
                   				<% 
                   					while(rs.next()){
                   						int job_id=rs.getInt("job_id");
                   						String job=rs.getString("job");
                   				%>
                   						<option value="<%= job_id%>"><%= job%></option>		
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
                   			</select><br>
							<span class="if">
								*유사한 직종이 포함되어 있는 항목을 골라주세요.
							</span>
						</li>
						<li>
							<label for="people">인원수</label> 
							<select name="people" id="people" required>
								<option value="">선택</option>
								<option value="1">1명</option>
								<option value="2">2~5명</option>
								<option value="3">6~9명</option>
								<option value="4">10명 이상</option>
								<option value="5">20명 이상</option>
								<option value="6">상시 채용</option>
							</select>
							<span class="if">
								*본 공고시에만 적용됩니다.
							</span>
								</li>
								<li>
							   <label for="region">지역</label> 
							   <select name="region" id="region" size="1">
							       <option value="" selected>선택</option>
							       <% 
							       try {
							           conn = DBManager.getConnection();
							           String sql = "select main_region_id, main_region from main_region_tb group by main_region order by main_region_id ASC";
							           
							           pstmt = conn.prepareStatement(sql);
							           rs = pstmt.executeQuery();
							           
							           while(rs.next()) {
							               int main_region_id = rs.getInt("main_region_id");
							               String main_region = rs.getString("main_region");
							       %>
							               <option value="<%= main_region_id %>"><%= main_region %></option>		
							       <%
							           }
							       } catch(Exception e) {
							           e.printStackTrace();
							           System.out.println("지역 데이터 연동 및 출력 실패");
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
									 <select name="region_detail" id="region_detail" size="1">
							       <option value="" selected>선택</option>
							       <% 
							       try {
							           conn = DBManager.getConnection();
							           String sql = "select semi_region_id, semi_region from semi_region_tb group by semi_region order by semi_region_id ASC";
							           
							           pstmt = conn.prepareStatement(sql);
							           rs = pstmt.executeQuery();
							           
							           while(rs.next()) {
							               int semi_region_id = rs.getInt("semi_region_id");
							               String semi_region = rs.getString("semi_region");
							       %>
							               <option value="<%= semi_region_id %>"><%= semi_region %></option>		
							       <%
							           }
							       } catch(Exception e) {
							           e.printStackTrace();
							           System.out.println("지역 데이터 연동 및 출력 실패");
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
								<input type="text" name="salary" id="salary">
								<span>만원 (연봉기준)</span>
							</li>
							<li>
							<label for="post_date">채용공고 마감일</label> 
							<input type="date" name="post_date" id="post_date">
							</li>
							<li>
						<label for="welfare">복지</label>
						<input type="text" name="welfare" id="welfare" placeholder="회사 내 복지사항에 대해 적어주세요.">
						</li>
						<li><label for="job_detail">직무 세부사항</label> 
						<input type="text" name="job_detail" id="job_detail"placeholder="직무에 관련된 세부사항을 적어주세요.">
						</li>
					</div>
					</ul>
					<div class="bottom">
						<input type="submit" name="submit" id="submit" value="등록">
						<a class="cancel" href="index">취소</a>
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