package model.region;

import java.sql.*;
import java.util.*;
import util.DBManager;

public class RegionDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private RegionDao() { }
	private static RegionDao instance = new RegionDao();
	public static RegionDao getInstance() {
		return instance;
	}
	
	public MainRegion getMainRegion(String mainRegion) {
		MainRegion mainRegions = null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from main_region_tb where main_region=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1,mainRegion);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					String mRegion = this.rs.getString(2);
					mainRegions = new MainRegion(mRegion);					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return mainRegions;
	}
	
	
	public ArrayList<MainRegion> getMainRegionAll(){
		ArrayList<MainRegion> list = new ArrayList<MainRegion>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql="select * from main_region_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String mainRegion = this.rs.getString(2);
					
					MainRegion mainRegions = new MainRegion(mainRegion);
					
					list.add(mainRegions);
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
