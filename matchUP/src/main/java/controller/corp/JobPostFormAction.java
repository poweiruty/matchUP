package controller.corp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JobPost.JobPostDao;
import model.JobPost.JobPostDto;

/**
 * Servlet implementation class JobPostFormAction
 */

//@WebServlet("/JobPost")
public class JobPostFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public JobPostFormAction() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			request.setCharacterEncoding("UTF-8");

			String job = request.getParameter("job");
			String people = request.getParameter("people");
			String region = request.getParameter("region");
			String regionDetail = request.getParameter("region_detail");
			String salary = request.getParameter("salary");
			String postDate = request.getParameter("post_date");
			String welfare = request.getParameter("welfare");
			String jobDetail = request.getParameter("job_detail");
			String corp_name = request.getParameter("corp_name");
			String staffs = request.getParameter("staffs");
			String ceo = request.getParameter("ceo");
			
			// 화면에서 넘겨준 데이터 확인
			System.out.println("corp_name : " + corp_name);
			System.out.println("staffs : " + staffs);
			System.out.println("ceo : " + ceo);
			System.out.println("job : " + job);
			System.out.println("people : " + people);
			System.out.println("region : " + region);
			System.out.println("regionDetail : " + regionDetail);
			System.out.println("salary : " + salary);
			System.out.println("postDate : " + postDate);
			System.out.println("welfare : " + welfare);
			System.out.println("jobDetail : " + jobDetail);

			// DTO 객체 생성
			JobPostDto jobPost = new JobPostDto(corp_name, staffs, ceo, job, people, region, regionDetail, salary, postDate, welfare, jobDetail);

			// DAO 객체 생성
			JobPostDao jobPostDao = JobPostDao.getInstance();

			// JobPost 데이터 DB에 저장
			boolean result = jobPostDao.createJobPost(jobPost);

			String url = "jobPost";
			
			response.sendRedirect(url);
			
		}
	}
}
