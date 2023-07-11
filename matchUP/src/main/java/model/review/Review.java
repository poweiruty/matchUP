package model.review;

public class Review {
	private int review_id;
	private int pusers_id;
	private int corp_id;
	private int star;
	private String review;
	private int created;
	private int updated;
	
	public Review(int pusersId, int corpId,int star,String review) {
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.review=review;	
	}
	
	public Review(int reviewId, int pusersId, int corpId, int star, 
				  String review, int created, int updated) {
		this.review_id=reviewId;
		this.pusers_id=pusersId;
		this.corp_id=corpId;
		this.star=star;
		this.review=review;
		this.created=created;
		this.updated=updated;
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
	public String getReview() {
		return review;
	}
	public int getCreated() {
		return created;
	}
	public int getUpdated() {
		return updated;
	}


	@Override
	public String toString() {	
		return String.format(
				"리뷰 인덱스:%d\n개인유저 인덱스:%d \n기업정보 인덱스:%d \n별점:%d \n리뷰:%s \n작성시간:%d \n수정시간:%d\n",
				this.review_id,this.pusers_id,this.corp_id,this.star,this.review,this.created,this.updated);
	}
}
