Para comparar instâncias corretamente em Java, precisamos sobrescrever (`override`) os métodos `equals()` e `hashCode()`. Isso garante que objetos sejam comparados corretamente em coleções como `HashSet` e `HashMap`.

---

## **📌 Regras Importantes**
1. **`equals()` deve comparar valores** dos atributos relevantes.
2. **`hashCode()` deve retornar o mesmo valor para objetos iguais** (segundo `equals()`).
3. **Sempre sobrescreva `hashCode()` se sobrescrever `equals()`**.

---

## **✅ Implementação Correta**
Aqui está um exemplo de classe `Pessoa` com `equals()` e `hashCode()`:

```java
import java.util.Objects;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Se for a mesma instância, são iguais
        if (obj == null || getClass() != obj.getClass()) return false; // Se for null ou classes diferentes, são diferentes

        Pessoa pessoa = (Pessoa) obj;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade); // Gera um hash baseado nos atributos
    }

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Alice", 30);
        Pessoa p2 = new Pessoa("Alice", 30);
        Pessoa p3 = new Pessoa("Bob", 25);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false
        System.out.println(p1.hashCode() == p2.hashCode()); // true (na maioria dos casos)
        System.out.println(p1.hashCode() == p3.hashCode()); // false
    }
}
```

---

## **📝 Explicação**
✔ **`equals()`**
   - Verifica se os objetos são da mesma instância (`this == obj`).
   - Compara os valores de `nome` e `idade`.
   - Usa `Objects.equals()` para evitar `NullPointerException`.

✔ **`hashCode()`**
   - Usa `Objects.hash(nome, idade)` para gerar um hash único.
   - Se `equals()` retorna `true`, os hashCodes devem ser iguais.

Agora seu código pode ser usado corretamente em coleções como `HashSet` e `HashMap`! 🚀
