package br.com.api.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product {

 @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String description;
 private BigDecimal price;
 private String imageUrl;

 @OneToMany(mappedBy = "id.product", fetch = FetchType.LAZY)
 private Set<OrderItem> items = new HashSet<>();

 public Product() {}
 public Product(String name, String description, BigDecimal price, String imageUrl, Set<Category> categories) {
  this.name = name;
  this.description = description;
  this.price = price;
  this.imageUrl = imageUrl;
  this.categories = categories;

 }

 @ManyToMany
 @JoinTable(
   // nome da tabela das associações entre Product e Category
   name = "tb_product_category",
   // nome da coluna que referencia a entidade principal (Product)
   joinColumns = @JoinColumn(name = "product_id"),
   // nome da coluna que referencia a entidade associada (Category)
   inverseJoinColumns = @JoinColumn(name = "category_id")
 )
 private Set<Category> categories = new HashSet<>();

 @JsonIgnore
 public Set<Order> getOrders() {
  Set<Order> set = new HashSet<>();
  for (OrderItem x : items) {
   set.add(x.getOrder());
  }
  return set;
 }

 public Long getId() { return id;}
 public String getName() { return name;}
 public void setName(String name) { this.name = name;}
 public String getDescription() { return description;}
 public void setDescription(String description) {
  this.description = description;}
 public BigDecimal getPrice() { return price;}
 public void setPrice(BigDecimal price) { this.price = price;}
 public String getImageUrl() { return imageUrl;}
 public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}
 public Set<Category> getCategories() {
  return categories;
 }
 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((id == null) ? 0 : id.hashCode());
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
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }

 
}
