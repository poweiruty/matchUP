<%@page import="model.user_corp.CorpUser"%>
<%@page import="model.user_corp.CorpUserDao"%>
<%@page import="model.job.JobRequestDto"%>
<%@page import="model.job.JobDao"%>
<%@page import="model.job.Job"%>
<%@page import="model.region.SemiRegion"%>
<%@page import="model.region.MainRegionRequestDto"%>
<%@page import="model.region.MainRegion"%>
<%@page import="model.region.RegionDao"%>
<%@page import="model.JobPost.JobPostDto"%>
<%@page import="model.JobPost.JobPostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="resources/img/favicon.png">

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/style/corpSearch.css">
<link rel="stylesheet" href="resources/style/grid.css">
</head>
<body>
<section class="container">
<% 
if(request.getParameter("post_id") != null){
	int post_id = Integer.parseInt(request.getParameter("post_id")); 
	JobPostDao pdao = JobPostDao.getInstance();
	JobPostDto dto = pdao.getJobPostbyId(post_id);
	RegionDao rdao = RegionDao.getInstance();	
	JobDao jdao = JobDao.getInstance();
	CorpUserDao cdao = CorpUserDao.getInstance();
	
	int job_id = Integer.parseInt(dto.getJob());	
	int main_id = Integer.parseInt(dto.getRegion());
	int semi_id = Integer.parseInt(dto.getRegionDetail());
	
	Job job = jdao.getJobByJobId(job_id);
	MainRegion main = rdao.getMainRegion(main_id);
	SemiRegion semi = rdao.getSemiRegion(semi_id);
	
	String jobName = job.getJob();
	String main_region = main.getMainRegion();
	String semi_region = semi.getSemiRegion();
	
	dto.setJob(jobName);
	dto.setRegion(main_region);
	dto.setRegionDetail(semi_region);
	
	String title = dto.getTitle();
	String cname = dto.getCorp_name();
	String staffs = dto.getStaffs();
	
	CorpUser cuser = cdao.getUserbyCname(cname);	
	
	jobName = dto.getJob();
	main_region = dto.getRegion();
	semi_region = dto.getRegionDetail();
	
	String region = main_region + " " + semi_region;
	String people = dto.getPeople();
	String postDate = dto.getPostDate();
	String salary = dto.getSalary();
	String welfare = dto.getWelfare();
	String jobDetail = dto.getJobDetail();
	String create_post = dto.getCreate_post().substring(0,10);
	
	String mgr_name = cuser.getMgr_name();
	String mgr_tel = cuser.getMgr_tel().substring(0, 3) + "-" + cuser.getMgr_tel().substring(3, 7) + "-" + cuser.getMgr_tel().substring(7);	
	
	%>
		<div class="post_detail_con1">
			<h2 class="title" style="margin-bottom: 20px"><%=title %>(<%=jobName %>)</h2>
			<p class="cname"><%=cname %></p>
			<p class="post_region" style="margin-bottom: 10px"><%=region %></p>			
		</div>
		<div class="post_detail_con2" style="margin-top: 15px">
			<h3 style="margin-bottom: 10px">기업 정보</h3>						
			<p class="staffs">직원수 : <%=staffs %>명</p>		
			<p class="postDate">지원 기간 : <%=create_post %> ~ <%=postDate %></p>
			<p class="people">모집인원 : <%=people %>명</p>
			<p class="salary">연봉 : <%=salary %></p>
			<p class="welfare">복지 : <%=welfare %></p>
			<p class="description">직무 내용 : <%=jobDetail %></p>	
			<p class="mgr_info">담당자 : <%=mgr_name %>(<%=mgr_tel %>)</p>
		</div>		
	<%
}
		
%>
	</section>
	
</body>
</html>