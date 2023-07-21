package controller.corp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user_corp.CorpUserRequestDto;
import model.user_corp.CorpUserDao;

/**
 * Servlet implementation class CorpUpdateAction
 */
public class CorpUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorpUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		CorpUserRequestDto corpUserDto = null;
		
		String cid = request.getParameter("cid");
		String cpassword = request.getParameter("cpassword");
		String newCpassword = request.getParameter("new-password");
		String cname = request.getParameter("cname");
		int cnum = request.getIntHeader("cnum");
		String mgr_name = request.getParameter("mgr_name");
		String mgr_tel = request.getParameter("mgr_tel");
		String mgr_email = request.getParameter("mgr_email");
		String caddress = request.getParameter("caddress");
		
		
		if(newCpassword == null || newCpassword.equals("")) {
			newCpassword = cpassword;
		}
		
		System.out.println("cid " + cid);
		System.out.println("cpassword " + cpassword);
		System.out.println("newCpassword " + newCpassword);
		System.out.println("cname " + cname);
		System.out.println("cnum " + cnum);
		System.out.println("mgr_name " + mgr_name);
		System.out.println("mgr_tel " + mgr_tel);
		System.out.println("mgr_email " + mgr_email);
		System.out.println("caddress " + caddress);
		
		
		corpUserDto = new CorpUserRequestDto(cid, newCpassword, cname, cnum, mgr_name, mgr_tel, mgr_email, caddress);
		
		CorpUserDao corpUserDao = CorpUserDao.getInstance();
		corpUserDao.updateCorpUser(corpUserDto, cpassword);
		session.setAttribute("email", mgr_email);
		session.setAttribute("phone", mgr_tel);
		session.setAttribute("mgr_name", mgr_name);
		
		String url = "mypageCorp"; //수정
		
		response.sendRedirect(url);	
		
	}
}