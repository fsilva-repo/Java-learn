package br.com.academia.app.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alunos")
public class Aluno {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "data_nascimento")
  private LocalDate dataNascimento;
  @Column(name = "genero")
  private String genero;
  @Column(name = "cpf", unique = true)
  private String cpf;
  @Column(name = "telefone")
  private String telefone;
  @Column(name = "celular")
  private String celular;
  @Column(name = "email", unique = true)
  private String email;
  @Column(name = "observacao")
  private String observacao;
  @Column(name = "endereco")
  private String endereco;
  @Column(name = "numero")
  private String numero;
  @Column(name = "complemento")
  private String complemento;
  @Column(name = "bairro")
  private String bairro;
  @Column(name = "cidade")
  private String cidade;
  @Column(name = "estado", length = 2)
  private String estado;
  @Column(name = "cep")
  private String cep;
  @Column(name = "criado_em")
  private LocalDateTime criadoEm;
  @Column(name = "atualizado_em")
  private LocalDateTime atualizadoEm;

  /* O processo de criação e atualização do aluno é gerenciado automaticamente pelos métodos prePersist
   * e preUpdate, que são anotados com @PrePersist.
   * Esses métodos são chamados antes de persistir ou atualizar a entidade no banco de dados,
   * garantindo que as datas de criação e atualização sejam definidas corretamente.
  */
  @PrePersist
  public void prePersist() {
      LocalDateTime agora = LocalDateTime.now();

      this.criadoEm = agora;
      this.atualizadoEm = agora;
  }

  @PreUpdate
  public void preUpdate() {
      this.atualizadoEm = LocalDateTime.now();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Aluno other = (Aluno) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  
  
}













