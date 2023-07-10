package model.resume;

import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.Date;


public class Resume {
	private int pusers_id;
	private int job_id;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private Timestamp resume_created;
	private Timestamp resume_modified;
	
	
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
				  Timestamp resumeCreated, Timestamp resumeModified) {
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
	public Timestamp getResumeCreated() {
		return resume_created;
	}
	public Timestamp getResumeModified() {
		return resume_modified;
	}
	
	@Override
	public String toString() {	
		return String.format("id : %d\njob_id : %d\ncareer : %s\ndegree : %s\nactivity : %s\ncertificate : %s\n", 
				this.pusers_id, this.job_id, this.career, this.degree, this.activity);
	}	
}