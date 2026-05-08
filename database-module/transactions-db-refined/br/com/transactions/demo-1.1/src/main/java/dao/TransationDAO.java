package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import service.DB;

public class TransationDAO {

  /** Corrigindo o problema na tentativa de atualizar varias tabelas
   * de uma so vez, quando acontece um erro o banco de dados
   * fica inconcistente, mas utilizaremos os objetos de transação para
   * evitar esse tipo de problema.
   */
  public static void run() {
    Connection conn = null;
    try {
        conn = DB.getConnection();
        // a transação so pode ser confirmada pelo programador
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();

        st.executeUpdate("UPDATE produtos SET estoque = 75 WHERE id = 1");

        // nenhum valor sera alterado enquanto houver algum erro
        int n = 1;
        if (n == 1) { // simular um erro para que a atualização não ocorra nas duas colunas
          throw new SQLException("fake error !");
        }

        st.executeUpdate(
        "UPDATE produtos SET estoque = 55 WHERE id = 2");
        
        // commit manual
        conn.commit();
      } catch (SQLException e) {
        // o rollback pode gerer uma exception
        try {
          conn.rollback();
          throw new SQLException("Transaction rolled back ! coused by: " + e.getMessage());
        } catch (SQLException er) {
         System.err.println("Error trying to rollback coused by: " + er.getMessage());
        }
      }
  }
}
