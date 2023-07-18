<%@page import="org.apache.tomcat.jni.Local"%>
<%@page import="model.user_corp.CorpUserDao"%>
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
	CorpUserDao cdao = CorpUserDao.getInstance();
	String code = null;
	if(request.getParameter("code") != null){
		code = request.getParameter("code");
	}	
	%>
	<script>
		localStorage.getItem("email");
	</script>	
	<%
	String userID = null;
	String tempEmail = session.getAttribute("tempEmail").toString();
	boolean res = false;
	if(dao.getUserbyEmail(tempEmail) == null && cdao.getCorpUserbyEmail(tempEmail) == null){	
		res = true;
	}
	System.out.println("tempEmail : " + tempEmail);
	System.out.println("res : " + res);
	// hash 처리한 결과를 비교해 결과 값 반환
	boolean isRight = (SHA256.getSHA256(tempEmail).equals(code)) ? true : false;
	if(res && isRight){		
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('인증에 성공했습니다.');");		
		script.println("window.close();");
		script.println("</script>");
		script.close();		
		return;
	}else{
		PrintWriter script = response.getWriter();
		session.removeAttribute("tempEmail");
		script.println("<script>");
		script.println("alert('이미 사용중인 이메일입니다.');");
		script.println("window.close();");
		script.println("</script>");
		script.close();
	}
%>
</body>
</html>