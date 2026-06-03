package br.com.program.application.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nome", nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(name = "telefone")
  private Long phone;
  public Client() {}
  public Client(Long id, String name, String email, Long phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }
  public Long getId() {return id;}
  public void setId(Long id) {this.id = id;}
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}
  public Long getPhone() {return phone;}
  public void setPhone(Long phone) {this.phone = phone;}
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
    Client other = (Client) obj;
    if (id != other.id)
      return false;
    return true;
  }

  

}
