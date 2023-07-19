package controller.corp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user_corp.CorpUser;
import model.user_corp.CorpUserDao;

/**
 * Servlet implementation class CorpUpdateRequest
 */
//@WebServlet("/CorpUpdateRequest")
public class CorpUpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorpUpdateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorpUserDao corpUserDao = CorpUserDao.getInstance(); 

		String id = (String) request.getSession().getAttribute("log");

		CorpUser corpUser = corpUserDao.getCorpUserbyId(id);
		
		String cpassword = "";
		String mgr_email = "";
		String mgr_tel = "";
		String caddress = "";
		
		String url = "login";
		
		if(corpUser != null) {
			cpassword = corpUser.getCpassword();
			mgr_email = corpUser.getMgr_email();
			mgr_tel = corpUser.getMgr_tel();
			caddress = corpUser.getCaddress();
			
			request.setAttribute("cpassword", cpassword);
			request.setAttribute("mgr_email", mgr_email);
			request.setAttribute("mgr_tel", mgr_tel);
			request.setAttribute("caddress", caddress);
			
			url = "mypageCorp";
		}

		request.getRequestDispatcher(url).forward(request, response);	
	}
}
