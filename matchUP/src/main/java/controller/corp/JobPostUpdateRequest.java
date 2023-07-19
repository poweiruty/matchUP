package controller.corp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import model.JobPost.JobPostDao;
import model.JobPost.JobPostDto;
import model.search.JobPostSearchDao;

/**
 * Servlet implementation class JobPostUpdateRequest
 */
@WebServlet("/JobPostUpdateRequest")
public class JobPostUpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobPostUpdateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cname = (String) session.getAttribute("cname");
        
        // cname이 null이거나 비어있는 경우, 클라이언트에 에러 응답을 보냅니다.
        if (cname == null || cname.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("세션에 기업명이 저장되어 있지 않습니다.");
            return;
        }

        // 기업명이 있는 경우, JobPostDao를 사용하여 기업명에 해당하는 데이터를 가져옵니다.
        JobPostDao jobPostDao = new JobPostDao();
        ArrayList<JobPostDto> jobPostList = jobPostDao.getPostByCorpName(cname);

        // 가져온 데이터를 JSON 형식으로 변환하여 응답합니다.
        JSONArray jsonArray = new JSONArray(jobPostList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonArray.toString());

    }

}
