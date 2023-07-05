package model.resume;

public class Resume_semiRequestDto {
	private String resume_education;
	private String resume_career;
	private String resume_certificate;
	private String resume_hope;
	
	public Resume_semiRequestDto(String resume_hope) {
		this.resume_hope = resume_hope;
	}
	public Resume_semiRequestDto(String resume_education, String resume_career, String resume_certificate, String resume_hope) {
		this.resume_education = resume_education;
		this.resume_career = resume_career;
		this.resume_certificate = resume_certificate;
		this.resume_hope = resume_hope;
	}
	public String getResume_education() {
		return resume_education;
	}
	public void setResume_education(String resume_education) {
		this.resume_education = resume_education;
	}
	public String getResume_career() {
		return resume_career;
	}
	public void setResume_career(String resume_career) {
		this.resume_career = resume_career;
	}
	public String getResume_certificate() {
		return resume_certificate;
	}
	public void setResume_certificate(String resume_certificate) {
		this.resume_certificate = resume_certificate;
	}
	public String getResume_hope() {
		return resume_hope;
	}
	public void setResume_hope(String resume_hope) {
		this.resume_hope = resume_hope;
	}
	
	
	
}
