package model.user_corp;

public class CorpUser {
	private String cid;
	private String cpassword;
	private String cname;
	private int cnum;
	private String mgr_name;
	private String mgr_tel;
	private String mgr_email;
	private String caddress;
	private int emailChk;
	
	
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, String mgr_tel) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
	}
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, String mgr_tel,
			String mgr_email) {
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.mgr_email = mgr_email;
	}
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, String mgr_tel, String mgr_email,
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
	public CorpUser(String cid, String cpassword, String cname, int cnum, String mgr_name, String mgr_tel,
			String mgr_email, String caddress, int emailChk) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cnum = cnum;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
		this.mgr_email = mgr_email;
		this.caddress = caddress;
		this.emailChk = emailChk;
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
	public String getMgr_tel() {
		return mgr_tel;
	}
	public String getMgr_email() {
		return mgr_email;
	}
	public String getCaddress() {
		return caddress;
	}	
	public int getEmailChk() {
		return emailChk;
	}
	@Override
	public String toString() {
		return "CorpUser [cid=" + cid + ", cpassword=" + cpassword + ", cname=" + cname + ", cnum=" + cnum
				+ ", mgr_name=" + mgr_name + ", mgr_tel=" + mgr_tel + ", mgr_email=" + mgr_email + ", caddress="
				+ caddress + ", emailChk=" + emailChk + "]";
	}


}
