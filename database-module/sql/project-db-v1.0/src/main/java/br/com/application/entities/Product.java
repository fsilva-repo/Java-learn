package br.com.application.entities;

public class Product {

  private String name;
  private double price;
  private int id;
  private int stock;
  private String category;
  private int categoryId;

  public Product() {}
  public Product(int id, String name, String category, double price, int stock) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.category = category;
    this.stock = stock;
  }

  public int getCategoryId() {return categoryId;}
  public void setCategoryId(int categoryId) {this.categoryId = categoryId;}
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public double getPrice() {return price;}
  public void setPrice(double price) {this.price = price;}
  public int getId() {return id;}
  public void setId(int id) {this.id = id;}
  public int getStock() {return stock;}
  public void setStock(int stock) {this.stock = stock;}
  public String getCategory() {return category;}
  public void setCategory(String category) {this.category = category;}

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id != other.id)
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "Product [name: " + name + ", price: " + price + ", id: " + id + ", stock: " + stock + ", category: "
        + category + "]";
  }
  
}
