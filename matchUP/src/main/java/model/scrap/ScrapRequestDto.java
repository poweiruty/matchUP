package model.scrap;

public class ScrapRequestDto {
	private int scrap_id;
	private int pusers_id;
	private int post_id;
	
	// Constructor
	public ScrapRequestDto(int pusersId, int postId) {
		this.pusers_id=pusersId;
		this.post_id=postId;
	}
	public ScrapRequestDto(int scrapId, int pusersId, int postId) {
		this.scrap_id=scrapId;
		this.pusers_id=pusersId;
		this.post_id=postId;
	}
	
	// Getter / Setter
	public int getScrapId() {
		return scrap_id;
	}

	public void setScrapId(int scrapId) {
		this.scrap_id = scrapId;
	}
	
	public int getPusersId() {
		return pusers_id;
	}

	public void setPusersId(int pusersId) {
		this.pusers_id = pusersId;
	}

	public int getPostId() {
		return post_id;
	}

	public void setPostId(int postId) {
		this.post_id = postId;
	}
}
