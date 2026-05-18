package app;

//import model.Product;
import dao.ProductDAO;
import service.DB;

public class Main {

  void main() {
    // salva dados no banco
    ProductDAO.save("Mouse Game MAXX", 124.75, 3);

    // lista os dados recebidos
    ProductDAO.listProducts().stream().filter(p -> p.getId() > 2).forEach(System.out::println);

    // fecha a conexão
    DB.shutdown();
  }
}









