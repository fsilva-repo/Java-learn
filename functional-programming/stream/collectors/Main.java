
import java.util.Map;
import java.util.Set;
import java.util.stream.*;
import java.util.List;


class Pessoa {
    String nome;
    int idade;
    public Pessoa(String nome, int idade) {
    	this.nome = nome;
    	this.idade = idade;
    }
    public int getIdade() { return idade; }
    public String getNome() { return nome; }
	@Override
	public String toString() {
		return "[ nome: " + nome + "idade: " + idade + "]";
	}
}

class Produto {
    String nome;
    double preco;
   public  Produto(String nome, double preco) {
    	this.nome = nome;
    	this.preco = preco;
    }
    public double getPreco() { return preco; }
    public String getNome() { return nome; }
	@Override
	public String toString() {
		return "[ nome: " + nome + "preco: " + preco + "]";
	}
}

/*
 * Collectors é uma classe utilitária do Java, em java.util.stream,
 * que oferece operações para reunir os elementos de um Stream em uma
 * estrutura ou resultado.
 * Essas operações são usadas com collect().
*/

public class Main {
	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 4, 6, 5, 12, 8, 20, 3);

		// coletando para formar uma lista
		List<Integer> listNumerosPar = numeros.stream()
			.filter(n -> n % 2 == 0)
			.collect(Collectors.toList());
		System.out.println(listNumerosPar);


		var filtraNumerosPar = numeros.stream().filter(n -> n % 2 == 0).toList();
		System.out.println(filtraNumerosPar);
		/*
		 * Embora os métodos `collect(Collectors.toList())` e `toList()`
		 * retornem uma lista (List), existem algumas diferenças entre eles.
		 *
		 * O primeiro com collect(Collectors.toList()) 
		 * geralmente retorna um ArrayList, que pode ser modificado,
		 * enquanto o segundo retorna uma lista (List) que não pode ser modificada.
		*/


		List<Produto> produtos = List.of(
		  new Produto("Mouse", 50),
		  new Produto("Teclado", 150),
		  new Produto("Monitor", 900)
		);

		List<String> nomeProdutosMaiorQue100 = produtos.stream()
			.filter(p -> p.getPreco() > 100)
			.map(p -> p.getNome())
			.collect(Collectors.toList());
		System.out.println(nomeProdutosMaiorQue100);


		List<Pessoa> pessoas = List.of(
		  new Pessoa("Ana", 20),
		  new Pessoa("Bruno", 20),
		  new Pessoa("Carlos", 30)
		);



		// coletando para um set
		Set<String> nomesNaoDuplicado = pessoas.stream()
			.map(Pessoa::getNome)
			.collect(Collectors.toSet());
		System.out.println(nomesNaoDuplicado);



		
		// coletando para um map com agrupando por  
		Map<String, List<Integer>> grupos = numeros.stream()
		  .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "pares" : "ímpares"));
		System.out.println(grupos);



		// agrupando por idade
		Map<Integer, List<String>> agrupadoPorIdade = pessoas.stream()
			.collect(Collectors.groupingBy(Pessoa::getIdade,
			Collectors.mapping(Pessoa::getNome, Collectors.toList())));		
		System.out.println(agrupadoPorIdade);


		List<Double> listaDePreco = List.of(1024.89, 477.89, 132.45, 762.90, 998.20, 78.79, 309.10);
		Map<String, List<Double>> listaDesconto15Porcento = listaDePreco.stream()
			.filter(preco -> preco > 500)
			.collect(Collectors.groupingBy(preco -> "comDesconto15",
			Collectors.mapping(preco -> Math.round(preco * 0.85 * 100.0) / 100.0, Collectors.toList())));
		System.out.println(listaDesconto15Porcento);

	}
}
