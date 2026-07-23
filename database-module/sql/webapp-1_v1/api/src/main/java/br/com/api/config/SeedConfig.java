package br.com.api.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.entities.Category;
import br.com.api.entities.Order;
import br.com.api.entities.OrderItem;
import br.com.api.entities.OrderStatus;
import br.com.api.entities.Payment;
import br.com.api.entities.Product;
import br.com.api.entities.User;
import br.com.api.repository.CategoryRepository;
import br.com.api.repository.OrderItemRepository;
import br.com.api.repository.OrderRepository;
import br.com.api.repository.ProductRepository;
import br.com.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SeedConfig implements CommandLineRunner {


 private final UserRepository userRepository;
 private final OrderRepository orderRepository;
 private final ProductRepository productRepository;
 private final CategoryRepository categoryRepository;
 private final OrderItemRepository orderItemRepository;


 @Override
 @Transactional
 public void run(String... args) throws Exception {
  seedDatabase();
 }

 // verifica se o banco de dados já possui dados antes de executar o seed
 private void seedDatabase() {
  if (userRepository.count() > 0) {
    System.out.println("✅  Banco já possui dados. Seed ignorado.");
    return;
  }

 System.out.println("🌱 Iniciando seed...");



 // 1. Criar e salvar usuários primeiro
 User u1 = new User(null, "John Doe", "john.doe@example.com", "123456789", "oUH87$3", null);
 User u2 = new User(null, "Jane Smith", "jane.smith@example.com", "987654321", "kL98$#2", null);
 User u3 = new User(null, "Bob Johnson", "bob.johnson@example.com", "555555555", "mN45@!9", null);
 User u4 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
 User u5 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);

 List<User> savedUsers = userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));






 // 2. Criar pedidos usando os usuários salvos (com IDs atualizados)
 Order o1 = new Order(null, null, null, OrderStatus.WAITING_PAYMENT, savedUsers.get(0));
 Order o2 = new Order(null, null, null, OrderStatus.SHIPPED, savedUsers.get(1));
 Order o3 = new Order(null, null, null, OrderStatus.DELIVERED, savedUsers.get(2));
 Order o4 = new Order(null, null, null, OrderStatus.SHIPPED, savedUsers.get(3));
 Order o5 = new Order(null, null, null, OrderStatus.DELIVERED, savedUsers.get(4));
 Order o6 = new Order(null, null, null, OrderStatus.SHIPPED, savedUsers.get(0));
 Order o7 = new Order(null, null, null, OrderStatus.DELIVERED, savedUsers.get(1));


  Payment pay2 = new Payment(null, null, o2);
  o2.setPayment(pay2);
  Payment pay3 = new Payment(null, null, o3);
  o3.setPayment(pay3);
  Payment pay4 = new Payment(null, null, o4);
  o4.setPayment(pay4);
  Payment pay5 = new Payment(null, null, o5);
  o5.setPayment(pay5);
  Payment pay6 = new Payment(null, null, o6);
  o6.setPayment(pay6);
  Payment pay7 = new Payment(null, null, o7);
  o7.setPayment(pay7);


 List<Order> savedOrders = orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7));





  // 3. Criar categorias
  Category c1 = new Category("Books");
  Category c2 = new Category("Electronics");
  Category c3 = new Category("Computers");

  List<Category> saveCategories = categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

 // 4. Associar produtos às categorias
  Set<Category> books = new HashSet<>();
  books.add(c1);
  Set<Category> electronics = new HashSet<>();
  electronics.add(c2);
  Set<Category> computers = new HashSet<>();
  computers.add(c3);
  Set<Category> computerElectronics = new HashSet<>();
  computerElectronics.add(c2);
  computerElectronics.add(c3);


  // 5. Criar produtos
  Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", new java.math.BigDecimal("90.5"), "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg", books);
  Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new java.math.BigDecimal("2190.0"), "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg", electronics);
  Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new java.math.BigDecimal("1250.0"), "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg", computers);
  Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new java.math.BigDecimal("1200.0"), "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg", computerElectronics);
  Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", new java.math.BigDecimal("100.99"), "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg", books);

  List<Product> saveProducts = productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));



  // 6. Criar OrderItems associando pedidos e produtos
  OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
  OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
  OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
  OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
  
  List<OrderItem> saveOrderItems = orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));








  // 8. Exibir mensagens de sucesso
  System.out.println("✅  " + savedUsers.size() + " usuários salvos.");
  System.out.println("✅  " + savedOrders.size() + " pedidos salvos com sucesso!");
  System.out.println("✅  " + saveCategories.size() + " Categorias criadas com sucesso!");
  System.out.println("✅  " + saveProducts.size() + " Produtos criados com sucesso!");
  System.out.println("✅  " + saveOrderItems.size() + " Itens de pedido criados com sucesso!");
  System.out.println("🎉  Seed finalizado com sucesso!");
 }

}