<%@page import="java.util.ArrayList"%>
<%@page import="model.resume.Resume"%>
<%@page import="model.resume.ResumeRequestDto"%>
<%@page import="model.resume.ResumeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

	ResumeDao dao = ResumeDao.getInstance();

	// Create : clear
	/* System.out.println("\n데이터 추가하기>>");
	ResumeRequestDto newResume = new ResumeRequestDto(13,2,"new career","new degree","new activity","new certificate");
	boolean created = dao.createResume(newResume);
	if (created) {
    	System.out.println("데이터가 성공적으로 추가되었습니다.");
	} else {
    	System.out.println("데이터 추가에 실패했습니다.");
	} */
	
	
	// Read : clear
	Resume resume = dao.getResumeInfo(1);
	
	System.out.println("\n데이터 1개 불러오기>>");
	if (resume != null) {
		System.out.println(resume);
	} else {
		System.out.println("Resume not found\n");
	}
	
	/* System.out.println("\n데이터 전체 불러오기>>");
	ArrayList<Resume> list = dao.getResumeAll();
	for(Resume resumes:list){
		System.out.println(resumes);
	} */ 
	
	/* // Update : clear
	System.out.println("\n데이터 업데이트하기>>");
	resume = dao.getResumeByPusersId(3);
	ResumeRequestDto updateResume = new ResumeRequestDto(4,12,"수정된 경력 2번째","수정된 학력","수정된 활동","수정된 자격증");
	dao.updateResume(updateResume); 
	
	// Delete : clear
	System.out.println("\n데이터 삭제하기>>");
	int deleteId=4; // 삭제할 데이터의 Resume ID를 지정해주세요.
	boolean deleted = dao.deleteResume(deleteId);
	if (deleted) {
	    System.out.println("데이터가 성공적으로 삭제되었습니다.");
	} else {
	    System.out.println("데이터 삭제에 실패했습니다.");
	} */
	
	
%>
</body>
</html>