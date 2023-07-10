package controller.corp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user_corp.CorpUser;
import model.user_corp.CorpUserDao;

/**
 * Servlet implementation class JoinCuserAction
 */
public class LoginCuserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCuserAction() {
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
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		
		CorpUserDao dao = CorpUserDao.getInstance();
		CorpUser cuser = dao.getCorpUserbyId(id);
		
		String url="login";
		if(cuser != null && cuser.getCpassword().equals(pwd)) {
			url = "index";
			HttpSession session = request.getSession();
			session.setAttribute("log", id);
			
			System.out.println(session.getAttribute("log"));
		}
		
		response.sendRedirect(url);
		
	}
}
