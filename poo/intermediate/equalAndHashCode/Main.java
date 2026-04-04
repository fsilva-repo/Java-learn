package poo.intermediate.equalAndHashCode;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Person p1 = new Person("Alice", 30, 1);
		Person p2 = new Person("Alice", 30, 2);
		Person p3 = new Person("Walace", 30, 2);
		Person p4 = new Person("Vine", 30, 3);
		Person p5 = new Person("Pedro", 30, 4);
		Person p6 = new Person("Jose", 30, 4);
		Person p7 = new Person("Michael", 30, 5);
		Person p8 = new Person("Vine", 30, 6);
		
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		System.out.println("p1.equals(p2): " + p2.equals(p2));
		
		List<Person> peoples = new ArrayList<>();
		peoples.add(p1);
		peoples.add(p2);
		peoples.add(p3);
		peoples.add(p4);
		peoples.add(p5);
		peoples.add(p6);
		peoples.add(p7);
		peoples.add(p8);
		
		User users = new User(peoples);
		users.getList();
	

	}
	

}
















