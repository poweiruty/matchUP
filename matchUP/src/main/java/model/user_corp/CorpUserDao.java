package model.user_corp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class CorpUserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CorpUserDao() {	}

	private static CorpUserDao instance = new CorpUserDao();

	public static CorpUserDao getInstance() {
		return instance;
	}

	public boolean createCorpUser(CorpUserRequestDto dto) {
		CorpUser dupl = getCorpUserbyId(dto.getCid());
		if (dupl != null)
			return false;

		String id = dto.getCid();
		String password = dto.getCpassword();
		String name = dto.getCname();
		int num = dto.getCnum();
		String mgr_name = dto.getMgr_name();
		int mgr_tel = dto.getMgr_tel();
		String mgr_email = dto.getMgr_email();
		String address = dto.getCaddress();

		boolean check = true;

		if (id != null && password != null && name != null && num != 0 && mgr_tel != 0) {
			this.conn = DBManager.getConnection();
			if (this.conn != null) {
				if (!mgr_email.equals("") && address.equals("")) {
					String sql = "INSERT INTO cusers_tb (cid, cpassword, cname, cnum, mgr_name, mgr_tel, mgr_email) VALUES(?,?,?,?,?,?,?)";

					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, num);
						this.pstmt.setString(5, mgr_name);
						this.pstmt.setInt(6, mgr_tel);
						this.pstmt.setString(7, mgr_email);

						this.pstmt.execute();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(this.conn, this.pstmt);
					}
				} else if (!address.equals("") && mgr_email.equals("")) {
					String sql = "INSERT INTO cusers_tb (cid, cpassword, cname, cnum, mgr_name, mgr_tel, caddress) VALUES(?,?,?,?,?,?,?)";

					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, num);
						this.pstmt.setString(5, mgr_name);
						this.pstmt.setInt(6, mgr_tel);
						this.pstmt.setString(7, address);

						this.pstmt.execute();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(this.conn, this.pstmt);
					}
				} else {
					String sql = "INSERT INTO cusers_tb VALUES(?,?,?,?,?,?,?,?)";

					try {
						this.pstmt = this.conn.prepareStatement(sql);
						this.pstmt.setString(1, id);
						this.pstmt.setString(2, password);
						this.pstmt.setString(3, name);
						this.pstmt.setInt(4, num);
						this.pstmt.setString(5, mgr_name);
						this.pstmt.setInt(6, mgr_tel);
						this.pstmt.setString(7, mgr_email);
						this.pstmt.setString(8, address);

						this.pstmt.execute();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(this.conn, this.pstmt);
					}
				}
			} else {
				check = false;
			}
		} else {
			check = false;
		}
		return check;
	}

	public CorpUser getCorpUserbyId(String cid) {
		CorpUser corp = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM cusers_tb WHERE cid=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, cid);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					int num = this.rs.getInt(4);
					String mgr_name = this.rs.getString(5);
					int mgr_tel = this.rs.getInt(6);
					String mgr_email = this.rs.getString(7);
					String address = this.rs.getString(8);

					corp = new CorpUser(cid, password, name, num, mgr_name, mgr_tel, mgr_email, address);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return corp;
	}

	public ArrayList<CorpUser> getCorpUserAll() {
		ArrayList<CorpUser> list = new ArrayList<>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM cusers_tb";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String id = this.rs.getString(1);
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					int num = this.rs.getInt(4);
					String mgr_name = this.rs.getString(5);
					int mgr_tel = this.rs.getInt(6);
					String mgr_email = this.rs.getString(7);
					String address = this.rs.getString(8);

					CorpUser corp = new CorpUser(id, password, name, num, mgr_name, mgr_tel, mgr_email, address);

					list.add(corp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	// 비밀번호, 담당자 요소3개, 회사주소
	public void updateCorpUser(CorpUserRequestDto dto, String cpassword) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "UPDATE cusers_tb SET cpassword=?, mgr_name=? WHERE cid=? AND cpassword=?";
			CorpUser cuser = getCorpUserbyId(dto.getCid());			
			try {				
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, cuser.getCpassword());				
				this.pstmt.setString(2, dto.getMgr_name());			
				this.pstmt.setString(3, dto.getCid());
				this.pstmt.setString(4, cpassword);
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}
	
	public boolean deleteCorpUser(String id, String password) {

		this.conn = DBManager.getConnection();
		boolean check = true;

		if (this.conn != null) {
			String sql = "DELETE FORM cusers_tb WHERE cid=? AND cpassword=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.pstmt.setString(2, password);

				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
				check = false;
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		} else {
			check = false;
		}

		return check;
	}

}
