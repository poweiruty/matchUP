package model.review;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.review.ReviewRequestDto;
import util.DBManager;

public class ReviewDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");

	private ReviewDao() {}
	
	private static ReviewDao instance = new ReviewDao();
	public static ReviewDao getInstance() {
		return instance;
	}
	
	
	// CREATE
	public boolean createReview(ReviewRequestDto dto) {
					
		int pusersId = dto.getPusersId();
		int corpId=dto.getCorpId();
		int star=dto.getStar();
		String summary=dto.getSummary();
		String review=dto.getReview();
		String position=dto.getPosition();
		String period=dto.getPeriod();
			
		this.conn = DBManager.getConnection();
		
		String sql = "insert into review_tb(pusers_id,corp_id,star,summary,review,position,period) values(?,?,?,?,?,?,?)";			
			
		try{
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, pusersId);
			this.pstmt.setInt(2,corpId);
			this.pstmt.setInt(3, star);
			this.pstmt.setString(4, summary);
			this.pstmt.setString(5, review);
			this.pstmt.setString(6, position);
			this.pstmt.setString(7, period);
			
			this.pstmt.execute();
			
		}catch (Exception e) {
			System.out.println("데이터 추가성공");
			e.printStackTrace();
		}finally {
			DBManager.close(this.conn, this.pstmt);
		}
		return true;
	}
	
		
	// READ
	public Review getReviewByPusersId(int pusersIdx){
		Review reviews = null;
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from review_tb where pusers_id=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, pusersIdx);
				this.rs = this.pstmt.executeQuery();
				
				if(this.rs.next()) {
					int reviewId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int corpId = this.rs.getInt(3);
					int star = this.rs.getInt(4);
					String summary=this.rs.getString(5);
					String review = this.rs.getString(6);
					String position = this.rs.getString(7);
					String period = this.rs.getString(8);
					Timestamp created = this.rs.getTimestamp(9);
					int createdTime=Integer.parseInt(sdf.format(created));
					Timestamp updated =this.rs.getTimestamp(10); 
					int updatedTime=Integer.parseInt(sdf.format(updated));
					
					reviews = new Review(reviewId,pusersId,corpId,star,summary,review,position,period,createdTime,updatedTime);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return reviews;
	}
	
	public ArrayList<Review> getReviewAll(){
		ArrayList<Review> list = new ArrayList<Review>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "select * from review_tb";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int reviewId = this.rs.getInt(1);
					int pusersId = this.rs.getInt(2);
					int corpId = this.rs.getInt(3);
					int star = this.rs.getInt(4);
					String summary=this.rs.getString(5);
					String review = this.rs.getString(6);
					String position = this.rs.getString(7);
					String period = this.rs.getString(8);
					Timestamp created = this.rs.getTimestamp(9);
					int createdTime=Integer.parseInt(sdf.format(created));
					Timestamp updated =this.rs.getTimestamp(10); 
					int updatedTime=Integer.parseInt(sdf.format(updated));
					
					Review reviews = new Review(reviewId,pusersId,corpId,star,summary,review,position,period,createdTime,updatedTime);
					
					list.add(reviews);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return list;
	}
	

	// Update
	public void updateReview(ReviewRequestDto dto) {	
		this.conn = DBManager.getConnection();		
		if(this.conn != null) {			
			String sql = "update review_tb set corp_id=?,star=?,review=? where pusers_id=?";					
			 	
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
	            this.pstmt.setInt(1, dto.getCorpId());
	            this.pstmt.setInt(2, dto.getStar());
	            this.pstmt.setString(3, dto.getReview());
	            this.pstmt.setInt(4, dto.getPusersId());
	            
	            int rowsAffected = this.pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("리뷰 업데이트 성공");
	                System.out.println("확인 : "+rowsAffected);
	            } else {
	                System.out.println("리뷰 업데이트 실패");
	                System.out.println("확인 : "+rowsAffected);
	            }
	            
				System.out.println("데이터 수정 성공");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("데이터 수정 실패");
			}finally {
				DBManager.close(this.conn, this.pstmt);
			}			
		}
	}

	
	// DELETE
	public boolean deleteReview(int reviewId) {
		this.conn = DBManager.getConnection();
		boolean check = true;
		
		if(this.conn != null) {
			String sql = "delete from review_tb where review_id=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, reviewId);
				
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



