function postIt(htmlform) {	
	const title = htmlform.title.value
	const mgr_name = htmlform.mgr_name.value;
	const job = htmlform.job.value;
	const staffs = htmlform.staffs.value;
	const phone = htmlform.phone.value;
	const region = htmlform.region.value;
	const region_detail = htmlform.region_detail.value;
	const people = htmlform.people.value;
	const post_date = htmlform.post_date.value;
	const salary = htmlform.salary.value;
	const welfare = htmlform.welfare.value;
	const job_detail = htmlform.job_detail.value;
	
	let check = true;
	
	if(title === "") {
		alert("채용공고 제목을 입력하세요.")
		check = false;
	}  else if(mgr_name === "") {
		alert("채용 담당자명은 필수 항목입니다.")
		check = false;
	
	}  else if(staffs === "") {
		alert("사원수를 입력하세요.(비공개시 '00'으로 적어주세요.)")
		check = false;
	
	}  else if(phone === "") {
		alert("담당자 연락처는 필수 항목입니다.")
		check = false;
	
	} else if(job === "") {
		alert("직종은 필수 항목입니다.")
		check = false;
	
	} else if(region === "") {
		alert("지역을 설정해 주세요.")
		check = false;
	
	} else if(region_detail === "") {
		alert("세부 지역을 설정해 주세요.")
		check = false;
	
	} else if(people === "") {
		alert("채용 인원을 선택하세요.")
		check = false;
	
	} else if(post_date === "") {
		alert("공고 기간을 선택하세요")
		check = false;
	
	} else if(salary === "") {
		alert("급여 항목을 입력하세요.")
		check = false;
	
	} else if(welfare === "") {
		alert("회사내 복지 정보를 입력하세요.")
		check = false;
	
	} else if(job_detail === "") {
		alert("직무 세부사항을 입력하세요")
		check = false;
	}
	
	if(check === true) {
		alert("채용 공고 등록에 성공하였습니다 :)")
		htmlform.submit();
	}
}