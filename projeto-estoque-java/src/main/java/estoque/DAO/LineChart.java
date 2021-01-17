package estoque.DAO;

import estoque.DTO.Movimentacao;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class LineChart {
    
    protected ConectarBanco conexaoChart = new ConectarBanco();
    public JFreeChart chart;
    
    public void dataset(String nome) {
        try {
            conexaoChart.conectar();

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            List<Movimentacao> movimentacao = conexaoChart.jdbcTemplate.query(
                "select * from (select nome, sum(quantidade) as quantidade, "
                +"dayname(momento) as momento, date_format(momento, '%Y-%m-%d')"
                +" as dataComp from movimentacao, produto where "
                +"nome = ? and fkProduto=idProduto and quantidade<6"
                +" and momento between date_format(current_date()-7, '%Y-%m-%d')"
                +" and date_format(current_date()+1, '%Y-%m-%d') group by "
                +"dataComp order by dataComp desc limit 7) sele order by dataComp asc;", 
                new BeanPropertyRowMapper(Movimentacao.class), nome);

            for (Movimentacao mov : movimentacao) {
                System.out.println(mov.getQuantidade()+"+"+mov.getNome()+"+"+mov.getMomento());
                dataset.addValue(mov.getQuantidade(), mov.getNome(), mov.getMomento());
            }

            chart = ChartFactory.createLineChart(
                    "Grafico de movimentação de\n"+nome,
                    "Dia",
                    "Quantidade total de Produtos",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
        } catch (Exception ex) {
            System.out.println("Problema na criação do line chart"+ex.getMessage());
        }
    }
}
