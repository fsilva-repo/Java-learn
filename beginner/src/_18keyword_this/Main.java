package _18keyword_this;

// referenciando atributos da class com  this
class Carro {
  private String marca;
  private String modelo;

  public Carro() {
    this("Desconhecida", "Desconhecido"); // Chama o outro construtor
  }

  public Carro(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

}

public class Main {
  public static void main(String[] args) {
    Carro c1 = new Carro();
    System.out.println("Marca: " + c1.getMarca() + ", Modelo: " + c1.getModelo());
  }
}
