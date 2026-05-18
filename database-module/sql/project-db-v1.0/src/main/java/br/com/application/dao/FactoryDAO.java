package br.com.application.dao;

import java.sql.SQLException;

import br.com.application.database.DB;
import br.com.application.model.ProductDAOImp;

public class FactoryDAO {

  // ***** (Design Pattern Singleton) ocupando menos memoria ***** //
  private static final FactoryDAO  INSTANCE = new FactoryDAO();
  private FactoryDAO() {} 
  public static FactoryDAO getInstance() {
    return INSTANCE;
  }
 
  // retorna a implementação da interface productDao
  public ProductDAO geProductDAO() throws SQLException {
    return new ProductDAOImp(DB.getConnection());
  }
}
