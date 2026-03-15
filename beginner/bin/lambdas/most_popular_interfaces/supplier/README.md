A `Supplier` é uma interface funcional introduzida no Java 8 como parte do pacote `java.util.function`. Ela é usada para representar uma função que não recebe nenhum argumento, mas produz um resultado do tipo especificado. A interface `Supplier` é útil em cenários onde você precisa gerar ou fornecer valores sem precisar de uma entrada.

### Definição da Interface

A interface `Supplier` é definida da seguinte forma:

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

- `T`: O tipo do resultado que o `Supplier` fornece.
- `get()`: O método abstrato que retorna um valor do tipo `T`.

### Exemplos de Uso

Aqui estão alguns exemplos de como você pode usar a interface `Supplier`:

#### 1. Fornecendo uma String

```java
Supplier<String> stringSupplier = () -> "Hello, World!";
System.out.println(stringSupplier.get());  // Saída: Hello, World!
```

#### 2. Fornecendo um Número Aleatório

```java
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get());  // Saída: Um número aleatório entre 0.0 e 1.0
```

#### 3. Fornecendo um Objeto Personalizado

```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

Supplier<Person> personSupplier = () -> new Person("John Doe", 30);
System.out.println(personSupplier.get());  // Saída: Person{name='John Doe', age=30}
```

### Casos de Uso Comuns

1. **Inicialização Preguiçosa (Lazy Initialization)**: `Supplier` pode ser usado para adiar a criação de um objeto até que ele seja realmente necessário.

    ```java
    Supplier<ExpensiveObject> lazyInitializer = () -> {
        ExpensiveObject obj = new ExpensiveObject();
        // Inicialização custosa
        return obj;
    };

    // O objeto só será criado quando get() for chamado
    ExpensiveObject obj = lazyInitializer.get();
    ```

2. **Geração de Dados**: `Supplier` pode ser usado para gerar dados dinamicamente, como números aleatórios, strings, ou qualquer outro tipo de dado.

3. **Configuração de Testes**: Em testes unitários, `Supplier` pode ser usado para fornecer dados de teste de forma dinâmica.

### Métodos Padrão e Estáticos

A interface `Supplier` também possui alguns métodos estáticos úteis, como `Supplier::of`, que permite criar um `Supplier` a partir de um valor constante:

```java
Supplier<String> constantSupplier = Supplier.of("Constant Value");
System.out.println(constantSupplier.get());  // Saída: Constant Value
```

### A interface `Supplier` é usada em alguns métodos da API `Stream` do Java para fornecer valores ou gerar elementos sob demanda:

### 1. **`Stream.generate(Supplier<T> s)`**
   - Este método cria um **fluxo infinito** de elementos, onde cada elemento é gerado pelo `Supplier` fornecido.
   - O `Supplier` é chamado sempre que um novo elemento é necessário.
   - Como o fluxo é infinito, é comum usar métodos como `limit()` para limitar o número de elementos gerados.

   **Exemplo:**
   ```java
   Stream<String> stream = Stream.generate(() -> "Hello");
   stream.limit(5).forEach(System.out::println);
   ```
   Saída:
   ```
   Hello
   Hello
   Hello
   Hello
   Hello
   ```

   Neste exemplo, o `Supplier` fornece a string `"Hello"` repetidamente.

---

### 2. **`Stream.iterate(T seed, Supplier<T> hasNext, UnaryOperator<T> next)`**
   - Este método foi introduzido no Java 9 e permite criar um fluxo finito ou infinito com base em uma semente (`seed`), uma função para verificar se o fluxo deve continuar (`hasNext`), e uma função para gerar o próximo elemento (`next`).
   - O `Supplier<Boolean>` (`hasNext`) é usado para determinar quando o fluxo deve parar.

   **Exemplo:**
   ```java
   Stream<Integer> stream = Stream.iterate(
       0,                      // Semente inicial
       n -> n < 10,            // Supplier<Boolean> para verificar se deve continuar
       n -> n + 1              // UnaryOperator para gerar o próximo elemento
   );
   stream.forEach(System.out::println);
   ```
   Saída:
   ```
   0
   1
   2
   3
   4
   5
   6
   7
   8
   9
   ```

   Neste exemplo, o `Supplier<Boolean>` (`n -> n < 10`) controla quando o fluxo deve parar.

---

### 3. **`Stream.iterate(T seed, UnaryOperator<T> f)`**
   - Este método cria um fluxo infinito a partir de uma semente (`seed`) e uma função (`UnaryOperator`) para gerar o próximo elemento.
   - Embora este método não use diretamente um `Supplier`, ele pode ser combinado com um `Supplier` para gerar a semente inicial.

   **Exemplo:**
   ```java
   Supplier<Integer> seedSupplier = () -> 0;
   Stream<Integer> stream = Stream.iterate(seedSupplier.get(), n -> n + 1);
   stream.limit(5).forEach(System.out::println);
   ```
   Saída:
   ```
   0
   1
   2
   3
   4
   ```

   Aqui, o `Supplier` é usado para fornecer a semente inicial.

---

### 4. **`Stream.concat(Stream<? extends T> a, Stream<? extends T> b)`**
   - Embora este método não use diretamente um `Supplier`, ele pode ser combinado com `Stream.generate()` ou `Stream.iterate()` para criar fluxos concatenados.

   **Exemplo:**
   ```java
   Stream<String> stream1 = Stream.generate(() -> "A").limit(3);
   Stream<String> stream2 = Stream.generate(() -> "B").limit(2);
   Stream<String> result = Stream.concat(stream1, stream2);
   result.forEach(System.out::println);
   ```
   Saída:
   ```
   A
   A
   A
   B
   B
   ```

   Aqui, `Stream.generate()` usa um `Supplier` para criar os fluxos que são concatenados.

---

### 5. **Uso em `Collectors`**
   - Embora não seja um método direto da API `Stream`, a interface `Supplier` também é usada em alguns métodos da classe `Collectors`, como `Collectors.toCollection(Supplier<C> collectionFactory)`.
   - Esse método permite especificar um `Supplier` para criar uma nova coleção onde os elementos do fluxo serão coletados.

   **Exemplo:**
   ```java
   List<String> list = Stream.of("A", "B", "C")
                             .collect(Collectors.toCollection(ArrayList::new));
   System.out.println(list);
   ```
   Saída:
   ```
   [A, B, C]
   ```

   Aqui, o `Supplier` (`ArrayList::new`) é usado para criar uma nova instância de `ArrayList`.

---

### Resumo dos Métodos que Usam `Supplier`:
| Método da API `Stream`         | Descrição                                                                 |
|--------------------------------|---------------------------------------------------------------------------|
| `Stream.generate(Supplier<T>)` | Gera um fluxo infinito de elementos fornecidos pelo `Supplier`.           |
| `Stream.iterate(T, Supplier<Boolean>, UnaryOperator<T>)` | Cria um fluxo controlado por um `Supplier<Boolean>`. |
| `Collectors.toCollection(Supplier<C>)` | Usa um `Supplier` para criar uma coleção durante a coleta de elementos. |

Esses métodos demonstram como a interface `Supplier` é integrada à API `Stream` para fornecer valores sob demanda, gerar fluxos e controlar a criação de coleções.
