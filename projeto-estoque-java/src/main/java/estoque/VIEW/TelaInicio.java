/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque.VIEW;

import java.awt.Toolkit;

/**
 *
 * @author kaiob
 */
public class TelaInicio extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicio
     */
    public TelaInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAnalise = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();
        btCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de estoque");
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 1140) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 390) / 2);

        btAnalise.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btAnalise.setText("Ver Análises");
        btAnalise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAnalise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnaliseActionPerformed(evt);
            }
        });

        btProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btProdutos.setText("Novo Produto");
        btProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        btCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btCategoria.setText("Nova Categoria");
        btCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Olá! Seja bem-vindo ao programa de controle de estoque");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAnalise, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAnalise, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnaliseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnaliseActionPerformed
        // TODO add your handling code here:
        try{
            TelaConsulta analise = new TelaConsulta();
            analise.setVisible(true);
            dispose();
        } catch (Exception ex) {
            System.out.println("Houve problema ao entrar na tela de análise:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_btAnaliseActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        // TODO add your handling code here:
        try {
            TelaProduto novoProduto = new TelaProduto();
            novoProduto.setVisible(true);
            dispose();
        } catch (Exception ex) {
            System.out.println("Houve problema ao entrar na tela de cadastro de produto:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCategoriaActionPerformed
        // TODO add your handling code here:
        try {
            TelaCategoria novaCategoria = new TelaCategoria();
            novaCategoria.setVisible(true);
            dispose();
        } catch (Exception ex) {
            System.out.println("Houve problema ao entrar na tela de cadastro de categoria:\n"+ex.getMessage());
        }
    }//GEN-LAST:event_btCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalise;
    private javax.swing.JButton btCategoria;
    private javax.swing.JButton btProdutos;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}