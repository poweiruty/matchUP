package model.review;

import java.sql.Timestamp;

public class Review {
	private int review_id;
	private int pusers_id;
	private String corp_name;
	private int star;
	private String summary;
	private String review;
	private String position;
	private String period;
	private Timestamp review_created;
	private Timestamp review_modified;
	
	public Review(int pusersId, String corpName,int star,String summary, String review, 
				  String position, String period) {
		this.pusers_id=pusersId;
		this.corp_name=corpName;
		this.star=star;
		this.summary=summary;
		this.review=review;	
		this.position=position;
		this.period=period;
	}
	
	public Review(int reviewId, int pusersId, String corpName, int star, String summary,
			String review, String position, String period) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_name=corpName;
		this.star=star;
		this.summary=summary;
		this.review=review;
		this.position=position;
		this.period=period;		
	}
	
	public Review(int reviewId, int pusersId, String corpName, int star, String summary,
			String review, String position, String period,
			Timestamp reviewCreatedNum, Timestamp reviewModifiedNum) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_name=corpName;
		this.star=star;
		this.summary=summary;
		this.review=review;
		this.position=position;
		this.period=period;
		this.review_created=reviewCreatedNum;
		this.review_modified=reviewModifiedNum;
	}
	
	
	// Getter	
	public int getReviewId() {
		return review_id;
	}
	
	public int getPusersId() {
		return pusers_id;
	}
	
	public String getCorpName() {
		return corp_name;
	}
	
	public int getStar() {
		return star;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getReview() {
		return review;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public Timestamp getCreated() {
		return review_created;
	}
	
	public Timestamp getModified() {
		return review_modified;
	}
	
	/*
	 * @Override public String toString() { return String.format(
	 * "리뷰 인덱스:%d\n개인유저 인덱스:%d \n기업정보 인덱스:%d \n별점:%d \n리뷰:%s \n작성시간:%d \n수정시간:%d\n",
	 * this.review_id,this.pusers_id,this.corp_id,this.star,this.review,this.created
	 * ,this.updated); }
	 */
}
