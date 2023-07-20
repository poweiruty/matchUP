package controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.JobPost.JobPostDto;
import model.review.ReviewDao;
import model.review.ReviewRequestDto;
import model.search.JobPostSearchDao;
import model.search.ReviewSearchDao;

/**
 * Servlet implementation class SearchAction
 */
public class ReviewSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("application/json; charset=utf-8");		
		String cname = request.getParameter("cname");
		
		ArrayList<ReviewRequestDto> list = null;
		ReviewSearchDao dao = ReviewSearchDao.getInstance();
		if(cname != null) {
			list = dao.getPostbyCname(cname);
		}
		
		if(list != null) {
			ArrayList<ReviewRequestDto> reviewList = new ArrayList<ReviewRequestDto>();
			for(ReviewRequestDto review : list) {
				int reviewId = review.getReviewId();
				String corpName = review.getCorpName();
				int star = review.getStar();
				String summary = review.getSummary();
				String con = review.getReview();
				String position = review.getPosition();
				String period = review.getPeriod();
				
				
				ReviewRequestDto dto = new ReviewRequestDto(reviewId, corpName, star, summary, con, position, period);
				reviewList.add(dto);
			}
			JSONArray responseList = new JSONArray(reviewList);
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