// 광역자치

package model.region;

public class MainRegion {
	private String main_region;
	
	public MainRegion(String mainRegion) {
		this.main_region=mainRegion;
	}
	
	// getter 
	public String getMainRegion() {
		return main_region;
	}
	
	@Override
	public String toString() {
		return String.format("Main Region : %s",this.main_region);
	}	
}
