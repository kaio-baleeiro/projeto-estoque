package estoque.VIEW;

import estoque.DAO.ConectarBanco;
import estoque.DAO.LineChart;
import estoque.DTO.Produto;
import estoque.VIEW.TelaInicio;
import estoque.DTO.Categoria;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class TelaConsulta extends javax.swing.JFrame {
    
    public TelaConsulta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCategoria = new javax.swing.JComboBox<>();
        cbProduto = new javax.swing.JComboBox<>();
        pnGrafico = new javax.swing.JPanel();
        lbVoltar = new javax.swing.JLabel();
        btRefresh = new javax.swing.JButton();
        btRanking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Análise de Produtos");
        setBackground(Color.black);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 1150) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 700) / 2);

        cbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbCategoria.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbCategoriaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        cbProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnGraficoLayout = new javax.swing.GroupLayout(pnGrafico);
        pnGrafico.setLayout(pnGraficoLayout);
        pnGraficoLayout.setHorizontalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnGraficoLayout.setVerticalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        lbVoltar.setIcon(new javax.swing.ImageIcon("C:\\Users\\kaiob\\OneDrive\\Documentos\\bandtec\\projeto-estoque\\projeto-estoque-java\\icons\\left-arrow-64.png")); // NOI18N
        lbVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVoltarMouseClicked(evt);
            }
        });

        btRefresh.setText("Refresh");
        btRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        btRanking.setText("Ranking");
        btRanking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRankingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbVoltar)
                        .addGap(65, 65, 65)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btRefresh)
                        .addGap(116, 116, 116)
                        .addComponent(btRanking))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(pnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVoltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btRefresh)
                        .addComponent(btRanking)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(pnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ConectarBanco conexaoCombo = new ConectarBanco(); 
    
    private void cbCategoriaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCategoriaAncestorAdded
        // TODO add your handling code here:
        try{
            conexaoCombo.conectar();

            List<Categoria> categorias = conexaoCombo.jdbcTemplate.query(
                "select * from categoria", 
                new BeanPropertyRowMapper(Categoria.class));

            for (Categoria c : categorias) {
                cbCategoria.addItem(c.toString());
            }
        }catch(Exception ex) {
            System.out.println("Houve problema ao carregar a combo das categorias:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_cbCategoriaAncestorAdded

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
        try{
            cbProduto.removeAllItems();
            conexaoCombo.conectar();

            String categoria = cbCategoria.getSelectedItem().toString();

            List<Produto> produtos = conexaoCombo.jdbcTemplate.query(
                "select * from categoria, produto where idCategoria = fkCategoria and nomeCategoria = ?", 
                new BeanPropertyRowMapper(Produto.class), categoria);

            for (Produto p : produtos) {
                cbProduto.addItem(p.toString());
            }
        }catch(Exception ex) {
            System.out.println("Houve problema ao carregar a combo dos produtos:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        // TODO add your handling code here:
        try{
            pnGrafico.removeAll();
            LineChart linechart = new LineChart();
            String nomeProduto = cbProduto.getSelectedItem().toString();

            linechart.dataset(nomeProduto);

            ChartPanel chartpanel = new ChartPanel(linechart.chart);
            chartpanel.setSize(pnGrafico.getWidth(), pnGrafico.getHeight());
            chartpanel.setVisible(true);
            pnGrafico.add(chartpanel);
        } catch(Exception ex) {
            System.out.println("Houve problema na plotagem do gráfico:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void lbVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVoltarMouseClicked
        // TODO add your handling code here:
        try{
            TelaInicio home = new TelaInicio();
            home.setVisible(true);
            dispose();
        }catch(Exception ex) {
            System.out.println("Houve um problema ao retornar ao início:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_lbVoltarMouseClicked

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        // TODO add your handling code here:
        try{
            pnGrafico.removeAll();
            LineChart linechart = new LineChart();
            String nomeProduto = cbProduto.getSelectedItem().toString();

            linechart.dataset(nomeProduto);

            ChartPanel linePanel = new ChartPanel(linechart.chart);
            linePanel.setSize(pnGrafico.getWidth(), pnGrafico.getHeight());
            linePanel.setVisible(true);
            pnGrafico.add(linePanel);
        } catch(Exception ex) {
            System.out.println("Houve problema na plotagem do gráfico:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_btRefreshActionPerformed

    private void btRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRankingActionPerformed
        // TODO add your handling code here:
        TelaRanking rank = new TelaRanking();
        rank.setVisible(true);
        dispose();
    }//GEN-LAST:event_btRankingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRanking;
    private javax.swing.JButton btRefresh;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbProduto;
    private javax.swing.JLabel lbVoltar;
    private javax.swing.JPanel pnGrafico;
    // End of variables declaration//GEN-END:variables
}
