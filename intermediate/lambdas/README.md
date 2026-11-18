A API Stream do Java é fortemente baseada em **interfaces funcionais** para permitir operações flexíveis e expressivas sobre coleções e fluxos de dados. As interfaces funcionais mais populares e frequentemente usadas na API Stream são:

---

### 1. **`Predicate<T>`**
   - **Descrição**: Representa uma função que recebe um argumento do tipo `T` e retorna um valor booleano (`true` ou `false`).
   - **Método principal**: `boolean test(T t)`.
   - **Uso comum**: Filtragem de elementos em um fluxo.
   - **Exemplo**:
     ```java
     Stream<String> stream = Stream.of("Java", "Python", "C++", "JavaScript");
     stream.filter(s -> s.length() > 3).forEach(System.out::println);
     ```
     Saída:
     ```
     Java
     Python
     JavaScript
     ```

---

### 2. **`Function<T, R>`**
   - **Descrição**: Representa uma função que recebe um argumento do tipo `T` e retorna um resultado do tipo `R`.
   - **Método principal**: `R apply(T t)`.
   - **Uso comum**: Transformação de elementos em um fluxo (mapeamento).
   - **Exemplo**:
     ```java
     Stream<String> stream = Stream.of("Java", "Python", "C++");
     stream.map(s -> s.length()).forEach(System.out::println);
     ```
     Saída:
     ```
     4
     6
     3
     ```

---

### 3. **`Consumer<T>`**
   - **Descrição**: Representa uma operação que recebe um argumento do tipo `T` e não retorna nenhum resultado (`void`).
   - **Método principal**: `void accept(T t)`.
   - **Uso comum**: Executar uma ação para cada elemento do fluxo.
   - **Exemplo**:
     ```java
     Stream<String> stream = Stream.of("Java", "Python", "C++");
     stream.forEach(System.out::println);
     ```
     Saída:
     ```
     Java
     Python
     C++
     ```

---

### 4. **`Supplier<T>`**
   - **Descrição**: Representa uma função que não recebe argumentos e retorna um valor do tipo `T`.
   - **Método principal**: `T get()`.
   - **Uso comum**: Gerar ou fornecer valores sob demanda, como em `Stream.generate()`.
   - **Exemplo**:
     ```java
     Stream<String> stream = Stream.generate(() -> "Hello").limit(3);
     stream.forEach(System.out::println);
     ```
     Saída:
     ```
     Hello
     Hello
     Hello
     ```

---

### 5. **`UnaryOperator<T>`**
   - **Descrição**: Um caso especial de `Function<T, T>`, onde o tipo de entrada e saída são iguais. Representa uma operação que recebe um argumento do tipo `T` e retorna um resultado do mesmo tipo `T`.
   - **Método principal**: `T apply(T t)`.
   - **Uso comum**: Transformações em que o tipo de entrada e saída são iguais, como em `Stream.iterate()`.
   - **Exemplo**:
     ```java
     Stream<Integer> stream = Stream.iterate(1, n -> n * 2).limit(5);
     stream.forEach(System.out::println);
     ```
     Saída:
     ```
     1
     2
     4
     8
     16
     ```

---

### 6. **`BinaryOperator<T>`**
   - **Descrição**: Um caso especial de `BiFunction<T, T, T>`, onde os dois argumentos e o resultado são do mesmo tipo. Representa uma operação que combina dois valores do tipo `T` e retorna um resultado do mesmo tipo `T`.
   - **Método principal**: `T apply(T t1, T t2)`.
   - **Uso comum**: Redução de elementos em um fluxo, como em `Stream.reduce()`.
   - **Exemplo**:
     ```java
     Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
     int sum = stream.reduce(0, (a, b) -> a + b);
     System.out.println(sum);
     ```
     Saída:
     ```
     15
     ```

---

