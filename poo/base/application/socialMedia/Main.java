package poo.base.application.socialMedia;

public class Main {

	public static void main(String[] args) {
		Post p1 = new Post("Amo dia chuvoso");
		Comment c1 = new Comment("tambem amooo :)");
		p1.setLike(3);
		p1.addComment(c1);
		Comment c2 = new Comment("preciso de guardachuvas");
		p1.addComment(c2);
		IO.println(p1);
	}

}
