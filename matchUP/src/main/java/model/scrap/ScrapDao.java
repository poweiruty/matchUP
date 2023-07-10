package model.scrap;

import java.sql.*;
import java.util.ArrayList;
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
	
	// 광역자치 Read
	public Scrap getScrap(int pusersIdx) {
		Scrap scrap = null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from scrap_tb where pusers_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1,pusersIdx);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					int pusersId = this.rs.getInt(2);
					int jobPostingId = this.rs.getInt(3);
					
					scrap = new Scrap(pusersId,jobPostingId);					
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
					int pusersId = this.rs.getInt(2);
					int jobPostingId = this.rs.getInt(3);
					
					Scrap scrap = new Scrap(pusersId,jobPostingId);
					
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
}
