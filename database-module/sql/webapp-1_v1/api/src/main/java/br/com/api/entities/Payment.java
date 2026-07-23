package br.com.api.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_payment")
public class Payment {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private LocalDateTime date;

 @OneToOne
 @MapsId
 private Order orders;


 @PrePersist
 protected void onCreate() {
  this.date = LocalDateTime.now();
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
  Payment other = (Payment) obj;
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }
 
}
