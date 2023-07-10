/*$('#id').on('change', e => {
	if($('#id').val() !== "") {
		$('#error-id').hide();
		$('#id').parent().css('border-color', 'lightgrey');
	}
});*/

function checkValue(htmlForm){
	const id = htmlForm.id.value;
	const password = htmlForm.password.value;
	const name = htmlForm.name.value;
	const birth = htmlForm.birth.value;	
	const tel = htmlForm.tel.value;
	
	let check = true;
	
	if(id === ""){
		$('')
	}
}
function daumPostCode(){
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            
            var addr='';
            var extraAddr='';
            
            // userSelectedType : 유저가 선택한 주소의 타입 => R(도로명)/J(지번)
            if(data.userSelectedType === 'R'){
				// roadAddress : 도로명주소
				addr = data.roadAddress;
			}else{
				// jibunAddress : 지번주소
				addr = data.jibunAddress;
			}
			
			if(data.userSelectedType === 'R'){
				// bname : 법정동 이름
				// 법정동명이 있을 경우 추가
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				
				// 건물명이 있고, 공동주택일 경우 추가
				if(data.buildingName !== '' && data.apartment === 'Y'){
                	extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            	}
            	
            	// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열 생성
            	if(extraAddr !== ''){
					extraAddr = '(' + extraAddr + ')';					
				}
				
				document.getElementById('extraAddress').value = extraAddr;
			}else{
				document.getElementById('extraAddress').value = '';
			}
			// 우편번호와 주소 정보를 필드에 담기
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById('address').value = addr;
			
			// 커서를 상세주소 필드로 이동
			document.getElementById('detailAddress').focus();			
    	}        
    }).open();
}


/*function emailAuthentication(){	
	if(!emailValCheck()){
		return false;
	}
	var url = "confirmEmail.jsp?email=" + document.joinForm.email.value;
	var condition = "toolbar=no, location=no, menubar=no, scrollbars=no,resizable=no,width=300,height=200";
	open(url, "confirm", condition);

}

const form = document.joinForm;
function emailValCheck(){
	var emailPattern= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	var email = form.email.value;
	if(form.selectEmail.value === "1"){
		email += form.email2.value;
	}else{
		email += form.selectEmail.value;
	}
	
	if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")) {
		return false;
	}
    return true;
}

function check(pattern, target, message){
	if(pattern.test(target)){
		return true;
	}
	alert(message);
	target.focus();
	return false;
}*/
var isAuth = false;
function sendEmail(){	
	var email = document.getElementById('email').value;
	if(document.getElementById('selectEmail').value === '1'){
		email += document.getElementById("email2").value;
	}else{
		email += document.getElementById("selectEmail").value;
	}
	
	location.href='views/emailSendAction.jsp?email=' + email;		

}
/*$('#btn2').click(function() {
		var email = document.getElementById('email').value;
		if(document.getElementById('selectEmail').value === '1'){
			email += document.getElementById("email2").value;
		}else{
			email += document.getElementById("selectEmail").value;
		}
		
		$.ajax({
			type : 'get',
			url : '<c:url value ="sendEmail?email="/>'+email, // GET방식이라 Url 뒤에 email을 뭍힐수있다.
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				code =data;
				alert('인증번호가 전송되었습니다.')
			}			
		}); // end ajax
	}); // end send eamil*/