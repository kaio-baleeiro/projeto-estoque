package br.com.estoque;

public abstract class Produto {
    protected Integer idProduto;
    protected String Nome;
    protected String categoria;
    protected Double valorProduto;
    protected Integer limiteMin; 

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Integer getLimiteMin() {
        return limiteMin;
    }

    public void setLimiteMin(Integer limiteMin) {
        this.limiteMin = limiteMin;
    }
    
    public final String getAlert() {
        return "O Produto "+this.Nome+" está no limite mínimo de estoque";
    }
}
