package model.review;

public class ReviewRequestDto {
	private int review_id;
	private int pusers_id;
	private int corp_id;
	private int star;
	private String review;
	private int created;
	private int updated;
	
	public ReviewRequestDto(int pusersId, int corpId,int star,String review) {
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.review=review;	
	}
	
	public ReviewRequestDto(int reviewId, int pusersId, int corpId, int star, 
				  String review, int created, int updated) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.review=review;
		this.created=created;
		this.updated=updated;
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

	public void setCorp_id(int corpId) {
		this.corp_id = corpId;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public int getUpdated() {
		return updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}
}
