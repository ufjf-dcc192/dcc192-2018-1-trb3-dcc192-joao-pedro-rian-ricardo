package DAOs;

import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rian Alves
 */
public class UsuarioDAO {

    private static Connection conexao;
    private static UsuarioDAO dao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        UsuarioDAO.conexao = Conexao.getConexao();
    }

    public static UsuarioDAO getInstance() {
        if (dao == null) {
            try {
                dao = new UsuarioDAO();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dao;
    }

    public void adicionar(Usuario usuario) {
        String sql = "INSERT INTO USUARIO(nome, email,senha) VALUES(?,?,MD5(?))";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getSenha());
            comando.execute();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuario(String login, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = MD5(?)";
        Usuario usuario = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("login"));
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
     public Usuario listbyID(Integer id) throws SQLException {
        Usuario usuario;
        try (PreparedStatement consulta = conexao.prepareStatement("Select * from usuario where id = ?")) {
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"),resultado.getString("login"));
        }
        return usuario;
    }

}
