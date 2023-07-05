package model.user_corp;

public class CorpUser {
	private String cid;
	private String cpassword;
	private String cname;
	private int cnum;
	private String mgr_name;
	private int mgr_tel;
	private String mgr_email;
	private String caddress;
	
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
	}
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel,
			String mgr_email) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.mgr_email = mgr_email;
	}
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel, String mgr_email,
			String caddress) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.mgr_email = mgr_email;
		this.caddress = caddress;
	}
	public String getCid() {
		return cid;
	}
	public String getCpassword() {
		return cpassword;
	}
	public String getCname() {
		return cname;
	}
	public int getCnum() {
		return cnum;
	}
	public String getMgr_name() {
		return mgr_name;
	}
	public int getMgr_tel() {
		return mgr_tel;
	}
	public String getMgr_email() {
		return mgr_email;
	}
	public String getCaddress() {
		return caddress;
	}
	
	@Override
	public String toString() {	
		return String.format("id : %s\npassword : %s\nname; : %s\nnum : %d\nmgr_name : %s\nmgr_tel : %d\nmgr_email : %s\naddress : %s", this.cid, this.cpassword, this.cname, this.cnum,this.mgr_name, this.mgr_tel, this.mgr_email, this.caddress);
	}
}
