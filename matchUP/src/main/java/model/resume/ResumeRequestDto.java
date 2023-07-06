package model.resume;

import java.sql.Timestamp;

public class ResumeRequestDto {
	private String pid;
	private int job_id;
	private String career;
	private String degree;
	private String activity;
	private String certificate;
	private Timestamp resume_created;
	private Timestamp resume_modified;
	
		public ResumeRequestDto(String pid, String career, String degree, 
								String activity, String certificate) {
				this.pid=pid;
				this.career=career;
				this.degree=degree;
				this.activity=activity;
				this.certificate=certificate;
		}
		public ResumeRequestDto(String pid, int job_id, String career, String degree, 
								String activity, String certificate) {
				this.pid=pid;
				this.job_id=job_id;
				this.career=career;
				this.degree=degree;
				this.activity=activity;
				this.certificate=certificate;
		}
		public ResumeRequestDto(String pid, int job_id, String career, 
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
		
		// Getter, Setter
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		
		public int getJob_id() {
			return job_id;
		}
		public void setJob_id(int job_id) {
			this.job_id = job_id;
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
		
		public Timestamp getResume_created() {
			return resume_created;
		}
		public void setResume_created(Timestamp resume_created) {
			this.resume_created = resume_created;
		}
		
		public Timestamp getResume_modified() {
			return resume_modified;
		}
		public void setResume_modified(Timestamp resume_modified) {
			this.resume_modified = resume_modified;
		}
		
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/main
