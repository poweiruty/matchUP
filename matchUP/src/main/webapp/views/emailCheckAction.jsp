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
	
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 해주세요');");
		script.println("location.href = 'userLogin.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	// hash 처리한 결과를 비교해 결과 값 반환
	String userEmail = dao.getUserbyId(userID).getEmail();
	boolean isRight = (SHA256.getSHA256(userEmail).equals(code)) ? true : false;
	if(isRight == true){
		//dao.setUserEmailChecked(userID);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('인증에 성공했습니다.');");
		script.println("location.href = 'index.jsp'");
		script.println("</script>");
		script.close();
		return;
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('잘못된 이메일 주소입니다.');");
		script.println("location.href = 'index.jsp'");
		script.println("</script>");
		script.close();
	}

%>
</body>
</html>