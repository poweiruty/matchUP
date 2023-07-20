<%@page import="model.job.Job"%>
<%@page import="model.job.JobDao"%>
<%@page import="model.resume.ResumeDao"%>
<%@page import="model.resume.Resume"%>

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
        <div class="main_con">         
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="ResumeReadDetail" method="post">                	            		                              	                	
                    <%
    					// URL 매개변수로 전달된 resume_id를 읽어옵니다.
    					int resumeId = Integer.parseInt(request.getParameter("resume_id"));

    					// ResumeDao를 이용해 해당 resume_id에 해당하는 이력서 정보를 가져옵니다.
    					ResumeDao resumeDao = ResumeDao.getInstance();
    					Resume resume = resumeDao.getResumeByResumeIdx(resumeId);
    					
    					// JobDao를 이용해 해당 resume의 job_id에 해당하는 job 값을 가져옵니다.
    			        JobDao jobDao = JobDao.getInstance();
    					Job job = jobDao.getJobByJobId(resume.getJobId());
					%>
                   
                    
                    <ul>                   	                   	
                    	<li>
                            <label for="resume_title">제목</label>
                            <span><%= resume.getResumeTitle() %></span>                   
                        </li>
                        
                        <li>
                            <label for="pname">이름 </label>
                            <span>${sessionScope.pname}</span>
                        </li>
                        
                        <li>
                            <label for="birth">생년월일 </label>
                            <span>${sessionScope.birth}</span>	
                        </li>
                        
                        <li>                   
                            <label for="tel">연락처 </label>
                            <span>${sessionScope.phone}</span>
                        </li>
                        
                        <li>
                            <label for="email_resume">이메일 </label>
                            <span>${sessionScope.email}</span>
                        </li>
                        
                        <li>
                            <label for="user_address">주소 </label>
                            <span>${sessionScope.address}</span>
                        </li> 
                   		
                   		<li>
                   			<label for="job">희망직종</label>                        				
                   			<span><%= job.getJob()%></span>
                   		</li>
                   		            
                        <li>
                            <label for="graduation">최종학력</label>
                            <span><%= resume.getGraduation()%></span>
                        </li>
                        
                        <li>
                            <label for="career">경력</label>
                            <span><%= resume.getCareer()%></span>
                        </li>
                        
                        <li>
                            <label for="activity">대외활동/수상이력</label>
                            <span><%= resume.getActivity()%></span>
                        </li>
                        
                        <li>
                            <label for="certificate">보유자격증</label>
                            <span><%= resume.getCertificate()%></span>
                        </li>
                        
                        <li>
                            <label for="intro">자기소개 </label>
                            <span><%= resume.getIntro()%></span>
                        </li>
                    </ul>
                    
                    <div class="bottom">
                    	<a href="resumeCreate"><input type="button" value="수정하기"></a>               
                		<a href="resumeRead"><input type="button" value="뒤로가기"></a>
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