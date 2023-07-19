package model.resume;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


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
		int puserIdx=dto.getPusersId();
		String resumeTitle=dto.getResumeTitle();
		int jobId=dto.getJobId();
		String graduation=dto.getGraduation();
		String degree=dto.getDegree();
		String career=dto.getCareer();
		String activity=dto.getActivity();
		String certificate=dto.getCertificate();
		String intro=dto.getIntro();
			
		this.conn = DBManager.getConnection();
		
		String sql = "INSERT INTO resume_tb(pusers_id,resume_title,job_id,graduation,degree,career,activity,certificate,intro) VALUES(?,?,?,?,?,?,?,?,?)";			
			
		try{
			this.pstmt=this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1,puserIdx);
			this.pstmt.setString(2,resumeTitle);
			this.pstmt.setInt(3,jobId);		
			this.pstmt.setString(4,graduation);
			this.pstmt.setString(5,degree);
			this.pstmt.setString(6,career);
			this.pstmt.setString(7,activity);
			this.pstmt.setString(8,certificate);
			this.pstmt.setString(9,intro);
			
			this.pstmt.execute();
			
			System.out.println("Data Added");
		}catch (Exception e) {
			System.out.println("Data Adding failed");
			e.printStackTrace();
		}finally {
			DBManager.close(this.conn, this.pstmt);
		}
		return true;
	}
	
	// READ : 특정DB만 뽑아오기
	public Resume getResumeInfo(int puserIdx) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Resume resume = null;

	    try {
	        conn = DBManager.getConnection();
	        String sql = "select * from resume_tb where pusers_id=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, puserIdx);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // 이력서 정보를 가져와서 Resume 객체에 저장
	        	String resumeTitle=rs.getString("resume_title");
	            int jobId = rs.getInt("job_id");
	            String graduation = rs.getString("graduation");
	            String degree = rs.getString("degree");
	            String career = rs.getString("career");
	            String activity = rs.getString("activity");
	            String certificate = rs.getString("certificate");
	            String intro = rs.getString("intro");

	            resume = new Resume(resumeTitle, jobId, graduation, degree, career, activity, certificate, intro);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return resume;
	}
	
//	public Resume getResumeInfo(int pusersIdx) {
//		Resume resume = null;
//		
//		this.conn=DBManager.getConnection();
//		
//		if(this.conn!=null) {
//			String sql = "SELECT pusers_id, job_id, graduation, degree, career, activity, certificate, intro FROM resume_tb WHERE pusers_id = ?";
//			
//			try {    
//		        this.pstmt = conn.prepareStatement(sql);
//		        this.pstmt.setInt(1, pusersIdx);
//		        this.rs = pstmt.executeQuery();
//
//		        if (rs.next()) {
//		        	int puserId=rs.getInt("pusers_id");
//		            int jobId = rs.getInt("job_id");
//		            String graduation = rs.getString("graduation");
//		            String degree = rs.getString("degree");
//		            String career = rs.getString("career");
//		            String activity = rs.getString("activity");
//		            String certificate = rs.getString("certificate");
//		            String intro = rs.getString("intro");
//
//		            resume = new Resume(puserId, jobId, graduation, degree, career, activity, certificate, intro);
//		        }
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    } finally {
//		        DBManager.close(conn, pstmt, rs);
//		    }
//		}
//			
//		return resume;
//	}
	
	
	
	// READ : 1개의 데이터베이스 전체컬럼 읽기
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
					String resumeTitle=this.rs.getString(3);
					int jobId=this.rs.getInt(4);					
					String graduation=this.rs.getString(5);
					String degree=this.rs.getString(6);
					String career=this.rs.getString(7);
					String activity = this.rs.getString(8);
					String certificate = this.rs.getString(9);
					String intro = this.rs.getString(10);
					Timestamp createdTime =this.rs.getTimestamp(11);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(12); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime));
					
					resume = new Resume(resumeId,pusersId,resumeTitle,jobId,graduation,degree,career,activity,certificate,intro,createdTimeNum,modifiedTimeNum);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return resume;
	}
	
	// READ : 특정회원 데이터 읽기(리스트)
	public ArrayList<Resume> getResumesByLogin(int puserIdx){
		ArrayList<Resume> list=new ArrayList<Resume>();
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from resume_tb where pusers_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, puserIdx);
				
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int resumeId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					String resumeTitle = this.rs.getString(3);
					int jobId = this.rs.getInt(4);					
					String graduation = this.rs.getString(5);
					String degree = this.rs.getString(6);
					String career = this.rs.getString(7);
					String activity = this.rs.getString(8);
					String certificate = this.rs.getString(9);
					String intro=this.rs.getString(10);
					Timestamp createdTime =this.rs.getTimestamp(11);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(12); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime)); 
					
					Resume resume = new Resume(resumeId,pusersId,resumeTitle,jobId,graduation,degree,career,activity,certificate,intro,createdTimeNum,modifiedTimeNum);
					
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
	
//	// READ : 데이터 전체 읽기(리스트)
//	public ArrayList<Resume> getResumeAll(){
//		ArrayList<Resume> list = new ArrayList<Resume>();
//		
//		this.conn = DBManager.getConnection();
//		
//		if(this.conn != null) {
//			String sql = "select * from resume_tb";
//			
//			try {
//				this.pstmt = this.conn.prepareStatement(sql);
//				this.rs = this.pstmt.executeQuery();
//				
//				while(this.rs.next()) {
//					int resumeId = this.rs.getInt(1);
//					int pusersId = this.rs.getInt(2);
//					String resumeTitle = this.rs.getString(3);
//					int jobId = this.rs.getInt(4);					
//					String graduation = this.rs.getString(5);
//					String degree = this.rs.getString(6);
//					String career = this.rs.getString(7);
//					String activity = this.rs.getString(8);
//					String certificate = this.rs.getString(9);
//					String intro=this.rs.getString(10);
//					Timestamp createdTime =this.rs.getTimestamp(11);
//					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
//					Timestamp modifiedTime =this.rs.getTimestamp(12); 
//					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime)); 
//					
//					Resume resume = new Resume(resumeId,pusersId,resumeTitle,jobId,graduation,degree,career,activity,certificate,intro,createdTimeNum,modifiedTimeNum);
//					
//					list.add(resume);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager.close(this.conn, this.pstmt, this.rs);
//			}
//		}		
//		return list;
//	}
		
	// Update
	public void updateResume(ResumeRequestDto dto) {	
		this.conn = DBManager.getConnection();		
		if(this.conn != null) {			
			String sql = "update resume_tb set resume_title=?,job_id=?,graduation=?,degree=?,career=?,activity=?,certificate=? where pusers_id=?";					
			 	
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setString(1, dto.getResumeTitle());
	            this.pstmt.setInt(2, dto.getJobId());	            
	            this.pstmt.setString(3, dto.getGraduation());
	            this.pstmt.setString(4, dto.getDegree());
	            this.pstmt.setString(5, dto.getCareer());
	            this.pstmt.setString(6, dto.getActivity());
	            this.pstmt.setString(7, dto.getCertificate());
	            this.pstmt.setInt(8, dto.getPusersId());
	            
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