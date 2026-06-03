package br.com.program.application.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Mantem um relacionamento co a entidade Category
  @ManyToOne(fetch = FetchType.LAZY) // LAZY é padrão para evitar carregar dados desnecessários
  @JoinColumn(name = "id_categoria", nullable = false) // Nome da coluna na tabela produtos
  private Category category;

  @Column(nullable = false, name = "nome")
  private String name;
  @Column(nullable = false, name = "preco")
  private BigDecimal price;
  @Column(nullable = false, name = "estoque")
  private Integer stock;
  
  public Product() {}
  public Product(Long id, Category category, String name, BigDecimal price, Integer stock) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }
  public Long getId() {return id;}
  public void setId(Long id) {this.id = id;}



  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }


  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public BigDecimal getPrice() {return price;}
  public void setPrice(BigDecimal price) {this.price = price;}
  public Integer getStock() {return stock;}
  public void setStock(Integer stock) {this.stock = stock;}

 
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
