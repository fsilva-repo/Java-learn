package br.com.academia.app.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
@Table(name = "matricula_modalidades")
public class MatriculaModalidade {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private LocalDate dataInicio;
 private LocalDate dataFim;

 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "matricula_id")
 private Matricula matricula;
 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "modalidade_id")
 private Modalidade modalidade;
 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "graduacao_id")
 private Graduacao graduacao;
 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "plano_id")
 private Plano plano;
 
 @PrePersist
 public void prePersist() {
  if (dataInicio == null) {
   dataInicio = LocalDate.now();
  }
 }
}
