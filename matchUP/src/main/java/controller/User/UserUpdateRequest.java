package controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		UserDao userDao = UserDao.getInstance(); 

		String id = (String) request.getSession().getAttribute("log");

		User user = userDao.getUserbyId(id);
		
		String ppasword = "";
		String email = "";
		String tel = "";
		String user_address = "";
		
		String url = "login";
		
		if(user != null) {
			ppasword = user.getPpassword();
			email = user.getEmail();
			tel = user.getTel();
			user_address = user.getUser_address();
			
			request.setAttribute("ppasword", ppasword);
			request.setAttribute("email", email);
			request.setAttribute("tel", tel);
			request.setAttribute("user_address", user_address);
			
			url = "mypagePerson";
		}
		
		// 페이지 이동 처리 방법 2가지 
		// 1) response.sendRedirect(url)
		// ㄴ 지정한 페이지로 랜딩만 함 (데이터는 들고가지 않음) 
		// response.sendRedirect(url);
		
		// 2) request.getRequestDispatcher(url).forward(request, response)
		// ㄴ 객체를 들고 url로 전달 처리 할 수 O 
		// ㄴ 이동 시, 변경된 url이 패스에 보이지 않고, -> 현재 servlet 패스값이 유지됨 
		request.getRequestDispatcher(url).forward(request, response);
		
	}


}
