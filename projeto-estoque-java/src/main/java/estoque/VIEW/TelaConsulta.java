package br.com.estoque;

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
        btVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 1459) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 686) / 2);

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

        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnGraficoLayout = new javax.swing.GroupLayout(pnGrafico);
        pnGrafico.setLayout(pnGraficoLayout);
        pnGraficoLayout.setHorizontalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1358, Short.MAX_VALUE)
        );
        pnGraficoLayout.setVerticalGroup(
            pnGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        btVisualizar.setText("Visualizar");
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btVisualizar)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVisualizar))
                .addGap(18, 18, 18)
                .addComponent(pnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ConectarBanco conexaoCombo = new ConectarBanco(); 
    
    private void cbCategoriaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCategoriaAncestorAdded
        // TODO add your handling code here:
        conexaoCombo.conectar();
        
        List<Categoria> categorias = conexaoCombo.jdbcTemplate.query(
            "select * from categoria", 
            new BeanPropertyRowMapper(Categoria.class));
        
        for (Categoria c : categorias) {
            cbCategoria.addItem(c.toString());
        }
    }//GEN-LAST:event_cbCategoriaAncestorAdded

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
        cbProduto.removeAllItems();
        conexaoCombo.conectar();
        
        String categoria = cbCategoria.getSelectedItem().toString();
        
        List<Produto> produtos = conexaoCombo.jdbcTemplate.query(
            "select * from categoria, produto where idCategoria = fkCategoria and nomeCategoria = ?", 
            new BeanPropertyRowMapper(Produto.class), categoria);
        
        for (Produto p : produtos) {
            cbProduto.addItem(p.toString());
        }
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        // TODO add your handling code here:
        pnGrafico.removeAll();
        LineChart linechart = new LineChart();
        String nomeProduto = cbProduto.getSelectedItem().toString();

        linechart.dataset(nomeProduto);

        ChartPanel chartpanel = new ChartPanel(linechart.chart);
        chartpanel.setSize(pnGrafico.getWidth(), pnGrafico.getHeight());
        chartpanel.setVisible(true);
        pnGrafico.add(chartpanel);
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        // TODO add your handling code here:
        pnGrafico.removeAll();
        LineChart linechart = new LineChart();
        String nomeProduto = cbProduto.getSelectedItem().toString();

        linechart.dataset(nomeProduto);

        ChartPanel chartpanel = new ChartPanel(linechart.chart);
        chartpanel.setSize(pnGrafico.getWidth(), pnGrafico.getHeight());
        chartpanel.setVisible(true);
        pnGrafico.add(chartpanel);
    }//GEN-LAST:event_btVisualizarActionPerformed

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
    private javax.swing.JButton btVisualizar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbProduto;
    private javax.swing.JPanel pnGrafico;
    // End of variables declaration//GEN-END:variables
}
