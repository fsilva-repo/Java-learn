package br.com.academia.app.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "planos")
public class Plano {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;
 private String descricao;
 @Column(name = "valor_mensal")
 private BigDecimal valor;
 private Boolean ativo = true;

 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "modalidade_id")
 private Modalidade modalidades;

 public Plano() {
 }

 public Plano(Long id, String nome, String descricao, BigDecimal valor, Boolean ativo,
   Modalidade modalidades) {
  this.id = id;
 
  this.nome = nome;
  this.descricao = descricao;
  this.valor = valor;
  this.ativo = ativo;
  this.modalidades = modalidades;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

 public BigDecimal getValor() {
  return valor;
 }

 public void setValor(BigDecimal valor) {
  this.valor = valor;
 }

 public Boolean getAtivo() {
  return ativo;
 }

 public void setAtivo(Boolean ativo) {
  this.ativo = ativo;
 }

 public Modalidade getModalidades() {
  return modalidades;
 }

 public void setModalidades(Modalidade modalidades) {
  this.modalidades = modalidades;
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
  Plano other = (Plano) obj;
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }
 
 
}
