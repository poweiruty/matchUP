<%@page import="model.resume.Resume"%>
<%@page import="model.resume.ResumeDao"%>
<%@page import="model.JobPost.JobPostDto"%>
<%@page import="model.job.Job"%>
<%@page import="model.job.JobDao"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="util.DBManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link rel="stylesheet" href="resources/style/scrap.css">

    <style>
        #saved_title, #completed_title{
    margin-bottom: 10px;
    font-size: 2rem;
    font-weight: 700;
}
    </style>
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
List<Map<String, String>> activeJobPostings = new ArrayList<>();
List<Map<String, String>> completedJobPostings = new ArrayList<>();
String sessionCname = (String) session.getAttribute("cname"); // 로그인한 세션의 "cname" 값 가져오기
Date today = new Date();

try {
    conn = DBManager.getConnection();

    // Query to fetch job_posting_tb, job_tb, main_region_tb, semi_region_tb
    String sql = "SELECT jp.title, jp.corp_name, corp.job_id, jp.recruit_people, "
            + "mr.main_region, sr.semi_region, jp.salary, jp.recruit_period, "
            + "jp.welfare, jp.description, jp.ceo "
            + "FROM job_posting_tb jp "
            + "JOIN job_tb corp ON jp.job_id = corp.job_id "
            + "JOIN main_region_tb mr ON jp.main_region_id = mr.main_region_id "
            + "JOIN semi_region_tb sr ON jp.semi_region_id = sr.semi_region_id";

    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();

    while (rs.next()) {
        String title = rs.getString("title");
        String corp_name = rs.getString("corp_name");
        String job = rs.getString("job_id"); 
        String people = rs.getString("recruit_people");
        String region = rs.getString("main_region");
        String regionDetail = rs.getString("semi_region");
        String salary = rs.getString("salary");
        String postDate = rs.getString("recruit_period");
        String welfare = rs.getString("welfare");
        String jobDetail = rs.getString("description");
        String ceo = rs.getString("ceo");

        // Convert the recruit_period string to a Date object for comparison
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date recruitDate = dateFormat.parse(postDate);

        // Check if recruit_period is today or in the future, and if corp_name matches the logged-in user's "cname"
        if (recruitDate.after(today) || recruitDate.equals(today)) {
            if (corp_name.equals(sessionCname)) {
                Map<String, String> activePosting = new HashMap<>();
                activePosting.put("title", title);
                activePosting.put("corp_name", corp_name);
                activePosting.put("job", job);
                activePosting.put("people", people);
                activePosting.put("region", region);
                activePosting.put("regionDetail", regionDetail);
                activePosting.put("salary", salary);
                activePosting.put("postDate", postDate);
                activePosting.put("welfare", welfare);
                activePosting.put("jobDetail", jobDetail);
                activeJobPostings.add(activePosting);
            }
                
        } else if (corp_name.equals(sessionCname)) {
            Map<String, String> completedPosting = new HashMap<>();
            completedPosting.put("title", title);
            completedPosting.put("corp_name", corp_name);
            completedPosting.put("job", job);
            completedPosting.put("people", people);
            completedPosting.put("region", region);
            completedPosting.put("regionDetail", regionDetail);
            completedPosting.put("salary", salary);
            completedPosting.put("postDate", postDate);
            completedPosting.put("welfare", welfare);
            completedPosting.put("jobDetail", jobDetail);
            completedJobPostings.add(completedPosting);
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


<%! // Define the intToStringJob method
    public static String intToStringJob(int jobId) {
        String job = "";
        switch (jobId) {
            case 1:
                job = "기획,전략";
                break;
            case 2:
                job = "마케팅,홍보";
                break;
            case 3:
                job = "회계,세무,재무";
                break;
            case 4:
                job = "인사,노무";
                break;
            case 5:
                job = "총무,법무,사무";
                break;
            case 6:
                job = "IT개발,데이터";
                break;
            case 7:
                job = "디자인";
                break;
            case 8:
                job = "영업,판매,무역";
                break;
            case 9:
                job = "고객상담,TM";
                break;
            case 10:
                job = "구재,자재,물류";
                break;
            case 11:
                job = "상품기획,MD";
                break;
            case 12:
                job = "운전,운송,배송";
                break;
            case 13:
                job = "생산";
                break;
            case 14:
                job = "의료";
                break;
            case 15:
                job = "연구R&D";
                break;
            case 16:
                job = "교육";
                break;
            case 17:
                job = "미디어,문화,스포츠";
                break;
            case 18:
                job = "금융,보험";
                break;
            case 19:
                job = "공공,복지";
                break;
                
            default:
                job = "오류"; // Default value if no match is found
                break;
        }
        return job;
    }
%>

<!-- Display Active Job Postings -->
<div class="active">
    <div class="active_con_detail">
        <% for (Map<String, String> activePosting : activeJobPostings) { %>
        <div class="con">
            <p>채용공고 제목: <%= activePosting.get("title") %></p>
            <p>기업명: <%= activePosting.get("corp_name") %></p>
            <p>직종: <%= intToStringJob(Integer.parseInt(activePosting.get("job"))) %></p>
            <p>채용 인원수: <%= activePosting.get("people") %>명</p>
            <p>지역: <%= activePosting.get("region") + " " + activePosting.get("regionDetail") %></p>
            <p>급여(연봉): <%= activePosting.get("salary") %>만원</p>
            <p>채용공고 마감일: <%= activePosting.get("postDate") %></p>
            <p>복리후생: <%= activePosting.get("welfare") %></p>
            <p>직무 상세: <%= activePosting.get("jobDetail") %></p><br>
        </div>
        <% } %>
    </div>
</div>
<!-- Display Completed Job Postings -->
<div class="completed">
    <p id="completed_title">마감된 채용공고</p>
    <span id="if">*오늘 마감되는 채용공고도 함께 표시됩니다.</span>
    <div class="completed_con_detail">
        <% for (Map<String, String> completedPosting : completedJobPostings) { %>
        <div class="con" style="background-color:indianred">
            <p>채용공고 제목: <%= completedPosting.get("title") %></p>
            <p>기업명: <%= completedPosting.get("corp_name") %></p>
            <p>직종: <%= intToStringJob(Integer.parseInt(completedPosting.get("job"))) %></p>
            <p>채용 인원수: <%= completedPosting.get("people") %>명</p>
            <p>지역: <%= completedPosting.get("region")  + " " + completedPosting.get("regionDetail") %></p>
            <p>급여(연봉): <%= completedPosting.get("salary") %>만원</p>
            <p>채용공고 마감일: <%= completedPosting.get("postDate") %></p>
            <p>복리후생: <%= completedPosting.get("welfare") %></p>
            <p>직무 상세: <%= completedPosting.get("jobDetail") %></p><br>
        </div>
        <% } %>
  
    </div>
</div>

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