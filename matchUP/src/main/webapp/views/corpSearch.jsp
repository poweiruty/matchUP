<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/style/corpSearch.css">
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="header"></jsp:include>

    <!-- header 끝 -->
    <!-- body 시작 -->
    <section class="container">
        <div class="msg">
            <p id="msg_title">채용공고 검색</p>
            <p>당신을 기다리고 있습니다!</p>
        </div>
            <div id="tab_search">
                <ul class="search">
                    <label for="search_bar">
                        <h2>검색어</h2>
                    </label>
                    <input type="text" id="search_bar" placeholder="업종, 직무 및 회사명">
                </ul>
                <ul class="region">
                    <label for="region_bar">
                        <h2>지역</h2>
                    </label>
                    <input type="text" id="region_bar" placeholder="근무지(도, 시, 군, 구, 동)" required>
                </ul>
                <ul>
                    <li class="search_btn">
						<!-- <button onclick="search()">검색</button> -->
						<input type="button" id="sBtn" name="sBtn" value="검색" onclick="search()">
                    </li>
                </ul>
            </div>
        <!-- 검색 내역 부분 -->
        <div class="con_wrap">
            <div class="search_con">
			
        </div>
    </section>
        
    <!-- body 끝 -->
		<script src="resources/script/search_post.js"></script>  
      <!-- footer 시작 -->
<%-- =======
	<section class="container">
		<div class="msg">
			<p id="msg_title">기업검색</p>
			<p>당신을 기다리고 있습니다!</p>
		</div>
		<div id="tab_search">
			<ul class="search">
				<label for="search_bar">
					<h2>검색어</h2>
				</label>
				<input type="text" id="search_bar" placeholder="업종, 직무 및 회사명">
			</ul>
			<ul class="region">
				<li class ="region_li" style="width: 1000px;">
							<label for="region">지역</label> 
							<select name="region" id="region" size="1">
                   				<option value="" selected>선택</option>
                   				<%
                   				Connection conn = null;
                   				PreparedStatement pstmt=null;
                   				ResultSet rs=null;
                   				
                   				                   				
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
							<select name="region_detail" id="region_detail" size="1">
                   				<option value="" selected>선택</option>
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
			</ul>
			<ul>
				<li class="search_btn">
					<button onclick="search()">검색</button>
				</li>
			</ul>
		</div>
		<!-- 검색 내역 부분 -->
		<div class="con_wrap">
			<div class="search_con">
			 
			</div>
		</div>
	</section>

	<!-- body 끝 --> --%>

	<!-- footer 시작 -->

     	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>