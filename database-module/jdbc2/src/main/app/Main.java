package main.app;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import main.exception.DBException;
import main.util.DB;

public class Main {
    
    public static void main(String[] args) {
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;

       try {
        conn = DB.getConnection();
        st = conn.createStatement();
        rs = st.executeQuery("select category_id, name, last_update from category");
        
        IO.println(" category_id  |     name     |    last_update\n");
        while (rs.next()) {
        	IO.println("|  " + rs.getInt(1) + "\t\t  |   " + rs.getString(2) + "\t\t  |   " + rs.getDate(3));
        }
       

       } catch (SQLException e) {
        throw new DBException(e.getMessage());
       } finally {								// ordem de fechamento
           DB.closeResultSet(rs); // Primeiro
           DB.closeStatement(st); // Segundo
           DB.closeConnection(); // E último
       }

    }
}