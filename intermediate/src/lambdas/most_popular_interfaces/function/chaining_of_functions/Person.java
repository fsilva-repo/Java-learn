package lambdas.most_popular_interfaces.function.chaining_of_functions;

class Person {
	private String name;
	private int age;
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}