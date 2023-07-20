function deleteResume(resumeId) {  		
	if(confirm("이력서를 삭제하시겠습니까?")==true){
		// 화면 상에서 목록을 삭제
     const resume = document.getElementById("resume_" + resumeId);
     if (resume) {
         resume.remove();
     }
 	
     // AJAX를 사용하여 서버로 이력서 삭제 요청 전송
     var xhr = new XMLHttpRequest();
     
     xhr.open('POST', 'ResumeDelete', true);
     xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
     xhr.onreadystatechange = function() {
         if (xhr.readyState === XMLHttpRequest.DONE) {
             if (xhr.status === 200) {
                 // 서버 응답을 처리할 수 있는 코드 작성
                 console.log('이력서 삭제 성공');
             } else {
                 // 서버 응답이 실패인 경우 처리할 코드 작성
                 console.log('이력서 삭제 실패');
             }
         }
     };
     xhr.send('resumeId=' + resumeId);	
	}else{
		return false;
	}    	
}