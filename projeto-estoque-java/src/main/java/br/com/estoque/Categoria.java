package br.com.estoque;

public class Categoria {
    protected Integer idCategoria;
    protected String categoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String toString() {
        return this.categoria;
    }
}
