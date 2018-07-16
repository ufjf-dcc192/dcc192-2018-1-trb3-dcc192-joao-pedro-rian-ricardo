package DAOs;

import Models.Curador;
import Models.Troll;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Usuario getUsuarioById(Integer id) {
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = MD5(?)";
        Usuario usuario = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
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

    public boolean haLoginCadastrado(String login) {
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ?";
        ResultSet resultado;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, login);
            resultado = comando.executeQuery();
            comando.close();
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean haEmail(String email) {
        String sql = "SELECT * FROM USUARIO WHERE EMAIL = ?";
        ResultSet resultado;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, email);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                return true;
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Troll> trolls() {
        String sql = "SELECT * FROM TROLLS()";
        List<Troll> trolls = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Troll troll = new Troll();
                    troll.setUsuario(this.getUsuarioById(resultado.getInt(1)));
                    troll.setTotalAvaliacaoComentario(resultado.getInt(4));
                    troll.setTotalAvaliacaoNegativa(resultado.getInt(5));
                    troll.setIndiceTotal(resultado.getDouble(6));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trolls;
    }

    public List<Curador> curadores() {
        String sql = "SELECT * FROM RANKING()";
        List<Curador> curadores = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Curador curador = new Curador();
                    curador.setUsuario(this.getUsuarioById(resultado.getInt(1)));
                    curador.setTotalPositivas(resultado.getInt(4));
                    curador.setTotalNegativas(resultado.getInt(5));
                    curador.setTotal(resultado.getInt(6));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curadores;
    }
