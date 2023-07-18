package model.resume;

public class ResumeRequestDto {
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
	
	public ResumeRequestDto(String resumeTitle, int jobId,String graduation,String degree, 
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
	public ResumeRequestDto(int puserIdx,String resumeTitle,int jobId,String graduation,String degree, 
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
	public ResumeRequestDto(int resumeId, int pusersId, String resumeTitle, int jobId, 
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
		
	// Getter, Setter
	public int getResumeId() {
		return resume_id;	
	}
	public void setResumeId(int resumeId) {
		this.resume_id = resumeId;
	}
	
	public int getPusersId() {
		return pusers_id;	
	}
	public void setPusersId(int pusersId) {
		this.pusers_id = pusersId;
	}
	
	public String getResumeTitle() {
		return resume_title;	
	}
	public void setResumeTitle(String resumeTitle) {
		this.resume_title = resumeTitle;
	}
		
	public int getJobId() {
		return job_id;
	}
	public void setJobId(int jobId) {
		this.job_id = jobId;
	}
	
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
		
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
		
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
		
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
		
	public int getResumeCreated() {
		return resume_created;
	}
	public void setResumeCreated(int resumeCreated) {
		this.resume_created = resumeCreated;
	}
		
	public int getResumeModified() {
		return resume_modified;
	}
	public void setResumeModified(int resumeModified) {
		this.resume_modified = resumeModified;
	}
}


