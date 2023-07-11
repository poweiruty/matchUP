package controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SHA256;
import model.user_general.UserDao;

/**
 * Servlet implementation class EmailCheck
 */
//@WebServlet("/emailCheck")
public class EmailCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserDao dao = UserDao.getInstance();
		String code = null;
		if(request.getParameter("code") != null){
			code = request.getParameter("code");
		}
		
		String userID = null;
		String tempEmail = session.getAttribute("tempEmail").toString();
		
		// hash 처리한 결과를 비교해 결과 값 반환
		boolean isRight = (SHA256.getSHA256(tempEmail).equals(code)) ? true : false;
		if(isRight == true){		
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('인증에 성공했습니다.');");
//			script.println("window.opener.location.href = 'join';");
//			script.println("window.close();");
//			script.println("</script>");
//			script.close();
			session.removeAttribute("tempEmail");
			session.setAttribute("code", code);
			response.sendRedirect("join");
		}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('잘못된 이메일 주소입니다.');");
			script.println("window.opener.location.href = 'joinForm.jsp';");
			script.println("</script>");
			script.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
