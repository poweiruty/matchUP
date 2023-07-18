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
		int jobId=dto.getJobId();		
		String graduation=dto.getGraduation();
		String degree=dto.getDegree();
		String career=dto.getCareer();
		String activity=dto.getActivity();
		String certificate=dto.getCertificate();
		String intro=dto.getIntro();
			
		this.conn = DBManager.getConnection();
		
		String sql = "INSERT INTO resume_tb(pusers_id,job_id,graduation,degree,career,activity,certificate,intro) VALUES(?,?,?,?,?,?,?,?)";			
			
		try{
			this.pstmt=this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1,puserIdx);
			this.pstmt.setInt(2,jobId);		
			this.pstmt.setString(3,graduation);
			this.pstmt.setString(4,degree);
			this.pstmt.setString(5,career);
			this.pstmt.setString(6,activity);
			this.pstmt.setString(7,certificate);
			this.pstmt.setString(8,intro);
			
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
	public Resume getResumeInfo(int pusersIdx) {
		Resume resume = null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql = "SELECT pusers_id, job_id, graduation, degree, career, activity, certificate, intro FROM resume_tb WHERE pusers_id = ?";
			
			try {    
		        this.pstmt = conn.prepareStatement(sql);
		        this.pstmt.setInt(1, pusersIdx);
		        this.rs = pstmt.executeQuery();

		        if (rs.next()) {
		        	int puserId=rs.getInt("pusers_id");
		            int jobId = rs.getInt("job_id");
		            String graduation = rs.getString("graduation");
		            String degree = rs.getString("degree");
		            String career = rs.getString("career");
		            String activity = rs.getString("activity");
		            String certificate = rs.getString("certificate");
		            String intro = rs.getString("intro");

		            resume = new Resume(puserId, jobId, graduation, degree, career, activity, certificate, intro);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt, rs);
		    }
		}
			
		return resume;
	}
	
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
					int jobId=this.rs.getInt(3);					
					String graduation=this.rs.getString(4);
					String degree=this.rs.getString(5);
					String career=this.rs.getString(6);
					String activity = this.rs.getString(7);
					String certificate = this.rs.getString(8);
					String intro = this.rs.getString(9);
					Timestamp createdTime =this.rs.getTimestamp(10);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(11); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime));
					
					resume = new Resume(resumeId,pusersId,jobId,graduation,degree,career,activity,certificate,intro,createdTimeNum,modifiedTimeNum);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return resume;
	}
	
	// READ : 데이터 전체 읽기
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
					String graduation = this.rs.getString(4);
					String degree = this.rs.getString(5);
					String career = this.rs.getString(6);
					String activity = this.rs.getString(7);
					String certificate = this.rs.getString(8);
					String intro=this.rs.getString(9);
					Timestamp createdTime =this.rs.getTimestamp(10);
					int createdTimeNum=Integer.parseInt(sdf.format(createdTime));
					Timestamp modifiedTime =this.rs.getTimestamp(11); 
					int modifiedTimeNum=Integer.parseInt(sdf.format(modifiedTime)); 
					
					Resume resume = new Resume(resumeId,pusersId,jobId,graduation,degree,career,activity,certificate,intro,createdTimeNum,modifiedTimeNum);
					
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
			String sql = "update resume_tb set job_id=?,graduation=?,degree=?,career=?,activity=?,certificate=? where pusers_id=?";					
			 	
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
	            this.pstmt.setInt(1, dto.getJobId());	            
	            this.pstmt.setString(2, dto.getGraduation());
	            this.pstmt.setString(3, dto.getDegree());
	            this.pstmt.setString(4, dto.getCareer());
	            this.pstmt.setString(5, dto.getActivity());
	            this.pstmt.setString(6, dto.getCertificate());
	            this.pstmt.setInt(7, dto.getPusersId());
	            
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



