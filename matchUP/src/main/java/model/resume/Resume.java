// MissingFormatException 발생

package model.resume;

public class Resume {
	private int resume_id;
	private int pusers_id;
	private String resume_title;
	private int job_id;
	private String graduation;
	private String degree;
	private String career;
	private String activity;
	private String certificate;
	private String intro;
	private int resume_created;
	private int resume_modified;
	
	public Resume(String resumeTitle, int jobId,String graduation,String degree, 
			  String career, String activity, String certificate, String intro) {
		this.resume_title=resumeTitle;
		this.job_id=jobId;
		this.graduation=graduation;
		this.degree=degree;
		this.career=career;
		this.activity=activity;
		this.certificate=certificate;
		this.intro=intro;
	}
	public Resume(int puserIdx,String resumeTitle,int jobId,String graduation,String degree, 
				  String career, String activity, String certificate, String intro) {
		this.pusers_id=puserIdx;
		this.resume_title=resumeTitle;
		this.job_id=jobId;
		this.graduation=graduation;
		this.degree=degree;
		this.career=career;
		this.activity=activity;
		this.certificate=certificate;
		this.intro=intro;
	} 

	public Resume(int resumeId, int pusersId, String resumeTitle, int jobId, 
		  	  	  String graduation, String degree, String career, 
		  	      String activity, String certificate, String intro, int resumeCreated, int resumeModified) {
		this.resume_id=resumeId;
		this.pusers_id = pusersId;
		this.resume_title=resumeTitle;
		this.job_id=jobId;
		this.graduation=graduation;
		this.degree=degree;
		this.career=career;
		this.activity=activity;
		this.certificate=certificate;
		this.intro=intro;
		this.resume_created=resumeCreated;
		this.resume_modified=resumeModified;
	}
	
	// getter
	public int getResumeId() {
		return resume_id;
	}
	public int getPusersId() {
		return pusers_id;
	}
	public String getResumeTitle() {
		return resume_title;
	}
	public int getJobId() {
		return job_id;
	}
	public String getGraduation() {
		return graduation;
	}
	public String getDegree() {
		return degree;
	}
	public String getCareer() {
		return career;
	}
	public String getActivity() {
		return activity;
	}
	public String getCertificate() {
		return certificate;
	}
	public String getIntro() {
		return intro;
	}
	public int getResumeCreated() {
		return resume_created;
	}
	public int getResumeModified() {
		return resume_modified;
	}
	
//	@Override
//	public String toString() {
//		return String.format("직업인덱스:%d \n최종학력:%s \n학력:%s \n경력:%s \n활동:%s \n자격증:%s \n자기소개:%s" 
//							 ,this.job_id,this.graduation,this.degree,this.career,this.activity,this.certificate,this.intro);
//	}	
}