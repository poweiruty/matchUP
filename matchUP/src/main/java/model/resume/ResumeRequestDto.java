package model.resume;

public class ResumeRequestDto {
	private int resume_id;
	private int pusers_id;
	private int job_id;
	private String job;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private String intro;
	private int resume_created;
	private int resume_modified;
	
	
	public ResumeRequestDto(String job, String career, String degree, 
							String activity, String certificate, String intro) {
		this.job=job;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
		this.intro=intro;;
	}
	
	public ResumeRequestDto(int jobId, String career, String degree, 
			  				String activity, String certificate) {
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
	}
	
	public ResumeRequestDto(int pusersId, int jobId, String career, String degree, 
				  			String activity, String certificate) {
		this.pusers_id=pusersId;
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
	}
	public ResumeRequestDto(int resumeId, int pusersId, int jobId, String career,
							String degree, String activity, String certificate) {
		this.resume_id=resumeId;
		this.pusers_id = pusersId;
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
	}
	public ResumeRequestDto(int resumeId, int pusersId, int jobId, String career, 
				  			String degree, String activity, String certificate, 
				  			int resumeCreated, int resumeModified) {
		this.resume_id=resumeId;
		this.pusers_id = pusersId;
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
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
		
	public int getJobId() {
		return job_id;
	}
	public void setJobId(int jobId) {
		this.job_id = jobId;
	}
	
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
		
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
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


