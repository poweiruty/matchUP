package model.user;

public class User {
	private String pid;
	private String ppassword;
	private String pname;
	private int birth;
	private String tel;
	private String email;
	private String user_address;
	
	public User(String pid, String ppassword, String pname, int birth, String tel) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
	}
	public User(String pid, String ppassword, String pname, int birth, String tel, String email) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
	}
	public User(String pid, String ppassword, String pname, int birth, String tel, String email,
			String user_address) {		
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		this.user_address = user_address;
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
	
	@Override
	public String toString() {
		return String.format("id : %s\npassword : %s\nname; : %s\nbirth : %d\ntel : %s\nemail : %s\naddress : %s", this.pid, this.ppassword, this.pname, this.birth, this.tel, this.email, this.user_address);
	}
	
}	
