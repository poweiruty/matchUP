package model.corp;

public class Corp {
	private String cid;
	private int staffs;
	private String ceo;
	private int corp_id;
	
	
	public Corp(String cid,  int staffs, String ceo, int corp_id) {
		this.cid = cid;
		this.staffs = staffs;
		this.ceo = ceo;
		this.corp_id = corp_id;
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

	public int getCorp_id() {
		return this.corp_id;
	}
	
	@Override
	public String toString() {	
		return String.format("cid : %s\nstaffs : %d\nceo : %s", this.cid, this.staffs, this.ceo);
	}	
	
}
