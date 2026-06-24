package br.com.academia.app.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FaturaAbertaProjection {
 LocalDate getDataVencimento();
 Long getMatriculaId();
 String getNome();
 BigDecimal getValor();
}
