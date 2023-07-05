package model.resume;

public class ResumeRequestDto {
	private String pid;
	private String resume_name;
	private int resume_tel;
	private String resume_email;
	private String resume_address;
	private String resume_education;
	private String resume_career;
	private String resume_certificate;
	private String resume_hope;
	
	public ResumeRequestDto(String pid, String resume_name, int resume_tel, String resume_email,
			String resume_address) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_email = resume_email;
		this.resume_address = resume_address;
	}
	public ResumeRequestDto(String pid, String resume_name, int resume_tel, String resume_email, String resume_address,
			String resume_education, String resume_career, String resume_certificate, String resume_hope) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_email = resume_email;
		this.resume_address = resume_address;
		this.resume_education = resume_education;
		this.resume_career = resume_career;
		this.resume_certificate = resume_certificate;
		this.resume_hope = resume_hope;
	}
	public String getPid() {
		return this.pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getResume_name() {
		return this.resume_name;
	}
	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}
	public int getResume_tel() {
		return this.resume_tel;
	}
	public void setResume_tel(int resume_tel) {
		this.resume_tel = resume_tel;
	}
	public String getResume_email() {
		return this.resume_email;
	}
	public void setResume_email(String resume_email) {
		this.resume_email = resume_email;
	}
	public String getResume_address() {
		return this.resume_address;
	}
	public void setResume_address(String resume_address) {
		this.resume_address = resume_address;
	}
	public String getResume_education() {
		return this.resume_education;
	}
	public void setResume_education(String resume_education) {
		this.resume_education = resume_education;
	}
	public String getResume_career() {
		return this.resume_career;
	}
	public void setResume_career(String resume_career) {
		this.resume_career = resume_career;
	}
	public String getResume_certificate() {
		return this.resume_certificate;
	}
	public void setResume_certificate(String resume_certificate) {
		this.resume_certificate = resume_certificate;
	}
	public String getResume_hope() {
		return this.resume_hope;
	}
	public void setResume_hope(String resume_hope) {
		this.resume_hope = resume_hope;
	}
	
	
}
