package com.app.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DB {

  private static final HikariDataSource dataSource;

  static {
    try {
      // O Hikari consegue ler o arquivo se passarmos o caminho absoluto ou via objeto
      // Properties
      // Para Java puro, carregar via ClassLoader é o mais seguro:
      var propertiesPath = DB.class.getClassLoader()
          .getResource("application.properties").getPath();

      HikariConfig config = new HikariConfig(propertiesPath);
      dataSource = new HikariDataSource(config);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Erro ao carregar configurações do banco.");
    }
  }

  // Método para obter uma conexão do pool
  public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  // Fechar o pool quando a aplicação encerrar (importante!)
  public static void shutdown() {
    if (dataSource != null && !dataSource.isClosed()) {
      dataSource.close();
    }
  }
}
