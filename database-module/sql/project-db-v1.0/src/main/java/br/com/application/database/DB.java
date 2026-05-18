package br.com.application.database;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DB {
private static HikariDataSource dataSource;
static {
  try {
    String propertiePath = DB.class.getClassLoader()
    .getResource("application.properties").getPath();


    HikariConfig config = new HikariConfig(propertiePath);
    dataSource = new HikariDataSource(config);
  } catch (Exception e) {
    throw new RuntimeException("Erro ao ler o arquivo ( .properties ) ");
  }
}

// obtem o pool de conexão
public static Connection getConnection() throws SQLException {
  return dataSource.getConnection();
}

public static void shutdown() {
  if (dataSource != null && !dataSource.isClosed()) dataSource.close(); 
}
  
}
