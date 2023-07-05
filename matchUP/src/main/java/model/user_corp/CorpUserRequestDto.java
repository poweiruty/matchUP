package model.user_corp;

public class CorpUserRequestDto {
	private String cid;
	private String cpassword;
	private String cname;
	private int cnum;
	private String mgr_name;
	private int mgr_tel;
	private String mgr_email;
	private String caddress;
	
	public CorpUserRequestDto(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
	}
	public CorpUserRequestDto(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel,
			String mgr_email) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.mgr_email = mgr_email;
	}
	public CorpUserRequestDto(String cid, String cpassword, String cname, int cnum, String mgr_name, int mgr_tel, String mgr_email,
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
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getMgr_name() {
		return mgr_name;
	}
	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}
	public int getMgr_tel() {
		return mgr_tel;
	}
	public void setMgr_tel(int mgr_tel) {
		this.mgr_tel = mgr_tel;
	}
	public String getMgr_email() {
		return mgr_email;
	}
	public void setMgr_email(String mgr_email) {
		this.mgr_email = mgr_email;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	


}
