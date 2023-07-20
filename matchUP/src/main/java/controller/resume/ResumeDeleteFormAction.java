package controller.resume;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.resume.ResumeDao;

public class ResumeDeleteFormAction extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int resumeId = Integer.parseInt(request.getParameter("resumeId"));
		
		ResumeDao resumeDao = ResumeDao.getInstance();
		
		boolean deleteResult = resumeDao.deleteResume(resumeId);
		
		if (deleteResult) {
			// 삭제 성공 시 응답 코드 200 전송
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 삭제 실패 시 응답 코드 500 전송
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET 요청에 대한 처리는 doPost() 메서드를 사용하도록 설정합니다.
		doPost(request, response);
	}
}