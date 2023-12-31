package model.scrap;

public class Scrap {
	private int scrap_id;
	private int pusers_id;
	private int post_id;
	
	public Scrap(int pusersId, int postId) {
		this.pusers_id=pusersId;
		this.post_id=postId;
	}
	public Scrap(int scrapId, int pusersId, int postId) {
		this.scrap_id=scrapId;
		this.pusers_id=pusersId;
		this.post_id=postId;
	}

	// getter
	public int getScrapId() {
		return scrap_id;
	}
	public int getPusersId() {
		return pusers_id;
	}

	public int getPostId() {
		return post_id;
	}

	@Override
	public String toString() {	
		return String.format("회원인덱스:%d \n채용공고인덱스:%d",this.pusers_id,this.post_id);
	}
	
}
