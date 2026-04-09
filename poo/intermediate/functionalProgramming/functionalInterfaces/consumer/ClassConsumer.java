package poo.intermediate.functionalProgramming.functionalInterfaces.consumer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClassConsumer {
	
	public static List<String> printUsers(List<Person> users)  {
		/*
		 *  interface funcional Function extrai um valor de um objeto e retorna um resultado,
		 *  ou seja, transforma um tipo em outro, neste caso transforma um Person em String.
		 */
		Function<Person, String> getName = person -> person.getName();
		
		/* filtra os usuários com id par, extrai o nome com o metodo map utilizando
		 * a funcao getName declara acima e retorna uma lista de nomes.
		 */
		List<String> logadUser =
				users.stream().filter(p -> p.getId() % 2 == 0).map(getName).collect(Collectors.toList());
		return logadUser;
		
	}
	
}
