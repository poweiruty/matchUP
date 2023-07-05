package model.corp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class CorpDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CorpDao() {}
	private static CorpDao instance = new CorpDao();
	public static CorpDao getInstance() {
		return instance;
	}
	
	// create
	public boolean createCorp(CorpRequestDto dto) {
		Corp corp = getCorpbyId(dto.getCid());
		
		if(corp != null)
			return false;
		
		String cid = dto.getCid();
		int staffs = dto.getStaffs();
		String ceo = dto.getCeo(); 
		
		boolean check = true;
			
		if(cid != null && staffs != 0 && ceo != null) {
			this.conn = DBManager.getConnection();
			if(this.conn != null) {
				String sql = "INSERT INTO corporation_tb(cid,staffs,ceo) VALUES(?,?,?) ";
				try {
					this.pstmt = this.conn.prepareStatement(sql);
					this.pstmt.setString(1,cid);
					this.pstmt.setInt(2, staffs);
					this.pstmt.setString(3, ceo);
					
					this.pstmt.execute();
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(this.conn, this.pstmt);
				}
			}else {
				check = false;
			}
		}else {
			check = false;
		}
		return check;
	}

	
	// read
	public Corp getCorpbyId(String cid) {
		Corp corp = null;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT * FROM corporation_tb WHERE cid=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, cid);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int staffs = this.rs.getInt(2);
					String ceo = this.rs.getString(3);
					
					corp = new Corp(cid, staffs, ceo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}	
		return corp;
	}
	
	public ArrayList<Corp> getCorpAll(){
		ArrayList<Corp> list = new ArrayList<Corp>();
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM corporation_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String cid = this.rs.getString(2);
					int staffs = this.rs.getInt(3);
					String ceo = this.rs.getString(4);
					
					Corp corp = new Corp(cid, staffs, ceo);
					
					list.add(corp);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return list;
	}
	
	// update
	public void updateCorp() {
		
	}
	// delete
	public void deleteCorp() {
		
	}
 }


















