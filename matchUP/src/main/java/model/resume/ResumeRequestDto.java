package model.resume;

public class ResumeRequestDto {
	private String pid;
	private String resume_name;
	private int resume_tel;
	private String resume_email;
	private String resume_address;
	
	public ResumeRequestDto(String pid, String resume_name, int resume_tel, String resume_address) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_address = resume_address;
	}
	public ResumeRequestDto(String pid, String resume_name, int resume_tel, String resume_email, String resume_address) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_email = resume_email;
		this.resume_address = resume_address;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getResume_name() {
		return resume_name;
	}
	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}
	public int getResume_tel() {
		return resume_tel;
	}
	public void setResume_tel(int resume_tel) {
		this.resume_tel = resume_tel;
	}
	public String getResume_email() {
		return resume_email;
	}
	public void setResume_email(String resume_email) {
		this.resume_email = resume_email;
	}
	public String getResume_address() {
		return resume_address;
	}
	public void setResume_address(String resume_address) {
		this.resume_address = resume_address;
	}

}
