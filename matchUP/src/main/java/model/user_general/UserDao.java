package model.user_general;

import java.sql.Connection;
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
		if(dupl != null) 
			return false;
		
		String id = dto.getPid();
		String password = dto.getPpassword();
		String name = dto.getPname();
		int birth = dto.getBirth();
		int tel = dto.getTel();
		String email = dto.getEmail();
		String address = dto.getUser_address();
		
		boolean check = true;
		
		if(id != null && password != null && name != null && birth != 0 && tel != 0) {
			this.conn = DBManager.getConnection();
			if(this.conn != null) {
				if(!email.equals("") && address.equals("")) {
					String sql = "INSERT INTO pusers_tb (pid,ppassword,pname,birth,tel,email) VALUES(?, ?, ?, DATE(?), ?, ?)";
					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, birth);
						this.pstmt.setInt(5, tel);
						this.pstmt.setString(6, email);
						
						this.pstmt.execute();
						
					}catch (Exception e) {
						e.printStackTrace();					
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}else if(!address.equals("") && email.equals("")){
					String sql = "INSERT INTO pusers_tb (pid,ppassword,pname,birth,tel,user_address) VALUES(?, ?, ?, DATE(?), ?, ?)";
					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, birth);
						this.pstmt.setInt(5, tel);
						this.pstmt.setString(6, address);
						
						this.pstmt.execute();
						
					}catch (Exception e) {
						e.printStackTrace();					
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}else {
					String sql = "INSERT INTO pusers_tb VALUES(?, ?, ?, DATE(?), ?, ?, ?)";
					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, birth);
						this.pstmt.setInt(5, tel);
						this.pstmt.setString(6, email);
						this.pstmt.setString(7, address);
						
						this.pstmt.execute();
						
					}catch (Exception e) {
						e.printStackTrace();					
					}finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}
			}else {
				check = false;
			}
		}else {
			check = false;
		}
		
		return check;
	}
	
	public User getUserbyId(String id) {
		User user = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM pusers_tb WHERE pid = ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1,id);
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					Date birth = this.rs.getDate(4);
					int birthNum = Integer.parseInt(sdf.format(birth));
					int tel = this.rs.getInt(5);
					String email = this.rs.getString(6);
					String address = this.rs.getString(7);					
					
					user = new User(id, password, name, birthNum, tel, email, address);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		
		return user;
	}
	

	public ArrayList<User> getUserAll(){
		ArrayList<User> list = new ArrayList<User>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM pusers_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String id = this.rs.getString(1);
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					Date birth = this.rs.getDate(4);
					int birthNum = Integer.parseInt(sdf.format(birth));
					int tel = this.rs.getInt(5);
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
	
	
	public void updateUser(UserRequestDto dto, String password) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE pusers_tb SET ppassword=?, tel=?, email=?, user_address=? WHERE pid=? AND ppassword=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, dto.getPpassword());
				this.pstmt.setInt(2, dto.getTel());
				this.pstmt.setString(3, dto.getEmail());
				this.pstmt.setString(4, dto.getUser_address());
				this.pstmt.setString(5, dto.getPid());
				this.pstmt.setString(6, password);
				
				this.pstmt.execute();
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	
	/*
	public void updateUserPwd(UserRequestDto dto, String password) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE pusers_tb SET ppassword=? WHERE pid=? AND ppassword=?";			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, dto.getPpassword());
				this.pstmt.setString(2, dto.getPid());
				this.pstmt.setString(3, password);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	
	public void updateUserTel(UserRequestDto dto, String password) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE pusers_tb SET tel=? WHERE id=? AND ppassword=?";			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, dto.getTel());
				this.pstmt.setString(2, dto.getPid());
				this.pstmt.setString(3, password);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	
	public void updateUserEmail(UserRequestDto dto, String password) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE pusers_tb SET email=? WHERE id=?";			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, dto.getEmail());
				this.pstmt.setString(2, dto.getPid());
				this.pstmt.setString(3, password);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	public void updateUserAddress(UserRequestDto dto, String password) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {			
			String sql = "UPDATE pusers_tb SET user_address=? WHERE id=? AND ppassword=?";			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, dto.getUser_address());
				this.pstmt.setString(2, dto.getPid());		
				this.pstmt.setString(3, password);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	*/
	public boolean deleteUser(String id, String password) {
		this.conn = DBManager.getConnection();
		boolean check = true;
		
		if(this.conn != null) {
			String sql = "DELETE FROM pusers_tb WHERE pid=? AND ppassword=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.pstmt.setString(2, password);
				
				this.pstmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
				check = false;
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}else{
			check = false;
		}
		
		return check;
	}
}	
