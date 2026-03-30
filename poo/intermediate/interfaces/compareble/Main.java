package poo.intermediate.interfaces.compareble;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	void main() {

		ReadFile readFile = new ReadFile();
		Employee employee = new Employee();
		List<String> list = new ArrayList<>();

		readFile.path("src/poo/intermediate/interfaces/compareble/src/list-names").forEach(IO::println);

		for (String name : list) {
			System.out.println(name);
		}
		
		IO.println("--------------------");
		
		readFile.path("src/poo/intermediate/interfaces/compareble/src/employee-names").stream().map(s -> s.split(","))
				.forEach(array -> Arrays.stream(array).forEach(System.out::println));
		
		IO.println("--------------------");
		
		List<Employee> employees = readFile.path("src/poo/intermediate/interfaces/compareble/src/employee-names")
				.stream()
		    .filter(line -> line != null && !line.isBlank())  // remove linhas vazias
		    .filter(line -> line.contains(","))               // garante que tem vírgula
		    .map(entry -> {
		        String[] parts = entry.split(",");
		        return new Employee(parts[0].trim(), Double.parseDouble(parts[1].trim()));
		    })
		    .collect(Collectors.toList());
		
		for(Employee e : employees) {
			System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
		}
		
		IO.println("--------------------");
		
		readFile.path("src/poo/intermediate/interfaces/compareble/src/employee-names")
		.stream()
    .filter(line -> line != null && !line.isBlank())  // remove linhas vazias
    .filter(line -> line.contains(","))               // garante que tem vírgula
    .map(entry -> {
        String[] parts = entry.split(",");
        employee.setName(parts[0].trim());
        employee.setSalary(Double.parseDouble(parts[1].trim()));
        return employee;
    })
    .collect(Collectors.toList());
		
		Collections.sort(employees);
		
		for(Employee e : employees) {
			System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
		}
		
		/*
		 * .stream() .map(s -> s.split(",")) .flatMap(Arrays::stream)
		 * .collect(Collectors.toList()) .forEach(System.out::println);
		 * 
		 */
	}

}
