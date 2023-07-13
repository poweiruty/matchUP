// MissingFormatException 발생

package model.resume;

public class Resume {
	private int resume_id;
	private int pusers_id;
	private int job_id;
	private String graduation;
	private String degree;
	private String career;
	private String activity;
	private String certificate;
	private String intro;
	private int resume_created;
	private int resume_modified;
	
	public Resume(int puserIdx,int jobId,String graduation,String degree, 
				  String career, String activity, String certificate, String intro) {
		this.pusers_id=puserIdx;
		this.job_id=jobId;
		this.graduation=graduation;
		this.degree=degree;
		this.career=career;
		this.activity=activity;
		this.certificate=certificate;
		this.intro=intro;
	} 
	public Resume(int resumeId,int pusersId,int jobId, 
		  	  	  String graduation, String degree, String career, 
		  	      String activity, String certificate, String intro, int resumeCreated, int resumeModified) {
		this.resume_id=resumeId;
		this.pusers_id = pusersId;
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
	public String intro() {
		return intro;
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
				"이력서 인덱스:%d\n개인유저 인덱스:%d \n직업 인덱스:%d \n경력:%s \n최종학력:%s \n학력:%s \n활동:%s \n자격증:%s \n자기소개:%s \n작성시간:%s \n수정시간:%s\n",
				this.resume_id,this.pusers_id,this.job_id,this.career,this.graduation,this.degree,this.activity,this.certificate,this.intro,this.resume_created,this.resume_modified);
	}
	
}