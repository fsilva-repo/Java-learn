package poo.base.application.socialMedia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
	
	private int like;
	private String text;
	private LocalDate date;
	private List<Comment> comments = new ArrayList<>();
	public Post(String text) {
		this.text = text;
		this.date = LocalDate.now();
	}
	public String getMyPost() {
		return text;
	}
	public void setLike(int l) {
		like = l;
	}
	public int getLike() {
		return like;
	}

	public void addComment(Comment c) {
		comments.add(c);
	}
	
//	return "Post [ " + myPost + " ]"
//	+ "\nlike [" + like + "]"
//	+ "\ncommnet " + comments;
	
	
	// ***** utilanzo o StringBuilder para strings muito logas *** ///
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	
	sb.append(text + "\n");
	sb.append("Data post: " + date + "\n");
	sb.append("Like: " + like + "\n");
	sb.append("Comments:\n");
	for(Comment c : comments) {
		sb.append(c.getComment() + "\n");
	}
	return sb.toString();
	
	}
	
}




















