package br.com.academia.app.projection;

import java.math.BigDecimal;

public interface FaturamentoMensalProjection {
 String getMes();
 Integer getQuantidade();
 BigDecimal getTotal();
}
