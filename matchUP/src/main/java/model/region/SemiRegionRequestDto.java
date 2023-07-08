// 지역자치

package model.region;

public class SemiRegionRequestDto {
	private String main_region;
	
	// Constructor
	public SemiRegionRequestDto(String mainRegion){
		this.main_region=mainRegion;
	}

	// Getter, Setter
	public String getMain_region() {
		return main_region;
	}

	public void setMain_region(String main_region) {
		this.main_region = main_region;
	}
	
}
