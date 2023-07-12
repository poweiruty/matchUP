package controller.resume;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import model.resume.ResumeDao;
import model.resume.ResumeRequestDto;

/**
 * Servlet implementation class ResumeFormAction
 */

//@WebServlet("/Resume")
public class ResumeFormAction extends HttpServlet{
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			{
				String job = request.getParameter("job");
				String career = request.getParameter("career");
				String degree = request.getParameter("degree");
				String activity = request.getParameter("activity");
				String certificate = request.getParameter("certificate");
				String intro = request.getParameter("intro");
				
				// 화면에서 넘겨준 데이터 확인
				System.out.println("job :"+job);
				System.out.println("career : " + career);
				System.out.println("degree : " + degree);
				System.out.println("activity : " + activity);
				System.out.println("certificate : " + certificate);
				System.out.println("intro : " + intro);

				// DTO 객체 생성
				ResumeRequestDto resume = new ResumeRequestDto(job,career, degree,activity,certificate,intro);

				// DAO 객체 생성
				ResumeDao dao = ResumeDao.getInstance();

				boolean result = dao.createResume(resume);

				String url = "index";
				
				response.sendRedirect(url);
			}
	}
}

