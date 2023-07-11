package model.resume;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.review.ReviewRequestDto;
import util.DBManager;

public class ResumeDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");

	private ResumeDao() {}
	
	private static ResumeDao instance = new ResumeDao();
	public static ResumeDao getInstance() {
		return instance;
	}
	
	
	// CREATE
	public boolean createResume(ResumeRequestDto dto) {
		
		Resume resume = getResumeByPusersId(dto.getPusersId());
		
		if (resume != null) {
			return false;
	    }
		
		int pusersId=dto.getPusersId();
		int jobId=dto.getJobId();
		String career=dto.getCareer();
		String degree=dto.getDegree();
		String activity=dto.getActivity();
		String certificate=dto.getCertificate();
			
		this.conn = DBManager.getConnection();
		
		String sql = "INSERT INTO resume_tb(pusers_id,job_id,career,degree,activity,certificate) VALUES(?,?,?,?,?,?)";			
			
		try{
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, pusersId);
			this.pstmt.setInt(2, jobId);
			this.pstmt.setString(3, career);
			this.pstmt.setString(4, degree);
			this.pstmt.setString(5, activity);
			this.pstmt.setString(6, certificate);
			
			this.pstmt.execute();
			
		}catch (Exception e) {
			System.out.println("데이터 추가실패");
			e.printStackTrace();
		}finally {
			DBManager.close(this.conn, this.pstmt);
		}
		return true;
	}
	
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
					int resumeId=this.rs.getInt(1);
					int pusersId=this.rs.getInt(2);
					int jobId=this.rs.getInt(3);
					String career=this.rs.getString(4);
					String degree=this.rs.getString(5);
					String activity = this.rs.getString(6);
					String certificate = this.rs.getString(7);
					Timestamp createdTime =this.rs.getTimestamp(8);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(9); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime));
					
					resume = new Resume(resumeId, pusersId, jobId, career, degree, activity, certificate, createdTimeNum, modifiedTimeNum);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return resume;
	}
	
	
	/*
	 * public Resume getResumeByResumeId(int resumeIdx) { Resume resume = null;
	 * 
	 * this.conn = DBManager.getConnection();
	 * 
	 * if(this.conn != null) { String sql =
	 * "select * from resume_tb where resume_id=?"; try { this.pstmt =
	 * this.conn.prepareStatement(sql); this.pstmt.setInt(1, resumeIdx); this.rs =
	 * this.pstmt.executeQuery();
	 * 
	 * if(this.rs.next()) { int resumeId=this.rs.getInt(1); int
	 * pusersId=this.rs.getInt(2); int jobId=this.rs.getInt(3); String
	 * career=this.rs.getString(4); String degree=this.rs.getString(5); String
	 * activity = this.rs.getString(6); String certificate = this.rs.getString(7);
	 * Timestamp createdTime =this.rs.getTimestamp(8); int
	 * createdTimeNum=Integer.parseInt(sdf.format(createdTime)); Timestamp
	 * modifiedTime =this.rs.getTimestamp(9); int
	 * modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime));
	 * 
	 * resume = new Resume(resumeId, pusersId, jobId, career, degree, activity,
	 * certificate, createdTimeNum, modifiedTimeNum); } }catch (Exception e) {
	 * e.printStackTrace(); }finally { DBManager.close(this.conn, this.pstmt,
	 * this.rs); } } return resume; }
	 */
	
	
	public ArrayList<Resume> getResumeAll(){
		ArrayList<Resume> list = new ArrayList<Resume>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from resume_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int resumeId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int jobId = this.rs.getInt(3);
					String career = this.rs.getString(4);
					String degree = this.rs.getString(5);
					String activity = this.rs.getString(6);
					String certificate = this.rs.getString(7);
					Timestamp createdTime =this.rs.getTimestamp(8);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(9); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime)); 
					
					Resume resume = new Resume(resumeId,pusersId,jobId,career,degree,activity,certificate,createdTimeNum,modifiedTimeNum);
					
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
	public void updateResume(ResumeRequestDto dto) {	
		this.conn = DBManager.getConnection();		
		if(this.conn != null) {			
			String sql = "update resume_tb set job_id=?,career=?,degree=?,activity=?,certificate=? where pusers_id=?";					
			 	
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
	            this.pstmt.setInt(1, dto.getJobId());
	            this.pstmt.setString(2, dto.getCareer());
	            this.pstmt.setString(3, dto.getDegree());
	            this.pstmt.setString(4, dto.getActivity());
	            this.pstmt.setString(5, dto.getCertificate());
	            this.pstmt.setInt(6, dto.getPusersId());
	            
	            int rowsAffected = this.pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("이력서 업데이트 성공");
	                System.out.println("확인 : "+rowsAffected);
	            } else {
	                System.out.println("이력서 업데이트 실패");
	                System.out.println("확인 : "+rowsAffected);
	            }
	            
				System.out.println("데이터 수정 성공");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("데이터 수정 실패");
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	
//	public void updateResume(ResumeRequestDto dto) {
//	    this.conn = DBManager.getConnection();
//	    
//	    if (this.conn != null) {
//	        String sql = "update resume_tb SET job_id=?,career=?,degree=?,activity=?,certificate=? WHERE resume_id=?";
//	        
//	        try {
//	            this.pstmt = this.conn.prepareStatement(sql);
//	            
//	            this.pstmt.setInt(1, dto.getJobId());
//	            this.pstmt.setString(2, dto.getCareer());
//	            this.pstmt.setString(3, dto.getDegree());
//	            this.pstmt.setString(4, dto.getActivity());
//	            this.pstmt.setString(5, dto.getCertificate());
//	            this.pstmt.setInt(6, dto.getResumeId());
//	            
//	            int rowsAffected = this.pstmt.executeUpdate();
//	            
//	            if (rowsAffected > 0) {
//	                System.out.println("데이터 업데이트 성공");
//	                System.out.println("확인 : "+rowsAffected);
//	            } else {
//	                System.out.println("데이터 업데이트 실패");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } finally {
//	            DBManager.close(this.conn, this.pstmt);
//	        }
//	    }
//	}

	
	// DELETE
	public boolean deleteResume(int resumeId) {
		this.conn = DBManager.getConnection();
		boolean check = true;
		
		if(this.conn != null) {
			String sql = "delete from resume_tb where resume_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, resumeId);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
				check = false;
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}else{
			check = false;
		}
		
		return check;
	}
}



