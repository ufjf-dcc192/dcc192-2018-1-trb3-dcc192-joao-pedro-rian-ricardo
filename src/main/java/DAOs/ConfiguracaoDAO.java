package DAOs;

import Models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracaoDAO {

    private static Connection conexao;
    private static ConfiguracaoDAO dao;
    private String SQL_SELECT_PARAMETROS = "SELECT * FROM CONFIGURACAO";

    private ConfiguracaoDAO() throws SQLException, ClassNotFoundException {
        ConfiguracaoDAO.conexao = Conexao.getConexao();
    }

    public static ConfiguracaoDAO getInstance() {
        if (dao == null) {
            try {
                dao = new ConfiguracaoDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;
    }

    public HashMap<String,String> getConfiguracoes() throws SQLException {
        HashMap<String,String> configuracoes = new HashMap<>();
        try (PreparedStatement comando = conexao.prepareStatement(SQL_SELECT_PARAMETROS)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    configuracoes.put(resultado.getString("chave"), resultado.getString("valor"));
                } while (resultado.next());
                comando.close();
            }
            return configuracoes;
        }

    }
}
