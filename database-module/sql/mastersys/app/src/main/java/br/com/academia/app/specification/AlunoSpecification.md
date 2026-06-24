# AlunoSpecification

## Propósito

A classe `AlunoSpecification` encapsula as regras de filtragem dinâmica para a entidade `Aluno`, utilizando a API `Specification` do Spring Data JPA. Ela permite construir consultas combinadas e flexíveis a partir de múltiplos critérios opcionais, sem a necessidade de escrever JPQL manualmente ou criar métodos de repositório para cada combinação possível de filtros.

## Funcionamento

### Método público: `filtrado(AlunoFiltroRequest filtro)`

Ponto de entrada da classe. Recebe um objeto `AlunoFiltroRequest` (record/DTO com os campos de filtro) e combina, via `.and()`, as `Specification`s individuais correspondentes a cada atributo:

- `nome`
- `genero`
- `endereco`
- `cidade`
- `estado`
- `cep`

O resultado é uma única `Specification<Aluno>` que representa a interseção (AND) de todos os critérios informados, podendo ser usada diretamente em um repositório que estenda `JpaSpecificationExecutor<Aluno>`.

### Métodos privados: `*Contem(String valor)`

Cada método (`nomeContem`, `generoContem`, `enderecoContem`, `cidadeContem`, `estadoContem`, `cepContem`) segue o mesmo padrão:

1. Recebe um valor de filtro (`String`).
2. Se o valor for `null` ou vazio (`isBlank()`), retorna `null` — fazendo com que esse critério seja **ignorado** na composição final.
3. Caso contrário, retorna uma `Specification` que aplica `LIKE` case-insensitive (`cb.lower(...)` + `%valor%`) sobre o campo correspondente da entidade `Aluno`.

Essa abordagem implementa o padrão de **filtros opcionais combináveis**: cada campo da requisição é tratado de forma independente, e apenas os campos efetivamente preenchidos pelo usuário entram na cláusula `WHERE` da consulta gerada.

## Exemplo de uso

```java
AlunoFiltroRequest filtro = new AlunoFiltroRequest("Maria", null, null, "Rio de Janeiro", null, null);
Specification<Aluno> spec = AlunoSpecification.filtrado(filtro);
List<Aluno> resultado = alunoRepository.findAll(spec);
```

Nesse exemplo, apenas os filtros `nome` e `cidade` são aplicados; os demais campos (`null`) são ignorados na consulta gerada.

## Observações

- **Busca parcial e case-insensitive**: todos os campos usam `LIKE '%valor%'` com normalização para minúsculas, permitindo buscas por substring independente de maiúsculas/minúsculas.
- **Uso de `Specification.where(...)`**: o método estático `where()` está deprecated nas versões mais recentes do Spring Data JPA (3.4+). Recomenda-se substituir por `Specification.unrestricted()` como ponto de partida da cadeia `.and(...)`, evitando o aviso de depreciação e eventuais `NullPointerException`.
- **Encadeamento seguro**: como cada método de filtro pode retornar `null`, a composição depende do comportamento de `.and()` em tratar `null` como "sem restrição adicional" — comportamento padrão do Spring Data JPA ao usar `Specification.where()`/`unrestricted()` como base.
