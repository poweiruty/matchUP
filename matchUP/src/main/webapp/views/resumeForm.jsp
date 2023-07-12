<%@page import="util.DBManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="resources/style/resume.css">
</head>

<body>
    <!-- header 시작 -->
       <jsp:include page="header_form"></jsp:include>

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
                <form action="Resume" method="post" name="resume" class="resumeForm" enctype="multipart/form-data">
                    <ul>
                        <li>
                            <!-- <label for="name">이름 </label>
                            <input type="text" id="name"> -->
                            <span class="pname">이름 : </span>
                            <span>${sessionScope.pname}</span>
                        </li>
                        <li>
                            <!-- <label for="date">생년월일 </label>
                            <input type="date" id="date"> -->
                            <span class="birth">생년월일 : </span>
                            <span>${sessionScope.birth}</span>
                        </li>
                        <li>
                            <!-- <label for="tel">연락처 </label>
                            <input type="text" id="tel"> -->
                            <span class="tel">전화번호 : </span>
                            <span>${sessionScope.tel}</span>
                        </li>
                        <li>
                           <!--  <label for="email">이메일 </label>
                            <input type="text" name="email" id="email">
                            <input type="text" name="email2" id="email2"> -->
                            <span class="email">이메일 : </span>
                            <span>${sessionScope.email}</span>
                        </li>
                        <li>
                            <!-- <label for="email">이메일 </label>
                            <input type="text" name="email" id="email">
                            <input type="text" name="email2" id="email2"> -->
                            <span class="user_address">주소 : </span>
                            <span>${sessionScope.user_address}</span>
                        </li> 
                   		
                   		<li>
                   			<label for="job">희망직종</label>
                   			<select name="job" id="job" size="1">      
                   				<option value="" selected></option>
                   				<%
                   				Connection conn = null;
                   				PreparedStatement pstmt=null;
                   				ResultSet rs=null;
                   				
                   				try{
                   					conn=DBManager.getConnection();
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
                            <label for="career">경력</label>
                            <input type="text" id="career">
                        </li>
                        <li>
                            <label for="degree">최종학력</label>
                            <select name="degree" id="degree">
                                <option value="sel">옵션 선택</option>
                                <option value="1">초졸</option>
                                <option value="2">중졸</option>
                                <option value="3">고졸</option>
                                <option value="4">대졸(2~3년제)</option>
                                <option value="5">대졸(4년제)</option>
                                <option value="6">대학원졸</option>
                                <input type="text" id="degree_input">
                            </select>
                        </li>
                        <li>
                            <label for="activity">대외활동/수상이력</label>
                            <input type="text" id="activity">
                        </li>
                        <li>
                            <label for="certificate">보유자격증</label>
                            <input type="text" id="certificate">
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
                <span><a href="#">등록</a></span>
                <span><a href="index">취소</a></span>
            </div>
        </div>
    </section>
    <!-- body 끝 -->

  <!-- footer 시작 -->
   	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>