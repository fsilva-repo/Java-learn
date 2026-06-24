package br.com.academia.app.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.academia.app.domain.enums.StatusFatura;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faturas_matriculas")
public class FaturaMatricula {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private BigDecimal valor;
 private BigDecimal valorPago;
 private LocalDate dataVencimento;
 private LocalDateTime dataPagamento;
 private LocalDateTime dataCancelamento;
 @Enumerated(jakarta.persistence.EnumType.STRING)
 private StatusFatura status = StatusFatura.ABERTA;
 @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
 @JoinColumn(name = "matricula_id")
 private Matricula matricula;

}
