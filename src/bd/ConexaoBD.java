package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static Connection conn;

    public static Connection abrirConexao() {

        try {
            System.out.println("Tentando conexão com o BD");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String servidor = "localhost";
            String bd = "infnet";
            String url = "jdbc:mysql://" + servidor + "/" + bd;
            String usuario = "root";
            String senha = "beatrice";
            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco conectado");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        }
        catch (SQLException e) {
            System.out.println("Erro: conexão ao BD");
        }
        return conn;
    }

    public static void fecharConexao() {

        try {
            conn.close();
        }
        catch (SQLException e) {
            System.out.println("Erro: fechamento do BD");
        }
    }
}
