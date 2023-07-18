package controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutRequestAction
 */
//@WebServlet("/LogoutRequestAction")
public class UserLogoutRequestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutRequestAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("log");
		request.getSession().removeAttribute("password");
		
		// 여기 인규가 만짐 : 에러가 터지면 빠따들고 오세용 
		request.getSession().removeAttribute("puserIdx");
		request.getSession().removeAttribute("pname");
		request.getSession().removeAttribute("birth");
		request.getSession().removeAttribute("phone");
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("address");
				
		response.sendRedirect("index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
