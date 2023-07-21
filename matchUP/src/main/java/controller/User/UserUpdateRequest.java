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
 * Servlet implementation class UpdateUserRequest
 */
public class UserUpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("UpdateUserRequest.doGet()");
		HttpSession session = request.getSession();
		UserDao userDao = UserDao.getInstance(); 

		String id = (String) request.getSession().getAttribute("log");

		User user = userDao.getUserbyId(id);
		
		String email = "";
		int birth = 0;
		String tel = "";
		String user_address = "";
		
		String url = "login";
		
		if(user != null) {
			email = user.getEmail();
			tel = user.getTel();
			user_address = user.getUser_address();
			
			request.setAttribute("email", email);
			request.setAttribute("birth", birth);
			request.setAttribute("phone", tel);
			request.setAttribute("user_address", user_address);
			
			url = "mypagePerson";
		}
		request.getRequestDispatcher(url).forward(request, response);
		//response.sendRedirect(url);		
	}
}
