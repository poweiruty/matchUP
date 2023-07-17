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

import model.user_corp.CorpUser;
import model.user_corp.CorpUserDao;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CorpUserDao cdao = CorpUserDao.getInstance();	
		HttpSession session = request.getSession();
		UserDao dao = UserDao.getInstance();
		String tmpId = request.getParameter("tmpId");
		String res = null;
		String id = tmpId;		

		if(dao.getUserbyId(id) == null && cdao.getCorpUserbyId(id) == null) {
			res = "사용가능";
		}else {
			res = "중복";
		}
		
		String url = "joinPerson";
		
		System.out.println(res);		
//		request.setAttribute("idDupl", res);	
//		request.setAttribute("id", id);
		session.setAttribute("idDupl", res);
		session.setAttribute("id", id);
//		ServletContext app = this.getServletContext();
//		RequestDispatcher dispatcher = app.getRequestDispatcher("/joinPerson");
//		dispatcher.forward(request, response);		
		response.sendRedirect(url);
	}
}
