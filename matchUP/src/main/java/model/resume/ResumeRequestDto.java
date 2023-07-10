package model.resume;

import java.sql.Timestamp;

public class ResumeRequestDto {
	private int pusers_id;
	private int job_id;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private Timestamp resume_created;
	private Timestamp resume_modified;
	
		public ResumeRequestDto(int pusersId, String career, String degree, 
								String activity, String certificate) {
				this.pusers_id=pusersId;
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
		public ResumeRequestDto(int pusersId, int jobId, String career, 
								String degree, String activity, String certificate, 
								Timestamp resume_created, Timestamp resume_modified) {
				this.pusers_id=pusersId;
				this.job_id=jobId;
				this.career=career;
				this.degree=degree;
				this.activity=activity;
				this.certificate=certificate;
				this.resume_created=resume_created;
				this.resume_modified=resume_modified;
		}
		
		// Getter, Setter
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
		
		public Timestamp getResumeCreated() {
			return resume_created;
		}
		public void setResumeCreated(Timestamp resumeCreated) {
			this.resume_created = resumeCreated;
		}
		
		public Timestamp getResumeModified() {
			return resume_modified;
		}
		public void setResumeModified(Timestamp resumeModified) {
			this.resume_modified = resumeModified;
		}
	}


