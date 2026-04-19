package com.db.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.db.exception.DBException;


public class DB {

  // credenciais do banco
  private static String url = "jdbc:mysql://localhost:3306/sakila";
  private static String user = "admin";
  private static String password = "Admin";
  // retorno de valore de uso interno
  private static String getUrl() {return url;}
  private static String getUser() {return user;}
  private static String getPassword() {return password;}
  
  // recebe os comando de consulta por argumento
  public static void getConnection(String query) {
    // abre a conecxão com o banco via gerenciador de driver
    try (Connection conn = DriverManager.getConnection(getUrl(), getUser(), getPassword())) {
      // prepara os argumentos da consulta na conexão com o banco
      PreparedStatement ps = conn.prepareStatement(query);
      /**
       * O ResultSet guarda a resposta da consulta feita por
       * executeQuery que usa as propriedades da classe PreparedStatement
       * que resgata os dados do banco
       */ 
      try (ResultSet rs = ps.executeQuery()) {
        IO.println();
        IO.println("| category_id |     name       |      date          |");
        rs.next();
        while (rs.next()) {
          int category_id = rs.getInt(1);
          String name = rs.getString(2);
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          LocalDateTime date = LocalDateTime.parse(rs.getString(3), formatter);
          String line = String.format("|  %d  |         %s       |         %s    |",category_id, name, date);
          IO.println(line);
          
        }

      } catch (SQLException e) {
        throw new DBException("falha na conexão com o db: " + e.getMessage());  
      }

    } catch (SQLException e) {
      throw new DBException("falha na conexão com o db: " + e.getMessage());
    }

    

  }

}






