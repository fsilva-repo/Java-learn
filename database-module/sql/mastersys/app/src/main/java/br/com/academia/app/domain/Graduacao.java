package br.com.academia.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "graduacoes")
public class Graduacao {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(name = "nome")
 private String nome;
 @Column(name = "ordem")
 private int ordem;

 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "modalidade_id")
 private Modalidade modalidades;
 
 public Graduacao() {
 }
 public Graduacao
(Long id, String nome, int ordem, Modalidade modalidades) {
  this.id = id;
  this.nome = nome;
  this.ordem = ordem;
  this.modalidades = modalidades;
 }
  public Modalidade getModalidades() {
  return modalidades;
 }
 public void setModalidades(Modalidade modalidades) {
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
 public int getOrdem() {
  return ordem;
 }
 public void setOrdem(int ordem) {
  this.ordem = ordem;
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
  Graduacao other = (Graduacao) obj;
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }
 
}
