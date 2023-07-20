<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Makers</title>
			<link rel="shortcut icon" href="resources/img/favicon.png">
		</head>

		<body>
			<!-- header -->
			<jsp:include page="header"></jsp:include>
			<style>
				@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gasoek+One&family=Gowun+Batang&family=IBM+Plex+Sans+KR:wght@300&family=Poor+Story&display=swap');

				section {
					display: flex;
					justify-content: space-evenly;
				}

				div,
				div>span,
				div>p {
					font-family: 'Gowun Batang', serif;
					font-weight: 700;
					text-align: center;
				}
				img{
					width: 500px;
					height: 400px;
				}
			</style>
			<section>
				<div>
					<p><img src="resources/img/1.jpg"></p>
					<span>In-Gyu Hwang</span>
					<p>Git : https://github.com/ighwang</p>
					<p>Email: hik130423@gmail.com</p>
				</div>
				<div>
					<p><img src="resources/img/2.jpg"></p>
					<span>Tae-Woo Lee</span>
					<p>Git : https://github.com/terrylee61</p>
					<p>Email: terrylee61@naver.com</p>
				</div>
				<div>
					<p><img src="resources/img/3.jpg"></p>
					<span>Gyu-Tae Park</span>
					<p>Git: https://github.com/poweiruty</p>
					<p>Email: qkrrb0032@naver.com</p>
				</div>
			</section>

			<!-- footer -->
			<jsp:include page="footer"></jsp:include>
		</body>

		</html>