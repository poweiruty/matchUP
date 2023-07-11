package controller.resume;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import model.resume.ResumeDao;
import model.resume.ResumeRequestDto;

/**
 * Servlet implementation class JobPostFormAction
 */

//@WebServlet("/resume")

public class ResumeFormAction {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ResumeFormAction() {}

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

			String career = request.getParameter("career");
			String degree = request.getParameter("degree");
			String activity = request.getParameter("activity");
			String certificate = request.getParameter("certificate");
			
			// 화면에서 넘겨준 데이터 확인
			System.out.println("career : " + career);
			System.out.println("region : " + degree);
			System.out.println("regionDetail : " + activity);
			System.out.println("salary : " + certificate);

			// DTO 객체 생성
			ResumeRequestDto resume = new ResumeRequestDto(career, degree, activity, certificate);

			// DAO 객체 생성
			ResumeDao dao = ResumeDao.getInstance();

			// JobPost 데이터 DB에 저장
			boolean result = dao.createResume(resume);

			String url = "index";
			
			response.sendRedirect(url);
			
		}
	}
}
