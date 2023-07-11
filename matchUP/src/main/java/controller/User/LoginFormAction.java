package controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user_general.User;
import model.user_general.UserDao;

/**
 * Servlet implementation class LoginFormAction
 */
public class LoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
				
		UserDao userDao = UserDao.getInstance();
		User user = userDao.getUserbyId(id);
		
		
		
		String url = "login";
		
		if(user != null && user.getPpassword().equals(password)) {
			url = "index";
			
			HttpSession session = request.getSession();
			session.setAttribute("log", id);
			session.setAttribute("pname", user.getPname());
			session.setAttribute("birth", user.getBirth());
			session.setAttribute("phone", user.getTel());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("address", user.getUser_address());

			
			System.out.println(session.getAttribute("log"));
			System.out.println(session.getAttribute("pname"));
			System.out.println(session.getAttribute("birth"));
			System.out.println(session.getAttribute("phone"));
			System.out.println(session.getAttribute("email"));
			System.out.println(session.getAttribute("address"));
		}
		
		
		
		response.sendRedirect(url);
	}
}
