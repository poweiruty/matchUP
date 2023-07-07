package model.region;

import java.sql.*;
import java.util.*;
import util.DBManager;


public class RegionDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private RegionDao(){}
	private static RegionDao instance=new RegionDao();
	public static RegionDao getInstance() {
		return instance;
	}
	
	// Read Main Region
	public Region getMainRegion(String Mr) {
		Region region=null;
		
		this.conn=DBManager.getConnection();
		if(this.conn!=null) {
			String sql="select * from main_region_tb where main_region=?";
			
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setString(1, Mr);
				this.rs=this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					String temp = this.rs.getString(2);
					
					region = new Region(temp);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt ,this.rs);
			}
		}
		
		return region;
	}
	
	public ArrayList<Region> getMainRegionAll(){
		ArrayList<Region> list=new ArrayList<Region>();
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="SELECT * FROM main_region_tb";
			
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.rs=this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String MainRegion=this.rs.getString(2);
					
					Region region=new Region(MainRegion);
					
					list.add(region);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return list;
	}
	
	// Create Semi Region : main_region 중복 부분 어찌해야할지 생각
		public boolean createSemiRegion(RegionRequestDto dto) {
			RegionDao regionDao=RegionDao.getInstance();
			Region region=regionDao.getMainRegion(dto.getSemi_region());
			
			if(region != null) {
				return false;
			} 
			
			int MrID=dto.getMain_region_id();
			String semiRegion=dto.getSemi_region();
			
			boolean check=true;
			
			if(MrID !=0 && semiRegion !=null) {
				this.conn=DBManager.getConnection();
				
				if(this.conn!=null) {
					String sql = "INSERT INTO resume(main_region_id,semi_region) VALUES(?,?)";			
					
					try{
						this.pstmt=this.conn.prepareStatement(sql);
						this.pstmt.setInt(1, MrID);
						this.pstmt.setString(2, semiRegion);
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}else {
					check=false;
				}
			}else {
				check=false;
			}
			return check;
		}	
	
	
	// Read Semi Region
	public Region getSemiRegion(String semiRegion) {
		Region region=null;
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from semi_region_tb JOIN main_region_tb ON semi_region_tb.main_region_id = main_region_tb.main_region_id WHERE main_region_tb.main_region_id=?";
			
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setString(3, semiRegion);
				this.rs=this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int mrId=this.rs.getInt(2);
				
					region=new Region(mrId, semiRegion);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt ,this.rs);
			}
		}
		return region;
	}
	
	public ArrayList<Region> getSemiRegionAll(){
		ArrayList<Region> list=new ArrayList<Region>();
		
		this.conn=DBManager.getConnection();
		
		if(this.conn!=null) {
			String sql="select * from semi_region_tb";
			
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.rs=this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int MainRegionId=this.rs.getInt(2);
					String SemiRegion=this.rs.getString(3);
					
					Region region=new Region(MainRegionId, SemiRegion);
					
					list.add(region);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return list;
	}

	// delete
	public boolean deleteSemiRegion(String semiRegion) {
		Region region = getSemiRegion(semiRegion);
		
		if(region.getSemi_region() !=null) {
			return false;
		}
		
		this.conn = DBManager.getConnection();
		boolean check = true;
			
		if(this.conn != null) {
			String sql = "delete from semi_region_tb where semi_region=?";
			try {
				this.pstmt=this.conn.prepareStatement(sql);
				this.pstmt.setString(1, semiRegion);				
					
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
