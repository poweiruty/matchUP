package model.corp;

public class CorpRequestDto {
	private String cid;
	private int staffs;
	private String ceo;
	
	public CorpRequestDto(String cid, int staffs, String ceo) {
		this.cid = cid;
		this.staffs = staffs;
		this.ceo = ceo;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getStaffs() {
		return staffs;
	}
	public void setStaffs(int staffs) {
		this.staffs = staffs;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}	
}
