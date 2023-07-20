<%@page import="java.util.ArrayList"%>
<%@page import="model.resume.Resume"%>
<%@page import="model.resume.ResumeDao"%>
<%@page import="model.job.Job"%>
<%@page import="model.job.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        
    <link rel="stylesheet" href="resources/style/resume_read.css">    
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="header_form"></jsp:include>

    <!-- header 끝 -->

    <!-- body 시작 -->
    <section class="container">
        <div class="main_con">
            <p class="resume_theme">나의 이력서</p>
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="ResumeRead" method="post" name="resume_delete_check">
                    <div class="resume_create">
                        <a href="resumeCreate">
                        	<input type="button" value="이력서 작성하기">
                        </a>                		
                    </div>
                    
                    
                    <%-- 데이터 리스트를 가져오기 --%>
                    <% 
                    	int puserIdx = (int) session.getAttribute("puserIdx");
                    
                        ResumeDao resumeDao = ResumeDao.getInstance();
                        ArrayList<Resume> resumeList = resumeDao.getResumesByLogin(puserIdx);
                    %>
					
	                    <ul>
	                        <%-- 데이터 리스트를 반복해서 출력 --%>
	                        <% int index=1; %>
	                        <% for (Resume resume : resumeList) { %>	                        	
	                        	<!-- <a href="resumeReadDetail"> -->
	                        	<%
   									 // 이력서 리스트에서 전달된 resume_id를 가져옵니다.
    								int resumeId = resume.getResumeId();
								%>
	                        	
		                        <div class="resume-item" id="resume_<%= resume.getResumeId() %>">	
		                        	<a href="resumeReadDetail?resume_id=<%= resumeId %>">                        	
			                        	<div class="resume-content">		                        				                        		
			                        		<div class="resume_number">
				                            	<li>
				                                	<label for="resume_number">NO.</label>
				                                	<span><%= index++ %></span>
				                            	</li>
				                            </div>
				                            			                          		                            			                            		                        				                        		
			                        		<div class="resume_title">
				                            	<li>		                                	
				                                	<span><%= resume.getResumeTitle() %></span>
				                            	</li>
				                            </div>
				                         </div>
				                       </a>  
				                       <div class="resume_function">
				                          	<li>				                            					                       		
				                          		<input class="delete" type="button" value="삭제" onclick="deleteResume(<%= resume.getResumeId() %>)">			                            					                            		
				                           	</li>
				                       </div>
				                            
				                        
			                        </div>
		                        
		                        <br>
		                        
	                        <% } %>
	                    </ul>
                    
                </form>
            </div>
        </div>
    </section>
    <!-- body 끝 -->

    <!-- footer 시작 -->
    <jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
    <script src="resources/script/resume_delete.js"></script>
</body>

</html>