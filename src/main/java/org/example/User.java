package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectaBD() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/teste?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean testaUsuario(String login, String senha) {
        boolean result = false;
        String sql = "";

        Connection conn = conectaBD();

        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }

        } catch (Exception e) { }

        return result;
    }
}
//fim da class
