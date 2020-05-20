/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_nop;

import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class bai3 extends javax.swing.JFrame {

    /**
     * Creates new form bai3
     */
    public bai3() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void PhepTinh(){
        double so1,so2;
        try{
            so1 = Double.parseDouble(txtsothunhat.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "chỉ được nhập số");
            txtsothunhat.requestFocusInWindow();
            return ;
        }
        try{
            so2 = Double.parseDouble(txtsothu2.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "chỉ được nhập số");
            txtsothu2.requestFocusInWindow();
            return ;
        }
        txtcanbachai.setText(so1 * so2+" ");
        txtluythua.setText(Math.pow(so1, so2)+" ");
        txtsonhonhat.setText(Math.min(so1, so2)+" ");
        txtsolonnhat.setText(Math.max(so1, so2)+" ");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblsothunhat = new javax.swing.JLabel();
        lblsothuhai = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblcanbac2 = new javax.swing.JLabel();
        lblluythua = new javax.swing.JLabel();
        lblsonhonhat = new javax.swing.JLabel();
        lblsolonnhat = new javax.swing.JLabel();
        btnthuchien = new javax.swing.JButton();
        txtsothunhat = new javax.swing.JTextField();
        txtsothu2 = new javax.swing.JTextField();
        txtcanbachai = new javax.swing.JTextField();
        txtluythua = new javax.swing.JTextField();
        txtsonhonhat = new javax.swing.JTextField();
        txtsolonnhat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lblsothunhat.setBackground(new java.awt.Color(102, 255, 153));
        lblsothunhat.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblsothunhat.setForeground(new java.awt.Color(0, 102, 102));
        lblsothunhat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsothunhat.setText("SỐ THỨ 1: ");

        lblsothuhai.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblsothuhai.setForeground(new java.awt.Color(0, 102, 102));
        lblsothuhai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsothuhai.setText("SỐ THỨ 2: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("KẾT QUẢ: ");

        lblcanbac2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblcanbac2.setForeground(new java.awt.Color(0, 102, 102));
        lblcanbac2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblcanbac2.setText("Căn bậc 2: ");

        lblluythua.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblluythua.setForeground(new java.awt.Color(0, 102, 102));
        lblluythua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblluythua.setText("Lũy thừa: ");

        lblsonhonhat.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblsonhonhat.setForeground(new java.awt.Color(0, 102, 102));
        lblsonhonhat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsonhonhat.setText("Số nhỏ nhất: ");

        lblsolonnhat.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblsolonnhat.setForeground(new java.awt.Color(0, 102, 102));
        lblsolonnhat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsolonnhat.setText("Số lớn nhất: ");

        btnthuchien.setText("THỰC HIỆN");
        btnthuchien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthuchienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblsolonnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblsonhonhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblluythua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcanbac2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblsothunhat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblsothuhai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsothunhat)
                            .addComponent(txtsothu2)
                            .addComponent(txtcanbachai)
                            .addComponent(txtluythua)
                            .addComponent(txtsonhonhat)
                            .addComponent(txtsolonnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnthuchien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsothunhat, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblsothunhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsothu2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblsothuhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcanbachai, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblcanbac2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtluythua, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblluythua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsonhonhat, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblsonhonhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsolonnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblsolonnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthuchien, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthuchienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthuchienActionPerformed
        this.PhepTinh();
    }//GEN-LAST:event_btnthuchienActionPerformed

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
            java.util.logging.Logger.getLogger(bai3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthuchien;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcanbac2;
    private javax.swing.JLabel lblluythua;
    private javax.swing.JLabel lblsolonnhat;
    private javax.swing.JLabel lblsonhonhat;
    private javax.swing.JLabel lblsothuhai;
    private javax.swing.JLabel lblsothunhat;
    private javax.swing.JTextField txtcanbachai;
    private javax.swing.JTextField txtluythua;
    private javax.swing.JTextField txtsolonnhat;
    private javax.swing.JTextField txtsonhonhat;
    private javax.swing.JTextField txtsothu2;
    private javax.swing.JTextField txtsothunhat;
    // End of variables declaration//GEN-END:variables
}
