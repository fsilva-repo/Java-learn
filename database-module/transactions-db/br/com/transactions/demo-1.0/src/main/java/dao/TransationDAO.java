package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import service.DB;

public class TransationDAO {

  /** tentaremos atualizar valores em duas colunas em tabelas  distintas
   * simularemos um erro durante o processo para se ter uma ideia
   * de como isso pode ser desastroso em uma aplicação
   * na versão dois da demo veremos como tratar isso.
   */
  public static void run() {

    try (Connection conn = DB.getConnection();
        Statement st = conn.createStatement()) {
        
          st.executeUpdate(
          "UPDATE produtos SET estoque = 75 WHERE id = 1");

          int n = 1;
          if (n == 1) { // simular um erro para que a atualização não ocorra nas duas colunas
            throw new SQLException("fake error !");
          }
          st.executeUpdate(
          "UPDATE produtos SET estoque = 55 WHERE id = 2");
  
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
}
