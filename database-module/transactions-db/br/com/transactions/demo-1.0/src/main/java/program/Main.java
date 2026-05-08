package program;

import dao.TransationDAO;
import service.DB;

public class Main {
  void main() {
    TransationDAO.run();
    DB.shutdown();
  }
}
