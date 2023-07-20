package controller.corp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutRequestAction
 */
//@WebServlet("/LogoutRequestAction")
public class CorpLogoutRequestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorpLogoutRequestAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("log");
		request.getSession().removeAttribute("cname");

		
		// 여기 인규가 만짐 : 에러가 터지면 빠따들고 오세용 
		request.getSession().removeAttribute("cpassword");
		request.getSession().removeAttribute("mgr_name");
		request.getSession().removeAttribute("phone");
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("map");
		request.getSession().removeAttribute("cnum");
		request.getSession().removeAttribute("ceo");
		request.getSession().removeAttribute("staffs");
        
				
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