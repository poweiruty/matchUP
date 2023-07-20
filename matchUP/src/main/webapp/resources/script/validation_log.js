$('#pid').on('change', e => {
	const id = $('#pid').val();
	
	if(id !== "") {
		$('#error-pid').hide();
	}
});

$('#ppwd').on('change', e => {
	const pwd = $('#ppwd').val();
	
	if(pwd !== "") {
		$('#error-ppwd').hide();
	}
});
$('#cid').on('change', e => {
	const id = $('#cid').val();
	
	if(id !== "") {
		$('#error-cid').hide();
	}
});

$('#cpwd').on('change', e => {
	const pwd = $('#cpwd').val();
	
	if(pwd !== "") {
		$('#error-cpwd').hide();
	}
});

function checkValue(htmlform) {		
	const id = htmlform.id.value
	const pwd = htmlform.pwd.value;
	
	let check = true;
	
	if(id === "") {

		check = false;
	} else if(pwd === "") {
		alert("비밀번호를 입력하세요.");
		check = false;
	}
	
	if(check === true) {
		alert("로그인에 성공하였습니다.");
		htmlform.submit();
	}
}