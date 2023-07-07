package controller.corp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String id = request.getParameter("cid");
		String password = request.getParameter("cpassword");
		String name = request.getParameter("cname");
		int num = Integer.parseInt(request.getParameter("cnum"));
		String mgr_name = request.getParameter("mgr_name");
		String mgr_tel = request.getParameter("mgr_tel");
		String mgr_email = request.getParameter("mgr_email");
		String address = request.getParameter("caddress");
		
		CorpUserRequestDto cuser = new CorpUserRequestDto(id, password, name, num, mgr_name, mgr_tel, mgr_email, address);
		
		
	}
}
