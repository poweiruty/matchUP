package model.corp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.user_corp.CorpUser;
import model.user_corp.CorpUserDao;
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
		CorpUserDao cuserDao = CorpUserDao.getInstance();		
		CorpUser cuser = cuserDao.getCorpUserbyId(dto.getCid());
		Corp dupl = getCorpbyId(dto.getCid());
		
		if(cuser == null || dupl != null)
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
			String sql = "SELECT corporation_tb.* FROM corporation_tb JOIN cusers_tb ON corporation_tb.cid = cusers_tb.cid WHERE corporation_tb.cid=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, cid);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {					
					int staffs = this.rs.getInt(4);
					String ceo = this.rs.getString(5);
					
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
	
	// update staffs, ceo
	public boolean updateCorp(CorpRequestDto dto, String cpassword) {
		CorpUserDao cuserDao = CorpUserDao.getInstance();		
		CorpUser cuser = cuserDao.getCorpUserbyId(dto.getCid());
		Corp corp = getCorpbyId(dto.getCid());		
		this.conn = DBManager.getConnection();
		
		if(cuser == null) {
			return false;
		}
		
		boolean check = true;
		if(this.conn != null) {
			String sql = "UPDATE corporation_tb b JOIN cusers_tb a ON b.cid = a.cid SET b.staffs=?, b.ceo=? WHERE b.cid=? AND a.cpassword=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				if(corp.getStaffs() == dto.getStaffs()) {
					this.pstmt.setInt(1, corp.getStaffs());
				}else {
					this.pstmt.setInt(1, dto.getStaffs());
				}
				
				if(corp.getCeo().equals(dto.getCeo())){
					this.pstmt.setString(2, corp.getCeo());
				}else {
					this.pstmt.setString(2, dto.getCeo());
				}
			
				this.pstmt.setString(3, dto.getCid());
				this.pstmt.setString(4, cpassword);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}else {
			check = false;
		}
		
		return check;
	}
	// delete
	public boolean deleteCorp(String cid, String cpassword) {
		CorpUserDao cuserDao = CorpUserDao.getInstance();
		CorpUser cuser = cuserDao.getCorpUserbyId(cid);
		
		if(!cuser.getCpassword().equals(cpassword)) {
			return false;
		}
		
		this.conn = DBManager.getConnection();
		boolean check = true;
		
		if(this.conn != null) {
			String sql = "DELETE b FROM corporation_tb b JOIN cusers_tb a ON b.cid=a.cid WHERE b.cid=? AND a.cpassword=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, cid);
				this.pstmt.setString(2, cpassword);				
				
				this.pstmt.execute();				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}else {
			check = false;
		}
		return check;
	}
 }


















