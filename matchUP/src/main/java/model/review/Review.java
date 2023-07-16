package model.review;

import java.sql.Timestamp;

public class Review {
	private int review_id;
	private int pusers_id;
	private int corp_id;
	private int star;
	private String summary;
	private String review;
	private String position;
	private String period;
	private Timestamp review_created;
	private Timestamp review_modified;
	private int review_created_num;
	private int review_modified_num;
	
	public Review(int pusersId, int corpId,int star,String summary, String review, 
				  String position, String period) {
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.summary=summary;
		this.review=review;	
		this.position=position;
		this.period=period;
	}
	
	public Review(int reviewId, int pusersId, int corpId, int star, String summary,
				  String review, String position, String period,
				  Timestamp reviewCreated, Timestamp reviewModified) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.summary=summary;
		this.review=review;
		this.position=position;
		this.period=period;
		this.review_created=reviewCreated;
		this.review_modified=reviewModified;
	}
	
	public Review(int reviewId, int pusersId, int corpId, int star, String summary,
			String review, String position, String period,
			int reviewCreatedNum, int reviewModifiedNum) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.summary=summary;
		this.review=review;
		this.position=position;
		this.period=period;
		this.review_created_num=reviewCreatedNum;
		this.review_modified_num=reviewModifiedNum;
	}
	
	
	// Getter	
	public int getReviewId() {
		return review_id;
	}
	
	public int getPusersId() {
		return pusers_id;
	}
	
	public int getCorpId() {
		return corp_id;
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
	
	public Timestamp getUpdated() {
		return review_modified;
	}
	
	public int getCreatedNum() {
		return review_created_num;
	}
	
	public int getModifiedNum() {
		return review_modified_num;
	}


	/*
	 * @Override public String toString() { return String.format(
	 * "리뷰 인덱스:%d\n개인유저 인덱스:%d \n기업정보 인덱스:%d \n별점:%d \n리뷰:%s \n작성시간:%d \n수정시간:%d\n",
	 * this.review_id,this.pusers_id,this.corp_id,this.star,this.review,this.created
	 * ,this.updated); }
	 */
}
