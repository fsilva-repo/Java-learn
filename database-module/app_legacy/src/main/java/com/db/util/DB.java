package com.db.util;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.db.exception.DBException;


public class DB {

  private static Connection conn = null;

  public static Connection getConnection() {

    if (conn == null) {
      Properties prop = loadProperties();

      String dburl = prop.getProperty("dburl");
      String user = prop.getProperty("user");
      String password = prop.getProperty("password");

      try {
        conn = DriverManager.getConnection(dburl, user, password);
      } catch (SQLException e) {
        throw new DBException("erro na conexão com o db: " + e.getMessage());
      }
    }
    return conn;
  }

  public static void closeConnection() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new DBException("erro a conexão não pôde ser fechada: " + e.getMessage());
      }
    }
  }

  private static Properties loadProperties() {
    Properties prop = new Properties();

    Path path = Paths.get("/home/arcade/Workstation/app/src/main/source/db.properties");
    try (InputStream file = Files.newInputStream(path)) {
      prop.load(file);
      return prop;
    } catch (IOException e) {
      throw new DBException("erro ao lêr o arquivo: " + e.getMessage());
    }

  }



  public static void closeStatement(java.sql.Statement st) {
    if (st != null) {
      try {
        st.close();
      } catch (SQLException e) {
        throw new DBException(e.getMessage());
      }
    }
  }


  public static void closeResultSet(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        throw new DBException(e.getMessage());
      }
    }
  }
}
