package br.com.application.dao;

import java.util.List;

import br.com.application.entities.Product;

public interface ProductDAO {

  public Product get(int id);
  public void insert(Product p);
  public void delete(int id);
  public List<Product> list();
}
