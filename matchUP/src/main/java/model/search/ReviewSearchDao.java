package model.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.JobPost.JobPostDto;
import model.review.ReviewRequestDto;
import util.DBManager;

public class ReviewSearchDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private ReviewSearchDao() { }
	private static ReviewSearchDao instance = new ReviewSearchDao();
	public static ReviewSearchDao getInstance() {
		return instance;
	}
	
	public String getReviewbyCname(String job) {
		String cname = null;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select corp_name from review_tb where corp_name like ?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, "%" + job + "%");
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					cname = this.rs.getString("corp_name");					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}		
		return cname;
	}
	
	public ArrayList<ReviewRequestDto> getPostbyCname(String name) {
		ArrayList<ReviewRequestDto> list = new ArrayList<ReviewRequestDto>();
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "select * from review_tb where corp_name like ?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
    			this.pstmt.setString(1, "%" + name + "%");
    			this.rs = this.pstmt.executeQuery();
    			while(this.rs.next()) {
    				int reviewId = this.rs.getInt("review_id");
    				int puserId = this.rs.getInt("pusers_id");
    				String cname = this.rs.getString("corp_name");
    				int star = this.rs.getInt("star");
    				String summary = this.rs.getString("summary");
    				String review = this.rs.getString("review");
    				String position = this.rs.getString("position");
    				String period = this.rs.getString("period");    				
    				Timestamp createdReview = this.rs.getTimestamp("review_created");
    				Timestamp modifiedReview = this.rs.getTimestamp("review_modified");
    				    				
    				ReviewRequestDto reviews = new ReviewRequestDto(reviewId,puserId,cname,star,summary,review,position,period,createdReview,modifiedReview);
    				list.add(reviews);
    			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}			
		}
		
		return list;
	}
}