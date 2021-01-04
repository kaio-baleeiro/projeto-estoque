package br.com.estoque;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class LineChart {
    
    ConectarBanco conexaoChart = new ConectarBanco();
    JFreeChart chart;
    
    public void dataset(String nome) {
        try {
            conexaoChart.conectar();

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            List<Movimentacao> movimentacao = conexaoChart.jdbcTemplate.query(
                "SELECT * FROM (SELECT quantidade, nome, momento FROM movimentacao, produto WHERE nome = ? AND fkProduto=idProduto ORDER BY momento DESC LIMIT 7) sele ORDER BY momento ASC", 
                new BeanPropertyRowMapper(Movimentacao.class), nome);

            for (Movimentacao mov : movimentacao) {
                System.out.println(mov.getQuantidade()+"+"+mov.getNome()+"+"+mov.getMomento());
                dataset.addValue(mov.getQuantidade(), mov.getNome(), mov.getMomento());
            }

            chart = ChartFactory.createLineChart(
                    "Grafico de movimentação de\n"+nome,
                    "Momento",
                    "Quantidade de Produtos",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
        } catch (Exception ex) {
            System.out.println("Deu ruim na criação do line chart"+ex.getMessage());
        }
    }
}
