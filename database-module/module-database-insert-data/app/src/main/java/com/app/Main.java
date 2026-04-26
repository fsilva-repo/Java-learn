package com.app;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.app.service.DB;

public class Main {
 public static void main(String[] args) {
   
  String employee = "INSERT INTO employees"
    + "(name, contact, department_id)"
    + "VALUES"
    + "(?, ?, ?)";

  //String departament = "";
      
  try (Connection conn = DB.getConnection()) {
    PreparedStatement ps = conn.prepareStatement(employee);

   /*ps.setString(1, "Pedro Almeida");
    ps.setString(2, "pedro.almeida@email.com");
    ps.setInt(3, 1); */

   ps.setString(1, "Juliana Martins");
   ps.setString(2, "juliana.martins@email.com");
   ps.setInt(3, 3);


    int rowsAffected = ps.executeUpdate();

    System.out.printf("rows affected %d ,done!", rowsAffected);
  } catch (Exception e) {
   System.err.println(e.getMessage());
  }
  DB.shutdown();
 }


 /*
  * ### "('Pedro Almeida', 'pedro.almeida@email.com', 2), " +
  * "('Juliana Martins', 'juliana.martins@email.com', 1)," +
  * "('Roberto Lima', 'roberto.lima@email.com', 3);";
  */
}