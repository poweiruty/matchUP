// MissingFormatException 발생

package model.resume;

public class Resume {
	private int pusers_id;
	private int job_id;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private int resume_created;
	private int resume_modified;
	
	public Resume(int pusersId, int jobId, String career, String degree, 
				  String activity, String certificate) {
		this.pusers_id=pusersId;
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
	}
	public Resume(int pusersId, int jobId, String career, 
				  String degree, String activity, String certificate, 
				  int resumeCreated, int resumeModified) {
		this.pusers_id = pusersId;
		this.job_id=jobId;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
		this.resume_created=resumeCreated;
		this.resume_modified=resumeModified;
	}
	
	
	// getter
	public int getPusersId() {
		return pusers_id;
	}
	public int getJobId() {
		return job_id;
	}
	public String getCareer() {
		return career;
	}
	public String getDegree() {
		return degree;
	}
	public String getActivity() {
		return activity;
	}
	public String getCertificate() {
		return certificate;
	}
	public int getResumeCreated() {
		return resume_created;
	}
	public int getResumeModified() {
		return resume_modified;
	}
	
	@Override
	public String toString() {	
		return String.format(
				"개인유저 인덱스:%d \n직업 인덱스:%d \n경력:%s \n학력:%s \n활동:%s \n자격증:%s \n작성시간:%s \n수정시간:%s",
				this.pusers_id,this.job_id,this.career,this.degree,this.activity,this.certificate,this.resume_created,this.resume_modified);
	}
	
}