package controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user_general.UserDao;
import model.user_general.UserRequestDto;

/**
 * Servlet implementation class UserUpdateAction
 */
public class UserUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserRequestDto userDto = null;
		
		String pid = request.getParameter("pid");
		String ppassword = request.getParameter("ppassword");
		String newPassword = request.getParameter("new-password");
		String email = request.getParameter("email");
		String pname = request.getParameter("pname");
		String tel = request.getParameter("tel");
		String user_address = request.getParameter("user_address");
		String newAddress = request.getParameter("new-address");
		
		
		System.out.println("pid " + pid);
		System.out.println("ppassword " + ppassword);
		System.out.println("newPassword " + newPassword);
		System.out.println("email " + email);
		System.out.println("pname " + pname);
		System.out.println("tel " + tel);
		System.out.println("user_address " + user_address);
		System.out.println("new-address " + newAddress);
		
		userDto = new UserRequestDto(pid, newPassword, pname, 0, tel, email, newAddress, 1);
		
		UserDao userDao = UserDao.getInstance();
		userDao.updateUser(userDto, ppassword);
		
		String url = "UserUpdateRequest";
		response.sendRedirect(url);	}

}
