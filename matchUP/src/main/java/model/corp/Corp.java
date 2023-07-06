package model.corp;

public class Corp {
	private String cid;
	private int staffs;
	private String ceo;
	
	public Corp(String cid,  int staffs, String ceo) {
		this.cid = cid;
		this.staffs = staffs;
		this.ceo = ceo;
	}

	public String getCid() {
		return this.cid;
	}
	
	public int getStaffs() {
		return this.staffs;
	}

	public String getCeo() {
		return this.ceo;
	}
	
	@Override
	public String toString() {	
		return String.format("cid : %s\nstaffs : %d\nceo : %s", this.cid, this.staffs, this.ceo);
	}	
	
}
