package model.JobPost;

public class JobPostDto {
	
	private int post_id;
	private String title;
	private String corp_name;
	private String staffs;
	private String ceo;
    private String job;
    private String region;	
	private String regionDetail;
	private String people;
	private String postDate;	
	private String salary;
	private String welfare;
	private String jobDetail;
	private String create_post;
	
	
	public JobPostDto(int post_id, String corp_name, String postDate, String jobDetail) {
		this.post_id = post_id;
		this.corp_name = corp_name;
		this.postDate = postDate;
		this.jobDetail = jobDetail;
	}

	
	public JobPostDto(int post_id, String title, String corp_name, String staffs, String ceo, String job, String region,
			String regionDetail, String people, String postDate, String salary, String welfare, String jobDetail,
			String create_post) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.corp_name = corp_name;
		this.staffs = staffs;
		this.ceo = ceo;
		this.job = job;
		this.region = region;
		this.regionDetail = regionDetail;
		this.people = people;
		this.postDate = postDate;
		this.salary = salary;
		this.welfare = welfare;
		this.jobDetail = jobDetail;
		this.create_post = create_post;
	}


	public JobPostDto(String corp_name, String staffs, String ceo, String job, String region, String regionDetail,
			String people, String postDate, String salary, String welfare, String jobDetail, String create_post) {		
		this.corp_name = corp_name;
		this.staffs = staffs;
		this.ceo = ceo;
		this.job = job;
		this.region = region;
		this.regionDetail = regionDetail;
		this.people = people;
		this.postDate = postDate;
		this.salary = salary;
		this.welfare = welfare;
		this.jobDetail = jobDetail;
		this.create_post = create_post;
	}


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

	public JobPostDto(int post_id, String corp_name, String staffs, String ceo, String people, String postDate, String salary,
			String welfare, String desc, String create_post) {
		this.post_id = post_id;
		this.corp_name = corp_name;
		this.staffs = staffs;
		this.ceo = ceo;
		this.people = people;
		this.postDate = postDate; 
		this.salary = salary;
		this.welfare = welfare;
		this.jobDetail = desc;
		this.create_post = create_post;		
	}
	public JobPostDto(int post_id, String corp_name, String staffs, String ceo, String job, String region,
			String regionDetail, String people, String postDate, String salary, String welfare, String jobDetail,
			String create_post) {
		super();
		this.post_id = post_id;
		this.corp_name = corp_name;
		this.staffs = staffs;
		this.ceo = ceo;
		this.job = job;
		this.region = region;
		this.regionDetail = regionDetail;
		this.people = people;
		this.postDate = postDate;
		this.salary = salary;
		this.welfare = welfare;
		this.jobDetail = jobDetail;
		this.create_post = create_post;
	}


	public int getPost_id() {
		return post_id;
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
	
	public String getCreate_post() {
		return create_post;
	}

	public void setCreate_post(String create_post) {
		this.create_post = create_post;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "JobPostDto [post_id=" + post_id + ", title=" + title + ", corp_name=" + corp_name + ", staffs=" + staffs
				+ ", ceo=" + ceo + ", job=" + job + ", region=" + region + ", regionDetail=" + regionDetail
				+ ", people=" + people + ", postDate=" + postDate + ", salary=" + salary + ", welfare=" + welfare
				+ ", jobDetail=" + jobDetail + ", create_post=" + create_post + "]";
	}
	
		

	

}
