// 지역자치

package model.region;

public class SemiRegion {
	private int main_region_id;
	private String semi_region;
	
	// Constructor
	public SemiRegion(String semiRegion) {
		this.semi_region=semiRegion;
	}
	public SemiRegion(int mainRegionId, String semiRegion) {
		this.main_region_id=mainRegionId;
		this.semi_region=semiRegion;
	}
	
	// Getter
	public int getMainRegionId() {
		return main_region_id;
	}
	
	public String getSemiRegion() {
		return semi_region;
	}
	
	@Override
	public String toString() {
		return String.format("Main Region ID : %d, Semi Region : %s", this.main_region_id, this.semi_region);
	}
}
