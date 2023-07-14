package controller.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user_general.User;
import model.user_general.UserDao;

/**
 * Servlet implementation class UserIdCheck
 */
@WebServlet("/UserIdCheck")
public class UserIdCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserIdCheckAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();	
		//PrintWriter script = response.getWriter();
		ServletContext app = this.getServletContext();
		RequestDispatcher dispatcher = app.getRequestDispatcher("/joinPerson");
		String pageInfo = request.getParameter("pageInfo");
		String id = request.getParameter("id");		
		String res = null;
		
		
		
		UserDao dao = UserDao.getInstance();
		User user = dao.getUserbyId(id);
		
		if(user == null) {
			res = "사용가능";
		}else {
			res = "중복";
		}
		request.setAttribute("idDupl", res);	
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();	
		//PrintWriter script = response.getWriter();		
		String tmpId = request.getParameter("tmpId");
		String res = null;
		String id = tmpId;
		UserDao dao = UserDao.getInstance();
		User user = dao.getUserbyId(tmpId);
		System.out.println("id : " + id);
		System.out.println("tmpId : " + tmpId);
		if(user == null) {
			res = "사용가능";			
		}else {
			res = "중복";
		}
		
		System.out.println(res);		
		request.setAttribute("idDupl", res);	
		request.setAttribute("id", id);	
		ServletContext app = this.getServletContext();
		RequestDispatcher dispatcher = app.getRequestDispatcher("/joinPerson");
		dispatcher.forward(request, response);
		
	}

}
