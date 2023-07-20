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
	
	String title = dto.getTitle();//
	String cname = dto.getCorp_name();//
	String staffs = dto.getStaffs();//
	String ceo = dto.getCeo();
	jobName = dto.getJob();//
	main_region = dto.getRegion();
	semi_region = dto.getRegionDetail();
	String region = main_region + " " + semi_region;//
	String people = dto.getPeople();//
	String postDate = dto.getPostDate();//
	String salary = dto.getSalary();//
	String welfare = dto.getWelfare();
	String jobDetail = dto.getJobDetail();//
	String create_post = dto.getCreate_post().substring(0,10);//
	
	%>
		<div class="post_detail_con1">
			<h2 class="title"><%=title %>(<%=jobName %>)</h2>
			<p class="cname"><%=cname %></p>
			<p class="post_region"><%=region %></p>			
		</div>
		<div class="post_detail_con2">
			<h4>기업 정보</h4>						
			<p class="staffs">직원수 : <%=staffs %>명</p>		
			<p class="postDate">지원 기간 : <%=create_post %> ~ <%=postDate %></p>
			<p class="people">모집인원 : <%=people %>명</p>
			<p class="salary">연봉 : <%=salary %></p>
			<p class="welfare">복지 : <%=welfare %></p>
			<p class="description">직무 내용 : <%=jobDetail %></p>	
		</div>
		<div class="post_detail_con3">
			<button type="button" class="apply-btn" name="apply" id="apply">지원하기</button>
		</div>
		
	<%
}
		
%>
	</section>
	
</body>
</html>