<%@page import="model.user_corp.CorpUser"%>
<%@page import="model.user_general.User"%>
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
	String userID = null;
	String tempEmail = session.getAttribute("tempEmail").toString();
	User user = dao.getUserbyEmail(tempEmail);
	CorpUser cuser = cdao.getCorpUserbyEmail(tempEmail);
	
	boolean res = false;
	if(user == null && cuser == null){	
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
		/* PrintWriter script = response.getWriter();		
		script.println("<script>");
		script.println("alert('이미 사용중인 이메일입니다.');");
		script.println("localStorage.");
		script.println("window.close();");
		script.println("</script>"); */
		%>
		<script type="text/javascript">
			alert('이미 사용중인 이메일입니다.');
			localStorage.clear();
			window.close();
		</script>		
		<%
		//script.close();
	}
%>
</body>
</html>