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
            <p class="msg_title">리뷰 작성</p>
        </div>
        <div class="main_con">
            <p class="resume_title">나의 이력서</p>
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="Resume" method="post">
                
                	<!--  테스토 : 황인규 작성
                	<div calss="test">
                		<span>세션값을 뽑아와보자 : </span>
                		<span>${sessionScope.puserIdx}</span>
                	</div> -->
                	
                    <ul>
                        <li>
                            <span class="pname">이름 : ㅋㅋㅋㅋ자살마렵다</span>
                            <span>${sessionScope.pname}</span>
                        </li>
                        
                        <li>
                            <span class="birth">생년월일 : </span>
                            <span>${sessionScope.birth}</span>
                        </li>
                        
                        <li>                   
                            <span class="tel">전화번호 : </span>
                            <span>${sessionScope.phone}</span>
                        </li>
                        
                        <li>
                            <span class="email_resume">이메일 : </span>
                            <span>${sessionScope.email}</span>
                        </li>
                        
                        <li>
                            <span class="user_address">주소 : </span>
                            <span>${sessionScope.address}</span>
                        </li> 
                   		            
                        <li>
                            <label for="graduation">최종학력</label>
                            <select name="graduation" id="graduation">
                                <option value="sel">옵션 선택</option>
                                <option value="1">초졸</option>
                                <option value="2">중졸</option>
                                <option value="3">고졸</option>
                                <option value="4">대졸(2~3년제)</option>
                                <option value="5">대졸(4년제)</option>
                                <option value="6">대학원졸</option>                             
                            </select>
                            <textarea name="degree" id="degree" cols="30" rows="10"></textarea>
                        </li>
                        
                        <li>
                            <label for="career">경력</label>
                            <textarea name="career" id="career" cols="30" rows="10"></textarea>
                        </li>
                        
                        <li>
                            <label for="activity">대외활동/수상이력</label>
                            <textarea name="activity" id="activity" cols="30" rows="10"></textarea>
                        </li>
                        <li>
                            <label for="certificate">보유자격증</label>
                            <textarea name="certificate" id="certificate" cols="30" rows="10"></textarea>
                        </li>
                        
                        <li>
                            <label for="intro">자기소개 </label>
                            <textarea name="intro" id="intro" cols="30" rows="10"></textarea>
                        </li>
                    </ul>
                    <div class="bottom">
                		<input type="submit" name="submit" id="submit" value="이력서 등록">
                		<span><a href="index"> 메인 페이지로 돌아가기</a></span> 
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