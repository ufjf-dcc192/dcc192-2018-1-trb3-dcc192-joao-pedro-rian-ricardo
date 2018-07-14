package Models;

import java.time.LocalDateTime;
import java.util.List;


public class Comentario {
    private Integer id;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Usuario usuario;
    private Item item;
    private List<AvaliacaoComentario> avaliacoes;

    public List<AvaliacaoComentario> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoComentario> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    

    public Comentario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
   
    
    
    
}
