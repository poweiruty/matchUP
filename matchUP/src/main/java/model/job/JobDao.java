package model.job;

import java.sql.*;
import java.util.*;
import util.DBManager;

public class JobDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private JobDao() { }
	private static JobDao instance = new JobDao();
	public static JobDao getInstance() {
		return instance;
	}
		
	
	public Job getJob(String job) {
		Job jobs = null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from job_tb where job=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1,job);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					String jobss = this.rs.getString(2);
					jobs = new Job(jobss);					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return jobs;
	}	

	public ArrayList<Job> getJobAll(){
		ArrayList<Job> list = new ArrayList<Job>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql="select * from job_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String job = this.rs.getString(2);
					
					Job jobs = new Job(job);
					
					list.add(jobs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return list;
	}
}