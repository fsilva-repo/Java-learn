package br.com.application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.dao.ProductDAO;
import br.com.application.entities.Product;

public class ProductDAOImp implements ProductDAO {

  private Connection conn;
  
  public ProductDAOImp(Connection conn) {
    this.conn = conn;
  }
  
  @Override
  public Product get(int id) {
    Product p = null;
    String sql = "SELECT p.id, p.nome, c.nome AS categoria, preco, estoque  FROM produtos p  JOIN categorias c ON p.id_categoria = c.id WHERE p.id = " 
    + id;
    try (PreparedStatement st = conn.prepareStatement(sql);
    ResultSet rs = st.executeQuery()) {
      p = new Product();
      while (rs.next()) {
        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setCategory(rs.getString(3));
        p.setPrice(rs.getDouble(4));
        p.setStock(rs.getInt(5));
      }
    } catch (SQLException e) {
      throw new UnsupportedOperationException("Não foi possivel obter o item do conjunto, causa: " + e.getMessage());
    }

    return p;
  }

  @Override
  public void insert(Product p) {
    // ***** Validação de Estado ***** //
    if (p.getName() != null
      && p.getCategory() != null
      && p.getPrice() != 0
      && p.getStock() != 0) {
      p = new Product();
    }
    String sql = "INSERT INTO produtos (id_categoria,nome,preco,estoque)" + //
            "VALUES (?,?,?,?);";
   try (PreparedStatement st = conn.prepareStatement(sql)) {

    // **** Uso da transação para consistência de dados *****
     conn.setAutoCommit(false);

      try {

        st.setInt(1, p.getCategoryId());
        st.setString(2, p.getName());
        st.setDouble(3, p.getPrice());
        st.setInt(4, p.getStock());

        st.executeUpdate();
        conn.commit();
        System.out.println("concluido");
      } catch (SQLException e) {
        conn.rollback();
        throw new UnsupportedOperationException("Erro na transação. Alterações revertidas, causa: " + e.getMessage());
      }

    } catch (SQLException e) {
      throw new UnsupportedOperationException("problema na conexão com o banco de dados, causa: " + e.getMessage());
   }
  }

  @Override
  public void delete(int id) {
    String sql = "DELETE FROM produtos WHERE id = ?;";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
      conn.setAutoCommit(false);
      try {
        st.setInt(1, id);
        st.executeUpdate();
        conn.commit();
        System.out.println("concluido!");
      } catch (SQLException e) {
        conn.rollback();
        throw new UnsupportedOperationException("Erro na transação. Alterações revertidas, causa: " + e.getMessage());
      }
    } catch (SQLException e) {
      throw new UnsupportedOperationException("problema na conexão com o banco de dados, causa: " + e.getMessage());
    }
  }

  @Override
  public List<Product> list() {
    List<Product> list = new ArrayList<>();
    String sql = "SELECT p.id,c.nome AS categoria,p.nome,preco,estoque FROM produtos p JOIN categorias c WHERE c.id = p.id_categoria";
    
    try (PreparedStatement st = conn.prepareStatement(sql);ResultSet rs = st.executeQuery()) {
      while (rs.next()) {
        list.add(
          new Product(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4),
            rs.getInt(5)
          ));
      }
    } catch (SQLException e) {
      throw new UnsupportedOperationException("problema na conexão com o banco de dados, causa: " + e.getMessage());
    }
    return list;
  }


}
