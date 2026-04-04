package poo.intermediate.equalAndHashCode;

import java.util.List;

public class User {

	private List<? extends Object> list;

	public User(List<? extends Object> list) {
		this.list = list;
	}

	private List<?> filterId() {
	
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				Object obj1 = list.get(i);
				Object obj2 = list.get(j);
				if (obj1.equals(obj2)) {
					list.remove(j);
				} 
			}
		}
		return list;
	}

	public void getList() {
		filterId().forEach(System.out::println);
	}
}
