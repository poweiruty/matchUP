package controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user_general.UserDao;

/**
 * Servlet implementation class DeleteUserFromAction
 */
public class DeletePuserFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePuserFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        System.out.println("id " + id);
        System.out.println("password " + password);
        
        UserDao userDao = UserDao.getInstance();
        boolean result = userDao.deleteUser(id, password);

        String url = "leave";

        if (result) {
            request.getSession().removeAttribute("log");
            url = "index";
        }

        response.sendRedirect(url);
    }

}
