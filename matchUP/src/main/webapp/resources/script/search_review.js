// CSS 파일 적용 
function loadCSSFile(url) {
  const link = document.createElement('link');
  link.rel = 'stylesheet';
  link.href = url;
  document.head.appendChild(link);
}

const cssFileURL = '/style/corpReview_detail.css';

loadCSSFile(cssFileURL);


// 검색한 항목의 데이터 불러오기
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
								<h2 class="corpName">${corpName} &nbsp&nbsp <span>★</span>&nbsp${star}</h2>				                  				                					                 					                    
				                <p class="summary">기업 한줄평:${summary}</p>
				                <p class="review">기업 리뷰:${review}</p>
				                <p class="position">근무직함:${position}&nbsp${period} 근무</p>
				                <br><br>                 
	                    	 </li>
	                    	 `
						);
					}
				});
			}		
		});	
	}	
}