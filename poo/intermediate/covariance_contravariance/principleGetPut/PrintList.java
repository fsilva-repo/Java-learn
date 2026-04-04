package poo.intermediate.covariance_contravariance.principleGetPut;

import java.util.List;

public class PrintList {
	/* em um contexto de manipulação de listas genericas para que a operacao de copiar
	 * de uma lista para a outra dê certo, é necessario que:
	 * a lista de recursos deve extender de um tipo
	 * e a lista que ira receber os dados deve ser um
	 * subtipo da supertipo da classe que contem os recursos
	 * a serem copiados*/
	public static <E> void copy(List<? extends E> source, List<? super E> target) {
		for (int i = 0; i < source.size(); i++) {
			target.add(source.get(i));
		}
	}
}
