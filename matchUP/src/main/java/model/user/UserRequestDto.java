package model.user;

public class UserRequestDto {
	private String pid;
	private String ppassword;
	private String pname;
	private int birth;
	private String tel;
	private String email;
	private String user_address;

	public UserRequestDto(String pid, String ppassword, String pname, int birth, String tel) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
	}

	public UserRequestDto(String pid, String ppassword, String pname, int birth, String tel, String email) {
		this.pid = pid;
		this.ppassword = ppassword;
		this.pname = pname;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
	}

	public UserRequestDto(String pid, String ppassword, String pname, int birth, String tel, String email,
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
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPpassword() {
		return this.ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getBirth() {
		return this.birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_address() {
		return this.user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
}
