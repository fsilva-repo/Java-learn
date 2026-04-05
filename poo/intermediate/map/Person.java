package poo.intermediate.map;

import java.util.Objects;

public class Person  {
	private String ame;
	private int age;
	private int id;
	
	public Person(String ame, int age, int id) {
		this.ame = ame;
		this.age = age;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Person [ame=" + ame + ", age=" + age + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

//	@Override
//	public int compareTo(Person o) {
//		return Integer.compare(this.id, o.id);
//	}
//	
	
}
