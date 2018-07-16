
package Models;


public class Troll {
    private Usuario usuario;
    private Integer totalAvaliacaoComentario;
    private Integer totalAvaliacaoNegativa;
    private Double indiceTotal;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTotalAvaliacaoComentario() {
        return totalAvaliacaoComentario;
    }

    public void setTotalAvaliacaoComentario(Integer totalAvaliacaoComentario) {
        this.totalAvaliacaoComentario = totalAvaliacaoComentario;
    }

    public Integer getTotalAvaliacaoNegativa() {
        return totalAvaliacaoNegativa;
    }

    public void setTotalAvaliacaoNegativa(Integer totalAvaliacaoNegativa) {
        this.totalAvaliacaoNegativa = totalAvaliacaoNegativa;
    }

    public Double getIndiceTotal() {
        return indiceTotal;
    }

    public void setIndiceTotal(Double indiceTotal) {
        this.indiceTotal = indiceTotal;
    }
    
    
}
