<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>마이페이지(개인)</title>
            <!-- header css -->
            <link rel="stylesheet" href="resources/style/join.css">
        </head>

        <body>
            <!-- header 시작 -->
       	   <jsp:include page="header_form"></jsp:include>
            <!-- header 끝 -->
            <!-- body 시작 -->
            <c:if test="${empty sessionScope.log }">
				<c:redirect url="login"></c:redirect>
			</c:if>
            <div id="wrap">
                <div class="section">
                    <div class="section_box">
                        <form action="" method="post" name="membership" enctype="multipart/form-data">
                            <ul>
                                <div class="pc_1">
                                    <li class="start">
                                        <h2>회원정보수정(개인 회원)</h2>
                                    </li>
                                    <!-- 아이디 부분 -->
                                    <li>
                                        <label for="id">
                                            <h2>아이디</h2>
                                        </label>
                                    </li>
                                    <li class="id">
                                        <input type="text" name="id" id="id" value="${sessionScope.log}" readonly>
                                    </li>

                                    <!-- 비밀번호 부분 -->
                                    <li><label for="pwd1">
                                            <h2>
                                                비밀번호<span class="pwd_warning"> 회원정보 수정을 위해 비밀번호를 입력해
                                                    주세요.</span>
                                            </h2>
                                        </label></li>
                                    <li class="pwd1"><input type="password" name="pwd1" id="pwd1" required> <span
                                            id="chkNotice" size="1"></span></li>

                                    <li><label for="pwd2">
                                            <h2>
                                                변경할 비밀번호<span class="pwd_warning"> *특수문자는 '! @ # $ % ^
                                                    & +='만 사용 가능합니다.</span>
                                            </h2>
                                        </label></li>

                                    <li class="pwd2"><input type="password" name="pwd2" id="pwd2"> 
                                    <span id="chkNotice"
                                            size="1"></span></li>
                                    <!-- 이름 부분 -->
                                    <li class="name">
                                        <label for="name">
                                            <h2>이름</h2>
                                        </label>
                                        <input type="text" name="name" id="name" value="${sessionScope.pname}"
                                            readonly>
                                    </li>

                                    <!-- 생년월일 부분 -->
                                    <li>
                                        <label for="birth">
                                            <h2>생년월일</h2>
                                        </label>
                                    </li>
                                    <li class="birth">
                                        <input type="text" name="birth" id="birth" value="${sessionScope.birth}"
                                            readonly>
                                    </li>

                                    <!-- 휴대폰 부분 -->
                                    <li>
                                        <h2>연락처</h2>
                                    </li>
                                    <li class="phone">
                                        <input type="text" name="phone" id="phone" value=${sessionScope.phone}>
                                    </li>

                                    <!-- 이메일 부분 -->
                                    <li><label for="email">
                                        <h2>이메일</h2>
                                    </label></li>
                                <li class="email"><input type="text" name="email" id="email"
                                        value="${sessionScope.email}"></li>
                            </div>
                            <div class="hr">
                                <hr class="pc_line">
                            </div>

                            <div class="pc_2">
                                <!-- 주소 부분 시작 -->
                                <div class="add_wrap">

                                    <label for="default_address">
                                        <h2 id="default_address">기존 주소</h2>
                                    </label> <input type="text" name="default_address" id="default_address" value="${sessionScope.address}" > 
                                        <label for="address">
                                        <h2 id="add">변경할 주소</h2>
                                    </label>
                                   <li id="add">
                                   		<input type="text" name="address" id="address" placeholder="우편번호를 검색하세요."> 
                                 	  	<input type="button" name="address_btn" id="address_btn" value="우편번호 검색">
                                    </li> 
                                    <input type="text" name="address_detail" id="address_detail" placeholder="상세주소">
                                </div>
                                <!-- 주소 끝 -->

                                <!-- 수정하기 부분 -->
                                <li class="sub"><input type="submit" name="submit" id="submit" value="수정하기" onclick="checkValue(form)">
                                        <!-- 메인 페이지로 돌아가기 부분 -->
                                        <a href="index"> <!-- 초기 화면으로 돌아감 -->
                                            <div id="index">메인 페이지로 돌아가기</div>
                                        </a>
                                    </li>
                                </div>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>
            	<script src="resources/script/validation_join.js"></script>
        </body>
<!-- footer 시작 -->
<jsp:include page="footer"></jsp:include>
<!-- footer 끝 -->

</html>