<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    
</head>

<body>
   <!-- header 시작 -->
    <jsp:include page="header_login"></jsp:include>
    <!-- header 끝 -->

    <!-- body 시작 -->

    <div class="containerwrap">
        <div class="login_box">
            <ul class="login_tab">
                <li class="login_person on"><a href="#">개인 로그인</a></li>
                <li class="login_corp"><a href="#">기업 로그인</a></li>
            </ul>
            <div class="tab_cont">
                <div class="tab on">
                    <!-- form -->
                    <form action="" class="index_form" method="post">
                        <h2>아이디</h2>
                        <div class="id">
                            <input type="text" class="id" name="id" id="id" placeholder="아이디">
                        </div>
                        <h2>비밀번호</h2>
                        <div class="pwd">
                            <input type="text" class="pwd" name="pwd" placeholder="비밀번호">
                        </div>
                        <input type="submit" name="login_btn" id="login_btn" value="로그인">
                    </form>
                </div>
                <div class="tab">
                    <!-- form -->
                    <form action="" class="index_form" method="post">
                        <h2>아이디</h2>
                        <div class="id">
                            <input type="text" class="id" name="id" id="id" placeholder="아이디">
                        </div>
                        <h2>비밀번호</h2>
                        <div class="pwd">
                            <input type="text" class="pwd" name="pwd" placeholder="비밀번호">
                        </div>
                        
                        <input type="submit" name="login_btn" id="login_btn" value="로그인">
                    </form>
                </div>
            </div>
        </form>
        
        <!-- 회원가입 연결 -->
        <div class="join_box">
            <a href="join">
                <button class="btn_join">회원가입</button>
            </a>
        </div>
        <!-- 아이디 비밀 번호 찾기 -->
        <div class="find_box">
            <h1>로그인 정보가 생각나지 않으세요?</h1>
            <p>아이디 또는 비밀번호를 찾으실 수 있습니다.</p>
            <a href="#"><button class="btn_find">아이디 찾기</button></a> <a href="#"><button
                    class="btn_find">비밀번호 찾기</button></a>
        </div>
        </div>
        </div>
        </div>
    </div>
    <!-- body 끝 -->
                <!-- 유효성 체크 
	<div class="container">
		<div id="login">
			<div class="loginTitle">
				<h1>로그인</h1>
			</div>
			<form action="" method="post" name="login" class="login_form"
				enctype="multipart/form-data">
				<div class="login_box">
					<input type="text" name="id" id="id" placeholder="아이디" required>
					<input type="password" name="pwd" id="pwd" placeholder="비밀번호"
						required>
				</div>
				<!-- 유효성 체크 
>>>>>>> refs/remotes/origin/#2-LeeTaewoo
                <script>
                    // 비밀번호 체크
                    // function checklogin() {
                        /* let pwd = document.getElementById("pwd").value; //ID가 pwd인 필드값을 가져와 변수 저장
                        let regex = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&+=])[a-z\d!@#$%^&+=]{6,12}$/i;
                        /*
                        조건 1. 영어 소문자 a-z까지
                        조건 2. 특수문자 !@#$%^&+= 만 포함
                        조건 3. 문자열 6-12자리까지
                                                    
                        /(?=.*\d)/에서 (?=)는 포지티브 룩헤드 어설션으로, 정규식 엔진이 룩헤드 내부의 패턴이 실제로 일치 항목에 포함되지 않고 문자열의 현재 위치 이후에 발생하는지 여부를 확인
                        .*는 모든 문자(개행 문자 제외)와 0회 이상 일치하고 \d는 숫자 문자와 일치.
                        (?=.*\d)는 "현재 위치부터 문자열 어딘가에 숫자 문자가 하나 이상 있다고 주장"한다는 의미
                        if (!regex.test(pwd)) { // !를 써서 부정문으로 ==> 일치하지 않는 경우 내용 표시
                            alert("비밀번호 확인하셈.");
                            return false; // ==> 양식을 제출하지 못하도록 false 반환
                        } */

                        // 아이디 && 비밀번호 매칭
                        // let id = document.getElementById("id").value;
                        // let pwd = document.getElementById("pwd").value;
                        // // let regex = /^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&+=])[a-z\d!@#$%^&+=]{6,12}$/i; >>>>>>이 코드는 꼭 필요한건 아닌데 비밀번호 복잡성 요건을 적용하고 보안을 위해 쓴대
                        // if (id === "matchup" && pwd === "up123!") { // 수정
                        //     return true;
                        // } else {
                        //     alert("아이디 또는 비밀번호를 확인해주세요.");
                        //     return false;
                        // }
                    // }
                 </script>-->
				
  <!-- footer 시작 -->
      	<jsp:include page="footer"></jsp:include>

    <!-- footer 끝 -->
</body>

</html>