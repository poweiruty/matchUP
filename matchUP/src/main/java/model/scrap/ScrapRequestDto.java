package model.scrap;

public class ScrapRequestDto {
	private int pusers_id;
	private int post_id;
	
	// Constructor
	public ScrapRequestDto(int pusersId, int postId) {
		this.pusers_id=pusersId;
		this.post_id=postId;
	}
	
	// Getter / Setter
	public int getPusersId() {
		return pusers_id;
	}

	public void setPusersId(int pusers_id) {
		this.pusers_id = pusers_id;
	}

	public int getPostId() {
		return post_id;
	}

	public void setPostId(int post_id) {
		this.post_id = post_id;
	}
}
