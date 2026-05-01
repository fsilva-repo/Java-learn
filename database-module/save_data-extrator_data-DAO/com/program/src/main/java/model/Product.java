package model;

public class Product {
  private int id;
  private String nome;
  private double preco;

  // Construtor para buscar dados
  public Product(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

  // Getters
  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
  }

  
}