### 7. **`BiFunction<T, U, R>`**
   - **Descrição**: Representa uma função que recebe dois argumentos (tipos `T` e `U`) e retorna um resultado do tipo `R`.
   - **Método principal**: `R apply(T t, U u)`.
   - **Uso comum**: Operações que envolvem dois argumentos, como em `Collectors.toMap()`.
   - **Exemplo**:
     ```java
     Map<String, Integer> map = Stream.of("Java", "Python", "C++")
                                      .collect(Collectors.toMap(s -> s, String::length));
     System.out.println(map);
     ```
     Saída:
     ```
     {Java=4, Python=6, C++=3}
     ```

---

### 8. **`BiConsumer<T, U>`**
   - **Descrição**: Representa uma operação que recebe dois argumentos (tipos `T` e `U`) e não retorna nenhum resultado (`void`).
   - **Método principal**: `void accept(T t, U u)`.
   - **Uso comum**: Operações que envolvem dois argumentos, como em `Map.forEach()`.
   - **Exemplo**:
     ```java
     Map<String, Integer> map = Map.of("Java", 4, "Python", 6, "C++", 3);
     map.forEach((k, v) -> System.out.println(k + " -> " + v));
     ```
     Saída:
     ```
     Java -> 4
     Python -> 6
     C++ -> 3
     ```

---

### 9. **`ToIntFunction<T>`, `ToLongFunction<T>`, `ToDoubleFunction<T>`**
   - **Descrição**: Representam funções que recebem um argumento do tipo `T` e retornam um valor primitivo (`int`, `long` ou `double`).
   - **Métodos principais**:
     - `int applyAsInt(T t)` (para `ToIntFunction`).
     - `long applyAsLong(T t)` (para `ToLongFunction`).
     - `double applyAsDouble(T t)` (para `ToDoubleFunction`).
   - **Uso comum**: Mapeamento para tipos primitivos.
   - **Exemplo**:
     ```java
     Stream<String> stream = Stream.of("Java", "Python", "C++");
     IntStream intStream = stream.mapToInt(String::length);
     intStream.forEach(System.out::println);
     ```
     Saída:
     ```
     4
     6
     3
     ```

---

### Resumo das Principais Interfaces Funcionais na API Stream:
| Interface Funcional       | Descrição                                                                 | Método Principal               | Uso Comum                          |
|---------------------------|---------------------------------------------------------------------------|--------------------------------|-------------------------------------|
| `Predicate<T>`            | Testa uma condição e retorna `boolean`.                                   | `boolean test(T t)`            | Filtragem (`filter`).               |
| `Function<T, R>`          | Transforma um valor do tipo `T` em um valor do tipo `R`.                  | `R apply(T t)`                 | Mapeamento (`map`).                 |
| `Consumer<T>`             | Executa uma ação com um valor do tipo `T`.                                | `void accept(T t)`             | Iteração (`forEach`).               |
| `Supplier<T>`             | Fornece um valor do tipo `T`.                                             | `T get()`                      | Geração de fluxos (`generate`).     |
| `UnaryOperator<T>`        | Transforma um valor do tipo `T` em outro valor do mesmo tipo `T`.         | `T apply(T t)`                 | Iteração (`iterate`).               |
| `BinaryOperator<T>`       | Combina dois valores do tipo `T` em um resultado do mesmo tipo `T`.       | `T apply(T t1, T t2)`          | Redução (`reduce`).                 |
| `BiFunction<T, U, R>`     | Combina dois valores (tipos `T` e `U`) em um resultado do tipo `R`.       | `R apply(T t, U u)`            | Operações com dois argumentos.      |
| `BiConsumer<T, U>`        | Executa uma ação com dois valores (tipos `T` e `U`).                      | `void accept(T t, U u)`        | Iteração em pares (`forEach`).      |
| `ToIntFunction<T>`        | Transforma um valor do tipo `T` em um `int`.                              | `int applyAsInt(T t)`          | Mapeamento para primitivos.         |

Essas interfaces funcionais são a base para operações como filtragem, mapeamento, redução e iteração na API Stream, tornando o código mais conciso e expressivo.
