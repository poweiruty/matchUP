package model.region;

public class Region {
	// 광역자치
	private String main_region;
	
	// 지역자치
	private int main_region_id;
	private String semi_region;
	
	public Region(String mainRegion) {
		this.main_region=mainRegion;
	}
	public Region(int mainRegionID, String SemiRegion) {
		this.main_region_id=mainRegionID;
		this.semi_region=SemiRegion;
	}
	public Region(String mainRegion, int mainRegionID, String semiRegion) {
		this.main_region=mainRegion;
		this.main_region_id=mainRegionID;
		this.semi_region=semiRegion;
	}
	
	// getter 
	public String getMain_region() {
		return main_region;
	}
	public int getMain_region_id() {
		return main_region_id;
	}
	public String getSemi_region() {
		return semi_region;
	}
	
	@Override
	public String toString() {	
		return String.format("Main Region : %s", this.main_region);
	}
}
	


