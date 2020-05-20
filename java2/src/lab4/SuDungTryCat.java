/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class SuDungTryCat extends javax.swing.JFrame {

    /**
     * Creates new form SuDungTryCat
     */
    public SuDungTryCat() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void NhanVien() {
        boolean check = true;
        String fullname = txthovaten.getText();

        try {
            Double so = Double.parseDouble(fullname);
            JOptionPane.showMessageDialog(this, "bạn đã nhập sai định dạng");
            txthovaten.setBackground(Color.green);
            check = false;
        } catch (Exception e) {
            if (fullname.length() == 0) {
                JOptionPane.showMessageDialog(this, "không được để trống họ tên");
                txthovaten.setBackground(Color.green);
                check = false;
            } else {
                txthovaten.setBackground(Color.white);
            }
        }

        String ngaysinh = txtngaysinh.getText();
        try {
            Date ngayDate = XDate.parse(ngaysinh, "dd-MM-yyyy");
            txtngaysinh.setBackground(Color.white);
        } catch (Exception e) {
            if (ngaysinh.length() == 0) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập ngày");
                txtngaysinh.setBackground(Color.green);
                check = false;
            } else {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng ngày");
                txtngaysinh.setBackground(Color.white);
            }
            
            txtngaysinh.setBackground(Color.green);
            check = false;

        }
        
        
        try {
            double luong = Double.parseDouble(txtluong.getText());
            if(luong < 0)
            {
                JOptionPane.showMessageDialog(this, "lương phải là số dương");
                txtluong.setBackground(Color.green);
            }else 
            {
                txtluong.setBackground(Color.white);
            }
            
        } catch (Exception e) {
            
            if (txtluong.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống lương");
                txtluong.setBackground(Color.green);
            } else {
              
            }
        
        }
            if(check == true){
            JOptionPane.showMessageDialog(this, "thành công");
        }
        
        }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtquanlynhanvien = new javax.swing.JLabel();
        jlbhovaten = new javax.swing.JLabel();
        jlbluong = new javax.swing.JLabel();
        jlbhovaten2 = new javax.swing.JLabel();
        txthovaten = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        txtluong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtquanlynhanvien.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txtquanlynhanvien.setForeground(new java.awt.Color(0, 204, 51));
        txtquanlynhanvien.setText("QUẢN LÝ NHÂN VIÊN");

        jlbhovaten.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jlbhovaten.setText("NGÀY SINH");

        jlbluong.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jlbluong.setText("LƯƠNG");

        jlbhovaten2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jlbhovaten2.setText("HỌ VÀ TÊN");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("CHECK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbhovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtngaysinh))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbhovaten2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbluong, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtluong)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txthovaten)
                    .addComponent(jlbhovaten2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jlbhovaten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbluong, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtluong))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.NhanVien();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SuDungTryCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuDungTryCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuDungTryCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuDungTryCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuDungTryCat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jlbhovaten;
    private javax.swing.JLabel jlbhovaten2;
    private javax.swing.JLabel jlbluong;
    private javax.swing.JTextField txthovaten;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JLabel txtquanlynhanvien;
    // End of variables declaration//GEN-END:variables
}
