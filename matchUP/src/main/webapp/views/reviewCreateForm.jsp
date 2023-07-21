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

    <link rel="stylesheet" href="resources/style/review_create.css">
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
            <div class="main_resume">
                <!-- 이름, 생년월일, 연락처, 이메일, 주소 -->
                <form action="ReviewCreate" method="post">                                	                	
                    <ul>
                    	<li>
                   			<label for="corporation">기업</label>                        				                  			
                            <input type="text" name="corp_name" id="corp_name">                
                   		</li>
                   		                                                                                                 
                        <li>
                            <label for="star">별점</label>
                            <select name="star" id="star">
                                <option value="sel">옵션 선택</option>
                                <option value="1">★☆☆☆☆</option>
                                <option value="2">★★☆☆☆</option>
                                <option value="3">★★★☆☆</option>
                                <option value="4">★★★★☆</option>
                                <option value="5">★★★★★</option>                                                             
                            </select>                         
                        </li>
                        
                        <li>
                            <label for="summary">기업 한줄평</label>
                            <input type="text" name="summary" id="summary" placeholder="기업에 관하여 간략하게 적어주세요." required>                    
                        </li>
                        
                        <li>
                            <label for="review">기업리뷰</label>
                            <textarea name="review" id="review" cols="30" rows="10" placeholder="저희 MatchUP은 회원님의 정보를 노출하지 않습니다.&#13;&#10;익명성을 보장하지 않는 정보의 입력은 지양하시기 바랍니다."></textarea>
                        </li>
                                                                                                                                
                        <li>
                            <label for="position">직함/담당업무</label>
                            <input type="text" name="position" id="position">                    
                        </li>
                        
                        <li>
                            <label for="period">근무기간</label>
                            <select name="period" id="period">
                                <option value="sel">옵션 선택</option>
                                <option value="1">1년~3년</option>
                                <option value="2">3년~5년</option>
                                <option value="3">5년~7년</option>
                                <option value="4">7년~10년</option>
                                <option value="5">10년 이상</option>                                                             
                            </select>                         
                        </li>
                        
                    </ul>
                    <div class="bottom">
                		<input type="submit" name="submit" id="submit" value="등록">
                		<a href="review"><input type="button" id="back_btn" value="뒤로가기"></a> 
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