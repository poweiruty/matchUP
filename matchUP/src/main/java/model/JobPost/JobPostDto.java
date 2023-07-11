package model.JobPost;

public class JobPostDto {

    private String job;
	private String people;
	private String region;
	private String regionDetail;
	private String salary;
	private String postDate;
	private String welfare;
	private String jobDetail;

	public JobPostDto(String job, String people, String region, String regionDetail, String salary, String postDate, String welfare, String jobDetail) {
		this.job = job;
		this.people = people;
		this.region = region;
		this.regionDetail = regionDetail;
		this.salary = salary;
		this.postDate = postDate;
		this.welfare = welfare;
		this.jobDetail = jobDetail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getRegionDetail() {
		return regionDetail;
	}

	public void setRegionDetail(String regionDetail) {
		this.regionDetail = regionDetail;
	}
	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	public String getWelfare() {
		return welfare;
	}

	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	
	public String getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}
	
}
