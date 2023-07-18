package controller.corp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.JobPost.JobPostDto;
import model.search.JobPostSearchDao;

/**
 * Servlet implementation class SearchAction
 */
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("application/json; charset=utf-8");		
		
		String job = request.getParameter("job");
		String region = request.getParameter("region");
		String region_detail = request.getParameter("region_detail");
		
		ArrayList<JobPostDto> list = null;
		JobPostSearchDao jpsDao = JobPostSearchDao.getInstance();
		
		
		String cname = null;
		String jobName = null;
		String main_region = null;
		String semi_region = null;
		
		if(!job.equals("") && jpsDao.getJobSearch(job) != null) 
			jobName = jpsDao.getJobSearch(job);		
			
		if(!job.equals("") && jpsDao.getCorpbyCname(job) != null) 
			cname = jpsDao.getCorpbyCname(job);		

		if(!region.equals("") && jpsDao.getMainbySearch(region) != null) 
			main_region = jpsDao.getMainbySearch(region);		
		
		if(!region_detail.equals("") && jpsDao.getSemibySearch(region_detail) != null) 
			semi_region = jpsDao.getSemibySearch(region_detail);
		
		
		if (cname != null && main_region != null && semi_region == null) { 			
			list = jpsDao.getPostbyCnameAndMain(cname, main_region);		
			System.out.println(1);
		}else if (cname != null && semi_region != null) { 
			list = jpsDao.getPostbyCnameAndSemi(cname, semi_region);
			System.out.println(2);
		}else if (main_region != null && semi_region == null) { 
			list = jpsDao.getPostbyMainRegion(main_region);
			System.out.println(3);
		}else if (jobName != null && main_region != null && semi_region == null) {
			list = jpsDao.getPostbyJobNameAndMain(jobName, main_region);
			System.out.println(4);
		}else if(jobName != null && semi_region != null) {
		 	list = jpsDao.getPostbyJobNameAndSemi(jobName, semi_region);
		 	System.out.println(5);
		}else if (semi_region != null) { 
			list = jpsDao.getPostbySemiRegion(semi_region);
			System.out.println(6);
		}else if (cname != null) {
			list = jpsDao.getPostbyCname(job);
			System.out.println(7);
		}else if (jobName != null) {
			list = jpsDao.getPostbyJobName(jobName);
			System.out.println(8);
		}else if(cname == null && jobName == null && main_region == null && semi_region == null) {
			list = jpsDao.getPostbyAll();
			System.out.println(9);
		}
		
		if(list != null) {
			ArrayList<JobPostDto> postList = new ArrayList<JobPostDto>();
			for(JobPostDto post : list) {				
				
				int post_id = post.getPost_id();
				String corp_name =  post.getCorp_name();
				String postDate = post.getPostDate();
				String desc = post.getJobDetail();				
				
				JobPostDto dto = new JobPostDto(post_id, corp_name, postDate, desc);				
				postList.add(dto);
			}				
			JSONArray responseList = new JSONArray(postList);
			response.getWriter().append(responseList.toString());
		}else	
			response.sendRedirect("search");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}