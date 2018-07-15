
package DAOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAO {
    private static Connection conexao;
    private static ItemDAO dao;

    public ItemDAO() throws SQLException, ClassNotFoundException {
        ItemDAO.conexao = Conexao.getConexao();
    }

    public static ItemDAO getInstance() {
        if (dao == null) {
            try {
                dao = new ItemDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;
    }
    
    
}
