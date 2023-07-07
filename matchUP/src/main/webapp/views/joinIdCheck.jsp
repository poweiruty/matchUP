<%@page import="java.util.Date"%>
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
	
		String id = request.getParameter("id");
		
		UserDao dao = UserDao.getInstance();
		boolean res = dao.idCheck(id);
		if(res){
			System.out.println("중복된 아이디입니다.");
		}else{
			System.out.println("사용가능한 아이디입니다.");
			%>
			<input type="button" value="아이디 사용하기" onclick="result()">
			<%
		}
	%>
	
	<div>
		<form action="joinIdCheck.jsp" method="POST">
			ID : <input type="text" name="id" value="<%=id%>">
			<input type="submit" value="중복 확인">		
		</form>
	</div>	
	
	<script>
		function result(){
			opener.document.getElementById('id').value() = document.getElementById('id').value();
			opener.document.getElementById('id').readonly = true;
			
			window.close();
		}	
	
	</script>
</body>
</html>