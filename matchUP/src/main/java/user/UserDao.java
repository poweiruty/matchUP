package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.DBManager;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
	
	private UserDao() { }
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	public boolean createUser(UserRequestDto dto) {
		User dupl = getUserbyId(dto.getPid());
		
		return false;
	}
	
	public User getUserbyId(String pid) {
		User user = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "insert into puser_db";
		}
		
		return null;
	}
	

	public ArrayList<User> getUserAll(){
		ArrayList<User> list = new ArrayList<User>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM pusers_db";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String id = this.rs.getString(1);
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					Date birth = this.rs.getDate(4);
					int birthNum = Integer.parseInt(sdf.format(birth));
					String tel = this.rs.getString(5);
					String email = this.rs.getString(6);
					String address = this.rs.getString(7);
					
					User user = new User(id,password,name,birthNum,tel,email,address);
					
					list.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		
		return list;
	}
	
}	
