package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import service.DB;

public class ProductDAO {

  // class para extrair dados da tabela produtos
  public static List<Product> listProducts() {
    List<Product> list = new ArrayList<>();
    String sql = "SELECT * FROM produtos";

    try (Connection conn = DB.getConnection();
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery()) {

      while (rs.next()) {
        list.add(new Product(
        rs.getInt("id"),
        rs.getString("nome"),
        rs.getDouble("preco")
        ));
      }
      
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao listar produtos: " + e.getMessage());
    }
    return list;
  }

  // class para inserir dados na tebela produtos
  public static void save(String nome, double preco, int categoriaId) {
    String sql = "INSERT INTO produtos (nome, preco, categoria_id) VALUES (?, ?, ?)";
  
    try (Connection conn = DB.getConnection();
      PreparedStatement pst = conn.prepareStatement(sql)) {
            
       pst.setString(1, nome);
       pst.setDouble(2, preco);
       pst.setInt(3, categoriaId);
       pst.executeUpdate();
            
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao salvar produto: " + e.getMessage());
    }
  }

}
