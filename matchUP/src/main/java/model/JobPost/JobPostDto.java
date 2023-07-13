package model.JobPost;

public class JobPostDto {
	
	private String corp_name;
	private String staffs;
	private String ceo;
    private String job;
	private String people;
	private String region;
	private String regionDetail;
	private String salary;
	private String postDate;
	private String welfare;
	private String jobDetail;

	public JobPostDto(String corp_name, String staffs, String ceo, String job, String people, String region, String regionDetail, String salary, String postDate, String welfare, String jobDetail) {
		this.corp_name = corp_name;
		this.staffs = staffs;
		this.ceo = ceo;
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

<<<<<<< HEAD
	@Override
	public String toString() {
		return "JobPostDto [job=" + job + ", people=" + people + ", region=" + region + ", regionDetail=" + regionDetail
				+ ", salary=" + salary + ", postDate=" + postDate + ", welfare=" + welfare + ", jobDetail=" + jobDetail
				+ "]";
	}
	
	
	
=======
	public String getCorp_name() {
		return corp_name;
	}

	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}

	public String getStaffs() {
		return staffs;
	}

	public void setStaffs(String staffs) {
		this.staffs = staffs;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

>>>>>>> refs/remotes/origin/#2-LeeTaewoo
}
