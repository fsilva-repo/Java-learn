package com.db.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import com.db.exception.DBException;
import com.db.util.DB;

public class Main {
    
    public static void main(String[] args) {
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;

       try {
        conn = DB.getConnection();
        st = conn.createStatement();
        rs = st.executeQuery("select name from category");

        // Iterar sobre os resultados
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
       } catch (SQLException e) {
        throw new DBException(e.getMessage());
       } finally {
           DB.closeResultSet(rs); // Primeiro
           DB.closeStatement(st); // Depois
           DB.closeConnection(); // Por último
       }

    }
}