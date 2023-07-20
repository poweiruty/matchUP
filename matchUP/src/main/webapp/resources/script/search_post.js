$(window).on('load',function(){
	$(document).on('keypress', e => {
		if(e.key === 'Enter'){
			search();
		}
	});	
});
function updateValue() {
	var selectElement = document.getElementById("region");
	var selectedValue = selectElement.value; 
	var myHiddenInput = document.getElementById("myHiddenInput");
	
	console.log(selectedValue);	
	document.getElementById('myHiddenInput').value = document.getElementById('region').value;
	
/*	var xhr = new XMLHttpRequest();
    xhr.open("POST", "search", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

    var data = "myHiddenInput=" + encodeURIComponent(selectedValue);
    xhr.send(data);	
    */
    console.log();
    $.ajax({
		url:`/Semi?main=${document.getElementById('myHiddenInput').value}`,
		method:"GET",								
	}).done(function(response) {
		$('#region_detail').empty();
		
		const list = response;				
		console.log('typeof list : ', typeof list);		

		if (typeof list === 'object') {
			$('#region_detail').append(
				`<option value="" selected>선택</option>`
			);
			list.forEach(semi => {
				const semi_region = semi.semi_region;
				console.log("semi : ", semi_region);
				if (semi_region !== "") {
					$('#region_detail').append(
						`<option value="${semi_region}">${semi_region}</option>`
					);
				}
			});
		}
	});
}

function search(){
	const job = $('#search_bar').val();
	const region = $('#region').val();
	const region_detail = $('#region_detail').val();	

	console.log(job);
	console.log(region);
	console.log(region_detail);
	let chk = true;
	
	if(chk === true){
		$.ajax({
			url:`/Search?job=${job}&region=${region}&region_detail=${region_detail}`,
			method:"GET",						
		}).done(function(response){
			$('#jobpost-list').empty();			
			$('#detail_tab').empty();
			const list = response;
			console.log('typeof list(search) : ', typeof list);
			
			if(typeof list === 'object'){
				$('#detail_tab').append(
					`<iframe src="viewDtail" name="detail_post" id="detail_post"></iframe>`
				);
				list.forEach(post => {
					const post_id = post.post_id;
					const title = post.title;
					const corp_name = post.corp_name;
					const postDate = post.postDate;
					const desc = post.jobDetail;	
					
					console.log("회사명 : ", corp_name);				
					if (corp_name !== "") {
						$('#jobpost-list').append(
							`<li class="post">		
								<a href="viewDtail?post_id=${post_id}" class="detail_btn" id="detail_btn" target="detail_post" onclick="detail()">	
									<h2 class="post-title">${title}</h2>				                  
				                 	<p class="post-cname">${corp_name}</p>				                 					                    
				                    <p class="post-desc">${desc}</p>
				                    <p class="post-postDate">~${postDate}까지</p>
				                </a>
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


 