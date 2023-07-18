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
import model.user_corp.CorpUserDao;
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
		UserDao dao = UserDao.getInstance();
		HttpSession session = request.getSession();
		CorpUserDao cdao = CorpUserDao.getInstance();
		String code = null;
		if(request.getParameter("code") != null){
			code = request.getParameter("code");
		}	
		
		String userID = null;
		String tempEmail = session.getAttribute("tempEmail").toString();
		boolean res = false;
		if(dao.getUserbyEmail(tempEmail) == null && cdao.getCorpUserbyEmail(tempEmail) == null){
			res = true;
		}
		System.out.println("tempEmail : " + tempEmail);
		System.out.println("res : " + res);
		boolean isRight = (SHA256.getSHA256(tempEmail).equals(code)) ? true : false;
		if(res && isRight){		
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('인증에 성공했습니다.');");		
			script.println("window.close();");
			script.println("</script>");
			script.close();		
			return;
		}else{
			PrintWriter script = response.getWriter();
			session.removeAttribute("tempEmail");
			script.println("<script>");
			script.println("alert('이미 사용중인 이메일입니다.');");
			script.println("window.close();");
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
