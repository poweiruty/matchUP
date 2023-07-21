const year = document.getElementById('year');
const month = document.getElementById('month');
const date = document.getElementById('date');
const output = document.getElementById('tmpBirth');
if(year !== null && month !== null && date !== null && output !== null){
	year.addEventListener('change', birthUpdate);
	month.addEventListener('change', birthUpdate);
	date.addEventListener('change', birthUpdate);
	
	function birthUpdate() {
		const value1 = year.value;
		const value2 = month.value;
		const value3 = date.value;
	
		const result = value1 + value2 + value3;
		output.value = result;
		if (result.length === 8) {			
			$('#error-birth').hide();	
		}
	}
}
const phone1 = document.getElementById('phone1');
const phone2 = document.getElementById('phone2');
const tmpTel = document.getElementById('tmpTel');
if(phone1 !== null && phone2 !== null && tmpTel !== null){
	phone1.addEventListener('change', telUpdate);
	phone2.addEventListener('change', telUpdate);
	
	function telUpdate() {
		const value1 = phone1.value;
		const value2 = phone2.value;
	
		const result = value1 + value2;
		tmpTel.value = result;
		if (result.length === 8) {			
			$('#error-tel').hide();	
		}
	}
}
$('#id').on('change', e => {	
	if($('#id').val() !== "") {
		$('#error-noneId').hide();
	}
	if($('#id').val().match(/^[a-zA-Z0-9]{4,12}$/) !== null){
		$('#error-regexId').hide();
	}
	if($('#id').val() === ""){
		$('#error-duplId').hide();
	}
});
$('#password').on('change', e => {
	if($('#password').val() !== "") {
		$('#error-password').hide();
	}
	if($('#password').val().match(/^[a-zA-Z0-9!@#$%]{8,20}$/) !== null){
		$('#error-passwordRegex').hide();
	}
});
$('#passwordChk').on('change', e => {
	if($('#passwordChk').val() !== "") {
		$('#error-password_chk').hide();
	}else if($('#passwordChk').val() === $('#password').val()){
		$('#error-pwdEquals').hide();
	}
});
$('#name').on('change', e => {
	if($('#name').val() !== "") {
		$('#error-name').hide();
	}
});
$('#email').on('change', e => {
	if($('#email').val() !== "") {
		$('#error-email').hide();
	}
});
$('#btn2').onclick = function(){
	if($('#email').val() !== ""){
		console.log('이거라도?');
	}
}
$('#pnum').on('change', e => {
	if($('#error-password_chk').length === 11 && $('#error-password_chk').match(/\d{11}/) !== null){
		$('#error-tel').hide();		
	}
});	

function idChk(idform){
	document.getElementById('tmpId').value = document.getElementById('id').value;
	const id = idform.tmpId.value;
	
	let check = true;
	if(id === ""){
		$('#error-noneId').show();
		check = false;
	}	
	
	if(check === true){
		$('#idForm').submit();
	}
}
function idNotice(){
	if($('#idchk').val() === "중복"){
		$('#error-duplId').show();
	}
}
function pJoinCheckValue(){
	const id = $('#id').val();
	const password = $('#password').val();
	const passwordChk = $('#passwordChk').val();
	const name = $('#name').val();
	const birth = $('#year').val() + $('#month').val() + $('#date').val(); 	
	const tel = $('#phone').val() + $('#phone1').val() + $('#phone2').val();
	const idchk = $('#idchk').val();
	const email = $('#email').val() + $('#email2').val();
	
	const emailChk = $('#emailchk').val();
	const address = $('#address').val() +$('#detailAddress').val() + $('#extraAddress').val();
	
	let check = true;
	
	if(id === "" || id.match(/^[a-zA-Z0-9]{3,11}$/) === null){
		$('#error-noneId').show();				
		$('#id').focus();		
		check = false;
	}else if(idchk === "중복" || idchk === null){			
		$('#id').focus();	
		check = false;		
	}else if(password === ""){
		$('#error-password').show();		
		$('#password').focus();	
		check = false;
	}else if(password.match(/^[a-zA-Z0-9!@#$%]{8,20}$/) === null){
		$('#error-passwordRegex').show();					
		$('#password').focus();	
		check = false;
	}else if(passwordChk === ""){
		$('#error-password_chk').show();				
		$('#passwordChk').focus();			
		check = false;
	}else if(password !== passwordChk){
		$('#error-pwdEquals').show();
		$('#passwordChk').focus();
		check = false;
	}else if(name === ""){		
		$('#error-name').show();	
		$('#name').focus();	
		check = false;
	}else if(birth === "" || birth.length !== 8){
		$('#error-birth').show();		
		if($('#year').val() === ""){
			$('#year').focus();
		}else if($('#month').val() === ""){
			$('#month').focus();
		}else if($('#date').val() === ""){
			$('#date').focus();
		}				
		check = false;
	}else if(tel.length !== 11){
		$('#error-tel').show();	
		if($('#phone1').val() === ""){
			$('#phone1').focus();
		}else if($('#phone2').val() === ""){
			$('#phone2').focus();
		}				
		check = false;
	}else if($('#email').val() === ""){		
		$('#error-email').show();	
		$('#email').focus();		
		check = false;
	}else if(emailChk === "인증실패" || emailChk === "인증중" || emailChk === "0"){
		$('#error-emailChk').show();
		check = false;
	}
	
	
	if(check === true){
		alert("회원가입에 성공했습니다.");
		$("#joinForm").submit();
	}
}
function cJoinCheckValue(){
	const id = $('#id').val();
	const password = $('#password').val();
	const passwordChk = $('#passwordChk').val();
	const cnum = $('#corp_num').val();
	const cname = $('#cname').val();	
	const mname = $('#mgr_name').val();
	const tel = $('#phone').val() + $('#phone1').val() + $('#phone2').val();
	const idchk = $('#idchk').val();	
	const email =  $('#email').val();	
	const chk3 = $('input:checkbox[name="chk3"]').is(':checked');
	const chk4 = $('input:checkbox[name="chk4"]').is(':checked');
	const emailChk = $('#emailchk').val();
	const address = $('#address').val() +$('#detailAddress').val() + $('#extraAddress').val();	
	
	let check = true;
	
	if(id === "" || id.match(/^[a-zA-Z0-9]{3,11}$/) === null){
		$('#error-noneId').show();				
		$('#id').focus();		
		check = false;
	}else if(idchk === "중복" || idchk === null){			
		$('#id').focus();	
		check = false;		
	}else if(password === ""){
		$('#error-password').show();		
		$('#password').focus();	
		check = false;
	}else if(password.match(/^[a-zA-Z0-9!@#$%]{8,20}$/) === null){
		$('#error-passwordRegex').show();					
		$('#password').focus();	
		check = false;
	}else if(passwordChk === ""){
		$('#error-password_chk').show();				
		$('#passwordChk').focus();			
		check = false;
	}else if(password !== passwordChk){
		$('#error-pwdEquals').show();
		$('#passwordChk').focus();
		check = false;
	}else if(cname === ""){		
		$('#error-cname').show();	
		$('#cname').focus();		
		check = false;
	}else if(cnum === ""){
		$('#error-cnum').show();
		$('#corp_num').focus();		
		check = false;
	}else if(mname === ""){
		$('#error-mname').show();	
		$('#mgr_name').focus();	
		check = false;
	}else if(tel.length !== 11){
		$('#error-tel').show();	
		if($('#phone1').val() === ""){
			$('#phone1').focus();
		}else{
			$('#phone2').focus();
		}
		check = false;
	}else if(email === ""){
		$('#error-email').show();
		$('#email').focus();	
		check = false;
	}else if(emailChk === "인증실패" || emailChk === "인증중" || emailChk === "0"){		
		$('#error-emailChk').show();
		$('#btn3').focus();		
		check = false;
	}else if(chk3 && chk4){
		alert('필수 약관동의를 확인해주세요.');
		if(chk3){		
			$('input:checkbox[name="chk3"]').focus();
			check = false;
		}else if(chk4){
			$('input:checkbox[name="chk4"]').focus();
			check = false;
		}
	}
	
	if(check === true){
		alert("회원가입에 성공했습니다.");
		$("#joinForm").submit();
	}
}
function checkPupdate(htmlForm){
	const id = htmlForm.id.value;
	const password = htmlForm.password.value;
	const name = htmlForm.name.value;
	const birth = htmlForm.birth.value;	
	const tel = htmlForm.tel.value;
		
	let check = true;
	
	if(id === "" || id){
		$('#error-noneId').show();		
		check = false;
	}else if(password === ""){
		$('#error-password').show();
		$('#password').parent().css('border-color', 'red');
		check = false;
	}else if(name === ""){		
		$('#error-name').show();
		check = false;
	}else if(birth === "" || birth.length !== 8){
		$('#error-birth').show();
		check = false;
	}else if(tel.length !== 11){
		$('#error-tel').show();
		check = false;
	}
	
	if(check === true){
		console.log(check);
		htmlForm.submit();
	}
}

function checkCupdate(htmlForm){
	const cid = htmlForm.cid.value;
	const cpassword = htmlForm.cpassword.value;
	const mgr_tel = htmlForm.mgr_tel.value;	
	const mgr_email = htmlForm.mgr_email.value;
	const caddress = htmlForm.caddress.value;
		
	let check = true;
	
	if(cid === ""){
		$('#error-password').show();		
		check = false;
	}else if(cpassword === ""){
		$('#error-password').show();
		$('#cpassword').parent().css('border-color', 'red');
		check = false;
	}else if(mgr_tel === ""){
		$('#error-password').show();
		check = false;
	}else if(mgr_email.length === ""){
		$('#error-password').show();
		check = false;
	}else if(caddress.length === ""){
		$('#error-password').show();
		check = false;
	}
	
	
	if(check === true){
		console.log("check " + check);
		htmlForm.submit();
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
function sendEmail(){		
	const emailId = $('#email').val();
	const email = $('#email2').val();
	var res = ""
	
	if(emailId !== "" && email !== ""){
		$('#error-email').hide();
		$('#error-emailClick').hide();
		$('#error-emailChk').hide();
		document.getElementById("emailchk").value = "인증중";
		res = emailId + "@" + email;
		alert("인증메일이 전송되었습니다.");	
		localStorage.setItem("email", res);		
		location.href='SendEmail?email=' + res;
	}else{
		$('#error-emailClick').hide();
		$('#error-emailChk').hide();
		$('#error-email').show();
	}
}

function emailAuthChk(){	
	var email = $('#email').val() + "@" + $('#email2').val();	
	
	if($('#emailchk').val() === "인증중" && localStorage.getItem("result") !== null){
		document.getElementById("emailchk").value = "1";
		$('#error-email').hide();
		$('#error-emailClick').hide();
		$('#error-emailChk').hide();
		$('#error-chkFalse').hide();
		alert("인증된 이메일입니다.");
		
	}else if($('#emailchk').val() === "0" && localStorage.getItem("result") === null){		
		$('#error-email').hide();
		$('#error-emailChk').hide();
		$('#error-emailClick').show();
		
	}else if($('#emailchk').val() === "인증중" && localStorage.getItem("result") === null){
		$('#error-email').hide();
		$('#error-emailClick').hide();
		$('#error-emailChk').show();
		
	}else{
		document.getElementById("emailchk").value = "인증실패";
		$('#error-email').hide();
		$('#error-emailClick').hide();
		$('#error-emailChk').hide();
		$('#error-chkFalse').show();
	}
	localStorage.clear();
}

function leave(id) {
  let result = confirm("탈퇴하시겠습니까?");
  if(result) {
    location.href="leave?id="+id;
    //get방식으로 아이디 파라미터 함께 넘기기
  }
}