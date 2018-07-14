package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() throws SQLException {
        String jdbcurl = System.getenv("JDBC_DATABASE_URL");
        return  DriverManager.getConnection(jdbcurl);
    }

}

