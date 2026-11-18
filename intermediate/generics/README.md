<br>

No Java, as letras maiúsculas dentro do **diamond operator** (`<>`) são **parâmetros de tipo genérico**. Elas são usadas para representar tipos de dados de forma genérica, permitindo que classes, interfaces e métodos sejam reutilizáveis para diferentes tipos de dados. Esses parâmetros de tipo são chamados de **type parameters** ou **type variables**.


---

### Significado das Letras Maiúsculas

1. **T**:
   - Representa o **tipo de entrada** (input type) da função.
   - No caso de `Function<T, R>`, `T` é o tipo do argumento que a função recebe no método `apply`.

   Exemplo:
   ```java
   Function<String, Integer> function = s -> s.length();
   ```
   Aqui, `T` é `String`, pois a função recebe uma `String` como entrada.

2. **`R`**:
   - Representa o **tipo de retorno** (return type) da função.
   - No caso de `Function<T, R>`, `R` é o tipo do valor que a função retorna após processar a entrada.

   Exemplo:
   ```java
   Function<String, Integer> function = s -> s.length();
   ```
   Aqui, `R` é `Integer`, pois a função retorna o comprimento da `String` como um `Integer`.

3. **`V`**:
   - É um **outro parâmetro de tipo genérico**, usado em métodos como `compose` e `andThen` da interface `Function`.
   - Representa um tipo intermediário ou adicional em operações de composição de funções.

   Exemplo:
   ```java
   Function<Integer, String> intToString = i -> "Number: " + i;
   Function<String, Integer> lengthFunction = s -> s.length();

   Function<Integer, Integer> composedFunction = lengthFunction.compose(intToString);
   ```
   Aqui, `V` é o tipo de entrada da função `intToString` (`Integer`), que é diferente do tipo de entrada da função `lengthFunction` (`String`).

---

### Convenções de Nomes

Embora você possa usar qualquer nome para parâmetros de tipo genérico, existem convenções comuns no Java para facilitar a leitura e o entendimento:

- **`T`**: Tipo (Type) – usado para representar o tipo principal.
- **`R`**: Retorno (Return) – usado para representar o tipo de retorno.
- **`V`**: Valor (Value) – usado para representar um tipo adicional ou intermediário.
- **`E`**: Elemento (Element) – comum em coleções, como `List<E>`.
- **`K`**: Chave (Key) – usado em mapas, como `Map<K, V>`.
- **`U`**: Um segundo tipo genérico, quando necessário.

---

### Exemplo Completo com `Function<T, R>`

Vamos analisar um exemplo completo usando `Function<T, R>`:

```java
Function<String, Integer> lengthFunction = s -> s.length();
int length = lengthFunction.apply("Hello"); // Retorna 5
```

- **`T`**: `String` (tipo de entrada).
- **`R`**: `Integer` (tipo de retorno).

Aqui, a função recebe uma `String` (`T`) e retorna um `Integer` (`R`), que é o comprimento da string.

---

### Exemplo com `compose` e `V`

No método `compose`, `V` é usado para representar o tipo de entrada da função que será aplicada antes da função atual:

```java
Function<Integer, String> intToString = i -> "Number: " + i;
Function<String, Integer> lengthFunction = s -> s.length();

Function<Integer, Integer> composedFunction = lengthFunction.compose(intToString);
int result = composedFunction.apply(42); // Retorna 10
```

- **`V`**: `Integer` (tipo de entrada da função `intToString`).
- **`T`**: `String` (tipo de entrada da função `lengthFunction`).
- **`R`**: `Integer` (tipo de retorno da função `lengthFunction`).

Aqui, `compose` cria uma nova função que primeiro aplica `intToString` (transforma `Integer` em `String`) e depois aplica `lengthFunction` (transforma `String` em `Integer`).

---

### Resumo

- As letras maiúsculas dentro do `<>` são **parâmetros de tipo genérico**.
- Elas representam tipos de dados que serão definidos quando a classe, interface ou método for usado.
- Convenções comuns incluem `T` (tipo principal), `R` (retorno), `V` (valor intermediário), entre outros.
- Esses parâmetros permitem que interfaces como `Function<T, R>` sejam flexíveis e reutilizáveis para diferentes tipos de dados.