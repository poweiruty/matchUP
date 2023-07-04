package model.corp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.user.UserRequestDto;
import util.DBManager;


public class CorpDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	private CorpDao() { }
	private static CorpDao instance = new CorpDao();
	public static CorpDao getInstance() {
		return instance;
	}
	
	public boolean createCorp(CorpRequestDto dto) {
		Corp dupl = getCorpbyId(dto.getCid());
		if(dupl != null)
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
		
		if(id != null && password != null && name != null && num != 0 && mgr_tel != 0) {
			this.conn = DBManager.getConnection();
			if(this.conn != null) {
				if(!mgr_email.equals("") && address.equals("")) {
					
				}
			}
		}
		return check;
	}

	public Corp getCorpbyId(String pid) {
		return null;
	}
	
	
}
