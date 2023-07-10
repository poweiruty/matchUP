package model.resume;

import java.sql.*;
import java.util.ArrayList;

import util.DBManager;

public class ResumeDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ResumeDao() {}
	
	private static ResumeDao instance = new ResumeDao();
	public static ResumeDao getInstance() {
		return instance;
	}
	
	// CREATE
//	public boolean createResume(ResumeRequestDto dto) {
//		
//		Resume resume = getResumeById(dto.getPusersId());
//		
//		if(resume != null) {
//			return false;
//		} 
//					
//		String id = dto.getPid();
//		int jobId=dto.getJob_id();
//		String career=dto.getCareer();
//		String degree=dto.getDegree();
//		String activity=dto.getActivity();
//		String certificate=dto.getCertificate();
//			
//		this.conn = DBManager.getConnection();
//		
//		String resumeSql = "INSERT INTO resume(pid,job_id,career,degree,activity,certificate) VALUES(?,?,?,?,?,?)";			
//			
//		try{
//			this.pstmt=this.conn.prepareStatement(resumeSql);
//			this.pstmt.setString(2, id);
//			this.pstmt.setInt(3, jobId);
//			this.pstmt.setString(4, career);
//			this.pstmt.setString(5, degree);
//			this.pstmt.setString(6, activity);
//			this.pstmt.setString(7, certificate);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(this.conn, this.pstmt);
//		}
//		return true;
//	}
	
		
	// READ
	public Resume getResumeByPusersId(int pusersIdx) {
		Resume resume = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from resume_tb where pusers_id=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, pusersIdx);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int pusersId=this.rs.getInt(2);
					int jobId=this.rs.getInt(3);
					String career=this.rs.getString(4);
					String degree=this.rs.getString(5);
					String activity = this.rs.getString(6);
					String certificate = this.rs.getString(7);
					Timestamp createdTime =this.rs.getTimestamp(8); 
					Timestamp modifiedTime =this.rs.getTimestamp(9); 
					
					resume = new Resume(pusersId, jobId, career, degree, activity, certificate, createdTime, modifiedTime);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return resume;
	}
	
	public ArrayList<Resume> getResumeAll(){
		ArrayList<Resume> list = new ArrayList<Resume>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from resume_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int pusersId = this.rs.getInt(2);
					int jobId = this.rs.getInt(3);
					String career = this.rs.getString(4);
					String degree = this.rs.getString(5);
					String activity = this.rs.getString(6);
					String certificate = this.rs.getString(7);
					Timestamp createdTime =this.rs.getTimestamp(8); 
					Timestamp modifiedTime =this.rs.getTimestamp(9); 
					
					Resume resume = new Resume(pusersId,jobId,career,degree,activity,certificate,createdTime,modifiedTime);
					
					list.add(resume);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return list;
	}
	

	// Update
//	public void updateResume(ResumeRequestDto dto) {
//		Resume resume=getResumeById(dto.getPid());
//		
//		this.conn = DBManager.getConnection();		
//		if(this.conn != null) {			
//			String sql = "update resume_tb rs inner join pusers_tb pu on rs.pid=pu.pid set job_id=?, rs.career=?, rs.degree=?,rs.activity=?,rs.certificate=? where rs.pid=?;";					
//			
//			try {
//				this.pstmt = this.conn.prepareStatement(sql);
//				
//				if(resume.getJob_id()==dto.getJob_id()) {
//					this.pstmt.setInt(1, resume.getJob_id());						
//				}else {
//					this.pstmt.setInt(1, dto.getJob_id());
//				}
//				if(resume.getCareer().equals(dto.getCareer())) {	
//					this.pstmt.setString(2, resume.getCareer());
//				}else {
//					this.pstmt.setString(2, dto.getCareer());
//				}
//				if(resume.getDegree().equals(dto.getDegree())) {
//					this.pstmt.setString(3, resume.getDegree());
//				}else {
//					this.pstmt.setString(3, dto.getDegree());
//				}
//				if(resume.getActivity().equals(dto.getActivity())) {
//					this.pstmt.setString(4, resume.getActivity());
//				}else {
//					this.pstmt.setString(4, dto.getActivity());
//				}
//				if(resume.getCertificate().equals(dto.getCertificate())){
//					this.pstmt.setString(5, resume.getCertificate());
//				}else {
//					this.pstmt.setString(5, dto.getCertificate());
//				}
//				
//				this.pstmt.setString(6, dto.getPid());
//				
//				this.pstmt.execute();				
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				DBManager.close(this.conn, this.pstmt);
//			}			
//		}
//	}
	
	// DELETE
//	public boolean deleteResume(String id, String password) {
//		this.conn = DBManager.getConnection();
//		boolean check = true;
//		
//		if(this.conn != null) {
//			String sql = "DELETE rs FROM resume_tb AS rs JOIN pusers_tb AS pu ON rs.pid=pu.pid WHERE pu.pid=? AND pu.ppassword=?;";
//			
//			try {
//				this.pstmt = this.conn.prepareStatement(sql);
//				this.pstmt.setString(1, id);
//				this.pstmt.setString(2, password);
//				
//				this.pstmt.execute();
//			}catch (Exception e) {
//				e.printStackTrace();
//				check = false;
//			}finally {
//				DBManager.close(this.conn, this.pstmt);
//			}
//		}else{
//			check = false;
//		}
//		
//		return check;
//	}
}



