package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DB;
import entities.Client;

public class Main {

  void main() {
    
    List<Client> clients = new ArrayList<>();

    String sql = "SELECT first_name, email, address FROM customer INNER JOIN address WHERE customer_id <= 10 AND customer_id = address.address_id ";


    try (Connection conn = DB.getConnection()) {
      PreparedStatement ps = conn.prepareStatement(sql);
      try (ResultSet rs = ps.executeQuery()) {
      
      rs.next();
      while (rs.next()) {

        String name = rs.getString("first_name");
        String email = rs.getString("email");
        String address = rs.getString("address");

        clients.add(new Client(name.toLowerCase(), email.toLowerCase(), address.toLowerCase()));
        
      }
    } catch (SQLException e)
    {
      IO.print(e.getMessage());
      throw new RuntimeException("erro ao processar os dados: ");
    }
    }   catch(SQLException e)
    {
      IO.print(e.getMessage());
      throw new RuntimeException("erro na conexão com o banco de dados: ");
    }
    clients.forEach(System.out::println);
    DB.shutdown();

  }
}
