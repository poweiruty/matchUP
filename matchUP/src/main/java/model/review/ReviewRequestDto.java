package model.review;

import java.sql.Timestamp;

public class ReviewRequestDto {
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
	
	public ReviewRequestDto(int pusersId, int corpId,int star,String summary, String review, 
			  String position, String period) {
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.summary=summary;
		this.review=review;	
		this.position=position;
		this.period=period;
	}
	
	public ReviewRequestDto(int reviewId, int pusersId, int corpId, int star, String summary,
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
	
	public ReviewRequestDto(int reviewId, int pusersId, int corpId, int star, String summary,
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

	public int getReviewId() {
		return review_id;
	}
	public void setReviewId(int reviewId) {
		this.review_id = reviewId;
	}

	public int getPusersId() {
		return pusers_id;
	}

	public void setPusersId(int pusersId) {
		this.pusers_id = pusersId;
	}

	public int getCorpId() {
		return corp_id;
	}

	public void setCorpId(int corpId) {
		this.corp_id = corpId;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	
	public Timestamp getReviewCreated() {
		return review_created;
	}
	public void setReviewCreated(Timestamp reviewCreated) {
		this.review_created = reviewCreated;
	}	
	public int getReviewCreatedNum() {
		return review_created_num;
	}
	public void setReviewCreatedNum(int reviewCreatedNum) {
		this.review_created_num = reviewCreatedNum;
	}

	
	public Timestamp getReviewModified() {
		return review_modified;
	}
	public void setReviewModified(Timestamp reviewModified) {
		this.review_modified = reviewModified;
	}	
	public int getReviewModifiedNum() {
		return review_modified_num;
	}	
	public void setReviewModifiedNum(int reviewModifiedNum) {
		this.review_modified_num = reviewModifiedNum;
	}

	
}
