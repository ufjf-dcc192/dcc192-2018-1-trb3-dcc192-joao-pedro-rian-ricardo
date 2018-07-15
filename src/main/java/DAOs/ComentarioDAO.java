package DAOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDAO {

    private static Connection conexao;
    private static ComentarioDAO dao;

    public ComentarioDAO() throws SQLException, ClassNotFoundException {
        ComentarioDAO.conexao = Conexao.getConexao();
    }

    public static ComentarioDAO getInstance() {
        if (dao == null) {
            try {
                dao = new ComentarioDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;

    }
}
