$(window).on('load',function(){
	$(document).on('keypress', e => {
		if(e.key === 'Enter'){
			search();
		}
	});	
});

function search(){
	const search_bar = $('#search_bar').val();
	const region_bar = $('#region_bar').val();	
	let chk = true;
	
	/*if(region_bar.length == 1){
		alert(region_bar + " 지역 취업정보를 찾지 못하였습니다.");
		document.getElementById('region_bar').value = "";
		chk = false;
	}*/
	
	
	if(chk === true){
		$.ajax({
			url:`/Search?job=${search_bar}&region=${region_bar}`,
			method:"GET",
			success: function(data){
				console.log("성공");
			},
			error: function(xhr, status){
				console.log("실패");
			}			
		});
	}
}