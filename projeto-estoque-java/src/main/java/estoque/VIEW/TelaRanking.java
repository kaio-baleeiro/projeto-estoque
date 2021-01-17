package estoque.VIEW;

import estoque.DAO.BarChart;
import java.awt.Toolkit;
import org.jfree.chart.ChartPanel;

public class TelaRanking extends javax.swing.JFrame {

    /**
     * Creates new form TelaRanking
     */
    public TelaRanking() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnGraficoBar = new javax.swing.JPanel();
        lbVoltar = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rank dos Produtos");
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 1150) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 700) / 2);

        javax.swing.GroupLayout pnGraficoBarLayout = new javax.swing.GroupLayout(pnGraficoBar);
        pnGraficoBar.setLayout(pnGraficoBarLayout);
        pnGraficoBarLayout.setHorizontalGroup(
            pnGraficoBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        pnGraficoBarLayout.setVerticalGroup(
            pnGraficoBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        lbVoltar.setIcon(new javax.swing.ImageIcon("C:\\Users\\kaiob\\OneDrive\\Documentos\\bandtec\\projeto-estoque\\projeto-estoque-java\\src\\main\\java\\estoque\\ICONS\\left-arrow-64.png")); // NOI18N
        lbVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVoltarMouseClicked(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTitulo.setText("Ranking do top 10 produtos com mais saídas nos últimos sete dias");
        lbTitulo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lbTituloAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
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
                        .addGap(140, 140, 140)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnGraficoBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbVoltar)
                    .addComponent(lbTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(pnGraficoBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVoltarMouseClicked
        // TODO add your handling code here:
        TelaConsulta consulta = new TelaConsulta();
        consulta.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbVoltarMouseClicked

    private void lbTituloAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbTituloAncestorAdded
        // TODO add your handling code here:
        try {
            pnGraficoBar.removeAll();
            
            BarChart barchart = new BarChart();
            barchart.dataset();
            
            ChartPanel barPanel = new ChartPanel(barchart.barChart);
            barPanel.setSize(pnGraficoBar.getWidth(), pnGraficoBar.getHeight());
            barPanel.setVisible(true);
            pnGraficoBar.add(barPanel);
        } catch (Exception ex) {
            System.out.println("Problema na plotagem do gráfico");
        }
    }//GEN-LAST:event_lbTituloAncestorAdded

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
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbVoltar;
    private javax.swing.JPanel pnGraficoBar;
    // End of variables declaration//GEN-END:variables
}
