function search(){
	const cname = $('#search_bar').val();
	
	console.log(cname);	
	let chk = true;
	
	if(chk === true){
		$.ajax({
			url:`/ReviewSearch?cname=${cname}`,
			method:"GET",						
		}).done(function(response){
			$('#review_list').empty();
			
			const list = response;
			console.log('typeof list : ', typeof list);
			
			if(typeof list === 'object'){
				list.forEach(reviews => {
					const reviewId = reviews.reviewId;					
					const corpName = reviews.corpName;
					const star = reviews.star;
					const summary = reviews.summary;
					const review = reviews.review;
					const position = reviews.position;
					const period = reviews.period;
					
					if (corpName !== "") {
						$('#review_list').append(
							`<li class="reviews">		
								<a href="viewReview?reviewId=${reviewId}" class="detail_btn" id="detail_btn" target="detail_post" onclick="detail()">	
									<h2 class="reviewId">${corpName}</h2>				                  
				                 	<p class="star">${star}</p>				                 					                    
				                    <p class="summary">${summary}</p>
				                    <p class="review">~${review}</p>
				                    <p class="position">~${position}</p>
				                    <p class="period">~${period}</p>
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