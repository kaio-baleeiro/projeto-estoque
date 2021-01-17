package br.com.estoque;

public class Produto {
    protected Integer idProduto;
    protected String Nome;
    protected Integer fkCategoria;
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

    public Integer getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Integer fkCategoria) {
        this.fkCategoria = fkCategoria;
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
    
    public String toString() {
        return this.Nome;
    }
    
    public final String getAlert() {
        return "O Produto "+this.Nome+" está no limite mínimo de estoque";
    }
}
