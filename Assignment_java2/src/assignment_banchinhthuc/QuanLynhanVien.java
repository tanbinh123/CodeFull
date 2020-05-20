/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_banchinhthuc;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author thanh
 */
public class QuanLynhanVien extends javax.swing.JFrame {

    List<NhanVien> list = new ArrayList<NhanVien>();

    public QuanLynhanVien() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void saveNhanVien() {
        NhanVien nv = new NhanVien();
        nv.maNhanVien = txtmanhanvien.getText();
        nv.hoVaTen = txthovaten.getText();
        nv.Tuoi = Integer.parseInt(txttuoi.getText());
        nv.email = txtemail.getText();
        nv.luong = Double.parseDouble(txtluong.getText());
        list.add(nv);
    }

    public void deleteNhanVien() {
        try {
            int index = tablenhanvien.getSelectedRow();
            list.remove(index);
        } catch (ArrayIndexOutOfBoundsException nv) {
            JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên!");
        }

    }

    public void updateNhanVien() {
        int index = tablenhanvien.getSelectedRow();
        NhanVien nv = list.get(index);
        nv.maNhanVien = txtmanhanvien.getText();
        nv.hoVaTen = txthovaten.getText();
        nv.Tuoi = Integer.parseInt(txttuoi.getText());
        nv.email = txtemail.getText();
        nv.luong = Double.parseDouble(txtluong.getText());
    }

    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tablenhanvien.getModel();
        model.setRowCount(0);
        for (NhanVien nv : list) {
            Object[] row = new Object[]{nv.maNhanVien, nv.hoVaTen, nv.Tuoi, nv.email, nv.luong};
            model.addRow(row);
        }
    }

    public void cleanText() {
        txtmanhanvien.setText(null);
        txthovaten.setText(null);
        txttuoi.setText(null);
        txtemail.setText(null);
        txtluong.setText(null);
    }

    public void showDetail() {
        cleanText();
        int index = tablenhanvien.getSelectedRow();
        NhanVien nv = list.get(index);
        nv.maNhanVien = txtmanhanvien.getText();
        nv.hoVaTen = txthovaten.getText();
        nv.Tuoi = Integer.SIZE;
        nv.email = txtemail.getText();
        nv.luong = Double.parseDouble(txtluong.getText());
    }

    public void findNhanVien() {
        int index = 0;
        if (index < list.size() - 1) {
            index++;
            showDetail();
        }
    }

    public void check() {
        String manhanvien = txtmanhanvien.getText();
        try {
            if (manhanvien.length() == 0) {
                JOptionPane.showMessageDialog(this, "không được để trống mã nhân viên");
                txtmanhanvien.setBackground(Color.red);
            } else {
                txtmanhanvien.setBackground(Color.white);
            }
        } catch (Exception e) {
                
        }
        
    }

    public void read() {
        try {

            JFileChooser c = new JFileChooser();
            int rVal = c.showOpenDialog(null);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                FileInputStream b = new FileInputStream(c.getSelectedFile());
                ObjectInputStream a = new ObjectInputStream(b);
                list = (ArrayList) a.readObject();
                a.close();
                fillToTable();
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLynhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbquanlynhanvien = new javax.swing.JLabel();
        lblhovaten = new javax.swing.JLabel();
        lbltuoi = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblluong = new javax.swing.JLabel();
        lblmanhanvien = new javax.swing.JLabel();
        txtmanhanvien = new javax.swing.JTextField();
        txttuoi = new javax.swing.JTextField();
        txtluong = new javax.swing.JTextField();
        txthovaten = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbtnew = new javax.swing.JButton();
        jbtsave = new javax.swing.JButton();
        jbtdelete = new javax.swing.JButton();
        jbtfind = new javax.swing.JButton();
        jbtopen = new javax.swing.JButton();
        jbtexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablenhanvien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Quản Lý Nhân Viên"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jlbquanlynhanvien.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jlbquanlynhanvien.setForeground(new java.awt.Color(0, 153, 51));
        jlbquanlynhanvien.setText("QUẢN LÝ NHÂN VIÊN");

        lblhovaten.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblhovaten.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblhovaten.setText("HỌ VÀ TÊN");

        lbltuoi.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbltuoi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltuoi.setText("TUỔI");

        lblemail.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblemail.setText("EMAIL");

        lblluong.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblluong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblluong.setText("LƯƠNG");

        lblmanhanvien.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblmanhanvien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblmanhanvien.setText("MÃ NHÂN VIÊN");

        jButton1.setText("<<");

        jButton2.setText("|<");

        jButton3.setText(">|");

        jButton4.setText(">>");

        jbtnew.setText("NEW");
        jbtnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnewActionPerformed(evt);
            }
        });

        jbtsave.setText("SAVE");
        jbtsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsaveActionPerformed(evt);
            }
        });

        jbtdelete.setText("DELETE");
        jbtdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtdeleteActionPerformed(evt);
            }
        });

        jbtfind.setText("FIND");
        jbtfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtfindActionPerformed(evt);
            }
        });

        jbtopen.setText("OPEN");
        jbtopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtopenActionPerformed(evt);
            }
        });

        jbtexit.setText("EXIT");
        jbtexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtexitActionPerformed(evt);
            }
        });

        tablenhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ NHÂN VIÊN", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ));
        tablenhanvien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tablenhanvienAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablenhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablenhanvien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthovaten)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblluong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jlbquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtopen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtdelete, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jbtnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jbtnew)
                        .addGap(18, 18, 18)
                        .addComponent(jbtsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtdelete)
                        .addGap(18, 18, 18)
                        .addComponent(jbtfind)
                        .addGap(18, 18, 18)
                        .addComponent(jbtopen)
                        .addGap(18, 18, 18)
                        .addComponent(jbtexit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmanhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhovaten, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblluong, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnewActionPerformed
        txtmanhanvien.setText("");
        txthovaten.setText("");
        txttuoi.setText("");
        txtemail.setText("");
        txtluong.setText("");
    }//GEN-LAST:event_jbtnewActionPerformed

    private void jbtsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsaveActionPerformed
        this.saveNhanVien();
        this.fillToTable();
        //this.check();
        //this.updateNhanVien();
    }//GEN-LAST:event_jbtsaveActionPerformed

    private void jbtdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtdeleteActionPerformed
        this.deleteNhanVien();
        this.fillToTable();
    }//GEN-LAST:event_jbtdeleteActionPerformed

    private void tablenhanvienAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablenhanvienAncestorMoved

    }//GEN-LAST:event_tablenhanvienAncestorMoved

    private void tablenhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhanvienMouseClicked
        // TODO add your handling code here:
        int index = tablenhanvien.getSelectedRow();

        String manhanvien = list.get(index).getMaNhanVien();
        txtmanhanvien.setText(manhanvien);

        String hoVaTen = list.get(index).getHoVaTen();
        txthovaten.setText(hoVaTen);

        String tuoi = String.valueOf(list.get(index).getTuoi());
        txttuoi.setText(tuoi);

        String email = list.get(index).getEmail();
        txtemail.setText(email);

        String luong = String.valueOf(list.get(index).getLuong());
        txtluong.setText(luong);


    }//GEN-LAST:event_tablenhanvienMouseClicked

    private void jbtexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtexitActionPerformed
        this.xuat();
        System.exit(0);
    }//GEN-LAST:event_jbtexitActionPerformed

    private void jbtopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtopenActionPerformed
        this.read();
    }//GEN-LAST:event_jbtopenActionPerformed

    private void jbtfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtfindActionPerformed
        this.findNhanVien();
    }//GEN-LAST:event_jbtfindActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLynhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtdelete;
    private javax.swing.JButton jbtexit;
    private javax.swing.JButton jbtfind;
    private javax.swing.JButton jbtnew;
    private javax.swing.JButton jbtopen;
    private javax.swing.JButton jbtsave;
    private javax.swing.JLabel jlbquanlynhanvien;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblhovaten;
    private javax.swing.JLabel lblluong;
    private javax.swing.JLabel lblmanhanvien;
    private javax.swing.JLabel lbltuoi;
    private javax.swing.JTable tablenhanvien;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthovaten;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtmanhanvien;
    private javax.swing.JTextField txttuoi;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
