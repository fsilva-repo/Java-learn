package br.com.program.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Client implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "nome")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "telefone")
  private long phone;

  public Client() {}

  public Client(int id, String name, String email, long phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public int getId() {return id;}
  public void setId(int id) {this.id = id;}
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}
  public long getPhone() {return phone;}
  public void setPhone(long phone) {this.phone = phone;}

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
    Client other = (Client) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("id: " + id + "\n");
    sb.append("name: " + name + "\n");
    sb.append("email: " + email + "\n");
    sb.append("phone: " + phone + "\n");
    return sb.toString();
  }
  
}
