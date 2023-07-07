package model.region;

public class RegionRequestDto {
	private String main_region;
	private int main_region_id;
	private String semi_region;
	
	public RegionRequestDto(String Mr) {
		this.main_region=main_region;
	}
	public RegionRequestDto(int MrId, String Sr) {
		this.main_region_id=main_region_id;
		this.semi_region=semi_region;
	}
	public RegionRequestDto(String Mr, int MrId, String Sr) {
		this.main_region=main_region;
		this.main_region_id=main_region_id;
		this.semi_region=semi_region;
	}
	public String getMain_region() {
		return main_region;
	}
	public void setMain_region(String main_region) {
		this.main_region = main_region;
	}
	
	// Getter / Setter
	public int getMain_region_id() {
		return main_region_id;
	}
	public void setMain_region_id(int main_region_id) {
		this.main_region_id = main_region_id;
	}
	public String getSemi_region() {
		return semi_region;
	}
	public void setSemi_region(String semi_region) {
		this.semi_region = semi_region;
	}
}
