package controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SHA256;
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
		HttpSession session = request.getSession();
		UserDao userDao = UserDao.getInstance();
		User user = userDao.getUserbyId(id);
		
		String pwd = "";
		
		if(user != null) {
			pwd = user.getPpassword();
		}
		String url = "login";
				
		if(user != null && password.equals(pwd)) {
			url = "index";
			
			
			session.setAttribute("log", id);
			
			session.setAttribute("ppassword",user.getPpassword());
			session.setAttribute("puserIdx",user.getPuserIdx());	// 황인규 작성
			session.setAttribute("pname", user.getPname());
			session.setAttribute("birth", user.getBirth());
			session.setAttribute("phone", user.getTel());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("address", user.getUser_address());

			
			System.out.println(session.getAttribute("log"));
			System.out.println(session.getAttribute("ppassword"));
			System.out.println(session.getAttribute("puserIdx"));   // 황인규 작성
			System.out.println(session.getAttribute("pname"));
			System.out.println(session.getAttribute("birth"));
			System.out.println(session.getAttribute("phone"));
			System.out.println(session.getAttribute("email"));
			System.out.println(session.getAttribute("address"));
			
			System.out.println(session.getAttribute("log"));
		}else{
			session.setAttribute("res", "실패");
		}
		response.sendRedirect(url);
	}
}