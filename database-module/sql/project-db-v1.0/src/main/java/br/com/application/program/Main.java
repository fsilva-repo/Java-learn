package br.com.application.program;

import java.sql.SQLException;

import br.com.application.dao.FactoryDAO;
import br.com.application.dao.ProductDAO;
import br.com.application.database.DB;
import br.com.application.entities.Product;

public class Main {
  void main() {

    // **** Obter um produto por id *****

    // try {
    //   // Obter o DAO através da Factory
    //   ProductDAO productDAO = FactoryDAO.getInstance().geProductDAO();
    //   System.out.println(productDAO.get(3));      
    // } catch (SQLException e) {
    //   e.printStackTrace();
    // }

    Product blusaHeringMascBrancaM = new Product();
    blusaHeringMascBrancaM.setCategoryId(3);
    blusaHeringMascBrancaM.setName("Blusa Hering branca masc M");
    blusaHeringMascBrancaM.setPrice(35.90);
    blusaHeringMascBrancaM.setStock(20);
    
    // ***** Inserir um produto na tabela *****
    // try {
    //   ProductDAO productDao = FactoryDAO.getInstance().geProductDAO();
    //   productDao.insert(blusaHeringMascBrancaM);
      
    // } catch (SQLException e) {
    //   e.printStackTrace();
    // }

    // ***** deletar um produto por id *****
    // try {
    //   ProductDAO productDAO = FactoryDAO.getInstance().geProductDAO();
    //   productDAO.delete(8);
    // } catch (SQLException e) {
    //   System.err.println(e.getMessage());
    // }

    try {
      ProductDAO productDAO = FactoryDAO.getInstance().geProductDAO();
      System.out.println();
      productDAO.list().forEach(System.out::println);
      System.out.println();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }




    DB.shutdown();
  }
}
