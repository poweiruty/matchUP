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
<link rel="shortcut icon" href="resources/img/favicon.png">

    <link rel="stylesheet" href="resources/style/resume.css">
</head>


<script>
    function deleteResume(resumeId) {
        // AJAX를 사용하여 서버로 이력서 삭제 요청 전송
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'ResumeDelete', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // 서버 응답을 처리할 수 있는 코드 작성
                    console.log('이력서 삭제 성공');
                } else {
                    // 서버 응답이 실패인 경우 처리할 코드 작성
                    console.log('이력서 삭제 실패');
                }
            }
        };
        xhr.send('resumeId=' + resumeId);
    }
</script>


<style>
	.main_con{
    	text-align: center;
    	height: 800px;
	    border: solid 1px gray;
	    margin: 5% 10%;
	    overflow:auto;
    	margin-bottom: 10px;
	}
	
	.resume_theme{	    
	    margin-bottom: 20px;
	    font-size: 3rem;
	    font-weight: 700;
	}

	ul{
	    display: flex;
	    flex-direction: column;
	}
	
	li{
	    margin:10px;
	}
	
	.resume_create > a> input{
	    border: 2px solid gray;
	    border-radius : 10px;
	    width: 20%;
	    margin-bottom : 20px;
	    padding: 10px;
	    font-weight:900;
	}
	
	.resume_create > a> input:hover{
	    cursor: pointer;
	    background-color: gray;
	}
	
	textarea{
	    height: 35px;
	}
	
	select{
	    border-radius: 10px;
	}
	
	label{
	    font-weight: 700;
	    margin-right: 10px;
	}
			
	.resume-item {		
    	width : 900px;
    	border: 2px solid black;
    	border-radius: 10px;    	
    	margin : 0 auto;
    	text-align:left;
    	padding : 20px;
	}
		
	.resume-item:hover{
		cursor:pointer;
		box-shadow : 0px 5px 5px 0px gray;
	}
	
	.resume_number{
		font-size : 1.4rem;
	}
	
	.resume_title{
		margin-left : 20px;	    
	    margin-bottom: 10px;
	    font-size: 2rem;
	    font-weight: 700;
	}
	
	.resume_function{
		text-align:right;
	}
	
	.resume_function > li> input{
		border: 1px solid gray;
	    border-radius : 10px;
	    width: 10%;
	    padding: 5px;
	    font-weight:900;
	}
	
	.resume_function > li> input.modify{
		background-color:black;
		color:white;
	}
	
	.resume_function > li> input.modify:hover{
		cursor: pointer;
	    background-color: gray;
	    color : black;			
	}
	
	.resume_function > li> input.delete:hover{
		cursor: pointer;
	    background-color: gray;			
	}
		
</style>

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
                <form action="ResumeRead" method="post">
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
	                        	<div class="resume-item">
		                        	<div class="resume-content">
		                        		
		                        		
		                        		<div class="resume_number">
			                            	<li>
			                                	<label for="resume_number">NO.</label>
			                                	<span><%= index++ %></span>
			                            	</li>
			                            </div>

			                            
			                            <%-- <div class="resume_index">			                            	                              	
			                                <%= resume.getResumeId() %>			                            	
			                            </div> --%>
			                            
			                            <div class="resume_index">
			                            	<li>
			                                	<label for="resume_index">확인용</label>
			                                	<span><%= resume.getResumeId() %></span>
			                            	</li>
			                            </div>
		                        		
		                        		
		                        		<div class="resume_title">
			                            	<li>		                                	
			                                	<span><%= resume.getResumeTitle() %></span>
			                            	</li>
			                            </div>
			                            
			                            <div class="resume_function">
			                            	<li>
			                            		<input class="modify" type="button" value="수정">			                       		
			                            		<input class="delete" type="button" value="삭제" onclick="deleteResume(<%= resume.getResumeId() %>)">		                            		

			                            	</li>
			                            </div>
			                            
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
</body>



</html>