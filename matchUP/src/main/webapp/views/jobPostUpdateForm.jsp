<%@page import="util.DBManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link rel="stylesheet" href="resources/style/scrap.css">
</head>

<body>
    <!-- header 시작 -->
	<jsp:include page="header"></jsp:include>

	<!-- header 끝 -->
	<!-- body 시작 -->
	<c:if test="${empty sessionScope.log }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<section class="container">
        <div class="msg">
            <p id="msg_title">채용공고관리</p>
        </div>
        <div class="main">
            <div class="saved">
                <p id="saved_title">진행중인 채용공고</p>
               <div class="saved_con_detail">
       <%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM job_posting_tb";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			String title = rs.getString("title");
			String corp_name = rs.getString("corp_name");
			String job = rs.getString("job_id");
			String people = rs.getString("recruit_people");
			String region = rs.getString("main_region_id");
			String regionDetail = rs.getString("semi_region_id");
			String salary = rs.getString("salary");
			String postDate = rs.getString("recruit_period");
			String welfare = rs.getString("welfare");
			String jobDetail = rs.getString("description"); 
			String ceo = rs.getString("ceo"); 
			
			// 세션에 저장된 cname과 기업명이 일치하는 경우에만 출력
			if (corp_name.equals(session.getAttribute("cname"))) {
				%>
				<!-- 출력 형식을 원하는 대로 변경하여 사용 -->
				<p>제목: <%= title %></p>
				<p>기업명: <%= corp_name %></p>
				<p>직무: <%= job %></p>
				<p>인원: <%= people %></p>
				<p>지역: <%= region %></p>
				<p>지역 상세: <%= regionDetail %></p>
				<p>급여: <%= salary %></p>
				<p>게시일: <%= postDate %></p>
				<p>복리후생: <%= welfare %></p>
				<p>직무 상세: <%= jobDetail %></p> 
				<%
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("직업 데이터 연동 및 출력 실패");
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>


                </div>
            </div>
            <div class="completed">
                <p id="completed_title">마감된 채용공고</p>
                
                <div class="completed_con_detail">
                    <!-- 여기에 내용 -->
                </div>
            </div>
        </div>
    </section>
    <!-- body 끝 -->

    <!-- footer 시작 -->
    	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>