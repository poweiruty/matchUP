package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user_general.UserDao;
import model.user_general.UserRequestDto;

/**
 * Servlet implementation class JoinFormAction
 */
//@WebServlet("/Join")
public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("year") + request.getParameter("month") + request.getParameter("date");
		int birthNum = Integer.parseInt(birth);
		String tel = request.getParameter("phone") + request.getParameter("phone1") + request.getParameter("phone2");
		String email = request.getParameter("email");
		if (request.getParameter("selectEmail").equals("1")) {
			email += request.getParameter("email2");
		} else {
			email += request.getParameter("selectEmail");
		}
		String address = request.getParameter("address") + " " + request.getParameter("detailAddress")
				+ request.getParameter("extraAddress");

		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		System.out.println("birthNum : " + birthNum);
		System.out.println("tel : " + tel);
		System.out.println("email : " + email);
		System.out.println("address : " + address);

		UserRequestDto user = new UserRequestDto(id, password, name, birthNum, tel, email, address);

		UserDao userDao = UserDao.getInstance();
		boolean result = userDao.createUser(user);

		String url = "";

		if (result) {
			url = "login";
		} else {
			url = "join";			
		}

		response.sendRedirect(url);
	}

}
