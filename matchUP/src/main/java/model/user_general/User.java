package model.user_general;

public class User {
	private String pid;
	private String ppassword;
	private String pname;
	private int birth;
	private String tel;
	private String email;
	private String user_address;
	private int emailCheck;
	
	public User(String pid, String ppassword, String pname, int birth, String tel, int emailCheck) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.emailCheck = emailCheck;
	}
	public User(String pid, String ppassword, String pname, int birth, String tel, String email, int emailCheck) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		this.emailCheck = emailCheck;
	}
	public User(String pid, String ppassword, String pname, int birth, String tel, String email,
			String user_address, int emailCheck) {		
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		this.user_address = user_address;
		this.emailCheck = emailCheck;
	}
	public String getPid() {
		return pid;
	}
	public String getPpassword() {
		return ppassword;
	}
	public String getPname() {
		return pname;
	}
	public int getBirth() {
		return birth;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	public String getUser_address() {
		return user_address;
	}	
	public int getEmailCheck() {
		return emailCheck;
	}
	
	@Override
	public String toString() {
		return String.format("id : %s\npassword : %s\nname; : %s\nbirth : %d\ntel : %s\nemail : %s\naddress : %s\nemailChk : %d", this.pid, this.ppassword, this.pname, this.birth, this.tel, this.email, this.user_address, this.emailCheck);
	}
	
}	
