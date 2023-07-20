package controller.review;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import model.review.ReviewDao;
import model.review.ReviewRequestDto;


/**
 * Servlet implementation class ResumeFormAction
 */

//@WebServlet("/Review")
public class ReviewCreateAction extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ReviewCreateAction() {}

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
				
				Object pusersIdObj = session.getAttribute("puserIdx");
				int pusersId;
				if (pusersIdObj instanceof Integer) {
				    pusersId = (int) pusersIdObj;
				} else {
				    pusersId = Integer.parseInt(pusersIdObj.toString());
				}
				
				// 그 이외의 값들 파라미터로 불러오기
				String corpId = request.getParameter("corporation");
				int star = Integer.parseInt(request.getParameter("star"));
				String summary = request.getParameter("summary");
				String review = request.getParameter("review");
				String position = request.getParameter("position");
				int periodIdx = Integer.parseInt(request.getParameter("period"));
				String period="";
				
				// html에서 선택한 옵션을 문자형태로 받아오기
				if(periodIdx==1) {
				    period = "1년~3년";
				}else if(periodIdx==2) {
					period = "3년~5년";
				}else if(periodIdx==3) {
					period = "5년~7년";
				}else if(periodIdx==4) {
					period = "7년~10년";
				}else if(periodIdx==5) {
					period = "10년 이상";
				}
				
				// 화면에서 넘겨준 데이터 확인
				System.out.println("유저 인덱스 :"+pusersId);
				System.out.println("기업 인덱스 :"+corpId);
				System.out.println("별점 : " + star);				
				System.out.println("기업 한줄평 : " + summary);
				System.out.println("리뷰 : " + review);
				System.out.println("직함 : " + position);
				System.out.println("기간 : " + period);
				
				// DTO 객체 생성
				ReviewRequestDto reviews = new ReviewRequestDto(pusersId,corpId,star,summary,review,position,period);

				// DAO 객체 생성
				ReviewDao dao = ReviewDao.getInstance();

				boolean result = dao.createReview(reviews);
				System.out.println(result);	// 이력서 create 확인용
				
				String url = "index";
				response.sendRedirect(url);
			}
	}

