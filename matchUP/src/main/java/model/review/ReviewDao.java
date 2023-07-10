package model.review;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import util.DBManager;

public class ReviewDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");

	private ReviewDao() {}
	
	private static ReviewDao instance = new ReviewDao();
	public static ReviewDao getInstance() {
		return instance;
	}
	
	
	// CREATE
//	public boolean createResume(ReviewRequestDto dto) {
//		
//		Review review = getReviewByResumeId(dto.getReviewid());
//		
//		if(resume != null) {
//			return false;
//		} 
//					
//		int pusersId = dto.getPusersId();
//		int jobId=dto.getJobId();
//		String career=dto.getCareer();
//		String degree=dto.getDegree();
//		String activity=dto.getActivity();
//		String certificate=dto.getCertificate();
//			
//		this.conn = DBManager.getConnection();
//		
//		String sql = "INSERT INTO resume_tb(pusers_id,job_id,career,degree,activity,certificate) VALUES(?,?,?,?,?,?)";			
//			
//		try{
//			this.pstmt=this.conn.prepareStatement(sql);
//			this.pstmt.setInt(1, pusersId);
//			this.pstmt.setInt(2, jobId);
//			this.pstmt.setString(3, career);
//			this.pstmt.setString(4, degree);
//			this.pstmt.setString(5, activity);
//			this.pstmt.setString(6, certificate);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(this.conn, this.pstmt);
//		}
//		return true;
//	}
	
		
	
	// READ
	public Review getResumeByPusersId(int reviewIdx) {
		Review reviews = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from review_tb where review_id=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, reviewIdx);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int reviewId=this.rs.getInt(1);
					int pusersId=this.rs.getInt(2);
					int corpId=this.rs.getInt(3);
					int star=this.rs.getInt(4);
					String review=this.rs.getString(5);
					Timestamp created = this.rs.getTimestamp(6);
					int createdTime=Integer.parseInt(sdf.format(created));
					Timestamp updated =this.rs.getTimestamp(7); 
					int updatedTime=Integer.parseInt(sdf.format(updated));
					
					reviews = new Review(reviewId, pusersId, corpId, star, review, createdTime, updatedTime);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return reviews;
	}
	
	public ArrayList<Review> getResumeAll(){
		ArrayList<Review> list = new ArrayList<Review>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from review_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int reviewId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int corpId = this.rs.getInt(3);
					int star = this.rs.getInt(4);
					String review = this.rs.getString(5);
					Timestamp created = this.rs.getTimestamp(6);
					int createdTime=Integer.parseInt(sdf.format(created));
					Timestamp updated =this.rs.getTimestamp(7); 
					int updatedTime=Integer.parseInt(sdf.format(updated));
					
					Review reviews = new Review(reviewId, pusersId, corpId, star, review, createdTime, updatedTime);
					
					list.add(reviews);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return list;
	}
	

	
//	// Update
//	public void updateResume(ResumeRequestDto dto) {
//		Resume resume=getResumeByPusersId(dto.getPusersId());
//		
//		this.conn = DBManager.getConnection();		
//		if(this.conn != null) {			
//			String sql = "update resume_tb rs inner join pusers_tb pu on rs.pusers_id=pu.pusers_id set job_id=?,rs.career=?,rs.degree=?,rs.activity=?,rs.certificate=? where rs.resume_id=?";					
//			 	
//			try {
//				this.pstmt = this.conn.prepareStatement(sql);
//				
//				if(resume.getJobId()==dto.getJobId()) {
//					this.pstmt.setInt(1, resume.getJobId());						
//				}else {
//					this.pstmt.setInt(1, dto.getJobId());
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
//				this.pstmt.setInt(6, dto.getPusersId());
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
//
//	
//	// DELETE
//	public boolean deleteResume(String resumeId) {
//		this.conn = DBManager.getConnection();
//		boolean check = true;
//		
//		if(this.conn != null) {
//			String sql = "delete from resume_tb where resume_id=?";
//			
//			try {
//				this.pstmt = this.conn.prepareStatement(sql);
//				this.pstmt.setString(1, resumeId);
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



