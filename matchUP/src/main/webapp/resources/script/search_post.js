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
		url:`/semi?main=${selectedValue}`,
		method:"GET",								
	}).done(function(data){
		$('#region_detail').empty();
			
			const list = response;
			console.log('typeof list : ', typeof list);
			
			if(typeof list === 'object'){
				list.forEach(region => {
					const semi_region = region.semi_region;
					
					if (corp_name !== "") {
						$('#jobpost-list').append(
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
			
			const list = response;
			console.log('typeof list : ', typeof list);
			
			if(typeof list === 'object'){
				list.forEach(post => {
					const post_id = post.post_id;
					const title = post.title;
					const corp_name = post.corp_name;
					const postDate = post.postDate;
					const desc = post.jobDetail;
					
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


 