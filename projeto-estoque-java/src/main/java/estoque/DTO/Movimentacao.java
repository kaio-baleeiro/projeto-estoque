package estoque.DTO;

public class Movimentacao {
    private Integer quantidade;
    private String nome;
    private String momento;
    private String dataComp;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public String getDataComp() {
        return dataComp;
    }

    public void setDataComp(String dataComp) {
        this.dataComp = dataComp;
    }
}
