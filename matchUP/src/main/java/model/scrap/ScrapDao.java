package model.scrap;

import java.sql.*;
import java.util.ArrayList;

import model.resume.Resume;
import model.resume.ResumeRequestDto;
import util.DBManager;

public class ScrapDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private ScrapDao() { }
	private static ScrapDao instance = new ScrapDao();
	public static ScrapDao getInstance() {
		return instance;
	}
	
	// Create
	public boolean createScrap(ScrapRequestDto dto) {
			
		Scrap scrap = getScrapByPusersId(dto.getPusersId());
			
		if (scrap != null) {
			return false;
		}
			
		int pusersId=dto.getPusersId();
		int postId=dto.getPostId();
				
		this.conn = DBManager.getConnection();
			
		String sql = "INSERT INTO scrap_tb(pusers_id,post_id) VALUES(?,?)";			
				
		try{
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, pusersId);
			this.pstmt.setInt(2, postId);
			
			this.pstmt.execute();
				
		}catch (Exception e) {
			System.out.println("데이터 추가실패");
			e.printStackTrace();
		}finally {
			DBManager.close(this.conn, this.pstmt);
		}
		return true;
	}
	
	// Read
	public Scrap getScrapByPusersId(int pusersIdx) {
		Scrap scrap = null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from scrap_tb where pusers_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,pusersIdx);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					int scrapId=this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int jobPostingId = this.rs.getInt(3);
					
					scrap = new Scrap(scrapId,pusersId,jobPostingId);					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return scrap;
	}
	
	
	public ArrayList<Scrap> getScrapAll(){
		ArrayList<Scrap> list = new ArrayList<Scrap>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql="select * from scrap_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int scrapId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int jobPostingId = this.rs.getInt(3);
					
					Scrap scrap = new Scrap(scrapId,pusersId,jobPostingId);
					
					list.add(scrap);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return list;
	}
	
	// Delete
	public boolean deleteScrap(int scrapId) {
		this.conn = DBManager.getConnection();
		boolean check = true;
		
		if(this.conn != null) {
			String sql = "delete from scrap_tb where scrap_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, scrapId);
				
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
