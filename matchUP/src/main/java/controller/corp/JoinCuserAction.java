package controller.corp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user_corp.CorpUserDao;
import model.user_corp.CorpUserRequestDto;

/**
 * Servlet implementation class JoinCuserAction
 */
@WebServlet("/JoinCuserAction")
public class JoinCuserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinCuserAction() {
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
		String password = request.getParameter("password");
		String name = request.getParameter("cname");
		int num = Integer.parseInt(request.getParameter("corp_num"));
		String mgr_name = request.getParameter("mgr_name");
		String mgr_tel = request.getParameter("phone") + request.getParameter("phone1") + request.getParameter("phone2");
		String mgr_email = request.getParameter("email") + "@";
		if(request.getParameter("selectEmail").equals("1")) {
			mgr_email += request.getParameter("email2");
		}else {
			mgr_email += request.getParameter("selectEmail");
		}
		String address = request.getParameter("address") + " " + request.getParameter("detailAddress") + request.getParameter("extraAddress");	
		int emailChk = Integer.parseInt(request.getParameter("emailchk"));
		
		CorpUserRequestDto cuser = new CorpUserRequestDto(id, password, name, num, mgr_name, mgr_tel, mgr_email, address, emailChk);
		CorpUserDao dao = CorpUserDao.getInstance();
		
		boolean res = dao.createCorpUser(cuser);
		String url = "login";
		if(!res) {
			url = "join";
		}
		
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		System.out.println("cnum : " + num);
		System.out.println("mgr_name : " + mgr_name);
		System.out.println("mgr_tel : " + mgr_tel);
		System.out.println("mgr_email : " + mgr_email);
		System.out.println("address : " + address);
		
		response.sendRedirect(url);

	}
}
