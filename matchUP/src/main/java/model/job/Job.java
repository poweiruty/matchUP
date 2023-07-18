package model.job;

public class Job {
	private int job_id;
	private String job;
	
	public Job(String job) {
		this.job=job;
	}
	
	public Job(int jobId, String job) {
		this.job_id=jobId;
		this.job=job;
	}
	
	public int getJobId() {
		return job_id;
	}
	public String getJob() {
		return job;
	}
	
	@Override
	public String toString() {
		return String.format("Job : %s", this.job);
	}
}