<%@page import="java.util.Arrays"%>
<%@page import="model.SHA256"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dynamic Select Options</title>
</head>
<body>
    <%
    	String pass = "ss003212";
    	String hashPass = SHA256.getSHA256(pass);
    	
    	System.out.println("pass : " + pass);
    	System.out.println("hashPass : " + hashPass);
    	
    	String loginPass = "qkrrb0032";
    	
    	boolean res = SHA256.verifyPassword(loginPass, hashPass);
    	System.out.println("res : " + res);    	
    %>
</body>
</html>