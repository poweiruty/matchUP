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
	<link rel="shortcut icon" href="resources/img/favicon.png">
    <link rel="stylesheet" href="resources/style/resume.css">
</head>


<body>
    <!-- header 시작 -->
       <jsp:include page="header_form"></jsp:include>

    <!-- header 끝 -->

    <!-- body 시작 -->
    <section class="container">
        <div class="msg">
            <p class="msg_title">이력서 등록</p>
        </div>
        <div class="main_con">
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="ResumeCreate" method="post">                                            	
                    <ul>
                    	<li>
                            <label for="resume_title">제목</label>
                            <input type="text" name="resume_title" id="resume_title">                    
                        </li>
                        
                        <li>
                            <label for="pname">이름 </label>
                            <input type="text" name="pname" id="pname" value="${sessionScope.pname}" readonly>
                            <!-- <span></span> -->
                        </li>
                        
                        <li>
                            <label for="birth">생년월일 </label>
                            <input type="text" name="birth" id="birth" value="${sessionScope.birth}" readonly>                      
                        </li>
                        
                        <li>                   
                            <label for="tel">연락처 </label>
                            <input type="text" name="tel" id="tel" value="${sessionScope.phone}" readonly>
                        </li>
                        
                        <li>
                            <label for="email_resume">이메일 </label>
                            <input type="text" name="birth" id="birth" value="${sessionScope.email}" readonly>
                        </li>
                        
                        <li>
                            <label for="user_address">주소 </label>
                            <input type="text" name="birth" id="birth" value="${sessionScope.address}" readonly>                           
                        </li> 
                   		
                   		<li>
                   			<label for="job">희망직종</label>                        				
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
                   						<option value="" selected></option>
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
                   			</select>
                   		</li>
                   		            
                        <li>
                            <label for="graduation">학력</label>
                            <select name="graduation" id="graduation">
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
                        	<textarea name="degree" id="degree" cols="30" rows="10" placeholder="그 밖의 학력에 관련된 세부사항을 적어주세요."></textarea>
                        </li>
                        
                        <li>
                        	<div class=label_input>
                            	<label for="career">경력</label>
                            </div>	
                            <textarea name="career" id="career" cols="30" rows="10"></textarea>                            
                        </li>
                        
                        <li>
                        	<div class=label_input>                           
                            	<label for="activity">대외활동/수상이력</label>
                            </div>
                            <textarea name="activity" id="activity" cols="30" rows="10"></textarea>
                        </li>
                        
                        <li>
                        <div class=label_input>
                        	<label for="certificate">보유자격증</label>
                        </div>                           
                        <textarea name="certificate" id="certificate" cols="30" rows="10"></textarea>
                        </li>
                        
                        <li>
                        <div class=label_input>
                        	<label for="intro">자기소개 </label>
                        </div>
                          	<textarea name="intro" id="intro" cols="30" rows="10"></textarea>
                        </li>
                    </ul>
                    
                    <div class="bottom">
                		<input type="submit" name="submit" id="submit" value="등록">
                		<a href="index"><input type="button" id="back" value="메인이동"></a>
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