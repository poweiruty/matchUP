package model.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.JobPost.JobPostDto;
import util.DBManager;

public class JobPostSearchDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private JobPostSearchDao() { }
	private static JobPostSearchDao instance = new JobPostSearchDao();
	public static JobPostSearchDao getInstance() {
		return instance;
	}
	
	public String getJobSearch(String jobN) {
		String job = null;
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select job_id from job_tb where job like ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, "%" + jobN + "%");
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					job = this.rs.getString("job_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return job;		
	}
	
	public String getCorpbyCname(String job) {
		String cname = null;
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select corp_name from job_posting_tb where corp_name like ?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, "%" + job + "%");
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					cname = this.rs.getString("corp_name");					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return cname;
	}
	
	public String getMainbySearch(String region) {
		String rid = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			//String sql = "SELECT * FROM main_region_tb WHERE main_region LIKE ?";
			String sql = "select * from main_region_tb where main_region=?;";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				//this.pstmt.setString(1, "%" + region + "%");
				this.pstmt.setString(1, region);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					rid = this.rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return rid;
	}
	public String getSemibySearch(String region_detail) {
//		ArrayList<SemiRegion> list = new ArrayList<SemiRegion>();
		String semi_region = null;
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select semi_region_id from semi_region_tb where semi_region=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, region_detail);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					semi_region = this.rs.getString(1);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn,this.pstmt, this.rs);
			}
		}
		return semi_region;
	}
	
    public ArrayList<JobPostDto> getPostbyMainRegion(String main){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where main_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setInt(1, Integer.parseInt(main));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }
    
    public ArrayList<JobPostDto> getPostbyCnameAndMain(String name, String main){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where corp_name=? and main_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, name);
    			this.pstmt.setInt(2, Integer.parseInt(main));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }
    
    public ArrayList<JobPostDto> getPostbyCnameAndSemi(String name, String semi){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where corp_name=? and semi_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, name);
    			this.pstmt.setInt(2, Integer.parseInt(semi));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }
    
    public ArrayList<JobPostDto> getPostbySemiRegion(String semi){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where semi_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setInt(1, Integer.parseInt(semi));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }

	public ArrayList<JobPostDto> getPostbyCname(String name) {
		ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select * from job_posting_tb where corp_name like ?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, "%" + name + "%");
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}			
		}
		
		return list;
	}
    public ArrayList<JobPostDto> getPostbyJobNameAndMain(String jobName, String main){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where job_id=? and main_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, jobName);
    			this.pstmt.setInt(2, Integer.parseInt(main));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }
    public ArrayList<JobPostDto> getPostbyJobNameAndSemi(String jobName, String semi){
    	ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
    	this.conn = DBManager.getConnection();
    	if(this.conn != null) {
    		String sql = "select * from job_posting_tb where job_id=? and semi_region_id=?";
    		try {
    			this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, jobName);
    			this.pstmt.setInt(2, Integer.parseInt(semi));
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
    	}
    	return list;
    }
	public ArrayList<JobPostDto> getPostbyJobName(String jobName) {
		ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select * from job_posting_tb where job_id = ?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, jobName);
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}			
		}
		
		return list;
	}
	
	public ArrayList<JobPostDto> getPostbyAll(){
		ArrayList<JobPostDto> list = new ArrayList<JobPostDto>();
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select * from job_posting_tb";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int postId = this.rs.getInt("post_id");
    				String title = this.rs.getString("title");
    				String cname = this.rs.getString("corp_name");
    				String staffs = this.rs.getString("staffs");
    				String ceo = this.rs.getString("ceo");
    				String job_id = this.rs.getString("job_id");
    				String main_region = this.rs.getString("main_region_id");
    				String semi_region = this.rs.getString("semi_region_id");
    				String recruit_people = this.rs.getString("recruit_people");
    				String recruit_period = this.rs.getString("recruit_period");
    				String salary = this.rs.getString("salary");
    				String welfare = this.rs.getString("welfare");    				
    				String desc = this.rs.getString("description");
    				Timestamp created_post = this.rs.getTimestamp("created_post");
    				String create_postToString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(created_post);
    				
    				JobPostDto post = new JobPostDto(postId, title, cname, staffs, ceo, job_id, main_region, semi_region, recruit_people,recruit_period, salary, welfare, desc, create_postToString);
    				list.add(post);
    			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}			
		}
		return list;
	}
}
