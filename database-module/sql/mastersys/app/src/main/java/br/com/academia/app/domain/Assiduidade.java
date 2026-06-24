package br.com.academia.app.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assiduidade")
public class Assiduidade {

 @Id// presistencia de dados automaticamente gera o id e data de entrada e saida
 @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
 private Long id;
 private LocalDateTime dataEntrada;
 private LocalDateTime dataSaida;

 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "matricula_id")
 private Matricula matricula;
 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "modalidade_id")
 private Modalidade modalidade;

 @PrePersist
 public void prePersistEntrada() {
  if (dataEntrada == null) {
    dataEntrada = LocalDateTime.now();
  } else if (dataSaida == null) {
    dataSaida = LocalDateTime.now();
  }
 }

}