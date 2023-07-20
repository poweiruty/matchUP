package model.region;

import java.sql.*;
import java.util.*;

import util.DBManager;

public class RegionDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private RegionDao() {
	}

	private static RegionDao instance = new RegionDao();

	public static RegionDao getInstance() {
		return instance;
	}

	// 광역자치 Read
	public MainRegion getMainRegion(String mainRegion) {
		MainRegion mainRegions = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from main_region_tb where main_region=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, mainRegion);
				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					String mRegion = this.rs.getString(2);
					mainRegions = new MainRegion(mRegion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return mainRegions;
	}
	
	// 광역자치 Read
	public MainRegion getMainRegion(int mainRegion) {
		MainRegion mainRegions = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from main_region_tb where main_region_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, mainRegion);
				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					String mRegion = this.rs.getString(2);
					mainRegions = new MainRegion(mRegion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return mainRegions;
	}
	
	public ArrayList<MainRegion> getMainRegionAll() {
		ArrayList<MainRegion> list = new ArrayList<MainRegion>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from main_region_tb";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
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

	// 지역자치 Read
	public SemiRegion getSemiRegion(String semiRegion) {
		SemiRegion semiRegions = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from semi_region_tb where semi_region=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, semiRegion);
				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					int mRegionId = this.rs.getInt(2);
					String sRegion = this.rs.getString(3);
					semiRegions = new SemiRegion(mRegionId, sRegion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return semiRegions;
	}
	// 지역자치 Read
	public SemiRegion getSemiRegion(int semiRegion) {
		SemiRegion semiRegions = null;

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from semi_region_tb where semi_region_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, semiRegion);
				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					int mRegionId = this.rs.getInt(2);
					String sRegion = this.rs.getString(3);
					semiRegions = new SemiRegion(mRegionId, sRegion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return semiRegions;
	}
	public ArrayList<SemiRegion> getSemiRegionAll() {
		ArrayList<SemiRegion> list = new ArrayList<SemiRegion>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "select * from semi_region_tb";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int mainRegionId = this.rs.getInt(2);
					String semiRegion = this.rs.getString(3);

					SemiRegion semiRegions = new SemiRegion(mainRegionId, semiRegion);

					list.add(semiRegions);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return list;
	}

	public ArrayList<SemiRegion> getSemibyMain(String main) {
		ArrayList<SemiRegion> list = new ArrayList<SemiRegion>();	
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql="select semi_region from semi_region_tb semi join main_region_tb main on semi.main_region_id = main.main_region_id where main.main_region=? group by semi.semi_region order by semi.semi_region_id ASC";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, main);
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				String semi_region = this.rs.getString("semi_region");
    				
    				SemiRegion semi = new SemiRegion(semi_region);
    				list.add(semi);
    			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}			
		}
		return list;
	}

//		public ArrayList<MainRegion> getMainbySearch(String region) {
//			ArrayList<MainRegion> list = new ArrayList<MainRegion>();
//			this.conn = DBManager.getConnection();
//
//			if (this.conn != null) {
//				String sql = "SELECT * FROM main_region_tb WHERE main_region LIKE ?";
//				try {
//					this.pstmt = this.conn.prepareStatement(sql);
//					this.pstmt.setString(1, "%" + region + "%");
//					this.rs = this.pstmt.executeQuery();
//
//					while (this.rs.next()) {
//						String rid = this.rs.getString(1);
//				
//
//						MainRegion mRegion = new MainRegion(rid);
//						list.add(mRegion);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					DBManager.close(this.conn, this.pstmt, this.rs);
//				}
//			}
//
//			return list;
//		}



	

}