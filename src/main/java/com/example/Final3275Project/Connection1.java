package com.example.Final3275Project;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/loan", "root", "");
        return con1;
    }
}
