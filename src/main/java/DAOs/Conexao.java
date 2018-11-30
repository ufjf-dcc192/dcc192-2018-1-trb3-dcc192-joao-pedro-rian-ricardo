package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
      boolean online = true;
      if(online){
          return ConexaoHeroku();
      }
      return ConexaoOffline();
    }

    private static Connection ConexaoHeroku() throws SQLException {
        String jdbcurl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(jdbcurl);
    }

    private static Connection ConexaoOffline() throws SQLException, ClassNotFoundException {
        String driver = "org.postgresql.Driver";
        String user = "pedrofreitas";
        String senha = "pfreitas02";
        String url = "jdbc:postgresql://localhost:5432/curadoria";
        Class.forName(driver);
        Connection conexao = (Connection) DriverManager.getConnection(url, user, senha);
        return conexao;
    }
}
