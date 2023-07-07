package model.resume;

import java.sql.Timestamp;

public class Resume {
	private String pid;
	private int job_id;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private Timestamp resume_created;
	private Timestamp resume_modified;
	
	
	public Resume(String pid, int job_id, String career, String degree, 
				  String activity, String certificate) {
		this.pid=pid;
		this.job_id=job_id;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
	}
	public Resume(String pid, int job_id, String career, 
				  String degree, String activity, String certificate, 
				  Timestamp resume_created, Timestamp resume_modified) {
		this.pid = pid;
		this.job_id=job_id;
		this.career=career;
		this.degree=degree;
		this.activity=activity;
		this.certificate=certificate;
		this.resume_created=resume_created;
		this.resume_modified=resume_modified;
	}
	
	public String getPid() {
		return pid;
	}
	public int getJob_id() {
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
	public Timestamp getResume_created() {
		return resume_created;
	}
	public Timestamp getResume_modified() {
		return resume_modified;
	}
	
	@Override
	public String toString() {	
		return String.format("id : %s\njob_id : %d\ncareer : %s\ndegree : %s\nactivity : %s\ncertificate : %s\n", 
				this.pid, this.job_id, this.career, this.degree, this.activity);
	}	
}