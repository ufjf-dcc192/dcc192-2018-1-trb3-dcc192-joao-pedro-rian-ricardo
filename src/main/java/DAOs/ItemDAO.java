package DAOs;

import Models.AvaliacaoItem;
import Models.Item;
import Models.Link;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAO {

    private static Connection conexao;
    private static ItemDAO dao;
    private final String SQL_SELECT_ITENS_FROM_CATEGORIA = "select id_item from item_categoria where id_categoria = ?";

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

    public Item getItemById(Integer id) {
        String sql = "SELECT * FROM ITEM WHERE ID = ?";
        Item item = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                item = new Item();
                item.setId(resultado.getInt(1));
                item.setUsuario(UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)));
                item.setTitulo(resultado.getString(3));
                item.setDescricao(resultado.getString(4));
                item.setDataCriacao(resultado.getTimestamp(5).toLocalDateTime());
                item.setDataAtualizacao(resultado.getTimestamp(6).toLocalDateTime());
                item.setLinks(this.getLinks(item));
                item.setAvaliacoes(this.getAvaliacoes(item));
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public List<Link> getLinks(Item item) {
        String sql = "SELECT * FROM links(?)";
        List<Link> links = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, item.getId());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    links.add(new Link(resultado.getInt(1), resultado.getString(3), item));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return links;
    }

    public List<AvaliacaoItem> getAvaliacoes(Item item) {
        String sql = "SELECT * FROM avaliacao_item where id_item = ?";
        List<AvaliacaoItem> avaliacoes = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, item.getId());
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    avaliacoes.add(new AvaliacaoItem(resultado.getInt(1), resultado.getInt(4), resultado.getInt(5), UsuarioDAO.getInstance().getUsuarioById(resultado.getInt(2)), item));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avaliacoes;
    }

    public void adicionarItem(Item item) {
        String sql = "INSERT INTO \n"
                + "  public.item\n"
                + "(\n"
                + "  id_usuario,\n"
                + "  titulo,\n"
                + "  descricao,\n"
                + "  data_criacao,\n"
                + "  data_atualizacao\n"
                + ")\n"
                + "VALUES (\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  CURRENT_timestamp,\n"
                + "  CURRENT_timestamp\n"
                + ");";
        Integer idItem = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            comando.setInt(1, item.getUsuario().getId());
            comando.setString(2, item.getTitulo());
            comando.setString(3, item.getDescricao());
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();
            if (rs.next()) {
                idItem = rs.getInt(1);
            }
            comando.close();
            this.adicionarLinks(idItem, item.getLinks());
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void adicionarLinks(Integer id, List<Link> links) {
        if (links.size() > 0) {
            links.forEach((link) -> {
                this.adicionarLink(id, link);
            });
        }
    }

    public void editarItem(Item item) {
        String sql = "UPDATE \n"
                + "  item \n"
                + "SET \n"
                + "  titulo = ?,\n"
                + "  descricao = ?,\n"
                + "  data_atualizacao = current_timestamp\n"
                + "WHERE \n"
                + "  id = ?\n"
                + ";";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, item.getTitulo());
            comando.setString(2, item.getDescricao());
            comando.setInt(3, item.getId());
            comando.execute();
            comando.close();
            this.editarLinks(item);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLinks(Item item) {
        this.excluirLinks(item.getId());
        this.adicionarLinks(item.getId(), item.getLinks());
    }

    public void excluirItem(Integer id) {
        try {
            this.excluirLinks(id);
            this.excluirAvaliacoes(id);
            String sql = "DELETE FROM item WHERE id = ?";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                comando.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirLinks(Integer id) {
        try {
            String sql = "DELETE FROM link WHERE id_item = ?";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                comando.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirAvaliacoes(Integer id) {
        try {
            String sql = "DELETE FROM avaliacao_item WHERE id_item = ?";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, id);
                comando.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> aAvaliar(Integer idUsuario) {
        String sql = "SELECT id FROM ITEM WHERE ID NOT IN (\n"
                + "              	SELECT ID_ITEM\n"
                + "              	FROM COMENTARIO\n"
                + "              	WHERE ID_USUARIO = ?  	) or\n"
                + "  	ID not IN (\n"
                + "           	SELECT ID_ITEM\n"
                + "  	         FROM AVALIACAO_ITEM\n"
                + "           	WHERE ID_USUARIO = ?\n"
                + "  	) AND id_usuario <> ?";
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idUsuario);
            comando.setInt(2, idUsuario);
            comando.setInt(3, idUsuario);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    itens.add(this.getItemById(resultado.getInt(1)));
                } while (resultado.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;

    }

    private void adicionarLink(Integer id, Link link) {
        String sql = "INSERT INTO \n"
                + "  link\n"
                + "(\n"
                + "  id_item,\n"
                + "  link\n"
                + ")\n"
                + "VALUES (\n"
                + "  ?,\n"
                + "  ?\n"
                + ");";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            comando.setString(2, link.getLink());
            comando.execute();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> getItensOrdenados(Integer ordenacao) {
        String sql = "SELECT item.id,\n"
                + "      item.data_criacao,\n"
                + "      item.data_atualizacao,\n"
                + "      COALESCE(sum(AI.POSITIVA - AI.NEGATIVA), 0) as avaliacaofinal,\n"
                + "      COALESCE(sum(ai.positiva + ai.negativa), 0) as totalavaliacao\n"
                + "FROM ITEM\n"
                + "    LEFT JOIN AVALIACAO_ITEM AI ON (ITEM.ID = AI.ID_ITEM)\n"
                + "group by 1\n"
                + "order by ?;";
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, ordenacao);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Item item = this.getItemById(resultado.getInt(1));
                    itens.add(item);
                } while (resultado.next());
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    public List<Item> getItensbyAvaliacao(Integer ordenacao) {
        String sql = "SELECT ITEM.ID,\n"
                + "       SUM(AI.POSITIVA) AS TOTALPOSITIVA,\n"
                + "       SUM(AI.NEGATIVA) AS TOTALNEGATIVA,\n"
                + "       SUM(AI.POSITIVA - AI.NEGATIVA) AS AVALIACAOFINAL\n"
                + "FROM ITEM\n"
                + "     INNER JOIN AVALIACAO_ITEM AI ON (ITEM.ID = AI.ID_ITEM)\n"
                + "GROUP BY 1 ";
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, ordenacao);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Item item = this.getItemById(resultado.getInt(1));
                    item.setTotalPositivas(resultado.getInt(2));
                    item.setTotalNegativas(resultado.getInt(3));
                    item.setAvaliacaofinal(resultado.getInt(4));
                    itens.add(item);
                } while (resultado.next());
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    public Item getItemDetalhes(Integer idITem) {
        String sql = "SELECT ITEM.ID,\n"
                + "       SUM(AI.POSITIVA) AS TOTALPOSITIVA,\n"
                + "       SUM(AI.NEGATIVA) AS TOTALNEGATIVA,\n"
                + "       SUM(AI.POSITIVA - AI.NEGATIVA) AS AVALIACAOFINAL\n"
                + "FROM ITEM\n"
                + "     LEFT JOIN AVALIACAO_ITEM AI ON (ITEM.ID = AI.ID_ITEM)\n"
                + "where item.id=?\n"
                + "GROUP BY 1";
        Item item = null;
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idITem);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                item = this.getItemById(resultado.getInt(1));
                item.setTotalPositivas(resultado.getInt(2));
                item.setTotalNegativas(resultado.getInt(3));
                item.setAvaliacaofinal(resultado.getInt(4));
                item.setComentarios(ComentarioDAO.getInstance().getCincoComentariosByItem(item));
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public List<Item> getAllItens(Integer usuario) {
        String sql = "SELECT ITEM.ID FROM ITEM ORDER BY ID";
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    Item item = this.getItemById(resultado.getInt(1));
                    item.setComentado(this.haComentario(usuario, item.getId()));
                    item.setAvaliado(this.haAvaliacaoItem(usuario, item.getId()));
                    itens.add(item);
                } while (resultado.next());
            }
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    public boolean haComentario(Integer idUsuario, Integer idItem) {
        String sql = "SELECT * FROM COMENTARIO WHERE ID_USUARIO = ? and ID_ITEM = ?";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idUsuario);
            comando.setInt(2, idItem);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean haAvaliacaoItem(Integer idUsuario, Integer idItem) {
        String sql = "SELECT * FROM AVALIACAO_ITEM WHERE ID_USUARIO = ? and ID_ITEM = ?";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, idUsuario);
            comando.setInt(2, idItem);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void adicionarAvaliacao(AvaliacaoItem av) {

        String sql = "INSERT INTO \n"
                + "  avaliacao_item\n"
                + "(\n"
                + "  id_usuario,\n"
                + "  id_item,\n"
                + "  positiva,\n"
                + "  negativa\n"
                + ")\n"
                + "VALUES (\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  ?,\n"
                + "  ?\n"
                + ");";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, av.getUsuario().getId());
            comando.setInt(2, av.getItem().getId());
            comando.setInt(3, av.getPositiva());
            comando.setInt(4, av.getNegativa());
            comando.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> getItensByCategoria(Integer id_categoria) throws SQLException {
        List<Item> itens = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(SQL_SELECT_ITENS_FROM_CATEGORIA)) {
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                do {
                    itens.add(ItemDAO.getInstance().getItemById(resultado.getInt("id_item")));
                } while (resultado.next());
            }
        }
        return itens;
    }
}
