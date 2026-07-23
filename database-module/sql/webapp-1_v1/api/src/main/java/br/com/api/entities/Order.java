package br.com.api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order")
public class Order {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private LocalDateTime orderDate;
 private LocalDateTime lastUpdate;
 private BigDecimal total;

 @Enumerated(EnumType.STRING)
 @Column(columnDefinition = "VARCHAR(20)")
 private OrderStatus orderStatus;
 @ManyToOne(fetch = FetchType.LAZY)
 //@JsonIgnore
 @JoinColumn(name = "client_id")
 private User client;
 
 @OneToOne(fetch = FetchType.LAZY, mappedBy = "orders", cascade = jakarta.persistence.CascadeType.ALL)
 private Payment payment;
 
 @OneToMany(mappedBy = "id.order", fetch = FetchType.LAZY)
 @JsonIgnore
 private Set<OrderItem> items = new HashSet<>();

 public BigDecimal getTotal() {
  total = items.stream()
    .map(OrderItem::getSubTotal)
    .reduce(BigDecimal.ZERO, BigDecimal::add);
  return total;
 }

 // --- MÉTODOS DE GERAÇÃO AUTOMÁTICA PARA DATA E HORA ---
 @PrePersist
 protected void onCreate() {
  this.orderDate = LocalDateTime.now();
  //this.lastUpdate = LocalDateTime.now();
 }

 // Atualiza apenas este campo no PATCH/PUT
 @PreUpdate
 protected void onUpdate() {
  this.lastUpdate = LocalDateTime.now();
 }

 public Order() {
 }

 public Order(Long id, LocalDateTime orderDate, LocalDateTime lastUpdate, OrderStatus orderStatus, User client) {
  this.id = id;
  this.orderDate = orderDate;
  this.lastUpdate = lastUpdate;
  this.orderStatus = orderStatus;
  this.client = client;
 }

 public void setPayment(Payment payment) {
  this.payment = payment;
 }

 public Payment getPayment() {
  return payment;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public LocalDateTime getOrderDate() {
  return orderDate;
 }

 public void setOrderDate(LocalDateTime orderDate) {
  this.orderDate = orderDate;
 }

 public LocalDateTime getLastUpdate() {
  return lastUpdate;
 }

 public void setLastUpdate(LocalDateTime lastUpdate) {
  this.lastUpdate = lastUpdate;
 }

 public OrderStatus getOrderStatus() {
  return orderStatus;
 }

 public void setOrderStatus(OrderStatus orderStatus) {
  this.orderStatus = orderStatus;
 }

 public User getClient() {
  return client;
 }

 public void setClient(User client) {
  this.client = client;
 }

 public Set<OrderItem> getItems() {
  return items;
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
  Order other = (Order) obj;
  if (id == null) {
   if (other.id != null)
    return false;
  } else if (!id.equals(other.id))
   return false;
  return true;
 }
 
 
}
