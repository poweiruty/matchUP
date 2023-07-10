package controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.SHA256;
import util.Gmail;


/**
 * Servlet implementation class SendSMSAction
 */
@WebServlet("/sendEmail")
public class SendEmailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");		
		
		System.out.println(email);
		
		String host = "http://localhost:8081/index.jsp";
		String from = "rbxo0032@gmail.com";
		String to = email;
		String subject = "Match-UP 이메일인증 메일";
		new SHA256();
		String content = "링크에 접속해 이메일인증을 진행해주세요." + 
					"<a href='" + host + "emailCheck?code=" + SHA256.getSHA256(to) +"'>이메일 인증하기 </a>";
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.google.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 추가된 코드
		p.put("mail.smtp.ssl.enable", "true");  // 추가된 코드
		
		try {
			Authenticator auth = new Gmail();
			Session session = Session.getInstance(p,auth);
			session.setDebug(true);
			MimeMessage msg = new MimeMessage(session);			
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html;charset=UTF-8");
			Transport.send(msg);
			
		}catch (Exception e) {
			e.printStackTrace();
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('잘못된 이메일 주소입니다.');");
			script.println("location.href = 'index'");
			script.println("</script>");
			script.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
		
	}

}
