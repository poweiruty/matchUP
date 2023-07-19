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

    <link rel="stylesheet" href="resources/style/resume.css">
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="header_form"></jsp:include>

    <!-- header 끝 -->

    <!-- body 시작 -->
    <section class="container">
        <div class="main_con">
            <p class="resume_title">나의 이력서</p>
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="ResumeRead" method="post">
                    <div class="createResume">
                        <a href="resumeCreate"><input type="button" value="이력서 작성하기"></a>                		
                    </div>
                    
                    <%-- 데이터 리스트를 가져오기 --%>
                    <% 
                        ResumeDao resumeDao = ResumeDao.getInstance();
                        ArrayList<Resume> resumeList = resumeDao.getResumesByLogin();
                    %>

                    <ul>
                        <%-- 데이터 리스트를 반복해서 출력 --%>
                        <% for (Resume resume : resumeList) { %>
                            <li>
                                <label for="resume_title">이력서 제목 </label>
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
                                <label for="job">희망직종 </label>
                                <% 
                                    JobDao jobDao = JobDao.getInstance();
                                    Job job = jobDao.getJobByJobId(resume.getJobId());
                                    if (job != null) {
                                        out.print(job.getJob());
                                    }
                                %>
                            </li>

                            <li>
                                <label for="graduation">최종학력 </label>
                                <span><%= resume.getGraduation() %></span>
                            </li>
                            
                            <li>
                                <label for="degree">학력 </label>
                                <span><%= resume.getDegree() %></span>
                            </li>

                            <li>
                                <label for="career">경력 </label>
                                <span><%= resume.getCareer() != null ? resume.getCareer() : "-" %></span>
                            </li>

                            <li>
                                <label for="activity">대외활동/수상이력 </label>
                                <span><%= resume.getActivity() %></span>
                            </li>

                            <li>
                                <label for="certificate">보유자격증 </label>
                                <span><%= resume.getCertificate() %></span>
                            </li>

                            <li>
                                <label for="intro">자기소개 </label>
                                <span><%= resume.getIntro() %></span>
                            </li>
                            
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
</body>

</html>