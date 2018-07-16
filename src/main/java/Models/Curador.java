
package Models;


public class Curador {
    Usuario usuario;
    Integer totalPositivas;
    Integer totalNegativas;
    Integer total;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTotalPositivas() {
        return totalPositivas;
    }

    public void setTotalPositivas(Integer totalPositivas) {
        this.totalPositivas = totalPositivas;
    }

    public Integer getTotalNegativas() {
        return totalNegativas;
    }

    public void setTotalNegativas(Integer totalNegativas) {
        this.totalNegativas = totalNegativas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
}
