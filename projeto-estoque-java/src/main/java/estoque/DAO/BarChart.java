package estoque.DAO;

import estoque.DTO.Ranking;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class BarChart {
    protected ConectarBanco conexaoBar = new ConectarBanco();
    public JFreeChart barChart;
    
    public void dataset() {
        try {
            conexaoBar.conectar();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            List<Ranking> ranking = ConectarBanco.jdbcTemplate.query(
                "select nome, sum(quantidade) as total, "
                +"date_format(momento, '%Y-%m-%d') as momento from "
                +"movimentacao, produto where quantidade < 6 and "
                +"idProduto=fkProduto and momento between "
                +"date_format(current_date()-6, '%Y-%m-%d') and "
                +"date_format(current_date()+1, '%Y-%m-%d') "
                +"group by nome order by total desc limit 10", 
                new BeanPropertyRowMapper(Ranking.class));
            
            for (Ranking rk : ranking) {
                System.out.println(rk.getNome()+"+"+rk.getTotal());
                dataset.setValue(rk.getTotal(), rk.getNome(),"");
            }
            
            barChart = ChartFactory.createBarChart(
                    "", "Total", "Produtos", dataset, PlotOrientation.VERTICAL, 
                    true, true, false);

        } catch (Exception ex) {
            System.out.println("Problema na criação do bar chart");
        }
    }
    
}
