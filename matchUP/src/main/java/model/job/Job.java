package model.job;

public class Job {
	private String job;
	
	public Job(String job) {
		this.job=job;
	}
	
	public String geJtob() {
		return job;
	}
	
	@Override
	public String toString() {
		return String.format("Job : %s", this.job);
	}
}