package model.review;

import java.sql.Timestamp;

public class ReviewRequestDto {
	private int reviewId;
	private int pusersId;
	private String corpName;
	private int star;
	private String summary;
	private String review;
	private String position;
	private String period;
	private Timestamp review_created;
	private Timestamp review_modified;

	public ReviewRequestDto(int reviewId, String corpName, int star, String summary, String con, String position,
			String period) {
		this.reviewId = reviewId;
		this.corpName = corpName;
		this.star = star;
		this.summary = summary;
		this.review = con;
		this.position = position;
		this.period = period;
	}

	public ReviewRequestDto(int reviewId, int pusersId, String corpName, int star, String summary, String review,
			String position, String period, Timestamp reviewCreatedNum, Timestamp reviewModifiedNum) {
		this.reviewId = reviewId;
		this.pusersId = pusersId;
		this.corpName = corpName;
		this.star = star;
		this.summary = summary;
		this.review = review;
		this.position = position;
		this.period = period;
		this.review_created = reviewCreatedNum;
		this.review_modified = reviewModifiedNum;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getPusersId() {
		return pusersId;
	}

	public void setPusersId(int pusersId) {
		this.pusersId = pusersId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
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

	public Timestamp getReviewModified() {
		return review_modified;
	}

	public void setReviewModified(Timestamp reviewModified) {
		this.review_modified = reviewModified;
	}
}