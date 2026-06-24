package br.com.academia.app.domain;

import java.time.LocalDate;

import br.com.academia.app.domain.enums.StatusMatricula;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")
public class Matricula {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(name = "data_matricula")
 private LocalDate dataMatricula;
 @Column(name = "dia_vencimento")
 private Integer diaVencimento;
 @Column(name = "data_encerramento")
 private LocalDate dataEncerramento;
 @Enumerated(jakarta.persistence.EnumType.STRING)
 @Column(name = "status")
 private StatusMatricula status = StatusMatricula.ATIVA;
 @Column(name = "criado_em")
 private LocalDate criadoEm;
 @Column(name = "atualizado_em")
 private LocalDate atualizadoEm;

 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "aluno_id")
 private Aluno aluno;

 /* Com o uso do PrePersist, a data da matricula do aluno sera definida pelo sistema */
 @PrePersist
 private void prePersist() {
  if (dataMatricula == null) {
   dataMatricula = LocalDate.now();
  }
 }

 public Matricula() {
 }

 public Matricula(Long id, Long alunoId, LocalDate dataMatricula, Integer diaVencimento,
  LocalDate dataEncerramento, StatusMatricula status, LocalDate criadoEm, LocalDate atualizadoEm) {
  this.id = id;
  this.dataMatricula = dataMatricula;
  this.diaVencimento = diaVencimento;
  this.dataEncerramento = dataEncerramento;
  this.status = status;
  this.criadoEm = criadoEm;
  this.atualizadoEm = atualizadoEm;
 }
 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public LocalDate getDataMatricula() {
  return dataMatricula;
 }

 public void setDataMatricula(LocalDate dataMatricula) {
  this.dataMatricula = dataMatricula;
 }

 public Integer getDiaVencimento() {
  return diaVencimento;
 }

 public void setDiaVencimento(Integer diaVencimento) {
  this.diaVencimento = diaVencimento;
 }

 public LocalDate getDataEncerramento() {
  return dataEncerramento;
 }

 public void setDataEncerramento(LocalDate dataEncerramento) {
  this.dataEncerramento = dataEncerramento;
 }

 public StatusMatricula getStatus() {
  return status;
 }

 public void setStatus(StatusMatricula status) {
  this.status = status;
 }

 public LocalDate getCriadoEm() {
  return criadoEm;
 }

 public void setCriadoEm(LocalDate criadoEm) {
  this.criadoEm = criadoEm;
 }

 public LocalDate getAtualizadoEm() {
  return atualizadoEm;
 }

 public void setAtualizadoEm(LocalDate atualizadoEm) {
  this.atualizadoEm = atualizadoEm;
 }

 public Aluno getAluno() {
  return aluno;
 }

 public void setAluno(Aluno aluno) {
  this.aluno = aluno;
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
  Matricula other = (Matricula) obj;
  if (id == null) {
    if (other.id != null)
      return false;
  } else if (!id.equals(other.id))
    return false;
  return true;
 }

 


}
