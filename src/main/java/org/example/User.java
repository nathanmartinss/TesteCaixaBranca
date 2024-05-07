package org.example;

// Importando as classes necessárias para conexão e manipulação de banco de dados.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Classe User
public class User {
    // Método para conectar ao banco de dados.
    public Connection conectaBD() {
        Connection conn = null;

        try {
            // Carregando o driver JDBC.
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Definindo a URL de conexão.
            String url = "jdbc:mysql://127.0.0.1/teste?user=lopes&password=123";
            // Estabelecendo a conexão.
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            // Em caso de erro, retorna null.
            return null;
        }
    }

    // Método para testar se um usuário existe no banco de dados.
    public boolean testaUsuario(String login, String senha) {
        boolean result = false;
        String sql = "";

        // Conectando ao banco de dados.
        Connection conn = conectaBD();

        // Construindo a consulta SQL.
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";

        try {
            // Criando um Statement para executar a consulta.
            Statement st = conn.createStatement();
            // Executando a consulta e armazenando o resultado.
            ResultSet rs = st.executeQuery(sql);

            // Se a consulta retornar algum resultado, o usuário existe.
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }

        } catch (Exception e) { }

        // Retorna o resultado do teste.
        return result;
    }
}
