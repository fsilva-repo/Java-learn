package br.com.academia.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import br.com.academia.app.domain.FaturaMatricula;
import br.com.academia.app.projection.AlunosPorCidadeProjection;
import br.com.academia.app.projection.FaturaAbertaProjection;
import br.com.academia.app.projection.FaturamentoMensalProjection;

public interface RelatorioAcademiaProjectionRepository extends Repository<FaturaMatricula, Long> {

  @Query(value = """
    SELECT
     DATE_FORMAT(data_vencimento, '%m/%Y') AS mes,
     COUNT(data_vencimento) AS quantidade,
     SUM(valor) AS total
    FROM faturas_matriculas
    WHERE status = 'PAGA'
    GROUP BY DATE_FORMAT(data_vencimento, '%m/%Y')
    ORDER BY mes;
    """, nativeQuery = true)

 List<FaturamentoMensalProjection> faturamentoMensal();

   @Query(value = """
    SELECT
     cidade,
     COUNT(*) AS quantidade
    FROM alunos
    GROUP BY cidade
    ORDER BY quantidade desc;
    """, nativeQuery = true)

 List<AlunosPorCidadeProjection> alunosPorCidade();

    @Query(value = """
    SELECT
      f.data_vencimento,
      m.id AS matricula_id,
      a.nome,
      a.cidade,
      f.valor
    FROM faturas_matriculas f
    JOIN matriculas m ON m.id = f.matricula_id
    JOIN alunos a ON a.id = m.aluno_id
    WHERE f.status = 'ABERTA'
    GROUP BY a.id
    ORDER BY f.data_vencimento desc;
    """, nativeQuery = true)

 List<FaturaAbertaProjection> faturaAberta();

}
