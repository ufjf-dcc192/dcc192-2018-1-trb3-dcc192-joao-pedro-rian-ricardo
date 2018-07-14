
package Models;


public class AvaliacaoComentario {
    private Integer id;
    private Integer positiva;
    private Integer negativa;
    private Usuario usuario;
    private Comentario comentario;

    public AvaliacaoComentario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositiva() {
        return positiva;
    }

    public void setPositiva(Integer positiva) {
        this.positiva = positiva;
    }

    public Integer getNegativa() {
        return negativa;
    }

    public void setNegativa(Integer negativa) {
        this.negativa = negativa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
        
}
