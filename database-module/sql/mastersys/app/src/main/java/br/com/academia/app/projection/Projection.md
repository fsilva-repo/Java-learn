# Projection no Spring Data JPA

## O que é Projection?

Projection é um recurso do Spring Data JPA que permite retornar apenas
os dados necessários de uma consulta, sem carregar uma entidade completa.

Em vez de buscar todos os campos de uma tabela,
a aplicação recupera apenas as colunas que serão utilizadas.

### Exemplo

Considere a entidade `Aluno`:

```java
@Entity
public class Aluno {

 @Id
 private Long id;
 private String nome;
 private String email;
 private String telefone;
 private String cpf;
 private LocalDate dataNascimento;
}