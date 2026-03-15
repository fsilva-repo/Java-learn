Em Java, os métodos **`equals`** e **`hashCode`** são fundamentais para comparar objetos e trabalhar com coleções como `HashSet`, `HashMap`, entre outras. Eles estão definidos na classe `Object`, que é a superclasse de todas as classes em Java, e podem ser sobrescritos para fornecer comportamentos personalizados. Vamos detalhar cada um:

---

### 1. **Método `equals`**
O método `equals` é usado para comparar se dois objetos são **iguais** em termos de conteúdo ou lógica de negócio.

- **Padrão**: A implementação padrão na classe `Object` compara as **referências** dos objetos (ou seja, verifica se são o mesmo objeto na memória).
- **Sobrescrita**: Geralmente, você sobrescreve o `equals` para comparar os **atributos** dos objetos e determinar se eles são logicamente iguais.

**Regras para sobrescrever o `equals`**:
1. **Reflexivo**: `x.equals(x)` deve ser `true`.
2. **Simétrico**: Se `x.equals(y)` é `true`, então `y.equals(x)` também deve ser `true`.
3. **Transitivo**: Se `x.equals(y)` é `true` e `y.equals(z)` é `true`, então `x.equals(z)` também deve ser `true`.
4. **Consistente**: Várias chamadas a `x.equals(y)` devem sempre retornar o mesmo valor, desde que os objetos não sejam modificados.
5. **Não nulo**: `x.equals(null)` deve ser `false`.

**Exemplo de implementação**:
```java
public class Pessoa {
    private String nome;
    private int idade;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mesma referência
        if (obj == null || getClass() != obj.getClass()) return false; // Classes diferentes ou nulo
        Pessoa outraPessoa = (Pessoa) obj;
        return idade == outraPessoa.idade && nome.equals(outraPessoa.nome); // Compara atributos
    }
}
```

---

### 2. **Método `hashCode`**
O método `hashCode` retorna um valor inteiro que representa o objeto. Ele é usado principalmente em estruturas de dados baseadas em hash, como `HashSet` e `HashMap`.

- **Padrão**: A implementação padrão na classe `Object` retorna um código hash baseado no endereço de memória do objeto.
- **Sobrescrita**: Quando você sobrescreve o `equals`, **deve** também sobrescrever o `hashCode` para garantir que objetos iguais tenham o mesmo código hash.

**Regras para sobrescrever o `hashCode`**:
1. **Consistência**: Se `x.equals(y)` é `true`, então `x.hashCode()` deve ser igual a `y.hashCode()`.
2. **Eficiência**: O código hash deve ser calculado de forma eficiente.
3. **Distribuição**: Objetos diferentes devem, preferencialmente, ter códigos hash diferentes para evitar colisões.

**Exemplo de implementação**:
```java
@Override
public int hashCode() {
    return Objects.hash(nome, idade); // Usa a classe utilitária Objects para calcular o hash
}
```

---

### 3. **Relação entre `equals` e `hashCode`**
- Se dois objetos são iguais (`equals` retorna `true`), eles **devem** ter o mesmo código hash (`hashCode` retorna o mesmo valor).
- No entanto, o inverso **não** é verdadeiro: dois objetos com o mesmo código hash **não precisam** ser iguais (isso é chamado de colisão de hash).

**Por que isso é importante?**
- Estruturas como `HashMap` e `HashSet` usam o `hashCode` para localizar rapidamente o "balde" onde o objeto deve ser armazenado. Depois, usam o `equals` para verificar se o objeto já existe naquele balde.
- Se `equals` e `hashCode` não estiverem alinhados, essas estruturas podem não funcionar corretamente.

---

### 4. **Exemplo completo**
Aqui está um exemplo completo de uma classe com `equals` e `hashCode` sobrescritos:

```java
import java.util.Objects;

public class Pessoa {
    private String nome;
    private int idade;

    // Construtor, getters e setters omitidos

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa outraPessoa = (Pessoa) obj;
        return idade == outraPessoa.idade && nome.equals(outraPessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
```

---

### 5. **Boas práticas**
1. **Sempre sobrescreva `hashCode` quando sobrescrever `equals`**.
2. Use a classe utilitária `Objects` para implementar `hashCode` de forma segura e eficiente.
3. Teste sua implementação de `equals` e `hashCode` para garantir que estejam alinhadas.

Se você seguir essas diretrizes, suas classes funcionarão corretamente com coleções baseadas em hash e outras operações de comparação. 😊