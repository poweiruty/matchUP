/*$('#id').on('change', e => {
	if($('#id').val() !== "") {
		$('#error-id').hide();
		$('#id').parent().css('border-color', 'lightgrey');
	}
});*/

function winOpen(){
	if(document.getElementById('id').val() === '' || document.getElementById('id').value().length < 0){
		$('#error-noneId').show();	
		document.getElementById('id').focus();
	}else{
		window.open("joinIdCheck.jsp?id=" + document.getElementById('id').value(),"","width=500, height=300");
	}
}

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