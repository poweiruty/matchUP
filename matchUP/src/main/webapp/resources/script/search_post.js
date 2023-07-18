$(window).on('load',function(){
	$(document).on('keypress', e => {
		if(e.key === 'Enter'){
			search();
		}
	});	
});

function search(){
	const job = $('#search_bar').val();
	const region = $('#region').val();
	const region_detail = $('#region_detail').val();	

	let chk = true;
	
	if(chk === true){
		$.ajax({
			url:`/Search?job=${job}&region=${region}&region_detail=${region_detail}`,
			method:"GET",						
		}).done(function(response){
			$('#contents-container').empty();
			
			const list = response;
			console.log('typeof list : ', typeof list);
			
			if(typeof list === 'object'){
				list.forEach(post => {
					const corp_name = post.corp_name;
					const postDate = post.postDate;
					const desc = post.jobDetail;
					
					if (corp_name !== "") {
						$('#contents-container').append(
							`<div class="post">		
								<a href="#${corp_name}" class="detail_btn">					                  
				                 	<span class="post-cname">${corp_name}</span>
				                    <span class="post-postDate">${postDate}</span>
				                    <span class="post-desc">${desc}</span>
				                </a>
	                    	 </div>
	                    	 `
						);
					}
				});
			}		
		});	
	}	
}



 