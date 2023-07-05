package model.resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class ResumeDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ResumeDao() { }
	
	private static ResumeDao instance = new ResumeDao();
	public static ResumeDao getInstance() {
		return instance;
	}
	
	public boolean createResume(ResumeRequestDto dto) {
		Resume resume = getResumebyId(dto.getPid());
		if(resume != null) 
			return false;		
		
		String id = dto.getPid();
		String name = dto.getResume_name();
		int tel = dto.getResume_tel();
		String email = dto.getResume_email();
		String address = dto.getResume_address();
		
		
		boolean check = true;
		
		if(id != null && name != null && tel != 0 && address != null) {
			this.conn = DBManager.getConnection();
			if(this.conn != null) {
				if(!email.equals("")) {
					String resumeSql = "INSERT INTO(pid,resume_name,resume_tel,resume_email) resume VALUES(?,?,?,?,?)";				
					//String resume_semiSql = "INSERT INTO resume_semi VALUES(?,?,?,?,?)";
					try {
						this.pstmt = this.conn.prepareStatement(resumeSql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, name);
						this.pstmt.setInt(3, tel);
						this.pstmt.setString(4, email);
						this.pstmt.setString(5, address);
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}else {
					String resumeSql = "INSERT INTO resume(pid,resume_name,resume_tel) VALUES(?,?,?,?,)";			
					try {
						this.pstmt = this.conn.prepareStatement(resumeSql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, name);
						this.pstmt.setInt(3, tel);
						this.pstmt.setString(4, address);
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}
			}
		}
		return check;
	}
	
	public boolean createResume_semi(ResumeRequestDto dto) {
		Resume_semi resume = getResume_semibyId(dto.getPid());
		if(resume != null) 
			return false;	
		
		String id = dto.getPid();
		String education = dto.getResume_education();
		String career = dto.getResume_career();
		String certificate = dto.getResume_certificate();
		String hope = dto.getResume_hope();
		
		if(hope != null) {
			this.conn = DBManager.getConnection();
			if(this.conn != null) {
				String sql = "INSERT INTO resume_semi VALUES(?,?,?,?,?)";
				try {
					this.pstmt = this.conn.prepareStatement(sql);
					this.pstmt.setString(1, id);
					this.pstmt.setString(2, education);
					this.pstmt.setString(3, career);
					this.pstmt.setString(4, certificate);
					this.pstmt.setString(5, hope);
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(this.conn, this.pstmt);
				}				
			}
		}
		
		return true;
	} 

	public Resume_semi getResume_semibyId(String pid) {
		Resume_semi resume_semi = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM resume WHERE pid=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, pid);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String name = this.rs.getString(3);
					int tel = this.rs.getInt(4);
					String email = this.rs.getString(5);
					String address = this.rs.getString(6);

				
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return null;
	}

	public Resume getResumebyId(String pid) {
		Resume resume = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM resume WHERE pid=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, pid);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					String name = this.rs.getString(3);
					int tel = this.rs.getInt(4);
					String email = this.rs.getString(5);
					String address = this.rs.getString(6);
					
					resume = new Resume(pid, name, tel, email, address);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return resume;
	} 
	
}
