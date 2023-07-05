package model.resume;

public class Resume {
	private String pid;
	private String resume_name;
	private int resume_tel;
	private String resume_email;
	private String resume_address;
	
	public Resume(String pid, String resume_name, int resume_tel, String resume_address) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_address = resume_address;
	}
	public Resume(String pid, String resume_name, int resume_tel, String resume_email, String resume_address) {
		this.pid = pid;
		this.resume_name = resume_name;
		this.resume_tel = resume_tel;
		this.resume_email = resume_email;
		this.resume_address = resume_address;
	}
	
	public String getPid() {
		return pid;
	}
	public String getResume_name() {
		return resume_name;
	}
	public int getResume_tel() {
		return resume_tel;
	}
	public String getResume_email() {
		return resume_email;
	}
	public String getResume_address() {
		return resume_address;
	}
	
	@Override
	public String toString() {	
		return String.format("id : %s\nresume_name : %s\nresumt_tel : %d\nresume_email : %s\nresume_address : %S", this.pid, this.resume_name, this.resume_tel, this.resume_email, this.resume_address);
	}	
}
