package com.db.app;


//import com.db.exception.DBException;
import com.db.util.DB;

public class Main {
    public static void main(String[] args) {
      String querySQL = "SELECT category_id, name, last_update FROM category";
      DB.getConnection(querySQL);
    
    }
}