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
			
				// 세션에서 로그인한 개인회원의 인덱스 따오기
				HttpSession session=request.getSession();
				
				Object puserIdxObj = session.getAttribute("puserIdx");
				int puserIdx;
				if (puserIdxObj instanceof Integer) {
				    puserIdx = (int) puserIdxObj;
				} else {
				    puserIdx = Integer.parseInt(puserIdxObj.toString());
				}
				
				// 그 이외의 값들 파라미터로 불러오기
				int jobIdx = Integer.parseInt(request.getParameter("job"));
				int graduationIdx = Integer.parseInt(request.getParameter("graduation"));
				String graduation="";
				String degree = request.getParameter("degree");
				String career = request.getParameter("career");
				String activity = request.getParameter("activity");
				String certificate = request.getParameter("certificate");
				String intro = request.getParameter("intro");
				
				// html에서 선택한 옵션을 문자형태로 받아오기
				if(graduationIdx==1) {
				    graduation = "초졸";
				}else if(graduationIdx==2) {
				    graduation = "중졸";
				}else if(graduationIdx==3) {
				    graduation = "고졸";
				}else if(graduationIdx==4) {
				    graduation = "대졸(2~3년제)";
				}else if(graduationIdx==5) {
				    graduation = "대졸(4년제)";
				}else if(graduationIdx==6) {
				    graduation = "대학원졸";
				}
				
				// 화면에서 넘겨준 데이터 확인
				System.out.println("유저 인덱스 :"+puserIdx);
				System.out.println("직종 인덱스 :"+jobIdx);
				System.out.println("최종학력 : " + graduation);				
				System.out.println("세부학력 : " + degree);
				System.out.println("경력 : " + career);
				System.out.println("활동 : " + activity);
				System.out.println("자격증 : " + certificate);
				System.out.println("자기소개 : " + intro);
				
				// DTO 객체 생성
				ResumeRequestDto resume = new ResumeRequestDto(puserIdx,jobIdx,graduation,degree,career,activity,certificate,intro);

				// DAO 객체 생성
				ResumeDao dao = ResumeDao.getInstance();

				boolean result = dao.createResume(resume);
				System.out.println(result);	// 이력서 create 확인용
				
				String url = "index";
				response.sendRedirect(url);
			}
	}

