package model.job;

public class JobRequestDto {
	private String job;
	
	// Constructor
	public JobRequestDto(String job) {
		this.job = job;
	}
	
	// Getter / Setter
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}

