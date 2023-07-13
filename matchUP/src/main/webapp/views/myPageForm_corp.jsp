<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>마이페이지(기업)</title>
            <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                       
            <link rel="stylesheet" href="resources/style/join.css">
           
        </head>

        <body>
            <!-- header -->
            <jsp:include page="header_form"></jsp:include>
            <!-- header 끝 -->

			<!-- body 시작 -->
			<c:if test="${empty sessionScope.log }">
				<c:redirect url="login"></c:redirect>
			</c:if>
	<!-- 기업회원 마이페이지 -->
            <div id="wrap">
                <div class="section">
                    <div class="section_box">
                        <form action="Cupdate" method="post" >
                            <ul>
                                <div class="pc_1">
                                    <li class="start">
                                        <h2>회원정보입력(기업 회원)</h2>
                                    </li>
                                    <!-- 아이디 부분 -->
                                    <li><label for="id">
                                            <h2>아이디</h2>
                                        </label></li>
                                    <li class="id"><input type="text" name="cid" id="cid"
                                            value="${sessionScope.log}" readonly></li>

                                    <!-- 비밀번호 부분 -->
							<li><label for="pwd1">
									<h2>비밀번호
						<span class="pwd_warning"></span>
									</h2>
							</label>
							</li>
							<li class="cpassword">
							<input type="password" name="cpassword"
								id="cpassword" value="${sessionScope. cpassword}" readonly> 
								<span id="chkNotice" size="1"></span></li>

							<li><label for="new-password">
									<h2>
										변경할 비밀번호
										<span class="pwd_warning"> 변경을 원치 않으시면, 현재 비밀번호를 입력하세요.</span>
									</h2>
							</label></li>

							<li class="newCpassword"><input type="password" name="newCpassword"
								id="newCpassword"> <span id="chkNotice" size="1"></span></li>
								
                                    <!-- 회사명 부분 -->
                                    <li class="cname"><label for="cname">
                                            <h2>회사명</h2>
                                        </label> <input type="text" name="cname" id="cname"
                                            value="${sessionScope.cname}" readonly></li>

                                    <!-- 사업자등록번호 부분 -->
                                    <li><label for="cnum">
                                            <h2>
                                                사업자등록번호
                                            </h2>
                                        </label></li>
                                    <li class="cnum"><input type="text" name="cnum" id="cnum"
                                            value="${sessionScope.cnum}" readonly></li>
                                    <!-- 담당자 이름 부분 -->
                                    <li><label for="mgr_name">
                                            <h2>채용 담당자 성명</h2>
                                        </label></li>
                                    <li><input type="text" name="mgr_name" id="mgr_name"
                                            value="${sessionScope.mgr_name}"></li>
                                    <!-- 담당자 번호 부분 -->
                                    <li>
                                        <h2>채용 담당자 연락처</h2>
                                    </li>
                                    <li class="mgr_tel"><input type="text" name="mgr_tel" id="mgr_tel"
                                            value=0${sessionScope.phone}></li>

                                    <!-- 이메일 부분 -->
                                    <li><label for="mgr_email">
                                            <h2>이메일</h2>
                                        </label></li>
                                    <li class="mgr_email"><input type="text" name="mgr_email" id="mgr_email"
                                            value="${sessionScope.email}"></li>
                                </div>
                                <div class="hr">
                                    <hr class="pc_line">
                                </div>

                                <div class="pc_2">
                                    <!-- 주소 부분 시작 -->
							<div class="add_wrap">
									<h2 id="map">주소</h2>
								 <input type="text" name="map" id="map"
									value="${sessionScope.map}"> 
							</div>
							<!-- 주소 끝 -->

                                    <!-- 수정하기 부분 -->
                                    <li class="sub"><input type="submit" name="submit" id="submit" value="수정하기"  onclick="checkValue(form)">
                                        <!-- 메인 페이지로 돌아가기 부분 --> <a href="index"> <!-- 초기 화면으로 돌아감 -->
                                            <div id="index">메인 페이지로 돌아가기</div>
                                        </a></li>
                                </div>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>
            	<script src="resources/script/validation_join.js"></script>
            <!-- footer -->
            <jsp:include page="footer"></jsp:include>
            <!-- footer 끝 -->
        </body>

        </html>