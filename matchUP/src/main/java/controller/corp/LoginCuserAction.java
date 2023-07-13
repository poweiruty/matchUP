package controller.corp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.corp.Corp;
import model.corp.CorpDao;
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
<<<<<<< HEAD
			
=======
			session.setAttribute("cpassword", cuser.getCpassword());
>>>>>>> refs/remotes/origin/#2-LeeTaewoo
			session.setAttribute("cname", cuser.getCname());
			session.setAttribute("mgr_name", cuser.getMgr_name());
			session.setAttribute("phone", cuser.getMgr_tel());
			session.setAttribute("email", cuser.getMgr_email());
			session.setAttribute("map", cuser.getCaddress());
			session.setAttribute("cnum", cuser.getCnum());
			
			 // corporation_tb에서 staffs 값 가져오기
	        CorpDao corpDao = CorpDao.getInstance();
	        Corp corp = corpDao.getCorpbyId(id);
	        if (corp != null) {
	            int staffs = corp.getStaffs();
	            String ceo = corp.getCeo();
	            
	            session.setAttribute("ceo", ceo);
	            session.setAttribute("staffs", staffs);
	        }
	        
			System.out.println(session.getAttribute("log"));
<<<<<<< HEAD
=======
			System.out.println(session.getAttribute("cpassword"));
			System.out.println(session.getAttribute("cname"));
			System.out.println(session.getAttribute("mgr_name"));
			System.out.println(session.getAttribute("phone"));
			System.out.println(session.getAttribute("email"));
			System.out.println(session.getAttribute("map"));
			System.out.println(session.getAttribute("cnum"));
>>>>>>> refs/remotes/origin/#2-LeeTaewoo
		}
		
		response.sendRedirect(url);
		
	}
}