<%@page import="model.SHA256"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="model.user_general.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	UserDao dao = UserDao.getInstance();
	String code = null;
	if(request.getParameter("code") != null){
		code = request.getParameter("code");
	}
	
	String userID = null;
	String tempEmail = session.getAttribute("tempEmail").toString();
	
	// hash 처리한 결과를 비교해 결과 값 반환
	boolean isRight = (SHA256.getSHA256(tempEmail).equals(code)) ? true : false;
	if(isRight == true){		
		/* request.getSession().setAttribute("emailchk", "1");
		session.removeAttribute("tempEmail"); */
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('인증에 성공했습니다.');");		
		//script.println("location.href = '/join'");		
		//script.println("console.log(localStorage.getItem('email'))");
		script.println("window.close();");
		script.println("</script>");
		script.close();
		//session.setAttribute("emailChk", "1");			
		return;
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('잘못된 이메일 주소입니다.');");
		script.println("location.href = 'joinForm.jsp'");
		script.println("</script>");
		script.close();
	}
%>
<!--  <script>
	window.localStorage.setItem("code",sessionStorage.getItem("tempEmail"));
</script> -->
</body>
</html>