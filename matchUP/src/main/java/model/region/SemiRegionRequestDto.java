// 지역자치

package model.region;

public class SemiRegionRequestDto {
	private int main_region_id;
	private String semi_region;
	
	// Constructor
	public SemiRegionRequestDto(int mainRegionId, String semiRegion){
		this.main_region_id = mainRegionId;
		this.semi_region = semiRegion;
	}

	// Getter, Setter
	public int getMain_region_id() {
		return main_region_id;
	}

	public void setMain_region_id(int mainRegionId) {
		this.main_region_id = mainRegionId;
	}
	
	public String getSemi_region() {
		return semi_region;
	}

	public void setSemi_region(String semiRegion) {
		this.semi_region=semiRegion;
	}
	
}
