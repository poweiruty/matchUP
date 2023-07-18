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
					const post_id = post.post_id;
					const corp_name = post.corp_name;
					const postDate = post.postDate;
					const desc = post.jobDetail;
					
					if (corp_name !== "") {
						$('#contents-container').append(
							`<li class="post">		
								<a href="viewDtail?post_id=${post_id}" class="detail_btn" id="detail_btn" target="detail_post" onclick="detail()">					                  
				                 	<span class="post-cname">${corp_name}</span>
				                    <span class="post-postDate">${postDate}</span>
				                    <span class="post-desc">${desc}</span>
				                </a>
				                <ul class="dropdown">
				                	<li><a href="#">채용공고 저장</a></li>
				                	<li><a href="#">관심 없음</a></li>
				                	<li><a href="#">신고하기</a></li>
				                </ul>
	                    	 </li>
	                    	 `
						);
					}
				});
			}		
		});	
	}	
}
function detail(){
	$('#detail_tab').show();
}


 